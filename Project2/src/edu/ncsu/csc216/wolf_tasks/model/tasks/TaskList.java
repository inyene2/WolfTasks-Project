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
	 * First column is priority of task, second is the task name
	 * 
	 * @return a 2D array of Strings that contain properties of the Tasks in a List
	 */
	public String[][] getTasksAsArray() {
		String[][] taskArray = new String[getTasks().size()][2];
		
		for (int i = 0; i < getTasks().size(); i++) {
			// TODO see if this works for counting task priority
			taskArray[i][0] = Integer.toString(i + 1);
			taskArray[i][1] = getTasks().get(i).getTaskName();
		}
		return taskArray;
	}

	/**
	 * Compares a TaskList name with the current TaskList name and returns a value depending
	 * on the comparison
	 * 
	 * 
	 * @param list a TaskList to compare to
	 * @return an Integer that will return different values depending on whether or
	 *         not a TaskList name is greater or less
	 */
	public int compareTo(TaskList list) {
		return this.getTaskListName().compareTo(list.getTaskListName());
	}

}
