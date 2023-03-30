# Introduction 

The doubly linked list is a type of data structure that consists of nodes that contain both a reference to the next node and the previous node in the list. This allows for efficient traversal in both directions, making it useful for certain applications such as implementing a deque (double-ended queue).Each node in a doubly linked list contains three fields: the data field, the next field, and the previous field. The data field stores the actual data that is being stored in the list. The next field contains a reference to the next node in the list, while the previous field contains a reference to the previous node in the list.

To create a doubly linked list, we start by creating a head node that does not contain any data. This head node will serve as a placeholder and will always be present in the list. We additionally, create a dummy tail nodethat also does not contain any data. This tail node will serve as a marker for the end of the list.

Each node in a doubly linked list contains three fields: a data field, a pointer to the next node, and a pointer to the previous node. The first node after the head node is called the first node, and the last node before the tail node is called the last node.

## Nodes

A node in a doubly linked list is a data structure that contains two pointers, one pointing to the previous node and one pointing to the next node in the list. It also contains a data element that holds the actual value or information stored in that particular node. The first node in the list is called the head and the last node is called the tail. Each node can be accessed by following either of its pointers, allowing for efficient traversal of the list in both directions.

### Node Addition

To insert a new node into a doubly linked list, we first create a new node with the desired data, and then adjust the pointers of the adjacent nodes to include the new node depending on where we want to insert it. 

For example, if we want to insert a new node between nodes A and B inside of a list containing A and B, we would first create the new node with its data. Then, we would set the next pointer of A to point to the new node, and set the previous pointer of B to point to the new node as well. Finally, we would set the next pointer of the new node to point to B, and set its previous pointer to 

#### Inserting at the beginning

If we want to insert the new node at the beginning of the list, we set the new node's next pointer to point to the current head of the list, and set the current head's previous pointer to point to the new node. Then we update the head pointer to point to the new node.

#### Inserting in the middle

If it is a node in between, we update its previous node's next pointer to point to its next node and its next node's previous pointer to point to its previous node.

#### Inserting at the end

If we want to insert the new node at the end of the list, we set the new node's previous pointer to point to the current tail of the list and the current tail's next pointer to point to the new node. Then we update the tail pointer to point to the new node.

### Node Deletion

To delete a node from a doubly linked list, we first check if itis the head or tail node. If it is the head node, we simply update the head pointer to point to the next node and set the previous pointer of the new head to NULL. If it is the tail node, we update the tail pointer to point to the previous node and set its next pointer to NULL. If the node to be deleted is neither the head nor the tail, we update the next pointer of the previous node to point to the next node and update the previous pointer of the next node to point to the previous node. Finally, we free the memory allocated for the deleted node.


# Performance

| Big-O: | Array | LinkedList |
| --- | --- | --- |
| get(int index) | O(1) | O(n) |
| contains(E item) | O(logn) | O(n) |
| size() | O(1) | O(1) |
| add() | O(1) | O(1) |
| remove(E item) | O(n) | O(1) |
| iterator.add() | O(n) | O(1) |
| iterator.remove() | O(n) | O(1) |
| iterator.set() | O(1) | O(1) |

When compared to an array-based structure, the doubly linked list has some advantages and disadvantages. While it has O(1) performance for adding and removing elementsat both the beginning and end of the list, it has a higher overhead due to the need for each node to store two pointers (one for the previous node and one for the next node).

When compared to an array-based structure, the doubly linked list has some advantages and disadvantages. While it has O(1) performance for adding and removing elementsat both the beginning and end of the list, it has a higher overhead due to the need for each node to store two pointers (one for the previous node and one for the next node).

One advantage of a doubly linked list is that it allows for efficient traversal in both directions. This can be useful in certain applications, such as implementing a text editor where users may need to move back and forth through a document.

Another advantage is that it allows for easy removal of nodes from anywhere in the list.

A doubly linked list is a type of data structure that consists of a series of nodes, each containing a value and pointers to the previous and next nodes in the list. This allows for efficient traversal of the list in both directions, as well as easy insertion and removal of nodes.

