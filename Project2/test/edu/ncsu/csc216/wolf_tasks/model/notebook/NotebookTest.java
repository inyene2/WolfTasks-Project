package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookReader;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Tests Notebook class
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class NotebookTest {
	
	/** Valid notebook file */
	private final File validTestFile = new File("test-files/notebook0.txt");
	
	/** Output file */
	private final File outputFile = new File("test-files/actual_out.txt");
	
	/**
	 * Tests Notebook constructor
	 */
	@Test
	void testNotebook() {
		Notebook n = new Notebook("Notebook1");
		assertEquals("Notebook1", n.getNotebookName());
		assertTrue(n.isChanged());
	}
	
	/**
	 * Tests Notebook.saveNotebook()
	 */
	@Test
	void testSaveNotebook() {
		Notebook n = NotebookReader.readNotebookFile(validTestFile);
		
		assertDoesNotThrow(() -> n.saveNotebook(outputFile));
		
		n.saveNotebook(outputFile);
		
		checkFiles(validTestFile, outputFile);
	}

	/**
	 * Tests Notebook.getNotebookName()
	 */
	@Test
	void testGetNotebookName() {
		Notebook n = new Notebook("Notebook1");
		Notebook n2 = new Notebook("Notebook2");
		
		assertEquals("Notebook1", n.getNotebookName());
		assertEquals("Notebook2", n2.getNotebookName());
	}

	/**
	 * Tests Notebook.isChanged()
	 */
	@Test
	void testIsChanged() {
		Notebook n = new Notebook("Notebook1");
		
		assertTrue(n.isChanged());
		n.setChanged(false);
		assertFalse(n.isChanged());
	}
	
	/**
	 * Tests Notebook.setChanged()
	 */
	@Test
	void testSetChanged() {
		Notebook n = new Notebook("Notebook1");
		
		assertTrue(n.isChanged());
		n.setChanged(false);
		assertFalse(n.isChanged());
	}

	/**
	 * Tests Notebook.addTaskList()
	 */
	@Test
	void testAddTaskList() {
		Notebook n = new Notebook("Notebook1");
		TaskList taskList = new TaskList("List1", 0);
		Task t = new Task("Name", "Task description", true, false);
		taskList.addTask(t);
		
		assertEquals(1, n.getTaskListsNames().length);
		
		n.addTaskList(taskList);
		
		assertEquals(2, n.getTaskListsNames().length);
		
	}

	/**
	 * Tests Notebook.getTaskListsNames()
	 */
	@Test
	void testGetTaskListsNames() {
		Notebook n = new Notebook("Notebook1");
		TaskList taskList = new TaskList("List1", 0);
		TaskList taskList2 = new TaskList("List2", 0);
		
		assertEquals(1, n.getTaskListsNames().length);
		
		n.addTaskList(taskList);
		n.addTaskList(taskList2);
		
		assertEquals("Active Tasks", n.getTaskListsNames()[0]);
		assertEquals("List1", n.getTaskListsNames()[1]);
		assertEquals("List2", n.getTaskListsNames()[2]);
	}

	/**
	 * Tests Notebook.setCurrentTaskList()
	 */
	@Test
	void testSetCurrentTaskList() {
		Notebook n = new Notebook("Notebook1");
		TaskList taskList = new TaskList("List1", 0);
		TaskList taskList2 = new TaskList("List2", 0);
		
		n.addTaskList(taskList);
		n.addTaskList(taskList2);
		
		n.setCurrentTaskList("List1");
		
		assertEquals("List1", n.getCurrentTaskList().getTaskListName());
	}
	
	/**
	 * Tests Notebook.getCurrentTaskList()
	 */
	@Test
	void testGetCurrentTaskList() {
		Notebook n = new Notebook("Notebook1");
		TaskList taskList = new TaskList("List1", 0);
		TaskList taskList2 = new TaskList("List2", 0);
		
		n.addTaskList(taskList);
		n.addTaskList(taskList2);
		
		n.setCurrentTaskList("List1");
		
		assertEquals("List1", n.getCurrentTaskList().getTaskListName());
	}

	/**
	 * Tests Notebook.editTaskList()
	 */
	@Test
	void testEditTaskList() {
		Notebook n = new Notebook("Notebook1");
		TaskList taskList = new TaskList("List1", 0);
		
		n.addTaskList(taskList);
		
		n.editTaskList("List2");
		
		assertTrue(n.isChanged());
	}

	/**
	 * Tests Notebook.removeTaskList()
	 */
	@Test
	void testRemoveTaskList() {
		Notebook n = new Notebook("Notebook1");
		TaskList taskList = new TaskList("List1", 0);
		TaskList taskList2 = new TaskList("List2", 0);
		
		assertEquals(1, n.getTaskListsNames().length);
		
		n.addTaskList(taskList);
		n.addTaskList(taskList2);
		
		assertEquals(3, n.getTaskListsNames().length);
		
		n.removeTaskList();
		
		assertEquals(2, n.getTaskListsNames().length);
	}

	/**
	 * Tests Notebook.addTask()
	 */
	@Test
	void testAddTask() {
		Notebook n = new Notebook("Notebook1");
		TaskList taskList = new TaskList("List1", 0);
		Task t = new Task("Name", "Task description", true, false);
		taskList.addTask(t);
		
		assertEquals(1, n.getTaskListsNames().length);
		
		n.addTaskList(taskList);
		n.setCurrentTaskList("List1");
		
		assertEquals("Name", n.getCurrentTaskList().getTask(0).getTaskName());
	}

	/**
	 * Tests Notebook.editTask()
	 */
	@Test
	void testEditTask() {
		Notebook n = new Notebook("Notebook1");
		TaskList taskList = new TaskList("List1", 0);
		Task t = new Task("Name", "Task description", true, false);
		taskList.addTask(t);
		
		assertEquals(1, n.getTaskListsNames().length);
		
		n.addTaskList(taskList);
		n.setCurrentTaskList("List1");
		n.editTask(0, "Name2", "Task description 2", false, false);
		
		assertEquals("Name2", n.getCurrentTaskList().getTask(0).getTaskName());
	}
	
	/**
	 * Private helper method for comparing files in write to file method
	 * @param expFile expected file to compare (want)
	 * @param actFile actual file to compare (have)
	 */
	private void checkFiles(File expFile, File actFile) {
		try (Scanner expScanner = new Scanner(expFile);
			 Scanner actScanner = new Scanner(actFile);) {
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
