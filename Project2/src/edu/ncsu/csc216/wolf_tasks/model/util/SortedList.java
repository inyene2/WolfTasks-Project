package edu.ncsu.csc216.wolf_tasks.model.util;



/**
 * SortedList utility class for sorted elements
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 * @param <E> generic type for list
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** Size field of the List, how much the list is populated */
	private int size;
	
	/** Front of the list */
	private ListNode front;

	/**
	 * Adds an element to the list
	 * 
	 * @param element the element to add
	 * @throws NullPointerException     if element is null
	 * @throws IllegalArgumentException if element is duplicate
	 */
	@Override
	public void add(E element) {
		int n = 0;
		if (n == 0)
			size();
	
	}
//		ListNode current = front;
////			while (current.next != null) {
////				current = current.next;
////			}
//			ListNode n = new ListNode(element, null);
//			//current.next = n;
//		}
//		

	/**
	 * Removes an element from the list
	 * 
	 * @param idx the index to remove
	 * @return the element removed from the list
	 */
	@Override
	public E remove(int idx) {
//		ListNode current = front;
////		for (int i = 0; i < idx - 1; i++) {
////			current = current.next;
////		}
		E element = null; //current.next.data;
//		current.next = current.next.next;
		
		return element;
		
	}

	/**
	 * Checks the data of a given Index
	 * 
	 * @param index the index to check
	 * @throws IndexOutOfBoundsException if index out of bounds for list
	 */
	private void checkIndex(int index) {
		get(index);
	}

	/**
	 * Returns whether or not an element is contained in the list
	 * 
	 * @param element the element to check the list for
	 * @return whether or not an element is contained in the list
	 */
	@Override
	public boolean contains(E element) {
		checkIndex(0);
		ListNode current = front;
		while (current.next != null) {
//			if (element.equals(current.data)) {
//				return true;
//			}
			current = current.next;
		}
		return false;
	}

	/**
	 * Gets the Element at given index
	 * 
	 * @param idx the index to get from in the list
	 * @return the Element at given index
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public E get(int idx) {
//		ListNode current = front;
////		for (int i = 0; i < idx; i++) {
////			current = current.next;
////		}
		E element = null; //current.data;
		return element;
	}

	/**
	 * Returns the size parameter of the List
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * ListNode class to use in a list of ListNodes
	 * 
	 * @author Mason Morano
	 * @author Inyene Etuk
	 *
	 */
	public class ListNode {

		/** The data contained in a ListNode */
		public E data;
		
		public ListNode next;

		/**
		 * Constructor for a ListNode
		 * 
		 * @param data the data that a ListNode contains
		 * @param next the reference to the next ListNode
		 */
		public ListNode(E data, ListNode next) {

		}
	}
}
