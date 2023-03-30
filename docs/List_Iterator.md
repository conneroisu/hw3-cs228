# Introduction 
The list iterator in java isan interface that allows us to traverse a list in both forward and backward directions. It is a subinterface of the Iterator interface and provides additional methods to manipulate the list during iteration. ListIterator can be used only with lists, such as ArrayList, LinkedList, etc., and not with sets or maps because they do not maintain any order of elements. In summary, ListIterator provides more functionality than Iterator, such as traversing both forward and backward directions, modifying elements during iteration, and obtaining indexes of elements. 

The list iterator is a member of the java collections framework meaning that it is a part of a unified architecture for representing and manipulating collections as described: [Java SE 7 Collections-Related APIs and Developer Guides (oracle.com)](https://docs.oracle.com/javase/7/docs/technotes/guides/collections/index.html).

Oracle Documentation: [ListIterator (Java Platform SE 7 ) (oracle.com)](https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html)
# Methods 
The ListIterator interface provides the following methods:

1. hasNext(): Returns true if there is a next element in the list.
2. next(): Returns the next element in the list.
3. hasPrevious(): Returns true if there is a previous element in the list.
4. previous(): Returns the previous element in the list.
5. nextIndex(): Returns the index of the next element in the list.
6. previousIndex(): Returns the index of the previous element in the list.
7. remove(): Removes from the list the last element returned by next() or previous().
8. set(E e): Replaces the last element returned by next() or previous() with a specified element.
9. add(E e): Inserts a specified element into the list immediately before or after an iterator's current position.


# Conclusion 
