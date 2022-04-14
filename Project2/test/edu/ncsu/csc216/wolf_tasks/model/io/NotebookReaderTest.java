package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Tests NotebookReader class
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
class NotebookReaderTest {

	/** Valid notebook file */
	private final File validTestFile = new File("test-files/notebook0.txt");

	/** Valid notebook file 1 */
	private final File validTestFile1 = new File("test-files/notebook1.txt");

	/**
	 * Valid notebook file 5 task list with missing name - creates notebook with no
	 * tasks lists
	 */
	private final File validTestFile2 = new File("test-files/notebook4.txt");
	
	/**
	 * Valid notebook file 5 task list with missing name - creates notebook with no
	 * tasks lists
	 */
	private final File validTestFile3 = new File("test-files/notebook5.txt");
	
	/**
	 * Valid notebook file 5 task list with missing name - creates notebook with no
	 * tasks lists
	 */
	private final File validTestFile4 = new File("test-files/notebook6.txt");
	
	/**
	 * Valid notebook file 5 task list with missing name - creates notebook with no
	 * tasks lists
	 */
	private final File validTestFile5 = new File("test-files/notebook7.txt");

	/** Invalid notebook file */
	private final File invalidTestFile = new File("test-files/notebook3.txt");

	/**
	 * Tests NotebookReader.readNotebookFile()
	 */
	@Test
	void testReadValidNotebookFile() {
		// three valid files
		assertDoesNotThrow(() -> NotebookReader.readNotebookFile(validTestFile));
		assertDoesNotThrow(() -> NotebookReader.readNotebookFile(validTestFile1));

		Notebook n = NotebookReader.readNotebookFile(validTestFile1);

		assertEquals("School", n.getNotebookName());
		assertEquals("CSC 216", n.getTaskListsNames()[1]);
		n.setCurrentTaskList("CSC 216");
		assertEquals(35, n.getCurrentTaskList().getCompletedCount());
		
		// Test task list names being constructed correctly
		String[] names = n.getTaskListsNames();
		String nameList = "";
		for (String name : names) {
			nameList += name + ",";
		}
		
		assertEquals("Active Tasks,CSC 216,CSC 226,Habits,", nameList);

		Task t1 = n.getCurrentTaskList().getTask(0);
		Task t2 = n.getCurrentTaskList().getTask(1);

		assertEquals("Read Project 2 Requirements", t1.getTaskName());
		assertFalse(t1.isRecurring());
		assertFalse(t1.isActive());

		assertEquals("Create CRC Cards", t2.getTaskName());
		assertFalse(t2.isRecurring());
		assertTrue(t2.isActive());

		// assertDoesNotThrow(() -> NotebookReader.readNotebookFile(validTestFile2));
	}

	/**
	 * Tests NotebookReader.readNotebookFile() invalid file
	 */
	@Test
	void testReadInvalidNotebookFile() {
		assertThrows(IllegalArgumentException.class, () -> NotebookReader.readNotebookFile(invalidTestFile));
		
		Notebook n = NotebookReader.readNotebookFile(validTestFile2);
		assertEquals("Personal", n.getNotebookName());
		//has empty active task list and thats it
		assertEquals(1, n.getTaskListsNames().length);
		
		Notebook n2 = NotebookReader.readNotebookFile(validTestFile3);
		assertEquals("Personal", n2.getNotebookName());
		//has empty active task list and thats it
		assertEquals(1, n2.getTaskListsNames().length);
		
		Notebook n3 = NotebookReader.readNotebookFile(validTestFile4);
		assertEquals("Personal", n3.getNotebookName());
		//has empty active task list and thats it
		assertEquals(1, n3.getTaskListsNames().length);
		
		Notebook n4 = NotebookReader.readNotebookFile(validTestFile5);
		assertEquals("Personal", n4.getNotebookName());
		n4.setCurrentTaskList("Habits");
		
		assertEquals(0, n4.getCurrentTaskList().getCompletedCount());
		//has one task list with a single task -- skips first
		// TODO figure out why notebook 7 works for ignoring on here but not on jenkins
		assertEquals(1, n4.getCurrentTaskList().getTasks().size());
		n4.setCurrentTaskList("Active Tasks");
		assertEquals(0, n4.getCurrentTaskList().getTasks().size());
	}

}
