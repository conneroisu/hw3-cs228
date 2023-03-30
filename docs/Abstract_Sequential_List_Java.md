# Introduction 
AbstractSequentialList is an abstract class that provides a skeletal implementation of the List interface for lists that allow sequential access to their elements. You can use any sorting algorithm that works with lists to sort an AbstractSequentialList. It implements the List Iterable and Collection interfaces. It provides a skeletal implementation of the List interface to minimize the effort required to implement this interface backed by a "sequential access" data store (such as a linked list). 

Because this class offers a skeletal implementation of the List Interface, implementing this class allows for the minimization of effort and code required to implement sequential data structuresAbstract Sequential List in Java is a class that provides a basic implementation of the List Interface. This class serves as a template for creating sequential data structures, such as arrays and linked lists, by providing default implementations for common methods like add(), remove(), and get(). By extending this class, developers can save time and effort in implementing their own custom data structures. The Abstract Sequential List class also ensures that the underlying data structure maintains its sequential order, making it suitable for use cases where order is important.. 

# AbstractSequentialList Methods

# Manipulation Methods
## ```add(int index, E element)```
Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).

## ``addAll(int index, Collection<? extends E> c)```
Inserts all of the elements in the specified collection into this list, starting at the specified position. Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). The new elements will appear in the list in the order that they are returned by the specified collection's iterator.

## ```remove(int index)```
Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.

## ```set(int index, E element)``` 
Replaces the element at the specified position in this list with the specified element. In other words, the `set(int index, E element)` method in Java replaces the element at the specified position in a sequential list with the specified element. The index parameter specifies the position of the element to be replaced, and the element parameter specifies the new value to be set at that position.

### Parameters
The `set()` method takes two parameters:
- `index`: an integer value representing the position of the element to be replaced.
- `element`: an object of type E representing the new value to be set at that position.

### Return Value
The `set()` method returns the previous value of the element at the specified position.

### Exceptions
The `set()` method may throw an IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).

### Example
Consider a sequential list of integers as follows:

```java
List<Integer> myList = new ArrayList<>();
myList.add(10);
myList.add(20);
myList.add(30);
```

To replace an element in this list, we can use the `set()` method as shown below:

```java
int previousValue = myList.set(1, 25);
System.out.println("Previous value: " + previousValue); // Output: Previous value: 20

System.out.println(myList); // Output: [10, 25, 30]
```

In this example, we replaced the second element (index 1) with a new value of 25. The previous value at that position was 20..
### Syntax
The syntax of using the `set(int index, E element)` method is as follows:

```java
public E set(int index, E element)
```
# Content Methods
## ```get(int index)```
Returns the element at the specified position in this list.

## ```listIterator(int index)```
Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list. The specified index indicates the first element that would be returned by an initial call to next. An initial call to previous would return the element with the specified index minus one.

## subList(int fromIndex, int toIndex)
Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the returned list is empty.) The returned list is backed by this list, so non-structural changes in the returned list are reflected in this list, and vice-versa. The returned list supports all of the optional list operations supported by this list.

## ```toString()```
Returns a string representation of this collection. The string representation consists of a list of the collection's elements in the order they are returned by its iterator, enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", " (comma and space). Elements are converted to strings as by String.valueOf(Object).

# AbstractSequentialList Fields
## protected transient int modCount
The number of times this list has been structurally modified. Structural modifications are those that change the size of the list, or otherwise perturb it in such a fashion that iterations in progress may yield incorrect results.
