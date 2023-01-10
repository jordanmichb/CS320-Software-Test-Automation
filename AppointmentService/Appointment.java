package appointment;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Appointment {
	// Instance variables
	private String id;
	private Date date;
	private String description;
	
	// Set format for date
	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");;
	
	// Constructor
	public Appointment(String id, String date, String description) throws Exception {
		// Validate input
		boolean valid = validateInput(id, 10);
		
		if (valid) {
			this.id = id;
		}
	
		Date pdate = dateFormat.parse(date); // Parse date to correct format and data type
		valid = valid && setDate(pdate);
		valid = valid && setDescription(description);
		
		if (!valid) {
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	// Validate and set date
	private boolean setDate(Date newDate) {
		boolean valid = !validateDate(newDate);
		if (valid) {
			date = newDate;
		}
		return valid;
	}
	
	// Validate and set description
	public boolean setDescription(String newDescription) {
		boolean valid = validateInput(newDescription, 50);
		if (valid) {
			description = newDescription;
		}
		return valid;
	}

	public String getId() {
		return id;
	}
	
	public String getDate() {
		return dateFormat.format(date);
	}
	
	public String getDescription() {
		return description;
	}
	
	// Check input for null and length
	private boolean validateInput(String item, int length) {
		return (item != null && item.length() <= length);
	}
	
	// Check if date is in the past
	private boolean validateDate(Date date) {
		return (date.before(new Date()));
	}
}
