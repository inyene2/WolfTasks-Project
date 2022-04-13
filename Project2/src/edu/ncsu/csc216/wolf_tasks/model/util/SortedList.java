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

	/** Size field of the List, how many elements are in the List */
	private int size;

	/** Front of the list */
	private ListNode front;

	/**
	 * Constructs a new LinkedList that is sorted, the constructor for SortedList
	 */
	public SortedList() {
		this.front = null;
		this.size = 0;
	}

	/**
	 * Adds an element to the list
	 * 
	 * @param element the element to add
	 * @throws NullPointerException     if element is null
	 * @throws IllegalArgumentException if element is duplicate
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}

		// Case of sorting an element to the front whether front is empty or front is
		// less than added element
		if (front == null || element.compareTo(front.data) < 0) {
			front = new ListNode(element, front);
		} else {
			ListNode current = front;

			// Traverse through list until condition fails
			while (current.next != null && current.next.data.compareTo(element) < 0) {
				current = current.next;
			}

			// While loop terminates when it finds a place to add
			// Checks for duplicate at current spot and then the next spot, since the only
			// place a duplicate can be is those locations
			if (current.data == element || current.next != null && current.next.data == element) {
				throw new IllegalArgumentException("Cannot add duplicate element");
			}

			// Add
			current.next = new ListNode(element, current.next);
		}

		// Increment size
		size++;
	}

	/**
	 * Removes an element from the list
	 * 
	 * @param idx the index to remove
	 * @return the element removed from the list
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		E tempReturn = null;

		// Remove at front
		if (idx == 0) {
			tempReturn = front.data;
			front = front.next;
		} else {
			// Traverse through list until reaching item at index
			ListNode current = front;
			for (int i = 0; i < idx - 1; i++) {
				current = current.next;
			}
			tempReturn = current.next.data;
			// Shift
			current.next = current.next.next;
		}
		// Decrement size
		size--;
		return tempReturn;

	}

	/**
	 * Checks the data of a given Index
	 * 
	 * @param idx the index to check
	 * @throws IndexOutOfBoundsException if index out of bounds for list
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

	/**
	 * Returns whether or not an element is contained in the list
	 * 
	 * @param element the element to check the list for
	 * @return whether or not an element is contained in the list
	 */
	@Override
	public boolean contains(E element) {
		ListNode current = front;

		// Traverse
		for (int i = 0; i < size() - 1; i++) {
			current = current.next;
			if (element.equals(current.data)) {
				// Found element
				return true;
			}
		}

		// Didn't find
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
		checkIndex(idx);
		ListNode current = front;

		// Traverse list
		for (int i = 0; i < idx; i++) {
			current = current.next;
		}

		return current.data;
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

		/** The next ListNode to refer to */
		public ListNode next;

		/**
		 * Constructor for a ListNode
		 * 
		 * @param data the data that a ListNode contains
		 * @param next the reference to the next ListNode
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
}
