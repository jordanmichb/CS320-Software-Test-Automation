package task;

public class Task {
	// Instance variables
	private String id;
	private String name;
	private String description;
	
	public Task(String id, String name, String description) {
		// Validate data
		boolean valid = validateInput(id, 10);
		
		if (valid) {
			this.id = id;
		}
		
		valid = valid && setName(name);
		valid = valid && setDescription(description);
		
		if (!valid) {
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	// Setters
	public boolean setName(String newName) {
		boolean valid = validateInput(newName, 20);
		if (valid) {
			name = newName;
		}
		return valid;
	}
	
	public boolean setDescription(String newDescription) {
		boolean valid = validateInput(newDescription, 50);
		if (valid) {
			description = newDescription;
		}
		return valid;
	}
	
	// Getters
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	// Check input for null and length
	private boolean validateInput(String item, int length) {
		return (item != null && item.length() <= length);
	}
}
