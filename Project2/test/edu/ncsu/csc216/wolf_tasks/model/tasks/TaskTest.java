package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests Task class
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class TaskTest {

	/**
	 * Tests Task constructor
	 */
	@Test
	void testTask() {
		Task t = new Task("Name", "Description", true, false);

		assertEquals("Name", t.getTaskName());
		assertEquals("Description", t.getTaskDescription());
		assertTrue(t.isRecurring());
		assertFalse(t.isActive());
		
		assertThrows(IllegalArgumentException.class, () -> new Task(null, "Description", true, false));
		assertThrows(IllegalArgumentException.class, () -> new Task("Name", null, true, false));
	}

	/**
	 * Tests Task.getTaskName()
	 */
	@Test
	void testGetTaskName() {
		Task t = new Task("Name", "Description", true, false);

		assertEquals("Name", t.getTaskName());
	}

	/**
	 * Tests Task.setTaskName()
	 */
	@Test
	void testSetTaskName() {
		Task t = new Task("Name", "Description", true, false);

		t.setTaskName("Name2");
		assertEquals("Name2", t.getTaskName());

	}

	/**
	 * Tests Task.getTaskDescription()
	 */
	@Test
	void testGetTaskDescription() {
		Task t = new Task("Name", "Description2", true, false);

		assertEquals("Description2", t.getTaskDescription());
	}

	/**
	 * Tests Task.setTaskDescription()
	 */
	@Test
	void testSetTaskDescription() {
		Task t = new Task("Name", "Description", true, false);

		t.setTaskDescription("Description2");
		assertEquals("Description2", t.getTaskDescription());
	}

	/**
	 * Tests Task.isRecurring()
	 */
	@Test
	void testIsRecurring() {
		Task t = new Task("Name", "Description", true, false);

		assertTrue(t.isRecurring());
	}

	/**
	 * Tests Task.setRecurring()
	 */
	@Test
	void testSetRecurring() {
		Task t = new Task("Name", "Description", true, false);

		t.setRecurring(false);
		assertFalse(t.isRecurring());
	}

	/**
	 * Tests Task.isActive()
	 */
	@Test
	void testIsActive() {
		Task t = new Task("Name", "Description", true, false);

		assertFalse(t.isActive());
	}

	/**
	 * Tests Task.setActive()
	 */
	@Test
	void testSetActive() {
		Task t = new Task("Name", "Description", true, false);

		t.setActive(true);
		assertTrue(t.isActive());
	}

	/**
	 * Tests Task.getTaskListName()
	 */
	@Test
	void testGetTaskListName() {
		TaskList taskList = new TaskList("List1", 0);
		Task t = new Task("Name", "Task description", true, false);
		taskList.addTask(t);
		
		assertEquals("List1", t.getTaskListName());
	}

	/**
	 * Tests Task.addTaskList()
	 */
	@Test
	void testAddTaskList() {
		TaskList taskList = new TaskList("List1", 0);
		Task t = new Task("Name", "Task description", true, false);
		t.addTaskList(taskList);
		
		assertEquals("List1", t.getTaskListName());
	}

	/**
	 * Tests Task.completeTask()
	 */
	@Test
	void testCompleteTask() {
		TaskList taskList = new TaskList("List1", 0);
		Task t = new Task("Name", "Task description", true, false);
		
		taskList.addTask(t);
		assertEquals(0, taskList.getCompletedCount());
		t.completeTask();
		assertEquals(1, taskList.getCompletedCount());
	}

	/**
	 * Tests Task.clone()
	 */
	@Test
	void testClone() {
		Task t = new Task("Name", "Task description", true, false);
		
		try {
			Task t2 = (Task) t.clone();
			assertEquals(t2, t);
		} catch (CloneNotSupportedException e) {
			fail("Clone not supported.");
		}
		
	}

	/**
	 * Tests Task.toString()
	 */
	@Test
	void testToString() {
		Task t = new Task("Name", "Task description", true, false);
		
		assertEquals("Name,Task description,true,false", t.toString());
	}
}
