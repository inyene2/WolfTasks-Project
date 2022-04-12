package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

/**
 * Notebook class for WolfTasks, this is a Notebook that is comprised of TaskLists that have Tasks.
 * 
 * @author Mason Morano
 * @author Inyene Etuk
 *
 */
public class Notebook {

	/** Name of a notebook */
	private String notebookName;

	/** Whether or not a notebook has been changed */
	private Boolean isChanged;
	
	/** List of sorted taskLists */
	private ISortedList<TaskList> taskLists ;
	
	/** List of active tasks */
	private ActiveTaskList activeTaskList;
	
	/** List of current tasks */
	private AbstractTaskList currentTaskList;

	/**
	 * Constructor for Notebook
	 * 
	 * @param name the name of a Notebook
	 * @throws IllegalArgumentException for invalid name
	 */
	public Notebook(String name) {
		if (name == null || name.isEmpty() || "Active Tasks".equals(name)) {
			throw new IllegalArgumentException();
		}
		setNotebookName(name);
		taskLists = new SortedList<TaskList>();
		activeTaskList = new ActiveTaskList();
		currentTaskList = activeTaskList;
		setChanged(true);
	}

	/**
	 * Method to do file output with a notebook file
	 * 
	 * @param file the file to output to
	 */
	public void saveNotebook(File notebookFile) {
		NotebookWriter.writeNotebookFile(notebookFile, notebookName, taskLists);
		setChanged(false);
	}

	/**
	 * Gets the name of the current Notebook
	 * 
	 * @return the notebookName the name of a Notebook
	 */
	public String getNotebookName() {
		return notebookName;
	}

	/**
	 * Sets the name of a Notebook
	 * 
	 * @param notebookName the notebookName to set
	 * @throws IllegalArgumentException for invalid name
	 */
	private void setNotebookName(String notebookName) {
		this.notebookName = notebookName;
	}

	/**
	 * Returns whether or not a Notebook has been changed
	 * 
	 * @return whether or not a notebook has been changed
	 */
	public Boolean isChanged() {
		return isChanged;
	}

	/**
	 * Sets whether or not a Notebook has been changed
	 * 
	 * @param isChanged whether a Notebook has been changed or not
	 */
	public void setChanged(Boolean isChanged) {
		this.isChanged = isChanged;
	}

	/**
	 * Adds a TaskList to the Notebook
	 * 
	 * @param taskList the TaskList to add
	 * @throws IllegalArgumentException for invalid name
	 */
	public void addTaskList(TaskList taskList) {
		if (taskList.getTaskListName().equals("Active Tasks")) {
			throw new IllegalArgumentException("Invalid name");
		}
		for (int i = 0; i < this.taskLists.size(); i++) {
			if (this.taskLists.get(i).getTaskListName().equals(taskList.getTaskListName())) {
				throw new IllegalArgumentException("Invalid name");
			}
		}
		this.taskLists.add(taskList);
		this.currentTaskList = taskList;
		setChanged(true);
	}

	/**
	 * Gets a list of the names of all of the TaskLists in a String array
	 * 
	 * @return an array of Strings of the names of the TaskLists in a Notebook
	 */
	public String[] getTaskListsNames() {
		String[] names = new String[this.taskLists.size()];
		names[0] = this.activeTaskList.getTaskListName();
		for (int i = 0; i < this.taskLists.size() - 1; i++) {
			names[i+1] = this.taskLists.get(i).getTaskListName();
		}
		return names;
	}

	/**
	 * Rebuilds activeTaskList by iterating through taskLists and
	 * adding each active task (by priority)
	 * 
	 */
	private void getActiveTaskList() {
		this.activeTaskList = new ActiveTaskList();
		for (int i = 0; i < this.taskLists.size(); i++) {
			TaskList list = taskLists.get(i);
			for (int j = 0; j < list.getTasks().size(); j++) {
				if(list.getTask(j).isActive()) {
					this.activeTaskList.addTask(list.getTask(j));
				}
			}
		}
	}

	/**
	 * Sets the currentTaskList to the AbstractTaskList with the give name
	 * 
	 * @param name the name to set a CurrentTaskList to
	 */
	public void setCurrentTaskList(String name) {
		for (int i = 0; i < this.taskLists.size(); i++) {
			if (name.equals(taskLists.get(i).getTaskListName())) {
				this.currentTaskList = taskLists.get(i);
			}
		}
		this.currentTaskList = this.activeTaskList;
	}

	/**
	 * Gets the current TaskList
	 * 
	 * @return the TaskList in the form of an AbstractTaskList
	 */
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}

	/**
	 * Updates currenTaskList with name
	 * 
	 * @param name the parameter to edit a task with
	 * @throws IllegalArgumentException for invalid name
	 */
	public void editTaskList(String name) {
		//checks if currentTaskList is an activeTaskList
		if (this.currentTaskList.getClass() == this.activeTaskList.getClass()) {
			
		}
	}

	/**
	 * Removes a TaskList from the Notebook
	 * @throws IllegalArgumentException if the currentTaskList is an ActiveTaskList
	 */
	public void removeTaskList() {

	}

	/**
	 * Adds a Task to a TaskList
	 * 
	 * @param t the Task to add
	 */
	public void addTask(Task t) {

	}

	/**
	 * Edits a task with a new set of parameters that belong to a Task object
	 * 
	 * @param id          the Id to create a new Task with
	 * @param taskName    the name of a Task to create
	 * @param description the description of a Task
	 * @param recurring   whether or not a task is Recurring
	 * @param active      whether or not a task is Active
	 * @throws IllegalArgumentException for invalid task 
	 */
	public void editTask(int id, String taskName, String description, boolean recurring, boolean active) {

	}

}
