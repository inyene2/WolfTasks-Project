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

	/**
	 * Adds an element to the List
	 *
	 * @param element
	 */
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub

	}

	/**
	 * Checks the capacity
	 * 
	 * @param capacity to check
	 */
	private void checkCapacity(int cap) {

	}

	/**
	 * Removes at a given index
	 * 
	 * @param the index to remove at
	 * @return the element at the index that was removed
	 */
	@Override
	public E remove(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Checks the element at a given index
	 * 
	 * @param index the index to check
	 */
	private void checkIndex(int index) {

	}

	/**
	 * Moves an element up in the list
	 * 
	 * @param idx the index element to move up
	 */
	@Override
	public void moveUp(int idx) {
		// TODO Auto-generated method stub

	}

	/**
	 * Moves an element down in the list
	 * 
	 * @param idx the index element to move down
	 */
	@Override
	public void moveDown(int idx) {
		// TODO Auto-generated method stub

	}

	/**
	 * Moves an element to the front of the list
	 * 
	 * @param idx the index element to move to front
	 */
	@Override
	public void moveToFront(int idx) {
		// TODO Auto-generated method stub

	}

	/**
	 * Moves an element to the back of the list
	 * 
	 * @param idx the index element to move to back
	 */
	@Override
	public void moveToBack(int idx) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the element at a given index
	 *
	 * @param idx the index to get from
	 * @return the element at the given index
	 */
	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the size of the list
	 * 
	 * @return the size of the list
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
