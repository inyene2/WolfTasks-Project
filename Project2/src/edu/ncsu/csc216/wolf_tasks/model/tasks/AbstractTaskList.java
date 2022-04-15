package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

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

	/** ISwapList of tasks */
	ISwapList<Task> tasks = new SwapList<Task>();

	/**
	 * Constructor for an AbstractTaskList
	 * 
	 * @param name  the name of a List
	 * @param count the count of completed tasks
	 * @throws IllegalArgumentException if name invalid or count invalid
	 */
	public AbstractTaskList(String name, int count) {
		setCompletedCount(count);
		setTaskListName(name);
		tasks = new SwapList<Task>();
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
	 * @throws IllegalArgumentException if the name string is empty or null
	 */
	public void setTaskListName(String taskListName) {
		if (taskListName == null || taskListName.length() == 0) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.taskListName = taskListName;
	}

	/**
	 * Gets the tasks in a TaskList
	 * 
	 * @return an ISwapList of Tasks
	 */
	public ISwapList<Task> getTasks() {
		return tasks;
	}

	/**
	 * Sets the amount of completed tasks
	 * 
	 * @param completedCount the completedCount to set
	 * @throws IllegalArgumentException if the count is less than 0
	 */
	public void setCompletedCount(int completedCount) {
		if (completedCount < 0) {
			throw new IllegalArgumentException("Invalid completed count.");
		}
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
		tasks.add(t);
		t.addTaskList(this);
	}

	/**
	 * Removes a Task from the List
	 * 
	 * @param index the index to remove a Task at
	 * @return the Task that was removed
	 */
	public Task removeTask(int index) {
		return tasks.remove(index);
	}

	/**
	 * Returns a task at a given index
	 * 
	 * @param index the index to retrieve a task from
	 * @return the Task at a given index
	 */
	public Task getTask(int index) {
		return tasks.get(index);
	}

	/**
	 * Sets the flag of a task to Completed. Iterates over the list of Tasks to find
	 * a task, then remove it and increment completed counter
	 * 
	 * @param t the Task to set as Complete
	 */
	public void completeTask(Task t) {
		for (int i = 0; i < tasks.size(); i++) {
			// NOTE: the writeup said to use == instead of .equals, so we will have to see if this works
			if (tasks.get(i) == t) {
				tasks.remove(i);
				completedCount++;
			}
		}
	}

	/**
	 * Gets the Tasks in String form in an array with counter.
	 * 
	 * @return a 2D array of String representations of Tasks
	 */
	public abstract String[][] getTasksAsArray();

}
