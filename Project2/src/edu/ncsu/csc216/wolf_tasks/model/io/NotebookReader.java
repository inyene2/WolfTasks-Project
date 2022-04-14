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

			if (nameLine.charAt(0) != '!' || nameLine.length() == 0) {
				fileReader.close();
				throw new IllegalArgumentException("Unable to load file.");
			}

			// TODO handle empty file or ! with nothing after

			// remove exclamation point
			String name = nameLine.substring(2);

			// Create notebook with read name
			Notebook n = new Notebook(name);
			fileReader.useDelimiter("\\r?\\n?[#]");
			while (fileReader.hasNext()) {
				TaskList t = processTaskList(fileReader.next());
				if (t == null) {
					Notebook brokenTasks = new Notebook(name);
					return brokenTasks;
				}
				n.addTaskList(t);
			}
			// Close the Scanner b/c we're responsible with our file handles
			fileReader.close();
			return n;

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
	}

	/**
	 * Processes a TaskList one by one from the notebook file.
	 * 
	 * @param taskList the TaskList to process task by task from the notebook file
	 * @return a TaskList of tasks from a notebook file
	 */
	private static TaskList processTaskList(String taskList) {
		Scanner scnr = new Scanner(taskList);
		// remove the #
		String taskListFields = scnr.nextLine().trim().substring(0);

		// read the fields from the line for the tasklist
		Scanner scnr1 = new Scanner(taskListFields);
		scnr1.useDelimiter(",");
		String taskListName = scnr1.next().trim();
		if (!scnr1.hasNextInt()) {
			scnr.close();
			scnr1.close();
			return null;
		}
		int count = scnr1.nextInt();
		try {
			TaskList t = new TaskList(taskListName, count);
			// break tasklist into "task tokens"
			scnr.useDelimiter("\\r?\\n?[*]");
			while (scnr.hasNext()) {
				//handle task problems
				try {
					processTask(t, scnr.next());
				} catch (Exception e) {
					t.setCompletedCount(0);
					continue;
				}
			}

			return t;
		} catch (Exception e) {
			return null;
		} finally {
			// close scanners
			scnr.close();
			scnr1.close();
		}

	}

	/**
	 * Processes a set of tasks from the TaskList read in by the processTaskList
	 * method.
	 * 
	 * @param taskList   a TaskList to read in and process
	 * @param taskString a Task in the form of a scanned String
	 * @return a Task object
	 * @throws IllegalArgumentException if the task string has faulty params
	 */
	private static Task processTask(AbstractTaskList taskList, String taskString) {
		String taskFields = taskString.substring(1);
		Scanner taskScanner = new Scanner(taskFields);

		// trim leading
		boolean isActive = false;
		boolean isRecurring = false;
		String nameAndFields = taskScanner.nextLine().trim().substring(0);
		Scanner taskFieldsScnr = new Scanner(nameAndFields);
		taskFieldsScnr.useDelimiter(",");
		String name = taskFieldsScnr.next();

		// handle case of no name
		if ("active".equals(name) || "recurring".equals(name)) {
			taskScanner.close();
			taskFieldsScnr.close();
			throw new IllegalArgumentException("Invalid task");
		}

		if (taskFieldsScnr.hasNext()) {
			String next = taskFieldsScnr.next();
			// only active, nothing else after
			if ("active".equals(next)) {
				isActive = true;
				// cant have recurring afterwards
				isRecurring = false;
			}
			// can be recurring and then check if there is a next
			else if ("recurring".equals(next)) {
				isRecurring = true;
				isActive = false;
				// if there is something after recurring, it has to be active
				if (taskFieldsScnr.hasNext()) {
					isActive = true;
				}
			}
		}

		taskFieldsScnr.close();

		String description = "";

		// get description
		// TODO see if this reads the descriptions correctly
		while (taskScanner.hasNextLine()) {
			description += taskScanner.nextLine().trim() + "\n";
		}

		Task t = new Task(name, description, isRecurring, isActive);
		taskList.addTask(t);

		taskScanner.close();
		return t;
	}

}
