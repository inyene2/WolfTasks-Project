package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.PrintStream;

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
	public static void writeNotebookFile(File filename, String name, ISortedList<TaskList> taskLists) {
		try {
	        PrintStream fileWriter = new PrintStream(filename);
	        fileWriter.print("! " + name + "\n");
	        if (taskLists.size() != 0) {
	        	for (int i = 0; i < taskLists.size(); i++) {
	        		fileWriter.print("# " + taskLists.get(i).getTaskListName() + "," + taskLists.get(i).getCompletedCount() + "\n");
	        		if (taskLists.get(i).getTasks().size() != 0) {
	        			for (int j = 0; j < taskLists.get(i).getTasks().size(); j++) {
	        				fileWriter.println(taskLists.get(i).getTask(j).toString());
	        			}
	        		}
	        	}
	        }
	
		    fileWriter.close();

        } catch (Exception e) {
        	throw new IllegalArgumentException("Unable to save file.");
        }

	}

}
