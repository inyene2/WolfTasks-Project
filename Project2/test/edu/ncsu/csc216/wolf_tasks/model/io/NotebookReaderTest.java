package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

/**
 * Tests NotebookReader class
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
class NotebookReaderTest {
	
	/** Valid notebook file */
	private final File validTestFile = new File("test-files/notebook0.txt");
	
	/** Valid notebook file 1 */
	private final File validTestFile1 = new File("test-files/notebook1.txt");
	
	/** Valid notebook file 5 task list with missing name - creates notebook with no tasks lists */
	private final File validTestFile2 = new File("test-files/notebook5.txt");
	
	/** Invalid notebook file */
	private final File invalidTestFile = new File("test-files/notebook3.txt");

	/**
	 * Tests NotebookReader.readNotebookFile()
	 */
	@Test
	void testReadValidNotebookFile() {
		//three valid files
		assertDoesNotThrow(() -> NotebookReader.readNotebookFile(validTestFile));
		assertDoesNotThrow(() -> NotebookReader.readNotebookFile(validTestFile1));
		assertDoesNotThrow(() -> NotebookReader.readNotebookFile(validTestFile2));
	}
	
	/**
	 * Tests NotebookReader.readNotebookFile() invalid file
	 */
	@Test
	void testReadInvalidNotebookFile() {
		assertThrows(IllegalArgumentException.class, () -> NotebookReader.readNotebookFile(invalidTestFile));
	}
	

}
