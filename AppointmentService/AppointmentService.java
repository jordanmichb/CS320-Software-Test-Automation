package appointment;

import java.util.HashMap;

public class AppointmentService {
	// Structure to hold Appointments
	private HashMap<String, Appointment> appointmentMap;
	
	public AppointmentService() {
		appointmentMap = new HashMap<String, Appointment>();
	}
	
	public boolean addAppointment(String id, String date, String description) throws Exception {
		if (appointmentMap.containsKey(id)) {
			// Check for duplicate ID
			throw new IllegalArgumentException("ID already used.");
		}
		// Create new appointment object
		Appointment newAppointment = new Appointment(id, date, description);
		// Add to appointmentMap with the ID as the key
		appointmentMap.put(newAppointment.getId(), newAppointment);
		return true;
	}
	
	// Delete an appointment by ID
	public void deleteAppointment(String id) {
		// Will remove appointment if present
		appointmentMap.remove(id);
	}
	
	// Return a specific appointment by ID
	public Appointment getAppointment(String id) {
		// Gets appointment if present, else returns null
		return appointmentMap.get(id);
	}
}
