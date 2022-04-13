package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * This is the Task object class, the object that comprises TaskLists that
 * comprise Notebooks
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class Task implements Cloneable {

	/** The name of a Task */
	private String taskName;
	/** The description of a Task */
	private String taskDescription;
	/** Whether or not a Task is recurring */
	private boolean recurring;
	/** Whether or not a Task is active */
	private boolean active;
	/** An ISwapList of AbstractTaskLists called taskLists */
	ISwapList<AbstractTaskList> taskLists = new SwapList<AbstractTaskList>();

	/**
	 * Constructor for a Task object. Has a name, desc, and whether or not task is
	 * recurring and or active.
	 * 
	 * @param taskName        the name of a Task
	 * @param taskDescription the description of a Task
	 * @param recurring       whether or not a Task is recurring
	 * @param active          whether or not a Task is active
	 */
	public Task(String taskName, String taskDescription, boolean recurring, boolean active) {
		setTaskName(taskName);
		setTaskDescription(taskDescription);
		setRecurring(recurring);
		setActive(active);
	}

	/**
	 * Returns the name of a Task
	 * 
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the name of a Task
	 * 
	 * @param taskName the taskName to set
	 * @throws IllegalArgumentException if invalid name
	 */
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() == 0) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskName = taskName;
	}

	/**
	 * Returns the description of a Task
	 * 
	 * @return the taskDescription
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * Sets the description of a Task
	 * 
	 * @param taskDescription the taskDescription to set
	 * @throws IllegalArgumentException if invalid taskDescription
	 */
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDescription = taskDescription;
	}

	/**
	 * Returns whether or not a Task is recurring
	 * 
	 * @return whether or not a Task is recurring
	 */
	public boolean isRecurring() {
		return recurring;
	}

	/**
	 * Sets whether or not a Task is recurring
	 * 
	 * @param recurring whether or not a Task is recurring
	 */
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	/**
	 * Gets whether or not a Task is active
	 * 
	 * @return whether or not a Task is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets whether or not a Task is active
	 * 
	 * @param active whether or not a Task is active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Returns the name of a TaskList that the Task is in at index 0.
	 * 
	 * @return the name of a TaskList
	 */
	public String getTaskListName() {
		return taskLists.get(0).getTaskListName();
	}

	/**
	 * Adds a TaskList to the current Task
	 * 
	 * @param taskList the TaskList to add
	 * @throws IllegalArgumentException if taskList is null
	 */
	public void addTaskList(AbstractTaskList taskList) {
		if (taskList == null) {
			throw new IllegalArgumentException();
		}
		// TODO check on how to fix:
		// If the AbstractTaskList is NOT already registered with the Task the
		// AbstractTaskList is added
		this.taskLists.add(taskList);
	}

	/**
	 * Sets the flag on whether or not a Task has been completed
	 */
	public void completeTask() {
		Task clonedTask;
		try {
			clonedTask = (Task) clone();
			for (int i = 0; i < taskLists.size(); i++) {
				taskLists.get(i).completeTask(this);
				if (isRecurring()) {
					taskLists.get(i).addTask(clonedTask);
				}
			}
		} catch (CloneNotSupportedException e) {
			// Do nothing
		}
		
	}

	/**
	 * Clones a task
	 *
	 * @return a cloned Task
	 * @throws CloneNotSupportedException if there are no AbstractTaskLists
	 *                                    registered with the Task
	 */
	public Object clone() throws CloneNotSupportedException {
		// if there is an ATL associated with this task
		if (taskLists.size() <= 0) {
			throw new CloneNotSupportedException("Cannot clone.");
		} 
		
		Task clone = new Task(taskName, taskDescription, recurring, active);
		
		for (int i = 0; i < taskLists.size(); i++) {
			clone.addTaskList(taskLists.get(i));
		}
		
		return clone;
	}

	/**
	 * Method for creating the String representation of a Task
	 *
	 * @return the String representation of a Task
	 */
	public String toString() {
		return taskName + "," + taskDescription + "," + isRecurring() + "," + isActive();
	}

}
