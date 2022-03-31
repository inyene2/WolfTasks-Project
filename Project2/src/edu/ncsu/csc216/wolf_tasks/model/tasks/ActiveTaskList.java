package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * This is the ActiveTaskList class, a TaskList that only contains active Tasks
 * 
 * @author Mason Morano
 * @author Inyene Ituk
 */
public class ActiveTaskList extends AbstractTaskList {

	/** Name of a TaskList that is Active */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";

	/**
	 * Constructor for ActiveTaskList
	 */
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}

	/**
	 * Adds a task to a TaskList
	 */
	public void addTask(Task t) {
		super.addTask(t);
	}

	/**
	 * Sets a name for a TaskList
	 */
	public void setTaskListName(String name) {
		super.setTaskListName(name);
	}

	/**
	 * Returns a 2D array of Strings that contain the properties of a Task in the
	 * list
	 *
	 * @return a 2D array of Strings that contain the properties of a Task in the
	 *         list
	 */
	@Override
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Clears the tasks in a List
	 */
	public void clearTasks() {

	}

}
