package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Abstract class AbstractTaskList that all other TaskLists inherit from.
 * Provides the basis for TaskList and ActiveTaskList
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 */
public abstract class AbstractTaskList {

	/** name of a taskList */
	private String taskListName;

	/** count of how many completed tasks in a taskList */
	private int completedCount;

	/**
	 * Constructor for an AbstractTaskList
	 * 
	 * @param name  the name of a List
	 * @param count the count of completed tasks
	 * @throws IllegalArgument exception if name invalid or count invalid
	 */
	public AbstractTaskList(String name, int count) {
		setCompletedCount(count);
		setTaskListName(name);
	}

	/**
	 * Returns the name of a TaskList
	 * 
	 * @return the taskListName
	 */
	public String getTaskListName() {
		return taskListName;
	}

	/**
	 * Sets the name of a TaskList
	 * 
	 * @param taskListName the taskListName to set
	 */
	public void setTaskListName(String taskListName) {
		this.taskListName = taskListName;
	}

	/**
	 * Gets the tasks in a TaskList
	 * 
	 * @return an ISwapList of Tasks
	 */
	public ISwapList<Task> getTasks() {
		return null;
	}

	/**
	 * Sets the amount of completed tasks
	 * 
	 * @param completedCount the completedCount to set
	 */
	private void setCompletedCount(int completedCount) {
		this.completedCount = completedCount;
	}

	/**
	 * Returns the amount of completed tasks in the List
	 * 
	 * @return the completedCount
	 */
	public int getCompletedCount() {
		return completedCount;
	}

	/**
	 * Adds a task to the List
	 * 
	 * @param t the task to add
	 */
	public void addTask(Task t) {
		t.completeTask();
	}

	/**
	 * Removes a Task from the List
	 * 
	 * @param index the index to remove a Task at
	 * @return the Task that was removed
	 */
	public Task removeTask(int index) {
		return null;
	}

	/**
	 * Returns a task at a given index
	 * 
	 * @param index the index to retrieve a task from
	 * @return the Task at a given index
	 */
	public Task getTask(int index) {
		return null;
	}

	/**
	 * Sets the flag of a task to Completed
	 * 
	 * @param t the Task to set as Complete
	 */
	public void completeTask(Task t) {
		t.getTaskName();
	}

	/**
	 * Gets the Tasks in String form in an array with counter.
	 * 
	 * @return a 2D array of String representations of Tasks
	 */
	public abstract String[][] getTasksAsArray();

}
