// By Connie Knupp for SNHU CS-320

package taskService;


public class Task {
	private final String taskId;
	private String taskName;
	private String taskDescription;
	
	//variables for parameter checks
	private int maxLengthTaskID = 10;
	private int maxLengthTaskName = 20;
	private int maxLengthTaskDescription = 50;
	
	//function for parameter checks
	public boolean checkParameters(String newVariable, int maxLength) {
		if (newVariable == null || newVariable.length()>maxLength) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//create new task
	public Task(String newTaskID, String newTaskName, String newTaskDescription) {
		if(checkParameters(newTaskID, maxLengthTaskID) == false) {
			throw new IllegalArgumentException("Invalid task ID.");
		}
		if(checkParameters(newTaskName, maxLengthTaskName) == false) {
			throw new IllegalArgumentException("Invalid task name.");
		}
		if(checkParameters(newTaskDescription, maxLengthTaskDescription) == false) {
			throw new IllegalArgumentException("Invalid task description.");
		}

		this.taskId = newTaskID;
		this.taskName = newTaskName;
		this.taskDescription = newTaskDescription;
	}
	
	
	//getters
	public String getTaskId() {
		return taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}


	//setters with checks included
	public void setTaskName (String newTaskName) {
		if(checkParameters(newTaskName, maxLengthTaskName) == false) {
			throw new IllegalArgumentException("Invalid task name.");
		}
		taskName = newTaskName;
	}
	public void setTaskDescription (String newTaskDescription) {
		if(checkParameters(newTaskDescription, maxLengthTaskDescription) == false) {
			throw new IllegalArgumentException("Invalid task description.");
		}
		taskDescription = newTaskDescription;
	}
	
}
	