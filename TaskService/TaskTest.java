package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.Task;

class TaskTest {
	// Test that object is created correctly
	@Test
	void testTask() {
		Task task = new Task("000", "Task 1", "Description 1");
		assertTrue(task.getId().equals("000"));
		assertTrue(task.getName().equals("Task 1"));
		assertTrue(task.getDescription().equals("Description 1"));
	}
	
	// Test ID
	@Test
	void testTaskIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("01234567890", "Task 2", "Description 2");
		});
	}
	
	@Test
	void testTaskIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Task 2", "Description 2");
		});
	}
	
	// Test name
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("111", "This name is too long", "Description 2");
		});
	}
	
	@Test
	void testTaskNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("111", null, "Desciption 2");
		});
	}
	
	// Test description
	@Test
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("111", "Task 2", "This description is too long, it longer than 50 characters");
		});
	}
	
	@Test
	void testTaskDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("111", "Task 2", null);
		});
	}

}
