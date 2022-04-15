package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests SwapList class
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class SwapListTest {

	/**
	 * Tests SwapList.add()
	 */
	@Test
	public void testAdd() {
		SwapList<Integer> list = new SwapList<Integer>();
		assertEquals(0, list.size());
		
		//test adding and getting
		list.add(10);
		assertEquals(10, list.get(0));
		assertEquals(1, list.size());
		
		list.add(20);
		assertEquals(10, list.get(0));
		assertEquals(20, list.get(1));
		assertEquals(2, list.size());
		
		list.add(30);
		assertEquals(10, list.get(0));
		assertEquals(20, list.get(1));
		assertEquals(30, list.get(2));
		assertEquals(3, list.size());
		
		
		//test adding OOB
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size() + 1));
		
		assertThrows(NullPointerException.class, () -> list.add(null));
	}
	
	/**
	 * Tests SwapList.remove()
	 */
	@Test
	public void testRemove() {
		SwapList<String> list = new SwapList<String>();
		assertEquals(0, list.size());
		
		list.add("hello");
		assertEquals("hello", list.get(0));
		assertEquals(1, list.size());
		
		list.add("world");
		assertEquals("hello", list.get(0));
		assertEquals("world", list.get(1));
		assertEquals(2, list.size());
		
		list.add("orange");
		assertEquals("hello", list.get(0));
		assertEquals("world", list.get(1));
		assertEquals("orange", list.get(2));
		assertEquals(3, list.size());
		
		list.remove(0);
		assertEquals("world", list.get(0));
		assertEquals("orange", list.get(1));
		assertEquals(2, list.size());
		
		list.remove(1);
		assertEquals("world", list.get(0));
		assertEquals(1, list.size());
		
		//remove OOB
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size() + 1));
	}
	
	
	/**
	 * Tests SwapList.moveUp()
	 */
	@Test
	void testMoveUp() {
		SwapList<Integer> list = new SwapList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list.moveUp(2);
		assertEquals(30, list.get(1));
		assertEquals(20, list.get(2));
		assertEquals(3, list.size());
		
		list.moveUp(1);
		assertEquals(30, list.get(0));
		assertEquals(10, list.get(1));
		assertEquals(20, list.get(2));
		assertEquals(3, list.size());
	}
	
	/**
	 * Tests SwapList.moveDown()
	 */
	@Test
	void testMoveDown() {
		SwapList<Integer> list = new SwapList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list.moveDown(0);
		// should be 20, 10, 30
		assertEquals(10, list.get(1));
		assertEquals(3, list.size());
		
		list.moveDown(1);
		// should be 20, 30, 10
		assertEquals(20, list.get(0));
		assertEquals(30, list.get(1));
		assertEquals(10, list.get(2));
		assertEquals(3, list.size());
	}
	
	/**
	 * Tests SwapList.moveToFront()
	 */
	@Test
	void testMoveToFront() {
		SwapList<Integer> list = new SwapList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		
		list.moveToFront(2);
		// 30 moves to front to become 30, 10, 20, 40
		assertEquals(30, list.get(0));
		assertEquals(4, list.size());
		
		list.moveToFront(1);
		// 10 moves to front to become 10, 30, 20, 40
		assertEquals(10, list.get(0));
		assertEquals(30, list.get(1));
		assertEquals(20, list.get(2));
		assertEquals(40, list.get(3));
		
		assertEquals(4, list.size());
	}
	
	/**
	 * Tests SwapList.moveToBack()
	 */
	@Test
	void testMoveToBack() {
		SwapList<Integer> list = new SwapList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list.moveToBack(0);
		// 10 moves to back to become 20, 30, 10
		assertEquals(10, list.get(2));
		assertEquals(3, list.size());
		
		list.moveToBack(1);
		// 20 and 10 swap to become 20,10,30
		assertEquals(20, list.get(0));
		assertEquals(10, list.get(1));
		assertEquals(30, list.get(2));
		assertEquals(3, list.size());
	}
	
}
