package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

class AppointmentTest {
	// Test that object is created correctly
	@Test
	void testAppointment() throws Exception {
		Appointment appointment = new Appointment("000", "10/24/2022 09:00 AM", "Description");
		assertTrue(appointment.getId().equals("000"));
		assertTrue(appointment.getDate().equals("10/24/2022 09:00 AM"));
		assertTrue(appointment.getDescription().equals("Description"));
	}
	
	// Test ID
	@Test
	void testAppointmentIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("01234567890", "10/24/2022 09:00 AM", "Description");
		});
	}
	
	@Test
	void testAppointmentIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, "10/24/2022 09:00 AM", "Description");
		});
	}
	
	// Test date
	@Test 
	void testAppointmentDateBefore() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("000", "10/24/2021 09:00 AM", "Description");
		});
	}
	
	@Test 
	void testAppointmentDateIsNull() {
		Assertions.assertThrows(Exception.class, () -> {
			new Appointment("000", null, "Description");
		});
	}
	
	// Test description
	@Test
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("000", "10/24/2021 09:00 AM", "This description is too long, it longer than 50 characters");
		});
	}
	
	@Test
	void testAppointmentDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("000", "10/24/2021 09:00 AM", null);
		});
	}
}
