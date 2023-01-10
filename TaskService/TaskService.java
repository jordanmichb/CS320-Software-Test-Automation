package task;

import java.util.HashMap;

public class TaskService {
	// Structure to hold Tasks
	private HashMap<String, Task> taskMap;
	
	// Constructor
	public TaskService() {
		taskMap = new HashMap<String, Task>();
	}
	
	public void addTask(String id, String name, String description) {
		if (taskMap.containsKey(id)) {
			// Check for duplicate ID
			throw new IllegalArgumentException("ID already used.");
		}
		// Create new task object
		Task newTask = new Task(id, name, description);
		// Add to taskMap with the ID as the key
		taskMap.put(newTask.getId(), newTask);
	}
	
	// Delete a task by ID
	public void deleteTask(String id) {
		// Will remove task if present, else returns null
		taskMap.remove(id);
	}
	
	// Return a specific task by ID
	public Task getTask(String id) {
		return taskMap.get(id);
	}
	
	// Methods to update task data by specified ID
	public void updateName(String id, String newName) {
		getTask(id).setName(newName);
	}
	
	public void updateDescription(String id, String newDesc) {
		getTask(id).setDescription(newDesc);
	}
}
