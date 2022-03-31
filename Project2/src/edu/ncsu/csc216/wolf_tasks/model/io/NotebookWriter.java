package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * File output class for WolfTasks
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class NotebookWriter {

	/**
	 * File output method for WolfTasks. Outputs a list of TaskLists to a Notebook
	 * file.
	 * 
	 * @param file     the file to write to
	 * @param name     the name of the notebook
	 * @param taskList the list of tasks to write out
	 * @throws IllegalArgumentException if can't write to file
	 */
	public static void writeNotebookFile(File file, String name, ISortedList<TaskList> taskList) {

	}

}
