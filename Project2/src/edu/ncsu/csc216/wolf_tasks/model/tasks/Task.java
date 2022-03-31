package edu.ncsu.csc216.wolf_tasks.model.tasks;

public class Task {
	private String taskName;
	private String taskDescription;
	private boolean recurring;
	private boolean active;

	/**
	 * @param taskName
	 * @param taskDescription
	 * @param recurring
	 * @param active
	 */
	public Task(String taskName, String taskDescription, boolean recurring, boolean active) {

	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the taskDescription
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * @param taskDescription the taskDescription to set
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 * @return the recurring
	 */
	public boolean isRecurring() {
		return recurring;
	}

	/**
	 * @param recurring the recurring to set
	 */
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	public String getTaskListName() {
		return null;
	}

	public void addTaskList(AbstractTaskList taskList) {

	}

	public void completeTask() {

	}

	public Object clone() {
		return null;
	}

	public String toString() {
		return null;
	}

}