Another advantage of a doubly linked list over a singly linked list is that it allows for efficient traversal in both directions. This can be useful in situations where you need to access elements in reverse order or perform operations on adjacent
1. AbstractSequentialList class hierarchy List is huge; writing an implementation from scratch will take days.

We will extend AbstractSequentialList (like with AbstractCollection) If you remember, when implementing  DoublyLinkedCollection, we had issues with too many if statements and special conditions. The solution to this problem is the inclusion of a dummy head and tail node inthe doubly linked list. A dummy head node is a node that does not contain any data, but serves as the starting point for the list. Similarly, a dummy tail node serves as the ending point for the list. By including these dummy nodes, we can simplify our code and avoid special conditions for empty lists or adding/removing nodes at the beginning or end of the list.

3. Constructor
```java
  public DoublyLinkedList()
  {
    head = new Node(null);
    tail = new Node(null);
    head.next = tail;
    tail.previous = head;
    size = 0;
  }
  ```

# Helper Methods
 We will write private helper methods to minimize code duplication. Helper methods should be private and not check for incorrect condition as this is the job of the public methods who use the helper methods.  Some common operations on a doubly linkedlist include inserting a node at the beginning or end of the list, deleting a node from the list, and traversing the list forwards or backwards.

Some useful helper methods can be found in the code block below:
```java
 link(), unlink(), findNodeByIndex() 
 // private methods that makes a linked list behave like an  array
```

## `link()` Method 
O(1)
The link method inserts node after current without incrementing the size of the list. 
```java
private void link(Node current, Node newNode){
	newNode.next = current.next;
	newNode.previous = current;
	current.next.previous = newNode;
	current.next = newNode;
} //4 instructions; O(1) performance
```

## `unlink()` Rearranges incoming links to the node
O(1)
```java
/**
*	Just rearrange the incoming links. Then the node can be deleted with 
*   current = null, after the method has been run.
*/
private void unlink(Node current){
	current.next.previous = current.previous; 
	current.previous.next = current.next;
}
```


## `findNodeByIndex(int position)` Method (O(n))

This method is O(n) because it has to traverse the list to find the node at the specified index.

This method makes the linked list behave like it is an array. One common use case for a doubly linked list is to make it behave like an array. This can be achieved by maintaining a reference to both the head and tail nodes, as well as keeping track of the length of the linked list. This modification allows for the referencing of arbitrary indices.
```java
private Node findNodeByIndex(int pos){
	//do not check if pos is legal
	
	if (pos == -1) return head;
	if (pos == size) return tail;//optimization
	
	int index = 0;
	Node current = head.next; 
	while(index < pos){
		current = current.next;
		index++;
	}
	return current;
}		
```
 
Additional Note: that after your find a node using an index you can find the referenced index using the remainder in a division operation of the position / node_data_length which is shown in the code block below:

```java 
int offset = position % node_data_length
```

# Methods without an iterator.
To acheive performace within a doubly linked list, there are a few methods inside of the class that are required to not utilize the iterator.

```java
//add at the tail
public boolean add(E item){
	Node newNode = new Node(item);
	link(tail.previous, newNode);
	size++;
	return true;
}

//add at arbitrary location - 
//the "overwritten" items should 
//be pushed to the right, to index pos+1
public void add(int pos, E item){
	if(pos < 0 || pos > size)
		throw new IndexOutOfBoundsException();
	//link works with the previous node.
	//so we can find the previous node by 
	//index, then add a new node right after 
	//this will "add to the left" to the 
	//requested index.
	Node newNode = new Node(item);
	Node previous = findNodeByIndex(pos-1);
	link(previous,newNode);
	size++;
}
```

