package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests TaskList class
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class TaskListTest {

	/**
	 * Tests TaskList constructor
	 */
	@Test
	void testTaskList() {
		TaskList t = new TaskList("Name", 0);
		
		assertEquals(0, t.getCompletedCount());
		assertEquals("Name", t.getTaskListName());
		
		assertThrows(IllegalArgumentException.class, () -> t.setTaskListName(null));
		assertThrows(IllegalArgumentException.class, () -> new TaskList("", 0));
		assertThrows(IllegalArgumentException.class, () -> new TaskList("Name", -1));
	}
	
	/**
	 * Tests TaskList.getTasksAsArray()
	 */
	@Test
	void testGetTasksAsArray() {
		TaskList t = new TaskList("Name", 0);
		
		Task task1 = new Task("Name1", "Description1", false, true);
		Task task2 = new Task("Name2", "Description2", true, true);
		Task task3 = new Task("Name3", "Description3", true, false);
		
		t.addTask(task1);
		t.addTask(task2);
		t.addTask(task3);
		
		assertEquals("1", t.getTasksAsArray()[0][0]);
		assertEquals("Name2", t.getTasksAsArray()[1][1]);
		assertEquals("3", t.getTasksAsArray()[2][0]);
	}
	
	/**
	 * Tests TaskList.compareTo()
	 */
	@Test
	void testCompareTo() {
		TaskList t = new TaskList("Name", 0);
		TaskList t2 = new TaskList("Name2", 1);
		TaskList t3 = new TaskList("Name2", 1);
		
		// TODO figure out how to compare less than, greater than
		
		//different where first is less than second
		assertEquals(-1, t.compareTo(t2));
		
		//different where first is greater than second
		assertEquals(1, t2.compareTo(t));
		
		//same tasklist
		assertEquals(0, t3.compareTo(t2));
	}
}
