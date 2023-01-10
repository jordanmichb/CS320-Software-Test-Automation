package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentService;

class AppointmentServiceTest {
	AppointmentService aService = new AppointmentService();
	
	// Add appointment and verify all data is correct
	@Test
	void testAddAppointment() throws Exception {
		assertTrue(aService.addAppointment("000", "10/24/2022 09:00 AM", "Description1"));
		
		Appointment appointment = aService.getAppointment("000");
		
		assertTrue(appointment.getId().equals("000"));
		assertTrue(appointment.getDate().equals("10/24/2022 09:00 AM"));
		assertTrue(appointment.getDescription().equals("Description1"));
	}
	
	// Test adding multiple appointments
	@Test
	void testAddMultipleAppointments() throws Exception {
		assertTrue(aService.addAppointment("111", "10/25/2022 09:30 AM", "Description2"));
		assertTrue(aService.addAppointment("222", "10/26/2022 10:30 AM", "Description3"));
	}
	
	// Test adding duplicate ID
	@Test
	void testAddDuplicateId() throws Exception {
		assertTrue(aService.addAppointment("333", "10/27/2022 08:30 AM", "Description4"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aService.addAppointment("333", "10/27/2022 09:30 AM", "Description4");
		});
	}
	
	// Test deleting appointment
	@Test
	void testDeleteAppointment() throws Exception {
		assertTrue(aService.addAppointment("444", "10/28/2022 08:30 AM", "Description5"));
		aService.deleteAppointment("444");
		assertEquals(null, aService.getAppointment("444"));
	}

}
