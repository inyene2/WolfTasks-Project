package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * This is the WolfTasks input class, NotebookReader. Reads in a notebook from a
 * file and processes it TaskList by TaskList, Task by Task.
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class NotebookReader {

	/**
	 * Overall input method. Reads in an entire notebook.
	 * 
	 * @param file the notebook file to read in
	 * @return a Notebook object made of TaskLists
	 * @throws IllegalArgumentException if can't read from file
	 */
	public static Notebook readNotebookFile(File file) {
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file));
			String nameLine = fileReader.nextLine();

			// Check first line for exclamation point
			Scanner nameScanner = new Scanner(nameLine);
			if (!nameScanner.next().equals("!")) {
				nameScanner.close();
				throw new IllegalArgumentException("Name must start with exclamation point");
			}

			// advance scanner past exclamation point
			nameScanner.next();
			String name = nameScanner.next();
			nameScanner.close();

			// Create notebook with read name
			Notebook n = new Notebook(name);
			fileReader.useDelimiter("\\r?\\n?[#]");
			while (fileReader.hasNext()) {
				TaskList t = processTaskList(fileReader.next());
				n.addTaskList(t);
			}
			// Close the Scanner b/c we're responsible with our file handles
			fileReader.close();

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		return null;
	}

	/**
	 * Processes a TaskList one by one from the notebook file.
	 * 
	 * @param taskList the TaskList to process task by task from the notebook file
	 * @return a TaskList of tasks from a notebook file
	 */
	private static TaskList processTaskList(String taskList) {
		Scanner scnr = new Scanner(taskList);
		String taskListFields = scnr.nextLine();
		Scanner scnr1 = new Scanner(taskListFields);
		scnr1.useDelimiter(",");
		String taskListName = scnr1.next().trim();
		int count = scnr1.nextInt();
		TaskList t = new TaskList(taskListName, count);
		scnr.close();
		scnr1.close();
		return null;
		}

	/**
	 * Processes a set of tasks from the TaskList read in by the processTaskList
	 * method.
	 * 
	 * @param taskList a TaskList to read in and process
	 * @param fileName a name to give a Task?
	 * @return a Task object
	 */
	private static Task processTask(AbstractTaskList taskList, String fileName) {
		return null;
	}

}
