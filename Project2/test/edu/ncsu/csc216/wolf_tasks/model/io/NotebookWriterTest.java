package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

/**
 * Tests NotebookWriter class
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class NotebookWriterTest {
	
	/** Valid notebook file */
	private final File validTestFile = new File("test-files/notebook0.txt");
	
	/** Output file */
	private final File outputFile = new File("test-files/actual_out.txt");
	
	/**
	 * Tests NotebookWriter.writeNotebookFile()
	 */
	@Test
	void testWriteNotebookFile() {
		// TODO figure out how this works in making sure the input file is exactly the same as the output file
		//create list of TaskLists
		ISortedList<TaskList> taskList = new SortedList<TaskList>();
		
		// new TaskLists
		TaskList t = new TaskList("Tasklist1", 3);
//		TaskList t2 = new TaskList("Tasklist2", 4);
//		
//		//create new Tasks
		Task k = new Task("Squat", "Workout1", true, true);
//		Task k2 = new Task("Run", "Workout2", false, true);
//		Task k3 = new Task("Rest", "Workout3", false, false);
//		
//		//add Task to TaskLists
		t.addTask(k);
//		t.addTask(k2);
//		t2.addTask(k3);
//		
//		//add TaskLists to list of TaskLists
		taskList.add(t);
//		taskList.add(t2);
		
		try {
			NotebookWriter.writeNotebookFile(outputFile, "Summer Plans", taskList);
			// check expected file
			checkFiles(outputFile, validTestFile);
		} catch(Exception e) {
			fail("Cannot write to file");
		}
//		assertDoesNotThrow(() -> NotebookWriter.writeNotebookFile(outputFile, "Notebook1", taskList));
//		
//		NotebookWriter.writeNotebookFile(outputFile, "Notebook1", taskList);
//		
//		checkFiles(validTestFile, outputFile);
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