# Iterator Constructors
```java
public ListIterator<E> listIterator()
{
	return new DoublyLinkedIterator();
}
public ListIterator<E> listIterator(int pos)
{
	return new DoublyLinkedIterator(pos);
}

private class DoublyLinkedIterator implements ListIterator<E>
{
	// direction for remove() and set()
	private static final int BEHIND = -1; //behind means "to the LEFT"
	private static final int AHEAD = 1; //ahead means "to the RIGHT"
	private static final int NONE = 0;
	private Node cursor;
	private int index;
	private int direction;
// Cursor points to the node returned by next() or previous index is the int position of cursor
public DoublyLinkedIterator(int pos)
{
	if (pos < 0 || pos > size)
		throw new IndexOutOfBoundsException ("" + pos);
	cursor = findNodeByIndex(pos);
	index = pos;
	direction = NONE;
}	
//after initializing here, next() serves the current index and advances to pos+1. Previous() would serve the PREVIOUS index.
		
public DoublyLinkedIterator()
{
	this(0);
}
```

## Visualization of iterator.

REMINDER: direction variable is the "direction of removal", not the direction of movement!
```text
	Next() then Previous()
	or
	Previous() then Next() 
	always serve the same element twice.

        V
     [Z] [A] [B] [C] [D]
```
next() will serve A!  so nextIndex() is 1!
which happens to be the index of the cursor.

Going backward:

previous will serve Z.  So previousIndex() is 0. 0 is the index that is cursor index -1.

2. Method code.
```java
nextIndex(){
	return index;
}

previousIndex(){
	return index - 1;
}

hasNext(){
	return index < size;
}

hasPrevious(){
	return index > 0;
}
```

# Iterator Methods
| Method | Description | Big-O |
| --- | --- | --- |
| next() | Returns the next element in the list and advances the cursor position. | O(1) |
| previous() | Returns the previous element in the list and moves the cursor position backwards. | O(1) |
| add(E item) | Inserts the specified element into the list. The element is inserted immediately before the element that would be returned by next(), if any, and after the element that would be returned by previous(), if any. (If the list contains no elements, the new element becomes the sole element on the list.) The new element is inserted before the implicit cursor: a subsequent call to next would be unaffected, and a subsequent call to previous would return the new element. (This call increases by one the value that would be returned by a call to nextIndex or previousIndex.) | O(1) |
| set(E item) | Replaces the last element returned by next() or previous() with the specified element (optional operation). This call can be made only if neither ListIterator.remove nor ListIterator.add have been called after the last call to next or previous. | O(1) |
| remove() | Removes from the list the last element that was returned by next() or previous() (optional operation). This call can only be made once per call to next or previous. It can be made only if ListIterator.add has not been called after the last call to next or previous. | O(1) |
| hasNext() | Returns true if the iteration has more elements. (In other words, returns true if next would return an element rather than throwing an exception.) | O(1) |
| hasPrevious() | Returns true if the list iterator has more elements when traversing the list in the reverse direction. (In other words, returns true if previous would return an element rather than throwing an exception.) | O(1) |
| nextIndex() | Returns the index of the element that would be returned by a subsequent call to next. (Returns list size if the list iterator is at the end of the list.) | O(1) |
| previousIndex() | Returns the index of the element that would be returned by a subsequent call to previous. (Returns -1 if the list iterator is at the beginning of the list.) | O(1) |

# Example Code 
A doubly linked list is a type of linked list in which each node has two pointers: one pointing to the next node and one pointing to the previous node. To access the next node in a doubly linked list, you can use the next pointer of the current node. For example, if you have a node called `current`, you can access the next node by `current.next`. Here is an example of a doubly linked list in Java³:

