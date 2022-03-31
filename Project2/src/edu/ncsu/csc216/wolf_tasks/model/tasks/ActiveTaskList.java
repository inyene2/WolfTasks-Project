package edu.ncsu.csc216.wolf_tasks.model.tasks;

public class ActiveTaskList extends AbstractTaskList {

	public static final String ACTIVE_TASKS_NAME = "Active Tasks";

	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}

	public void addTask(Task t) {
		super.addTask(t);
	}

	public void setTaskListName(String name) {
		super.setTaskListName(name);
	}

	@Override
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clearTasks() {

	}

}
