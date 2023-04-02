package edu.iastate.cs228.hw3;

import java.util.*;

/**
 * @param <E> The type of data stored in the list.
 * @author: Conner Ohnesorge
 *         <p>
 *         A doubly linked list that stores data in nodes of size nodeSize.The list is a doubly linked list, having a
 *         placeholder head and tail node.Also, the list has a data array in each node that stores the data.
 *         <p>
 *         The abstract sequential list is extended to provide a doubly linked list implementation with data stored in
 *         arrays in each node. The list is a doubly linked list, having a placeholder head and tail node. The length of
 *         the data array in a StoutList node is the nodeSize, an even and greater than 0 value.
 *         <p>
 */
public class StoutList<E extends Comparable<? super E>> extends AbstractSequentialList<E> {
    /**
     * The default number of elements that may be stored in a node.
     */
    private static final int DEFAULT_NODE_SIZE = 4;
    /**
     * The number of elements that may be stored in each node in the StoutList.
     */
    private final int nodeSize;
    /**
     * The placeholder node for the tail of the StoutList.
     */
    private final Node tail;
    /**
     * The placeholder node for the head of the StoutList.
     */
    public Node head;
    /**
     * The number of elements in the StoutList.
     */
    private int size;

    /**
     * Constructor for grading purposes only. Fully Implemented.
     *
     * @param head     a placeholder node for the head of the StoutList.
     * @param tail     a placeholder node for the tail of the StoutList.
     * @param nodeSize the number of elements that may be stored in a node within this StoutList.
     * @param size     the number of elements in the StoutList.
     */
    public StoutList(Node head, Node tail, int nodeSize, int size) {
        this.head = head;
        this.tail = tail;
        this.nodeSize = nodeSize;
        this.size = size;
    }

