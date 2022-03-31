package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * This is the Task object class, the object that comprises TaskLists that
 * comprise Notebooks
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class Task {

	/** The name of a Task */
	private String taskName;
	/** The description of a Task */
	private String taskDescription;
	/** Whether or not a Task is recurring */
	private boolean recurring;
	/** Whether or not a Task is active */
	private boolean active;

	/**
	 * Constructor for a Task object. Has a name, desc, and whether or not task is recurring and or active.
	 * 
	 * @param taskName        the name of a Task
	 * @param taskDescription the description of a Task
	 * @param recurring       whether or not a Task is recurring
	 * @param active          whether or not a Task is active
	 */
	public Task(String taskName, String taskDescription, boolean recurring, boolean active) {

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
	 */
	public void setTaskName(String taskName) {
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
	 */
	public void setTaskDescription(String taskDescription) {
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
	 * Returns the name of a TaskList that the Task is in
	 * 
	 * @return the name of a TaskList
	 */
	public String getTaskListName() {
		return null;
	}

	/**
	 * Adds a TaskList to the current Task
	 * 
	 * @param taskList the TaskList to add
	 */
	public void addTaskList(AbstractTaskList taskList) {

	}

	/**
	 * Sets the flag on whether or not a Task has been completed
	 */
	public void completeTask() {

	}

	/**
	 * Clones a task
	 *
	 * @return a cloned Task
	 * @throws CloneNotSupportedException if there is a problem cloning
	 */
	public Object clone() throws CloneNotSupportedException {
		return null;
	}

	/**
	 * Method for creating the String representation of a Task
	 *
	 * @return the String representation of a Task
	 */
	public String toString() {
		return null;
	}

}
