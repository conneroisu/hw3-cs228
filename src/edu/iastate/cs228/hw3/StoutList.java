package edu.iastate.cs228.hw3;

import java.util.*;

public class StoutList<E extends Comparable<? super E>> extends AbstractSequentialList<E> {
    private static final int DEFAULT_NODE_SIZE = 4;
    private final int nodeSize;
    private final Node tail;
    public Node head;
    private int size;

    public StoutList(Node head, Node tail, int nodeSize, int size) {
        this.head = head;
        this.tail = tail;
        this.nodeSize = nodeSize;
        this.size = size;
    }

    public StoutList(int nodeSize) {
        if (nodeSize <= 0 || nodeSize % 2 != 0) {
            throw new IllegalArgumentException();
        }

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
        this.nodeSize = nodeSize;
        size = 0;
    }


    public StoutList() {
        this(DEFAULT_NODE_SIZE);
    }

    @Override
    public boolean isEmpty() {
        return head.next.next == null && tail.previous.previous == null && size == 0;
    }

    @Override
    public boolean add(E item) {
        if (item == null) {
            throw new NullPointerException();
        }
        int offset = 0;
        // create a data array for checking the node
        Node node = null;
        if (isEmpty()) {
            node = new Node();
            node.addItem(0, item);
            link(head, node);
        } else {
            NodeInfo nodeInfo = findByIndex(size);
            if (nodeInfo.exists == false) {
                node = new Node();
                link(tail.previous, node);
                nodeInfo.node = node;
            }
            offset = nodeInfo.offset;
            node = nodeInfo.node;
            node.addItem(offset, item);
        }
        try {
            if (node.data[offset].equals(item)) {
                // todo logging for debugging needs removed
                System.out.println("Successful Added " + item + " at index " + size + " to node " + toStringInternal());
                size++;
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    @Override
    public void add(int position, E item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Index: " + position + " is out of bounds for size: " + size);
        }

        if (head.next == null) {
            new Node(head, item);
            return;
        }

        NodeInfo nodeInfo = findByIndex(position);
        Node node = nodeInfo.node;
        int offset = nodeInfo.offset;
        if (offset == 0) {
            if (!node.previousIsFull() && node.isNotHead()) {
                node.previous.addItem(0, item);
            } else if (node.previousIsFull() && node.isTail()) {
                new Node(node.previous, item);
            }
        } else if (node.hasSpace()) {
            node.insert(offset, item);
        } else {
            node.split(offset, item);
        }
        if (get(position).equals(item)) {
            size++;
        }
    }

    @Override
    public E remove(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        NodeInfo nodeInfo = findByIndex(pos);
        Node node = nodeInfo.node;
        int offset = nodeInfo.offset;
        if (offset == 0) {
            if (node.isNotHead()) {
                node.previous.removeItem(node.previous.count - 1);
            }
        } else if (offset == node.count - 1) {
            if (!node.isTail()) {
                node.next.removeItem(0);
            }
        } else {
            for (int j = offset; j < nodeSize - 1; j++) {
                node.data[j] = node.data[j + 1];
            }
            node.count--;
            size--;
        }

        NodeInfo here = findByIndex(pos);
        E rmd = here.node.next.data[here.offset];
        here.node.next.removeItem(here.offset);

        if (here.node.next.count == 0) {
            unlink(here.node);
        }

        return rmd;
    }

    private void link(Node beforeNode, Node newNode) {
        newNode.next = beforeNode.next;
        newNode.previous = beforeNode;
        beforeNode.next.previous = newNode;
        beforeNode.next = newNode;
    }

    private void bubbleSort(E[] arr) {
        // use size of this to sort arr[] into non-increasing order using bubble sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) < 0) {
                    E temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public String toStringInternal() {
        return toStringInternal(null);
    }

    public String toStringInternal(ListIterator<E> listiterator) {
        int count = 0;
        int position = -1;
        if (listiterator != null) {
            position = listiterator.nextIndex();
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node current = head.next;
        while (current != tail) {
            sb.append('(');
            E data = current.data[0];
            if (data == null) {
                sb.append("-");
            } else {
                if (position == count) {
                    sb.append("| ");
                    position = -1;
                }
                sb.append(data);
                ++count;
            }

            for (int i = 1; i < nodeSize; ++i) {
                sb.append(", ");
                data = current.data[i];
                if (data == null) {
                    sb.append("-");
                } else {
                    if (position == count) {
                        sb.append("| ");
                        position = -1;
                    }
                    sb.append(data);
                    ++count;

                    // iterator at end
                    if (position == size && count == size) {
                        sb.append(" |");
                        position = -1;
                    }
                }
            }
            sb.append(')');
            current = current.next;
            if (current != tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void exchange(E[] arr, int j, int i) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new StoutListIterator();
    }

    private void insertionSort(E[] arr, Comparator<? super E> comp) {
        int N = arr.length;
        for (int ii = 1; ii < N; ii++) {
            for (int j = ii; j > 0 && isLess(arr[j], arr[j - 1], comp); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }

    private boolean isLess(E e, E e1, Comparator<? super E> comp) {
        return comp.compare(e, e1) < 0;
    }

    public void sort() {
        E[] array = (E[]) new Comparable[size];
        Comparator<? super E> comp = Comparator.naturalOrder();
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        insertionSort(array, comp);
        clear();
        this.addAll(Arrays.asList(array));
    }

    @Override
    public void clear() {
        Node cursor = head.next;
        while (cursor != null) {
            try {
                unlink(cursor);
            } catch (NullPointerException e) {
                break;
            }
            cursor = cursor.next;
        }
    }

    private boolean isMax(int sum) {
        for (int j = 0; j < nodeSize; j++) {
            if (sum + j == Integer.MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private void unlink(Node current) {
        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    @Override
    public Iterator<E> iterator() {
        return new StoutListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new StoutListIterator(index);
    }

    public void sortReverse() {
        E[] array;
        try {
            array = (E[]) new Comparable[size];
        } catch (ClassCastException e) {
            throw new ClassCastException("Cannot cast to Comparable");
        }

        int i = 0;
        for (E e : this) {
            array[i] = e;
            i++;
        }
        bubbleSort(array);
        clear();
        this.addAll(Arrays.asList(array));

    }

    private NodeInfo findByIndex(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index is greater than size");
        }
        Node node = head.next;
        int previousSum = 0;
        int currentSum;
        while (node != null) {
            currentSum = previousSum + node.count;
            if (index > previousSum && index <= currentSum) {
                int positionInNode = index - previousSum;
                try {
                    E temp = node.data[positionInNode];
                    return new NodeInfo(node, positionInNode);
                } catch (IndexOutOfBoundsException e) {
                    Node resultNode = new Node();
                    link(tail.previous, resultNode);
                    return new NodeInfo(resultNode, 0);
                }
            }

            node = node.next;
            previousSum = currentSum;
        }
        Node resultNode = new Node();
        link(tail.previous, resultNode);
        return new NodeInfo(resultNode, 0);
    }

    private class NodeInfo {

        public Node node;
        public int offset;

        public boolean exists;

        public NodeInfo(Node node, int offset) {
            this.node = node;
            this.offset = offset;
            this.exists = true;
        }

        public NodeInfo(Node node, int offset, boolean exists) {
            this(node, offset);
            this.exists = exists;
        }
    }

    private class Node {

        public E[] data = (E[]) new Comparable[nodeSize];

        public Node next;

        public Node previous;

        public int count;

        public Node() {
            this.count = 0;
        }

        public Node(Node previous, E[] items) {
            super();
            link(previous, this);
            if (items.length > nodeSize) {
                throw new IllegalArgumentException("Array size is greater than node size");
            }
            System.arraycopy(items, 0, this.data, 0, items.length);
            this.count = items.length;
            size += items.length;
        }

        public Node(Node previous, E item) {
            super();
            link(previous, this);
            this.addItem(item);
            System.out.println("Added " + item + " at index " + 0 + " to node " + Arrays.toString(data));
        }


        private boolean isTail() {
            try {
                return next == null;
            } catch (NullPointerException e) {
                return true;
            }
        }

        void addItem(E item) {
            if (count >= nodeSize) {
                return;
            }
            data[count++] = item;
        }

        void addItem(int offset, E item) {

            if (count >= nodeSize) {
                return;
            }

            for (int i = count - 1; i >= offset; --i) {
                data[i + 1] = data[i];
            }

            ++count;
            data[offset] = item;

            // TODO remove this logging statement
            System.out.println("Added " + item + " at index " + offset + " to node " + Arrays.toString(data));
        }

        private boolean previousIsFull() {
            try {
                return previous.isFull();
            } catch (NullPointerException e) {
                return true;
            }
        }

        private void insert(int offset, E item) {
            if (count > 1) {
                for (int j = offset + 1; j < nodeSize; j++) {
                    if (data[j] != null) {
                        data[j] = data[j + 1];
                    }
                }
            }
            data[offset] = item;
            count++;
        }

        private void split(int offset, E item) {
            int last = nodeSize / 2;
            E[] newData = (E[]) new Comparable[last];
            int co = 0;
            // move the last half of the data to a new node after this one
            for (int j = last; j < nodeSize; j++) {
                newData[co] = data[j];
                data[j] = null;
                count--;
                size--;
                co++;
            }
            Node newNode = new Node(this, newData);
            if (offset <= last) {
                addItem(offset, item);
            }
            newNode.addItem(offset - last, item);
        }

        private boolean isFull() {
            return count == nodeSize;
        }

        private boolean hasSpace() {
            return count + 1 <= nodeSize;
        }

        private boolean isNotHead() {
            try {
                return previous != null;
            } catch (NullPointerException e) {
                return false;
            }
        }

        void removeItem(int offset) {
//            E item = data[offset];
            for (int i = offset + 1; i < nodeSize; ++i) {
                data[i - 1] = data[i];
            }
            data[count - 1] = null;
            --count;
        }
    }

    private class StoutListIterator implements ListIterator<E> {
     private Node current;
        private Node removeCurrent;
        private int removeOffS;
        private int pIndex;
        private int offS;
        private int poffS;
        // constants you possibly use ... instance variables ... TODO remove this
        private static final int BEHIND = -1;
        private static final int AHEAD = 1;

        private static final int NONE = 0;
        private Node cursor;

        private Node pending = null;
        private int index;
        private int direction;

        public StoutListIterator() {
            this(0);
        }

        public StoutListIterator(int positionalValue) {
            if (positionalValue < 0 || positionalValue > size) {
                throw new IndexOutOfBoundsException("Index: " + positionalValue + ", Size: " + size);
            }

            index = positionalValue;
            direction = NONE;
            // traverse list to find node at position by counting items in nodes
            cursor = head.next;
            int count = 0;
            while (count + cursor.count <= index && !cursor.isTail()) {
                count += cursor.count;
                cursor = cursor.next;
            }
        }

        @Override
        public boolean hasNext() {
            return index < size && cursor != null;
        }

        @Override
        public E next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            if(index > size) { throw new RuntimeException("Index is greater than size"); }

            pending = cursor;
            // increase index and find next node if needed
            Node node = findByIndex(index).node;
            int offset = findByIndex(index).offset;

            if (node != cursor) { cursor = cursor.next; }

            direction = AHEAD;
            index++;
            // if the cursor is not the tail or head, return the item at the offset
            if (!cursor.isTail() && cursor.isNotHead()) {
                return pending.data[offset];
            } else {
                // if at tail go back one node and return the data at the index
                if (cursor.isTail()) {
                    cursor = cursor.previous;
                } else {
                    // if at head go forward one node and return the data at the index
                    cursor = cursor.next;
                }
                return cursor.data[findByIndex(index).offset];

            }
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NullPointerException();
            }
            cursor = cursor.previous;
            index--;
            direction = AHEAD;
            return cursor.data[nextIndex()];
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return cursor.count - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unsupported Operation");
        }

        @Override
        public void set(E item) throws IllegalStateException {
            if (direction == NONE) {
                throw new IllegalStateException("set() can only be called after next() or previous()");
            }
            if (direction == AHEAD) {
                cursor.data[index] = item;
            } else if (direction == BEHIND) {
                cursor.previous.data[index] = item;
            }
            cursor.data[index] = item;
        }

        @Override
        public void add(E item) {
            if (item == null) {
                throw new NullPointerException();
            }
            Node temp = new Node();
            link(cursor.previous, temp);
            ++size;
            ++index;
            direction = NONE;
        }
        // Other methods you may want to add or override that could possibly facilitate
        // other operations, for instance, addition, access to the previous element,
        // etc.
    }
}
