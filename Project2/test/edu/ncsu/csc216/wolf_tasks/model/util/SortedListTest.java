package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.util.SortedList.ListNode;


/**
 * Tests SortedList class
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class SortedListTest {

	/**
	 * Tests SortedList.add()
	 */
	@Test
	public void testAdd() {
		SortedList<Integer> list = new SortedList<Integer>();
		assertEquals(0, list.size());
		
		//adding to beginning
		list.add(10);
		assertEquals(10, list.get(0));
		assertEquals(1, list.size());
		
		//adding to end
		list.add(20);
		assertEquals(10, list.get(0));
		assertEquals(20, list.get(1));
		assertEquals(2, list.size());
		
		//adding to middle
		list.add(15);
		assertEquals(10, list.get(0));
		assertEquals(15, list.get(1));
		assertEquals(20, list.get(2));
		assertEquals(3, list.size());
		
		
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
		
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size() + 1));
		
		assertThrows(NullPointerException.class, () -> list.add(null));
	}
	
	/**
	 * Tests SortedList.remove()
	 */
	@Test
	public void testRemove() {
		SortedList<String> list = new SortedList<String>();
		assertEquals(0, list.size());
		
		
		
		list.add("hello");
		
		list.remove(0); //edit this out
		
		assertEquals("hello", list.get(0));
		assertEquals(1, list.size());
		
		list.add("world");
		assertEquals("hello", list.get(0));
		assertEquals("world", list.get(1));
		assertEquals(2, list.size());
		
		list.add("orange");
		assertEquals("hello", list.get(0));
		assertEquals("orange", list.get(1));
		assertEquals("world", list.get(2));
		assertEquals(3, list.size());
		
		list.remove(0);
		assertEquals("orange", list.get(0));
		assertEquals("world", list.get(1));
		assertEquals(2, list.size());
		
		list.remove(1);
		assertEquals("orange", list.get(0));
		assertEquals(1, list.size());
		
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size() + 1));
	}
	
	/**
	 * Tests SortedList.contains()
	 */
	@Test
	void testContains() {
		SortedList<String> list = new SortedList<String>();
		assertFalse(list.contains("deez"));
	}
	
	/**
	 * Tests SortedList.get()
	 */
	@Test
	void testGet() {
		SortedList<String> list = new SortedList<String>();
		assertEquals("deez", list.get(0));
	}
	
	/**
	 * Tests SortedList.remove()
	 */
	@Test
	void testRemove1() {
		SortedList<String> list = new SortedList<String>();
		assertEquals("deez", list.remove(0));
	}
	
	/**
	 * Tests SortedList.ListNode
	 */
	@Test
	void testListNode() {
		SortedList<String> list = new SortedList<String>();
		
		@SuppressWarnings("rawtypes")
		ListNode l = list.new ListNode("String", null);
		assertNull(l.next);
		assertEquals("String", l.data);
		
	}
}
