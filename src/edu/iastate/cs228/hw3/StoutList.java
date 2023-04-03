package edu.iastate.cs228.hw3;

import java.util.*;

/**
 * @author Conner Ohnesorge
 * <p>
 * A doubly linked list that stores data in nodes of size nodeSize.The list is a doubly linked list, having a
 * placeholder head and tail node.Also, the list has a data array in each node that stores the data. The abstract
 * sequential list is extended to provide a doubly linked list implementation with data stored in arrays in each node.
 * Again, the list is a doubly linked list, having a placeholder head and tail node. The length of the data array in a
 * StoutList node is the nodeSize, an even and greater than 0 value. Rules for adding and removing elements ensure that
 * each node (except possibly the last one) is at least half full.
 * </p>
 */
public class StoutList<E extends Comparable<? super E>> extends
        AbstractSequentialList<E> {
    /**
     * Default number of elements that may be stored in each node of a StoutList.
     */
    private static final int DEFAULT_NODE_SIZE = 4;

    /**
     * Number of elements that can be stored in each node of this StoutList.
     */
    private final int nodeSize;
    /**
     * Placeholder node for tail of this StoutList.
     */
    private final Node tail;
    /**
     * Placeholder node for head(start).It should be private but set to public here only for grading purpose.In
     * practice, the head of a linked list a private instance variable.
     */
    public Node head;
    /**
     * Number of elements in the StoutList.
     */
    private int size;

    /**
     * Constructs an empty StoutList with the default node size.
     */
    public StoutList() {
        this(DEFAULT_NODE_SIZE);
    }

    /**
     * Constructs an empty list with the given node size.
     *
     * @param nodeSize number of elements that may be stored in each node, must be an even number
     */
    public StoutList(int nodeSize) {
        if (nodeSize <= 0 || nodeSize % 2 != 0) {
            throw new IllegalArgumentException();
        }

        // placeholder nodes for head and tail of this StoutList
        head = new Node();
        tail = new Node();
        // link head and tail of this StoutList
        head.next = tail;
        tail.previous = head;
        // set nodeSize of this StoutList
        this.nodeSize = nodeSize;
    }

    /**
     * Constructor for grading purposes only. Fully implemented.
     *
     * @param head     placeholder node for head of StoutList
     * @param tail     placeholder node for tail of StoutList
     * @param nodeSize number of elements that may be stored in each node of this StoutList
     * @param size     number of elements in this StoutList
     */
    public StoutList(Node head, Node tail, int nodeSize, int size) {
        this.head = head;
        this.tail = tail;
        this.nodeSize = nodeSize;
        this.size = size;
    }


    /**
     * Returns the size of the StoutList if it is less than Integer.MAX_VALUE. Otherwise, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        // if the size is greater than the max value of an integer, return the max value of an integer
        return Math.min(size, Integer.MAX_VALUE);
    }

    /**
     * Overrides the 'add' method of a parent class, taking an object 'item' of generic type E as a parameter. It checks
     * if the given 'item' is null; if so, it throws a NullPointerException. If 'item' is not null, it calls another
     * 'add' method with two arguments: 'size' and 'item', and then returns true.
     *
     * @param item element whose presence in this collection is to be ensured
     * @return true if this collection changed as a result of the call
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean add(E item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException();
        }

        add(size, item);
        return true;
    }

    /**
     * Inserts the specified element at the specified position in the StoutList.Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (adds one to their indices).The method returns void.
     *
     * @param position index at which the specified element is to be inserted.
     * @param item     element to be inserted into the StoutList.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    @Override
    public void add(int position, E item) {
        if (item == null) {
            throw new NullPointerException();
        }

        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }

        NodeInfo nodeInfo = find(position);
        add(nodeInfo.node, nodeInfo.offset, item);
    }


    /**
     * Removes the element at the specified position in the StoutList. Shifts any subsequent elements to the left
     * (subtracts one from their indices). Returns the element that was removed from the StoutList according to the
     * specification of the parent class.
     *
     * @param position the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public E remove(int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }

        NodeInfo nodeInfo = find(position);
        return remove(nodeInfo);
    }

    /**
     * Sort all elements in the stout list in the NON-DECREASING order. Traverse the list and copy its elements into an
     * array, deleting every visited node along the way.  Then, sort the array by calling the insertionSort() method.
     * (Note that sorting efficiency is not a concern for this project.) Finally, copy all elements from the array back
     * to the stout list, creating new nodes for storage. After sorting, all nodes but (possibly) the last one must be
     * full of elements.
     * <p>
     * Comparator<E> must have been implemented for calling insertionSort().
     */
    public void sort() {
        Iterator<E> iterator = iterator();

        E[] sortDataList = (E[]) new Comparable[size()];

        for (int i = 0; i < size; i++) {
            sortDataList[i] = iterator.next();
        }

        head.next = tail;
        tail.previous = head;
        size = 0;

        Comparator<E> comp = new genericComparator();
        insertionSort(sortDataList, comp);
    }

    /**
     * Sort all elements in the Stout list in the NON-INCREASING order. Call the bubbleSort() method. After sorting, all
     * but (possibly) the last nodes must be filled with elements.
     * <p>
     * Comparable<? Super E> must be implemented for calling bubbleSort().
     */
    public void sortReverse() {
        Iterator<E> iterator = iterator();
        E[] ReverseSortDataList = (E[]) new Comparable[size];

        for (int i = 0; i < size; i++) {
            ReverseSortDataList[i] = iterator.next();
        }

        head.next = tail;
        tail.previous = head;
        size = 0;

        bubbleSort(ReverseSortDataList);

        this.addAll(Arrays.asList(ReverseSortDataList));
    }

    /**
     * Returns an iterator over the elements in this list (in proper sequence) at the beginning of the StoutList.
     *
     * @return an iterator over the elements in this list (in proper sequence)
     */
    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @return a list iterator over the elements in this list (in proper sequence)
     */
    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @param index index of the first element to be returned from the list iterator (by a call to next)
     * @return a list iterator over the elements in this list (in proper sequence)
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    @Override
    public ListIterator<E> listIterator(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        return new StoutListIterator(index);
    }

    /**
     * Returns a string representation of this list showing the internal structure of the nodes.
     */
    public String toStringInternal() {
        return toStringInternal(null);
    }

    /**
     * Returns a string representation of this list showing the internal structure of the nodes and the position of the
     * iterator.
     *
     * @param iterator an iterator for this list
     */
    public String toStringInternal(ListIterator<E> iterator) {
        int count = 0;
        int position = -1;
        if (iterator != null) {
            position = iterator.nextIndex();
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node current = head.next;
        while (current != tail) {
            sb.append('(');
            E data = current.data[0];

            for (int i = 0; i < nodeSize; ++i) {
                if (i != 0) {
                    sb.append(", ");
                }
                data = current.data[i];
                if (data == null) {
                    sb.append("-");
                }
                else {
                    if (position == count) {
                        sb.append("| ");
                        position = -1;
                    }
                    sb.append(data.toString());
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

    /**
     * Helper method for finding the node and offset of the element at the given position.
     *
     * @param pos position of the element.
     * @return a NodeInfo object containing the node and offset of the element at the given position.
     */
    private NodeInfo find(int pos) {
        if (pos == -1) {
            return new NodeInfo(head, 0);
        }

        if (pos == size) {
            return new NodeInfo(tail, 0);
        }

        Node current = head.next;
        int index = current.count - 1;

        while (current != tail && pos > index) {
            current = current.next;
            index += current.count;
        }

        int offset = current.count + pos - index - 1;

        return new NodeInfo(current, offset);
    }

    /**
     * Helper method for adding an element to the list at the given position.
     *
     * @param node   node to add the element to.
     * @param offset offset of the element in the node.
     * @param item   element to add.
     * @return a NodeInfo object containing the node and offset of the added element.
     */
    private NodeInfo add(Node node, int offset, E item) {
        // if the item is null, throw a NullPointerExceptions
        if (item == null) {
            throw new NullPointerException();
        }

        NodeInfo NodeInfo = null;

        // if the list is empty, create a new node and add the item to it
        if (size == 0) {
            Node Node = new Node();

            Node.addItem(item);
            link(head, Node);
            NodeInfo = new NodeInfo(Node, 0);
        }
        else if (offset == 0 && node.previous.count < nodeSize && node.previous != head) {
            // if the offset is 0, the node is not the head, and the previous node has space, add the item to the previous node
            node.previous.addItem(item);
            NodeInfo = new NodeInfo(node.previous, node.previous.count - 1);
        }
        else if (offset == 0 && node == tail && node.previous.count == nodeSize) {
            // if the offset is 0, the node is the tail,
            // and the previous node is full, create a new node and add the item to it
            Node Node = new Node();

            Node.addItem(item);
            link(tail.previous, Node);
            NodeInfo = new NodeInfo(Node, 0);

        }
        else if (node.count < nodeSize) {
            // if the node has space, add the item to it
            node.addItem(offset, item);
            NodeInfo = new NodeInfo(node, offset);
        }
        else {
            // if the node is full, create a new node and add the item to it
            Node Node = new Node();

            link(node, Node);

            for (int i = nodeSize - 1; i >= nodeSize - nodeSize / 2; i--) {
                Node.addItem(0, node.data[i]);
                node.removeItem(i);
            }

            if (offset <= nodeSize / 2) {
                node.addItem(offset, item);
                NodeInfo = new NodeInfo(node, offset);
            }
            else {
                Node.addItem(offset - nodeSize / 2, item);
                NodeInfo = new NodeInfo(Node, offset - nodeSize / 2);
            }
        }

        size++;
        return (NodeInfo);
    }

    /**
     * Helper method for removing an element from the StoutList at the given position.
     *
     * @param nodeInfo NodeInfo object containing the node and offset of the element to remove.
     * @return the removed element.
     */
    private E remove(NodeInfo nodeInfo) {
        E E = nodeInfo.node.data[nodeInfo.offset];

        if (nodeInfo.node.next == tail && nodeInfo.node.count == 1) {
            unlink(nodeInfo.node);
        }

        else if (nodeInfo.node.next == tail || nodeInfo.node.count > nodeSize / 2) {
            nodeInfo.node.removeItem(nodeInfo.offset);
        }

        else if (nodeInfo.node.count <= nodeSize / 2) {
            nodeInfo.node.removeItem(nodeInfo.offset);

            if (nodeInfo.node.next.count > nodeSize / 2) {
                nodeInfo.node.addItem(nodeInfo.node.next.data[0]);
                nodeInfo.node.next.removeItem(0);
            }
            else {
                for (E e : nodeInfo.node.next.data) {
                    if (e != null) {
                        nodeInfo.node.addItem(e);
                    }
                }

                unlink(nodeInfo.node.next);
            }
        }

        size--;

        return (E);
    }

    /**
     * Helper method for linking two nodes together.
     *
     * @param current node to link to the new node.
     * @param newNode node to link to the current node.
     */
    private void link(Node current, Node newNode) {
        newNode.previous = current;
        newNode.next = current.next;
        current.next.previous = newNode;
        current.next = newNode;
    }

    /**
     * Helper method for separating a node from the list.
     *
     * @param current node to separate from the next node.
     */
    private void unlink(Node current) {
        // set the previous node's next to the next node in the StoutList
        current.previous.next = current.next;
        // set the next node's previous to the previous node in the StoutList
        current.next.previous = current.previous;
    }

    /**
     * Sort an array arr[] using the insertion sort algorithm in the NON-DECREASING order.
     *
     * @param arr  array storing elements from the list
     * @param comp comparator used in sorting
     */
    private void insertionSort(E[] arr, Comparator<? super E> comp) {
        // for each element in the array
        for (int i = 1; i < arr.length; i++) {
            // store the current element in a temporary variable
            E temp = arr[i];
            // store the index of the previous element
            int j = i - 1;
            // while the previous element is greater than the current element
            while (j > -1 && comp.compare(arr[j], temp) > 0) {
                // move the previous element to the next index
                arr[j + 1] = arr[j];
                // decrement the index of the previous element
                j--;
            }
            // insert the current element into the array
            arr[j + 1] = temp;
        }


        this.addAll(Arrays.asList(arr));
    }

    /**
     * Sort arr[] using the bubble sort algorithm in the NON-INCREASING order. For a description of bubble sort please
     * refer to Section 6.1 in the project description. You must use the compareTo() method from an implementation of
     * the Comparable interface by the class E or ? super E.
     *
     * @param arr array holding elements from the list
     */
    private void bubbleSort(E[] arr) {
        boolean swap = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) < 0) {
                E temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
                swap = true;
            }
        }

        if (swap) {
            bubbleSort(arr);
        }
    }

    /**
     * A private class comparator that implements the Comparator interface. It is used to compare two objects of type
     * E.
     *
     * @param <E> the type of the objects to be compared.
     */
    private static class genericComparator<E extends Comparable<? super E>> implements Comparator {
        /**
         * Compares two objects of type E.
         *
         * @param object1 the first object to be compared.
         * @param object2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or
         * greater than the second.
         */
        @Override
        public int compare(Object object1, Object object2) {
            E first = (E) object1;
            E second = (E) object2;

            return first.compareTo(second);
        }
    }

    /**
     * Node type for this list. Each node holds a maximum of nodeSize elements in an array. Empty slots are null.
     */
    private class Node {
        /**
         * Array of actual data elements. Unchecked warning unavoidable.
         */
        public E[] data = (E[]) new Comparable[nodeSize];

        /**
         * link to next node.
         */
        public Node next;

        /**
         * link to previous node;
         */
        public Node previous;

        /**
         * Index of the next available offset in this node, also equal to the number of elements in this node.
         */
        public int count;

        /**
         * Adds an item to this node at the first available offset. Precondition: count < nodeSize
         *
         * @param item element to be added
         */
        void addItem(E item) {
            if (count >= nodeSize) {
                return;
            }
            data[count++] = item;
        }

        /**
         * Adds an item to this node at the indicated offset, shifting elements to the right as necessary.
         * <p>
         * Precondition: count < nodeSize
         *
         * @param offset array index at which to put the new element
         * @param item   element to be added
         */
        void addItem(int offset, E item) {
            if (count >= nodeSize) {
                return;
            }
            for (int i = count - 1; i >= offset; --i) {
                data[i + 1] = data[i];
            }

            ++count;
            data[offset] = item;
            // useful for debugging
            // System.out.println("Added " + item.toString() + " at index " + offset + " to node: " + Arrays.toString(data));
        }

        /**
         * Deletes an element from this node at the indicated offset, shifting elements left as necessary. Precondition:
         * 0 <= offset < count
         *
         * @param offset array index of element in the data array of this node to be removed.
         */
        void removeItem(int offset) {
            for (int i = offset + 1; i < nodeSize; ++i) {
                data[i - 1] = data[i];
            }

            data[count - 1] = null;
            --count;
        }
    }

    /**
     * Private inner class for the StoutList that establishes a node information object. It contains a node, an offset,
     * and a boolean value that indicates whether the element exists in the node.
     */
    private class NodeInfo {

        /**
         * Node in the list.
         */
        public Node node;
        /**
         * Offset in the node.
         */
        public int offset;

        /**
         * A constructor that creates a new node information object with the given node and offset. The existence is set
         * to true with this constructor.
         *
         * @param node   the node that contains the element for the node information object.
         * @param offset the offset of the element in the node for the node information object.
         */
        public NodeInfo(Node node, int offset) {
            this.node = node;
            this.offset = offset;
        }
    }

    /**
     * A private class of an Iterator object that implements the ListIterator interface
     */
    private class StoutListIterator implements ListIterator<E> {
        /**
         * An integer that stores the index of the next element.
         */
        private int index;

        /**
         * A NodeInfo object that stores the last action performed by the iterator.
         */
        private NodeInfo lastAction;

        /**
         * A boolean value that indicates whether the remove method can be called.
         */
        private boolean removable;

        /**
         * Default constructor for the StoutListIterator.
         */
        public StoutListIterator() {
            index = 0;
            lastAction = null;
            removable = false;
        }

        /**
         * Constructor finds node at a given position.
         *
         * @param pos position in the list.
         */
        public StoutListIterator(int pos) {
            if (pos < 0 || pos > size) {
                throw new IndexOutOfBoundsException();
            }

            index = pos;
            lastAction = null;
            removable = false;
        }

        /**
         * Returns true if there is a next element in the list.
         *
         * @return true if there is a next element in the list.
         */
        @Override
        public boolean hasNext() {
            return (index < size);
        }

        /**
         * Returns the next element in the list and increments the index.
         *
         * @return the next element in the list.
         * @throws NoSuchElementException if there is no next element.
         */
        @Override
        public E next() throws NoSuchElementException {
            if (hasNext()) {
                NodeInfo n = find(index++);

                lastAction = n;
                removable = true;

                return (n.node.data[n.offset]);
            }

            throw new NoSuchElementException();
        }

        /**
         * Removes the last element returned by the iterator.
         *
         * @throws IllegalStateException if the remove method is called twice in a row.
         */
        @Override
        public void remove() {
            // if you can't remove, throw an exception
            if (!removable) {
                throw new IllegalStateException();
            }
            // find the node at the current index
            NodeInfo cursorInfo = find(index);
            // if the last action was on the same node and the offset is less than the current index,
            // decrement the index
            if (lastAction.node != cursorInfo.node || lastAction.offset < cursorInfo.offset) {
                index--;
            }
            StoutList.this.remove(lastAction);
            lastAction = null;
            removable = false;
        }

        /**
         * Evaluates the condition: is there a previous element in the list?
         */
        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        /**
         * Returns the previous element in the StoutList Iterator.
         *
         * @return the previous element in the StoutList Iterator.
         * @throws NoSuchElementException if there is no previous element.
         */
        @Override
        public E previous() throws NoSuchElementException {
            if (hasPrevious()) {
                NodeInfo n = find(--index);
                lastAction = n;
                removable = true;
                return n.node.data[n.offset];
            }

            throw new NoSuchElementException();
        }

        /**
         * Returns the next index of the StoutList Iterator.
         *
         * @return the next index of the StoutList Iterator.
         */
        @Override
        public int nextIndex() {
            return index;
        }

        /**
         * Returns the previous index of the StoutList Iterator.
         *
         * @return the previous index of the StoutList Iterator.
         */
        @Override
        public int previousIndex() {
            return index - 1;
        }

        /**
         * Sets the element at the current index of the StoutList Iterator.
         *
         * @param E the element to be set.
         */
        @Override
        public void set(E E) {
            // if the element is null, throw an exception
            if (E == null) {
                throw new NullPointerException();
            }
            // if not removable, throw an exception
            if (!removable) {
                throw new IllegalStateException();
            }

            lastAction.node.data[lastAction.offset] = E;
        }

        /**
         * Adds an element to the StoutList Iterator.
         *
         * @param e the element to be added.
         */
        @Override
        public void add(E e) {
            // if the element is null, throw an exception
            if (e == null) {
                throw new NullPointerException();
            }

            removable = false;
            StoutList.this.add(index++, e);
        }
    }
}
