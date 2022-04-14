package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;

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
	private final File validTestFile2 = new File("test-files/notebook5.txt");

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

		Task t1 = n.getCurrentTaskList().getTask(0);
		Task t2 = n.getCurrentTaskList().getTask(1);

		assertEquals("Complete exercises", t1.getTaskName());
		assertTrue(t1.isRecurring());
		assertFalse(t1.isActive());

		// assertEquals("", t1.toString());
		// assertEquals("", t2.toString());

		assertEquals("Complete quizzes", t2.getTaskName());
		assertTrue(t2.isRecurring());
		assertFalse(t2.isActive());

		// assertDoesNotThrow(() -> NotebookReader.readNotebookFile(validTestFile2));
	}

	/**
	 * Tests NotebookReader.readNotebookFile() invalid file
	 */
	@Test
	void testReadInvalidNotebookFile() {
		assertThrows(IllegalArgumentException.class, () -> NotebookReader.readNotebookFile(invalidTestFile));
	}

}
