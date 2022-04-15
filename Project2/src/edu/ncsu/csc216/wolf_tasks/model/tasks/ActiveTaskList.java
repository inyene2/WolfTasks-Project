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
	 * 
	 * @param t the Task to add
	 * @throws IllegalArgumentException if the Task is not active
	 */
	@Override
	public void addTask(Task t) {
		// check if task is active
		if (!t.isActive()) {
			throw new IllegalArgumentException("Cannot add task to Active Tasks.");
		}
		super.addTask(t);
	}

	/**
	 * Sets a name for a TaskList
	 * 
	 * @param name the name to set a TaskListName to
	 * @throws IllegalArgumentException if name is not equal to the constant
	 */
	@Override
	public void setTaskListName(String name) {
		if (!name.equals(ACTIVE_TASKS_NAME)) {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
		super.setTaskListName(name);
	}

	/**
	 * Returns a 2D array of Strings that contain the properties of a Task in the
	 * list
	 *
	 * @return Returns a 2D String array where the first column is the name of the
	 *         TaskList that the Task belongs to (or at least the TaskList at index
	 *         0) and the name of the Task
	 */
	@Override
	public String[][] getTasksAsArray() {
		String[][] taskArray = new String[getTasks().size()][2];
		for (int i = 0; i < getTasks().size(); i++) {
			taskArray[i][0] = getTasks().get(i).getTaskListName();
			taskArray[i][1] = getTasks().get(i).getTaskName();
		}
		return taskArray;
	}

	/**
	 * Clears the tasks in a List
	 */
	public void clearTasks() {

		for (int j = super.getTasks().size() - 1; j >= 0; j++) {
			super.removeTask(j);
		}

	}

}
