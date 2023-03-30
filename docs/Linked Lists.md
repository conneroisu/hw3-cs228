# Introduction
Linked Lists area data structure used in computer programming to store and organize data. They consist of a sequence of nodes, each containing a piece of data and a reference to the next node in the list. This allows for efficient insertion and deletion of elements, as well as easy traversal of the list. Linked Lists are commonly used in applications such as file systems, memory allocation, and graph algorithms. There are several types of Linked Lists, including singly linked lists, doubly linked lists, and circular linked lists. 

Linked lists are a popular data structure used in computer science to store and manage collections of data. Unlike arrays, which store data in contiguous blocks of memory, linked lists use pointers to connect individual nodes of data together. This makes them an ideal choice for situations where memory allocation and management are critical concerns.

One of the key advantages of linked lists is their flexibility. Because each node contains a pointer to the next node in the list, it's easy to add or remove elements from the list without having to shift around large blocks of memory. This makes linked lists particularly useful for applications that require frequent updates or modifications to the data they store.

However, there are also some limitations to using linked lists. For example, because there is no built-in size function for a rudimentary linked list, iterating over all elements in the list requires traversing each node individually using a loop. This can be more time-consuming than simply accessing elements in an array using an index.

Despite these limitations, linked lists remain a popular choice for many applications due to their efficient memory management and flexibility. Whether you're working on a small personal project or building complex software systems, understanding how linked lists work can help you make informed decisions about which data structures to use in your code.
Each Node has an E data  and also a Node next.

## Iterating through a linked list:

for loop is actually higher  effort! We do not have size  implemented for a rudimentary linked list.

a while loop with the condition

"My Node is not null" is the 
easiest way to traverse a 
linked list.

Node current = head;
while(current !=null){
	System.out.println(current.data);
	current = current.next;
}
Loop terminates when we are at the end of the list and do not have a data item in the current reference.

Weakness of this structure: 
previous element is not easily  accessible; O(n) is the cost of getting to the predecessor node.
Starting at head,  current = current.next until  current.next is myself.

Deleting in a linked list.
The delete operation is actually  reassigning a current.next to  another node.

If we have the following list:

head-->A-->B--->C--->null

and we are deleting the node with B:

head.next = head.next.next;
	Translated to English:
	Copy the "C" node address 
	to be the next node for the "A"
	node.

At that point, the Node with "B" 
has no references pointing to it; 
will be garbage collected in the 
"immediate" future.

What are the weaknesses of 
a singly-linked, null-terminated
 list:

1. Cannot easily go back one 
element.
	--add a "Node previous" reference
2. No fast searching: if 
we implemented binary search, 
we have to make each move 
by iterating through the elements.
	--cannot be mitigated

However, singly-linked, null-terminated
lists are perfectly capable data 
structures.

The killer application is stack.
 All it needs is a singly-linked 
 null-terminated list.


Doubly-linked list
```
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
  
Node cursor: hook to the next  node with a payload to be returned.
Node pending: hook to the node with  the last returned payload.
Pending here means "pending for deletion" "candidate for deletion"
If pending is null, remove() will  not work.


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
	
