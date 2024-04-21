// By Connie Knupp for SNHU CS-320

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;

class TaskTest {

	@Test
	void testTask() {
			Task newTask = new Task("123456789", "test task name", "test task description");
			assertTrue(newTask.getTaskId().equals("123456789"));
			assertTrue(newTask.getTaskName().equals("test task name"));
			assertTrue(newTask.getTaskDescription().equals("test task description"));
	
	}
	@Test
	void testTaskIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "test task name", "test task description");
		});
	}
	
	@Test
	void testTaskIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("01234567890", "test task name", "test task description");
		});
	}
	
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", "test too long task name", "test task description");
		});
	}
	
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", null, "test task description");
		});
	}
	
	@Test
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", "test task name", "test task description that is way too long to pass this test");
		});
	}
	
	@Test
	void testTaskDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", "test task name", null);
		});
	}
	
	@Test
	void testGetTaskId() {
		Task newTask = new Task ("0123456789", "test task name", "test task description");
		assertTrue(newTask.getTaskId().equals("0123456789"));
	}

	@Test
	void testGetTaskName() {
		Task newTask = new Task ("1234567890", "test task name", "test task description");
		assertTrue(newTask.getTaskName().equals("test task name"));
	}

	@Test
	void testGetTaskDescription() {
		Task newTask = new Task ("0987654321", "test task name", "test task description");
		assertTrue(newTask.getTaskDescription().equals("test task description"));
	}

	@Test
	void testSetTaskName() {
		Task newTask = new Task ("9876543210", "test task name", "test task description");
		newTask.setTaskName("New Name");
		assertTrue(newTask.getTaskName().equals("New Name"));
	}
	
	@Test
	void testSetTaskNameNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task newTask = new Task("1023456789", "test task name", "test task description");
			newTask.setTaskName(null);
		});
	}
	
	@Test
	void testSetTaskNameTooLong () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task newTask = new Task("1023456789", "test task name", "test task description");
			newTask.setTaskName("test name that is too long");
		});
	}

	@Test
	void testSetTaskDescription() {
		Task newTask = new Task ("987654321", "test task name", "test task description");
		newTask.setTaskDescription("New Task Description");
		assertTrue(newTask.getTaskDescription().equals("New Task Description"));
	}

	@Test
	void testSetDescriptionNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task newTask = new Task("1023456789", "test task name", "test task description");
			newTask.setTaskDescription(null);
		});
	}
	
	@Test
	void testSetTaskDescriptionTooLong () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task newTask = new Task("1023456789", "test task name", "test task description");
			newTask.setTaskDescription("test task description that is way too long to pass this test");
		});
	}
}
