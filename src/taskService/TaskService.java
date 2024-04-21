// By Connie Knupp for SNHU CS-320

package taskService;

import java.util.ArrayList;

public class TaskService {
	public ArrayList<Task> taskList = new ArrayList<Task>();
	
	//add task
	public void addTask(String newTaskID, String newTaskName, String newTaskDescription) {
		Task taskToAdd = new Task(newTaskID, newTaskName, newTaskDescription);
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getTaskId() == newTaskID){
				throw new IllegalArgumentException("Task ID already exists!");
			}
		}
		taskList.add(taskToAdd);
	}

	
	//delete task
	public void deleteTask(String taskIdToDelete) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getTaskId() == taskIdToDelete){
				taskList.remove(i);
			}
		}
	}
	
	//update task functions
	public void updateTaskName (String taskIdToUpdate, String updatedTaskName) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getTaskId() == taskIdToUpdate){
				taskList.get(i).setTaskName(updatedTaskName);
			}
		}
	}
	public void updateTaskDescription (String taskIdToUpdate, String updatedTaskDescription) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getTaskId() == taskIdToUpdate){
				taskList.get(i).setTaskDescription(updatedTaskDescription);
			}
		}
	}

}
