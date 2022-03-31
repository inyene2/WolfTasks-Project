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

	/** The size of the List */
	private int size;

	/** The front of a LinkedList */
	private ListNode front;

	/**
	 * Adds an element to the list
	 * 
	 * @param element the element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element is duplicate
	 */
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub

	}

	/**
	 * Removes an element from the list
	 * 
	 * @param idx the index to remove
	 * @return the element removed from the list
	 */
	@Override
	public E remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Checks the data of a given Index
	 * 
	 * @param index the index to check
	 * @throws IndexOutOfBoundsException if index out of bounds for list
	 */
	private void checkIndex(int index) {
		// TODO
	}

	/**
	 * Returns whether or not an element is contained in the list
	 * 
	 * @param element the element to check the list for
	 * @return whether or not an element is contained in the list
	 */
	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the size parameter of the List
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
