package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.TaskService;

class TaskServiceTest {
	TaskService tService = new TaskService();
	
	// Add task and verify that it has been added and all data is correct
	@Test
	void testAddTask() {
		tService.addTask("000", "Task 1", "Description 1");
		assertTrue(tService.getTask("000").getId().equals("000"));
		assertTrue(tService.getTask("000").getName().equals("Task 1"));
		assertTrue(tService.getTask("000").getDescription().equals("Description 1"));
	}
	
	// Test adding duplicate ID
	@Test
	void testAddTaskDuplicateId() {
		tService.addTask("111", "Task 2", "Description 2");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			tService.addTask("111", "Task 2.1", "Description 2.1");
		});
	}
	
	// Test deleting a task
	@Test
	void testDeleteTask() {
		tService.addTask("222", "Task 3", "Description 3");
		tService.deleteTask("222");
		
	}
	
	// Test updating task data
	@Test
	void testUpdateName() {
		tService.addTask("333", "Task 4", "Description 4");
		tService.updateName("333", "Task 4 New");
		assertEquals("Task 4 New", tService.getTask("333").getName());
	}
	
	@Test
	void testUpdateDescription() {
		tService.addTask("444", "Task 5", "Description 5");
		tService.updateDescription("444", "Description 5 New");
		assertEquals("Description 5 New", tService.getTask("444").getDescription());
	}
}
