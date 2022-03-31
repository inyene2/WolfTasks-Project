package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * This is a list that contains Tasks. Notebooks use different TaskLists
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class TaskList extends AbstractTaskList implements Comparable<TaskList> {

	/**
	 * Constructor for TaskList
	 * 
	 * @param name  the name of a TaskList
	 * @param count the count of Active Tasks
	 */
	public TaskList(String name, int count) {
		super(name, count);
	}

	/**
	 * Returns a 2D array of Strings that contain properties of the Tasks in a List
	 * 
	 * @return a 2D array of Strings that contain properties of the Tasks in a List
	 */
	public String[][] getTasksAsArray() {
		return null;
	}

	/**
	 * Compares a TaskList with the current TaskList and returns a value depending
	 * on the comparison
	 * 
	 * 
	 * @param list a TaskList to compare to
	 * @return an Integer that will return different values depending on whether or
	 *         not a TaskList is greater or less
	 */
	public int compareTo(TaskList list) {
		return 0;
	}

}