```java   
E next(){
	if (!hasNext())
		throw new NoSuchElementException();
	E returnValue = cursor.data;
	cursor = cursor.next;
	index++;
	direction = BEHIND;
	return returnValue;
}

E previous(){

	if (!hasPrevious())
		throw new NoSuchElementException();
	cursor = cursor.previous
	index--;
	direction = AHEAD;
	return cursor.data; //asymmetry means 
						//cursor is on the element 
						//to be served, AFTER the 
						//cursor update.
}


/**
* Direction-independent operation.
* Always adds to the left.
*/
public void add(E item)
{
	Node temp = new Node(item);
	link(cursor.previous, temp);
	++index;
	++size;
	direction = NONE;
}

void set(E item) {
	if( direction == NONE)
		throw new IllegalStateException();
	if (direction == AHEAD){ //we a did a previous()
					//means TO_THE_RIGHT
		cursor.data = item;
	}
	else if (direction == BEHIND){//we did a next()
					//means delete TO_THE_LEFT
		cursor.previous = item;
	}
}

/**
* Direction-dependent; will only execute 
* once in a sequence.
*/
void remove()
	if (direction == NONE)
		throw new IllegalStateException();
					//as opposed to NoSuchElementException()
	if (direction == AHEAD){ //deleting after prev()
		//save the location to move cursor to.
		Node temp = cursor.next;
		unlink(cursor); 
		cursor = temp; 
	}
	else if (direction == BEHIND){//deleting after	
									//next()
		unlink(cursor.previous);
		index--; //fewer train cars to the left of 
				//cursor even though it sat in 
				//place.
	}
	size--;
	direction = NONE;
}
```

# Example Implementation 

```java
public class DoublyLinkedCollection<E>
extends AbstractCollection<E>
{
	private Node head = null;
	private int size = 0;
	private class Node
	{
		public E data;
		public Node next;
		public Node previous;
		
		public Node(E data, Node next, Node previous)
		{
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
	}
}



	@Override
	public int size()
	{
		return size;
	}



  @Override
  public boolean add(E item){
	
    Node temp = new Node(item, head, null);
    if (head != null){
      head.previous = temp;
    }
    
    head = temp;
    ++size;
    return true;
  }
  
  
  Iterator's cursor:
  
  Node cursor: hook to the next 
	node with a payload to be returned.
  Node pending: hook to the node with 
	the last returned payload.
  Pending here means "pending for deletion"
	"candidate for deletion"
	If pending is null, remove() will 
	not work.


  @Override
  public Iterator<E> iterator()
  {
    return new LinkedIterator();
  }

When we are deleting, we will use 
the idiom:

pending.next.previous = pending.previous;
pending.previous.next = pending.next;

  private class LinkedIterator implements Iterator<E>
  {    
    
    
    private Node cursor = head;  
    private Node pending = null; 




	@Override
    public boolean hasNext()
	{
		return cursor != null;
	}
	
	
	@Override 
	public E next(){
		if(!hasNext())
			throw new NoSuchElementException();
	
		E result = cursor.data;
		pending = cursor;
		cursor = cursor.next;
		return result;
	}
	
	@Override 
	public void remove(){
		if (pending == null)
			throw new IllegalStateException();
		//if not at the end of the list, 
	    //pending.next should exist
		if (pending.next != null)
			pending.next.previous = 
				pending.previous;
		//if not at the beginning of the list, 
	    //pending.previous should exist
		if (pending.previous != null)
			pending.previous.next = 
				pending.next;
		//if we are removing the node 
		//at the head, the head needs to 
		//be redirected to be the next node.
		//If the next node is null, so be it!
		if(pending == head)
			head = pending.next;
		size--;
		pending = null;
	
	}
	
	
	```
# Conclusion 

The doubly linked list is a useful data structure that allows for efficient traversal in both directions. By maintaining references to both the head and tail nodes, as well as keeping track of the length of the list, we can make it behave like an array. This makes it a versatile data structure that can be used in a variety of applications.Some key features of a doubly linked list include:

1. Each node in the list contains a reference to the previous and next nodes, allowing for efficient traversal in both directions.

2. The head and tail nodes are special nodes that mark the beginning and end of the list, respectively.

3. The length of the list can be easily tracked by maintaining a count of the number of nodes in the list.

4. Insertion and deletion operations can be performed efficiently by updating references to neighboring nodes.

5. The list can be traversed in either direction, allowing for efficient insertion and deletion operations.