    /**
     * A public constructor that constructs an empty list with the given node size.
     *
     * @param nodeSize The number of elements that may be stored in a node. The given nodeSize must be even and greater
     *                 than 0.
     */
    public StoutList(int nodeSize) {
        // if the nodeSize is not even or is less than 0, throw an IllegalArgumentException
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


    /**
     * A public constructor that constructs an empty list with the default node size.
     */
    public StoutList() {
        this(DEFAULT_NODE_SIZE);
    }

    /**
     * A public overridden method that returns a boolean value indicating whether the StoutList is empty.
     *
     * @return a boolean value that is true if the StoutList is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * A public overridden method that adds the given element at the first available position in the StoutList. The
     * method will return true if the StoutList changed as a result of this call, false otherwise.
     *
     * @param item element whose presence in this collection is to be ensured
     * @return a boolean value that returns true if the StoutList changed as a result of this call, false otherwise.
     */
    @Override
    public boolean add(E item) {
        // if the item is null, throw a NullPointerException
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
            if (!nodeInfo.exists) {
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
        // if the item is null, throw a NullPointerException
        if (item == null) {
            throw new NullPointerException();
        }
        // if the position is out of bounds for the StoutList, throw an IndexOutOfBoundsException
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Index: " + position + " is out of bounds for size: " + size);
        }

        NodeInfo nodeInfo = findByIndex(position);
        Node node = nodeInfo.node;
        int offset = nodeInfo.offset;
        node.addItem(offset, item);
        size++;
    }

    /**
     * Removes the element at the given position in the StoutList.Shifts any subsequent elements to the left (subtracts
     * one from their indices),and returns the element that was removed from the list.If the given integer position is
     * out of bounds for the StoutList, the method throws an IndexOutOfBoundsException.
     *
     * @param pos the index of the element to be removed
     * @return the element previously at the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E remove(int pos) throws IndexOutOfBoundsException {
        // if the given integer position is out of bounds for the StoutList, throw an IndexOutOfBoundsException
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

    /**
     * Takes two Node objects as input, 'beforeNode' and 'newNode'. It's used to insert 'newNode' into a doubly-linked
     * list immediately after the 'beforeNode'. The method updates the 'previous' and 'next' pointers of relevant nodes
     * to maintain the order and structure of the list.
     *
     * @param beforeNode the node to link the new node to in order to make the new node the next node of this
     * @param newNode    the node to link to the before node in order to make the
     */
    private void link(Node beforeNode, Node newNode) {
        newNode.next = beforeNode.next; // Set 'newNode's next pointer to point to the node currently following 'beforeNode'.
        newNode.previous = beforeNode; // Set 'newNode's previous pointer to point to 'beforeNode'.
        beforeNode.next.previous = newNode; // Update the previous pointer of the node that follows 'newNode' to point back to 'newNode'.
        beforeNode.next = newNode; // Update the next pointer of 'beforeNode' to point to 'newNode'.
    }


    /**
     * Returns a string representation of the StoutList showing the internal structure of the nodes.
     *
     * @return a string representation of the StoutList
     */
    public String toStringInternal() {
        return toStringInternal(null);
    }

    /**
     * Returns a string representation of this list showing the internal structure of the node s and the position of the
     * iterator.
     *
     * @param listIterator an iterator for StoutList
     * @return a String containing the internal structure of the nodes and iterator in the StoutLIst.
     */
    public String toStringInternal(ListIterator<E> listIterator) {
        int count = 0;
        int position = -1;
        if (listIterator != null) {
            position = listIterator.nextIndex();
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

    /**
     * Exchanges the elements at the given indices.
     *
     * @param arr the array containing the elements to be exchanged.
     * @param j   the index of the first element to be exchanged.
     * @param i   the index of the second element to be exchanged.
     */
    private void exchange(E[] arr, int j, int i) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * Constructs a new StoutListIterator object using the default constructor.
     *
     * @return a new StoutListIterator object.
     */
    @Override
    public ListIterator<E> listIterator() {
        return new StoutListIterator();
    }


    /**
     * Compares two given elements using the given comparator,and returns a boolean value of true if the first element
     * is less than the second element otherwise returns a boolean value of false.
     *
     * @param e    the first element to be compared.
     * @param e1   the second element to be compared.
     * @param comp the comparator to be used to compare the elements.
     * @return true if the first given element is less than the second given element, false otherwise.
     */
    private boolean isLess(E e, E e1, Comparator<? super E> comp) {
        return comp.compare(e, e1) < 0;
    }

    /**
     * Sorts the elements in the StoutList using the insertion sort algorithm to sort the elements of StoutList into
     * ascending order.
     */
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

    /**
     * Removes all the elements from this StoutList. The StoutList will be empty after this call returns.
     */
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

    /**
     * Returns a boolean value representing whether the sum of the given integer and the node size is equal to the
     * maximum integer value. If so, the method returns true, otherwise it returns false.
     *
     * @param sum the sum of the given integer and contents of the node.
     * @return a boolean value representing whether the sum of the given integer and the node size is equal to the
     *         maximum integer value.
     */
    private boolean isMax(int sum) {
        for (int j = 0; j < nodeSize; j++) {
            if (sum + j == Integer.MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this list which is also the size of the StoutList.
     *
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Detaches the given node from the StoutList by updating the previous and next pointers of the node's neighbors.
     *
     * @param current the node to be detached from the StoutList.
     */
    private void unlink(Node current) {
        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence.
     */
    @Override
    public Iterator<E> iterator() {
        return new StoutListIterator();
    }

    /**
     * Constructs a new StoutListIterator object using the given index.
     *
     * @param index index of first element to be returned from the list iterator (by a call to the {@code next} method)
     * @return a new StoutListIterator object at the given index.
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return new StoutListIterator(index);
    }

    /**
     * Sorts the elements in the StoutList using the bubble sort algorithm to sort the elements of StoutList into
     * descending order.
     */
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

    /**
     * A method named `findByIndex` that finds and returns information about a node at a specified index within a custom
     * data structure.The method accepts an integer `index` as a parameter and returns a `NodeInfo` object. 1. The
     * method checks if the provided `index` is greater than the variable `size`. If it is, an
     * `IndexOutOfBoundsException` is thrown with an error message. 2. The method initializes a `Node` variable called
     * `node` to reference the next element after the head and initializes two integers, `previousSum` and `currentSum`.
     * 3. The method enters a while loop that iterates until `node` becomes the tail. a. It calculates the `currentSum`
     * by adding the `previousSum` and the current `node`'s count. B. It checks if the given `index` lies between
     * `previousSum` and `currentSum`. If true, then: i. Calculate `positionInNode` to find the position of the element
     * within the node. Ii. Then, it tries to return a new `NodeInfo` object containing the node, position, and its
     * data. If there's an `IndexOutOfBoundsException`, it creates a new empty node, links it to the previous element in
     * the list, and returns a new `NodeInfo` object with the new node and zero as its offset. c. If the condition in
     * step (b) is false, the `node` is set to its next element, and `previousSum` is updated to the value of
     * `currentSum`. 4. If the loop ends without finding the required node, it creates a new empty node, links it to the
     * previous element in the list, and returns a new `NodeInfo` object with the new node and zero as its position.
     *
     * @param index the index of the element to find
     * @return a NodeInfo object containing information about the node at the given index of the specified element in
     *         the StoutList
     */
    private NodeInfo findByIndex(int index) {
        Node node = head.next;
        int previousSum = 0;
        int currentSum;
        while (!node.isTail()) {
            currentSum = previousSum + node.count;
            if (index > previousSum && index <= currentSum) {
                int positionInNode = index - previousSum;
                try {
                    return new NodeInfo(node, positionInNode, true, node.data[positionInNode]);
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

    /**
     * Sorts an array, arr[], using the bubble sort algorithm to sort the elements of the array in non-increasing, aka
     * decreasing, order.Bubble sort is a sorting algorithm that repeatedly steps through the list compares adjacent
     * elements and swaps them if they are in the wrong order.
     *
     * @param arr array storing elements from the StoutList.
     */
    private void bubbleSort(E[] arr) { // use the size of this to sort arr[] into non-increasing order using bubble sort
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

    /**
     * Sorts an array,arr[], using the insertion sort algorithm in non-decreasing, aka increasing, order
     *
     * @param arr  array storing elements from the StoutList
     * @param comp comparator use in sorting
     */
    private void insertionSort(E[] arr, Comparator<? super E> comp) {
        int N = arr.length;
        for (int ii = 1; ii < N; ii++) {
            for (int j = ii; j > 0 && isLess(arr[j], arr[j - 1], comp); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }

    /**
     * Private inner class for the StoutList that establishes a node information object.
     */
    private class NodeInfo {
        /**
         * The offset of the element in the node for the node information object.
         */
        private final int offset;
        /**
         * A boolean value that indicates whether the element exists in the node for the node information object.
         */
        public boolean exists;
        /**
         * The node that contains the element for the node information object.
         */
        private Node node;
        /**
         * A temporary variable that stores the element for the node information object.
         */
        private E temp;

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
            this.exists = true;
        }

        /**
         * A constructor that creates a new node information object with the given node, offset, and existence.
         *
         * @param node   the node that contains the element for the node information object.
         * @param offset the offset of the element in the node for the node information object.
         * @param exists a boolean value that indicates whether the element exists in the node for the node information
         *               object.
         */
        public NodeInfo(Node node, int offset, boolean exists) {
            this(node, offset);
            this.exists = exists;
        }

        /**
         * A constructor that creates a new node information object with the given node, offset, existence, and
         * temporary variable.
         *
         * @param node   the node that contains the element for the node information object.
         * @param offset the offset of the element in the node for the node information object.
         * @param exists a boolean value that indicates whether the element exists in the node for the node information
         *               object.
         * @param temp   a temporary variable that stores the element for the node information object.
         */
        public NodeInfo(Node node, int offset, boolean exists, E temp) {
            this(node, offset, exists);
            this.temp = temp;
        }
    }

    /**
     * Private inner class for the StoutList that establishes a node.
     */
    private class Node {
        /**
         * The array that stores the elements in the node object of the StoutList.
         */
        public E[] data = (E[]) new Comparable[nodeSize];
        /**
         * A reference to the next node in the StoutList.
         */
        public Node next;
        /**
         * A reference to the previous node in the StoutList.
         */
        public Node previous;
        /**
         * The number of elements in the node object of the StoutList.
         */
        public int count;

        /**
         * A constructor that creates a new node object with a count of 0.
         */
        public Node() {
            this.count = 0;
        }

        /**
         * A constructor that creates a new node object with the given previous node and array of elements.
         *
         * @param previous the previous node in the StoutList.
         * @param items    the array of elements to be added to the node object of the StoutList.
         */
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

        /**
         * A constructor that creates a new node object with the given previous node and element.
         *
         * @param previous the previous node in the StoutList.
         * @param item     the element to be added to the node object of the StoutList.
         */
        public Node(Node previous, E item) {
            super();
            link(previous, this);
            this.addItem(item);
            System.out.println("Added " + item + " at index " + 0 + " to node " + Arrays.toString(data));
        }

        /**
         * A helper method that returns a boolean value representing whether the node is the tail of the StoutList.
         *
         * @return a boolean value representing whether the node is the tail of the StoutList.
         */
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

        /**
         * A helper method that adds an element to the node object of the StoutList at the given offset.
         *
         * @param offset the offset of the element in the node for the node information object.
         * @param item   the element to be added to the node object of the StoutList.
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
            // TODO remove this logging statement
            System.out.println("Added " + item + " at index " + offset + " to node " + Arrays.toString(data));
        }

        /**
         * A private helper method that returns a boolean value representing whether the node is full.
         *
         * @return a boolean value representing whether the node is full. Returns true if the node is full, otherwise
         *         returns false.
         */
        private boolean previousIsFull() {
            try {
                return previous.isFull();
            } catch (NullPointerException e) {
                return true;
            }
        }

        /**
         * A helper method that inserts an element into the node object of the StoutList at the given offset.
         *
         * @param offset the offset of the element in the node for the node information object.
         * @param item   the element to be added to the node object of the StoutList.
         */
        private void insert(int offset, E item) {
            if (count > 1) {
                for (int j = offset + 1; j < nodeSize + 1; j++) {
                    if (data[j] != null) {
                        data[j] = data[j + 1];
                    }
                }
            }
            data[offset] = item;
            count++;
        }

        /**
         * Split the node into two nodes, one with the first half of the data and one with the second half of the data.
         *
         * @param offset the offset of the element in the node for the node information object.
         * @param item   the element to be added to the node object of the StoutList.
         */
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

        /**
         * Method that determines the condition of if the Node is fully filled with elements and returns a boolean value
         * representing the state of said condition.
         *
         * @return a boolean value representing the state of the condition of whether the node is completely full of
         *         elements. More specifically, checks to see if the count of elements in the node is equal to the
         *         nodeSize.
         */
        private boolean isFull() {
            return count == nodeSize;
        }

        /**
         * Method that determines if the node has space for another element, and returns a boolean value representing
         * the state of said condition.
         *
         * @return a boolean value representing the condition of whether the node has space for another element.
         */
        private boolean hasSpace() {
            return count + 1 <= nodeSize;
        }

        /**
         * Method that determines if the current node is not the head node within the StoutList and returns a boolean
         * value representing the state of this condition.
         *
         * @return a boolean value representing the condition of whether the node is the head node of the StoutList.
         */
        private boolean isNotHead() {
            try {
                return previous != null;
            } catch (NullPointerException e) {
                return false;
            }
        }

        /**
         * Deletes an element from this node at the indicated offset shifting elements left as necessary within the
         * StoutList.Has a precondition that the offset is greater than or equal to 0 and less than the count of the
         * node.
         *
         * @param offset the offset of the element to remove from the node.
         */
        void removeItem(int offset) {
            E item = data[offset];
            for (int i = offset + 1; i < nodeSize; ++i) {
                data[i - 1] = data[i];
            }
            data[count - 1] = null;
            --count;
        }
    }

    /**
     * A private class of an Iterator object that implements the ListIterator interface
     */
    private class StoutListIterator implements ListIterator<E> {
        /**
         * A private class constants representing the behind direction of the ListIterator.
         */
        private static final int BEHIND = -1;
        /**
         * A private class constants representing the ahead direction of the ListIterator.
         */
        private static final int AHEAD = 1;
        /**
         * A private class constants representing the none direction of the ListIterator.
         */
        private static final int NONE = 0;
        /**
         * A private node object representing the current node of the StoutList Iterator.
         */
        private final Node current;
        /**
         * Private E object representing the payload of the StoutList Iterator.
         */
        private E payload;
        /**
         * A private integer value representing the index of the StoutList Iterator.
         */
        private int index;
        /**
         * A private integer value representing the direction of the StoutList Iterator.
         */
        private int direction;

        /**
         * The default constructor for a StoutList Iterator at the beginning of the StoutList. For example, if the
         * StoutList is [1, 2, 3, 4, 5], the StoutList Iterator will be at the beginning of the list before the 1.
         */
        public StoutListIterator() {
            this(0);
        }

        /**
         * Constructor for a StoutList Iterator at a specified position. Finds node at a given position. For example, if
         * the StoutList is [1, 2, 3, 4, 5], this StoutList Iterator constructor when called with a positionalValue of
         * 3, the cursor will be before the 4.
         *
         * @param positionalValue the position of the element within the StoutList.
         */
        public StoutListIterator(int positionalValue) {
            if (positionalValue < 0 || positionalValue > size) {
                throw new IndexOutOfBoundsException("Index: " + positionalValue + ", Size: " + size);
            }
            index = positionalValue;
            direction = NONE;
            current = findByIndex(positionalValue).node;

        }

        /**
         * A helper method that returns a boolean value representing whether the StoutList Iterator has a next element.
         *
         * @return a boolean value representing whether the StoutList Iterator has a next element.
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * A helper method that returns the next element in the StoutList Iterator.
         *
         * @return the next element in the StoutList Iterator.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int curIndex = index;
            direction = AHEAD;
            NodeInfo ni = findByIndex(nextIndex());
            payload = ni.node.data[ni.offset];
            return payload;
        }

        /**
         * An overridden public method that returns a boolean value representing whether the StoutList Iterator has a
         * previous element.
         *
         * @return a boolean value representing whether the StoutList Iterator has a previous element.
         */
        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        /**
         * A method that returns the previous element in the StoutList Iterator.
         *
         * @return the previous element in the StoutList Iterator.
         * @throws NoSuchElementException if the StoutList Iterator does not have a previous element.
         */
        @Override
        public E previous() throws NoSuchElementException {
            // if there is no previous element throw a NoSuchElementException
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            index--;
            direction = BEHIND;
            NodeInfo ni = findByIndex(previousIndex());
            payload = ni.node.data[ni.offset];
            return payload;
        }

        /**
         * A method that returns the next index of the StoutList Iterator.
         *
         * @return the next index of the StoutList Iterator.
         */
        @Override
        public int nextIndex() {
            int curIndex = index;
            // if at the beginning of the list return the size of the list
            if (curIndex + 1 >= size) {
                return size;
            }
            return curIndex + 2;
        }

        /**
         * A method that returns the previous index of the StoutList Iterator.
         *
         * @return the previous index of the StoutList Iterator.
         */
        @Override
        public int previousIndex() {
            int curIndex = index;
            NodeInfo ni = findByIndex(curIndex++);
            if (hasPrevious()) {
                curIndex = curIndex - 1;
                return curIndex;
            }
            return -1;
        }

        /**
         * A method that removes the current element(payload) of the StoutList Iterator.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unsupported Operation");
        }

        /**
         * A method that sets the current element(payload) of the StoutList Iterator.
         *
         * @param item the element with which to replace the last element returned by {@code next} or {@code previous}
         * @throws IllegalStateException if neither {@code next} nor {@code previous} have been called
         */
        @Override
        public void set(E item) throws IllegalStateException {
            // if the direction is none throw an IllegalStateException
            if (direction == NONE) {
                throw new IllegalStateException("set() can only be called after next() or previous()");
            }
            NodeInfo ni;
            if (direction == AHEAD) {
                ni = findByIndex(previousIndex());
            } else {
                ni = findByIndex(nextIndex());
            }
            ni.node.data[ni.offset] = item;
        }

        /**
         * A public method that adds an element to the StoutList Iterator following the cursor position.If the given
         * element is null,and the StoutList does not permit null elements, a NullPointerException is thrown.
         *
         * @param item the element to insert into the StoutList that should not be null.
         * @throws NullPointerException if the specified element is null and StoutList. This list does not permit null
         *                              elements
         */
        @Override
        public void add(E item) throws NullPointerException {
            // if the item is null, throw a NullPointerException
            if (item == null) {
                throw new NullPointerException();
            }
            Node temp = new Node();
            NodeInfo ni = findByIndex(nextIndex());
            if (ni.node.isFull()) {
                ni.node.split(ni.offset, item);
                size++; // TODO remove this maybe
            } else {
                ni.node.addItem(ni.offset, item);
            }
            ++size;
            ++index;
            direction = NONE;
        }
    }
}