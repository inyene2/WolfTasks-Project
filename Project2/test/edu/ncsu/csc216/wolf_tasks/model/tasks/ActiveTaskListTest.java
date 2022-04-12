package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests ActiveTaskList class
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class ActiveTaskListTest {

	/**
	 * Tests ActiveTaskList constructor
	 */
	@Test
	void testActiveTaskList() {
		ActiveTaskList a = new ActiveTaskList();
		
		
		assertEquals("Active Tasks", a.getTaskListName());
		assertEquals(0, a.getCompletedCount());	
	}
	/**
	 * Tests ActiveTaskList.addTask()
	 */
	@Test
	void testAddTask() {
		ActiveTaskList a = new ActiveTaskList();
		Task t = new Task("Name", "Description", false, true);
		Task t2 = new Task("Name", "Description", false, false);
		
		assertEquals(0, a.getTasksAsArray().length);
		a.addTask(t);
		assertEquals(1, a.getTasksAsArray().length);
		
		// test adding a task to the list that is not Active
		assertThrows(IllegalArgumentException.class, () -> a.addTask(t2));
	}
	
	/**
	 * Tests ActiveTaskList.setTaskListName()
	 */
	@Test
	void testSetTaskListName() {
		ActiveTaskList a = new ActiveTaskList();
		
		assertEquals("Active Tasks", a.getTaskListName());
		assertThrows(IllegalArgumentException.class, () -> a.setTaskListName("Test"));
	}
	
	/**
	 * Tests ActiveTaskList.getTasksAsArray()
	 */
	@Test
	void testGetTasksAsArray() {
		ActiveTaskList a = new ActiveTaskList();
		
		Task task1 = new Task("Name1", "Description1", false, true);
		Task task2 = new Task("Name2", "Description2", true, true);
		Task task3 = new Task("Name3", "Description3", true, true);
		
		a.addTask(task1);
		a.addTask(task2);
		a.addTask(task3);
		
		assertEquals("Active Tasks", a.getTasksAsArray()[0][0]);
		assertEquals("Name2", a.getTasksAsArray()[1][1]);
		assertEquals("Active Tasks", a.getTasksAsArray()[2][0]);
	}
	
	/**
	 * Tests ActiveTaskList.clearTasks()
	 */
	void testClearTasks() {
		ActiveTaskList a = new ActiveTaskList();
		Task t = new Task("Name", "Description", false, true);
		Task t2 = new Task("Name", "Description", false, true);
		Task t3 = new Task("Name", "Description", false, true);
		
		a.addTask(t);
		a.addTask(t2);
		a.addTask(t3);
		
		assertEquals(3, a.getTasksAsArray().length);
		
		a.clearTasks();
		
		assertEquals(0, a.getTasksAsArray().length);
	}
}
