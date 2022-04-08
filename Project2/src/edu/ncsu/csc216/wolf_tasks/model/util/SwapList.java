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

	/** Size field of the List, how much the list is populated */
	private int size;

	/** Suppress warning */
	@SuppressWarnings("unchecked")
	public SwapList() {
		this.list = (E[]) new Object[INITIAL_CAPACITY];
		this.size = 0;

	}

	/**
	 * Adds an element to the List
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 */
	@Override
	public void add(E element) {
		if (size == 0) {
			list[0] = element;
		} else {
			list[1] = element;
		}

	}

	/**
	 * Checks the capacity
	 * 
	 * @param cap capacity to check
	 */
	private void checkCapacity(int cap) {
		if (cap < 10 || cap > 250) {
			throw new IllegalArgumentException();
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
		checkCapacity(0);
		// get output E
		E output = list[idx];
		// left shift
		for (int j = idx; j < this.size; j++) {
			list[j] = list[j + 1];
		}
		// update size
		size--;

		// return E
		return output;
	}

	/**
	 * Checks the element at a given index
	 * 
	 * @param index the index to check
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	private void checkIndex(int index) {
		
	}

	/**
	 * Moves an element up in the list
	 * 
	 * @param idx the index element to move up
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public void moveUp(int idx) {
		checkIndex(0);
		E temp = list[idx - 1];
		list[idx - 1] = list[idx];
		list[idx] = temp;

	}

	/**
	 * Moves an element down in the list
	 * 
	 * @param idx the index element to move down
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public void moveDown(int idx) {
		E temp = list[idx + 1];
		list[idx + 1] = list[idx];
		list[idx] = temp;

	}

	/**
	 * Moves an element to the front of the list
	 * 
	 * @param idx the index element to move to front
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public void moveToFront(int idx) {
		E temp = list[0];
		list[0] = list[idx];
		list[idx] = temp;

	}

	/**
	 * Moves an element to the back of the list
	 * 
	 * @param idx the index element to move to back
	 * @throws IndexOutOfBoundsException if idx out of bounds for list
	 */
	@Override
	public void moveToBack(int idx) {
		E temp = list[size() - 1];
		list[size() - 1] = list[idx];
		list[idx] = temp;

	}

	/**
	 * Gets the element at a given index
	 *
	 * @param idx the index to get from
	 * @return the element at the given index
	 * 
	 */
	@Override
	public E get(int idx) {
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
