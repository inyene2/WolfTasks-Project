package edu.ncsu.csc216.wolf_tasks.model.tasks;

public class TaskList extends AbstractTaskList implements Comparable<TaskList> {

	public TaskList(String name, int count) {
		super(name, count);
	}

	public String[][] getTasksAsArray() {
		return null;
	}

	public int compareTo(TaskList list) {
		return 0;
	}

}
