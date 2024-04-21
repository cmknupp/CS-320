// By Connie Knupp for SNHU CS-320

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.TaskService;

class TaskServiceTest {
	TaskService newTaskService = new TaskService();
	
	@Test
	void testAddTask() {
		newTaskService.addTask("123456789", "test task name", "test task description");
		for (int i = 0; i < newTaskService.taskList.size(); i++) {
			if (newTaskService.taskList.get(i).getTaskId() == "123456789") {
				assertTrue(newTaskService.taskList.get(i).getTaskId().equals("123456789"));
				assertTrue(newTaskService.taskList.get(i).getTaskName().equals("test task name"));
				assertTrue(newTaskService.taskList.get(i).getTaskDescription().equals("test task description"));
			}
		}
	}

	@Test
	void testAddDuplicateCTaskId() {
		newTaskService.addTask("123456789", "test task name", "test task description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newTaskService.addTask("123456789", "dup task name", "dup test task description");
		});
	}
	
	@Test
	void testTwoTasks() {
		newTaskService.addTask("123456789", "test task name", "test task description");
		newTaskService.addTask("0123456789", "second name", "second task description");
			for (int i = 0; i < newTaskService.taskList.size(); i++) {
				if (newTaskService.taskList.get(i).getTaskId() == "123456789") {
					assertTrue(newTaskService.taskList.get(i).getTaskId().equals("123456789"));
					assertTrue(newTaskService.taskList.get(i).getTaskName().equals("test task name"));
					assertTrue(newTaskService.taskList.get(i).getTaskDescription().equals("test task description"));
				}
				if (newTaskService.taskList.get(i).getTaskId() == "0123456789") {
					assertTrue(newTaskService.taskList.get(i).getTaskId().equals("0123456789"));
					assertTrue(newTaskService.taskList.get(i).getTaskName().equals("second name"));
					assertTrue(newTaskService.taskList.get(i).getTaskDescription().equals("second task description"));
				}
			}
	}

	@Test
	void testDeleteTask() {
		newTaskService.addTask("123456789", "test task name", "test task description");
		newTaskService.deleteTask("123456789");
		for (int i = 0; i < newTaskService.taskList.size(); i++) {
			if (newTaskService.taskList.get(i).getTaskId() == "123456789") {
				fail("Task still exists");
			}
		}
	}
	
	@Test
	void testDeleteNonexistantTask() {
		newTaskService.addTask("123456789", "test task name", "test task description");
		try {
				newTaskService.deleteTask("123123123");
			}
		catch (Exception e) {
			fail("Threw exception with delete command");
		}
		for (int i = 0; i < newTaskService.taskList.size(); i++) {
			if (newTaskService.taskList.get(i).getTaskId() == "123123123") {
				fail("Task still exists");
			}
		}
	}

	@Test
	void testUpdateTaskName() {
		newTaskService.addTask("123456789", "test task name", "test task description");
		newTaskService.updateTaskName("123456789", "new task name");
		for (int i = 0; i < newTaskService.taskList.size(); i++) {
			if (newTaskService.taskList.get(i).getTaskId() == "123456789") {
				assertTrue(newTaskService.taskList.get(i).getTaskName().equals("new task name"));
			}
		}
	}

	@Test
	void testUpdateTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newTaskService.addTask("123456789", "test task name", "test task description");
			newTaskService.updateTaskName("123456789", null);
		});
	}
	
	@Test
	void testUpdateTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newTaskService.addTask("123456789", "test task name", "test task description");
			newTaskService.updateTaskName("123456789", "this task name is too long");
		});
	}
	
	@Test
	void testUpdateTaskDescription() {
		newTaskService.addTask("123456789", "test task name", "test task description");
		newTaskService.updateTaskDescription ("123456789", "new description for task");
		for (int i = 0; i < newTaskService.taskList.size(); i++) {
			if (newTaskService.taskList.get(i).getTaskId() == "123456789") {
				assertTrue(newTaskService.taskList.get(i).getTaskDescription().equals("new description for task"));
			}
		}
	}
	
	@Test
	void testUpdateTaskDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newTaskService.addTask("123456789", "test task name", "test task description");
			newTaskService.updateTaskDescription("123456789", null);
		});
	}
	
	@Test
	void testUpdateTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newTaskService.addTask("123456789", "test task name", "test task description");
			newTaskService.updateTaskDescription("123456789", "test task description that is way too long to pass this test");
		});
	}
}