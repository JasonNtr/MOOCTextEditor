package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head=new LLNode<E>(null);
		tail=new LLNode<E>(null);
		size=0;
		head.next=tail;
		tail.prev=head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		LLNode<E> last=new LLNode<E>(element);
		if (element==null) System.out.println("Surely you want to add a null in your list?");
			last.next=tail;
			last.prev=tail.prev;
			tail.prev.next=last;
			tail.prev=last;
			last.data=element;
			size++;
		
			
			
		// TODO: Implement this method
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{	
		if(size==0) return null;
	    if(index < 0 || index >= size()) {
	    	System.out.println("Out of bounds");
			return  null;
			}
		
			LLNode<E> get=head.next;
			
			for(int i=0;i<index;i++) {
				get=get.next;
				
			}
		return  (E) get.data;
		
		// TODO: Implement this method.
	}
	
	public void reverse() {
		for(int i=0;i<size;i++) {
			System.out.println(get(i));
		}
		
	}
	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{	
		LLNode<E> neo= new LLNode(element);
		LLNode<E> temp=head.next;
		
		if(index>size) System.out.println("index biggerr than list");
		else if(index<0) System.out.println("index out of bounds");
		else {
			for(int i=0;i<index;i++){
				temp=temp.next;
			}
			neo.next=temp;
			neo.prev=temp.prev;
			temp.prev.next=neo;
			temp.prev=neo;
			neo.data=element;
			size++;
		}
		// TODO: Implement thyis method
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{	if(size==0) System.out.println("no elements in list to remove");
		if(index < 0 || index > size())System.out.println("index biggerr than list or smaller");
			
		LLNode temp=head.next;
		for(int i=0;i<index;i++){
			temp=temp.next;          
		}
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;
		temp.next=null;
		temp.prev=null;
		temp.data=null;
		
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{	if (element==null) System.out.println("Surely you want to add a null in your list?");
		if(size==0) return null;
	    if(index < 0 || index >= size()) {
	    	System.out.println("Out of bounds");
			return  null;}
			
		LLNode<E> get=head.next;
		
		for(int i=0;i<index;i++) {
			get=get.next;
			
		}
		E oldelement=get.data;
		get.data=element;
		
		return oldelement;
	}   
}

public class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
