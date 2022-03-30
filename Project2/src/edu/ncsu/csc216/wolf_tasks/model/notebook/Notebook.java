package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

public class Notebook {

	private String notebookName;

	private Boolean isChanged;

	public Notebook(String name) {
		setNotebookName(name);
	}

	public void saveNotebook(File file) {

	}

	/**
	 * @return the notebookName
	 */
	public String getNotebookName() {
		return notebookName;
	}

	/**
	 * @param notebookName the notebookName to set
	 */
	private void setNotebookName(String notebookName) {
		this.notebookName = notebookName;
	}

	/**
	 * @return the isChanged
	 */
	public Boolean isChanged() {
		return isChanged;
	}

	/**
	 * @param isChanged the isChanged to set
	 */
	public void setChanged(Boolean isChanged) {
		this.isChanged = isChanged;
	}

	public void addTaskList(TaskList taskList) {

	}

	public String[] getTaskListsNames() {
		return null;
	}

	private void getActiveTaskList() {

	}

	public void setCurrentTaskList(String name) {

	}

	public AbstractTaskList getCurrentTaskList() {
		return null;
	}

	public void editTaskList(String name) {

	}

	public void removeTaskList() {

	}

	public void addTask(Task t) {

	}

	public void editTask(int id, String taskName, String description, boolean recurring, boolean active) {

	}

}
