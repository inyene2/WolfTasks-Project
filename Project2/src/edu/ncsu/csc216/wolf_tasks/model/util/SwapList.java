package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * SwapList utility class for moving elements
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 * @param <E> generic type for list
 */
public class SwapList<E> implements ISwapList<E> {

	/** Initial capacity for a SwapList */
	private static final int INITIAL_CAPACITY = 10;

	/** List of generic type E */
	private E[] list;

	/** Size field of the List, how many elements are in the list */
	private int size;

	/**
	 * Generic constructor for a SwapList. Sets initial capacity to 10, and sets the
	 * size to 0
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		this.list = (E[]) new Object[INITIAL_CAPACITY];
		this.size = 0;
	}

	/**
	 * Adds an element to the List
	 * 
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		checkCapacity(size() + 1);
		list[size++] = element;
	}

	/**
	 * Checks the capacity when being used in the add method. Makes sure there is
	 * room in the list before adding
	 * 
	 * @param cap capacity to check is valid
	 */
	@SuppressWarnings("unchecked")
	private void checkCapacity(int cap) {
		if (size >= list.length) {
			E[] doubledList = (E[]) new Object[list.length * 2];
			for (int i = 0; i < list.length; i++) {
				doubledList[i] = list[i];
			}
			list = doubledList;
		}
	}

	/**
	 * Removes at a given index
	 * 
	 * @param idx the index to remove at
	 * @return the element at the index that was removed
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public E remove(int idx) {
		// check for valid index
		checkIndex(idx);
		E temp = get(idx);
		// left shift
		for (int i = idx; i < size; i++) {
			list[i] = list[i + 1];
		}
		// decrement size
		size--;
		return temp;
	}

	/**
	 * Checks the element at a given index for use in the remove() method
	 * 
	 * @param index the index to check
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

	/**
	 * Moves an element up in the list
	 * 
	 * @param idx the index element to move up
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public void moveUp(int idx) {
		checkIndex(idx);
		// Case of indexed item already being at front
		if (idx != 0) {
			E temp = list[idx - 1];
			list[idx - 1] = list[idx];
			list[idx] = temp;
		}
	}

	/**
	 * Moves an element down in the list
	 * 
	 * @param idx the index element to move down
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public void moveDown(int idx) {
		checkIndex(idx);
		// Case of indexed item already being at back
		if (idx != size() - 1) {
			E temp = list[idx + 1];
			list[idx + 1] = list[idx];
			list[idx] = temp;
		}
	}

	/**
	 * Moves an element to the front of the list
	 * 
	 * @param idx the index element to move to front
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public void moveToFront(int idx) {
		checkIndex(idx);
		// Case of indexed item already being at front
		if (idx != 0) {
			E temp = list[0];
			list[0] = list[idx];
			list[idx] = temp;
		}

	}

	/**
	 * Moves an element to the back of the list
	 * 
	 * @param idx the index element to move to back
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public void moveToBack(int idx) {
		checkIndex(idx);
		// Case of indexed item already being at back
		if (idx != size() - 1) {
			E temp = list[size() - 1];
			list[size() - 1] = list[idx];
			list[idx] = temp;
		}
	}

	/**
	 * Gets the element at a given index
	 *
	 * @param idx the index to get from
	 * @return the element at the given index
	 * @throws IndexOutOfBoundsException if the index is OOB
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		return list[idx];
	}

	/**
	 * Returns the size of the list
	 * 
	 * @return the size of the list
	 */
	@Override
	public int size() {
		return size;
	}

}
