package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

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
	 */
	public static Notebook readNotebookFile(File file) {
		return null;
	}

	/**
	 * Processes a TaskList one by one from the notebook file.
	 * 
	 * @param taskList the TaskList to process task by task from the notebook file
	 * @return a TaskList of tasks from a notebook file
	 */
	private static TaskList processTaskList(String taskList) {
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
