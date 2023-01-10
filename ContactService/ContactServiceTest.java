
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.ContactService;

class ContactServiceTest {

	ContactService cService = new ContactService();
	
	// Add contact and verify that it has been added and all data is correct
	@Test
	void testAddContact() {
		cService.addContact("000", "John", "Smith", "0123456789", "12 Apple Lane");
		assertTrue(cService.getContact("000").getId().equals("000"));
		assertTrue(cService.getContact("000").getFirstName().equals("John"));
		assertTrue(cService.getContact("000").getLastName().equals("Smith"));
		assertTrue(cService.getContact("000").getPhone().equals("0123456789"));
		assertTrue(cService.getContact("000").getAddress().equals("12 Apple Lane"));
	}
	
	// Test adding duplicate ID
	@Test
	void testAddContactDuplicateId() {
		cService.addContact("111", "Jim", "Brown", "0123459876", "11 Orange Street");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		cService.addContact("111", "Jane", "Doe", "9876543210", "10 Banana Way");
		});
	}
	
	// Test deleting a contact
	@Test
	void testDeleteContact() {
		cService.addContact("123", "Michael", "Lee", "0123456789", "14 Appleseed Lane");
		cService.deleteContact("123");
		assertEquals(null, cService.getContact("123"));
	}
	
	// Test updating contact data
	@Test
	void testUpdateFirstName() {
		cService.addContact("222", "Jill", "Garcia", "9876012345", "13 Grape Ave");
		cService.updateFirstName("222", "Jillian");
		assertEquals("Jillian", cService.getContact("222").getFirstName());
	}
	
	@Test
	void testUpdateLastName() {
		cService.addContact("333", "Jill", "Garcia", "9876012345", "13 Grape Ave");
		cService.updateLastName("333", "Garza");
		assertEquals("Garza", cService.getContact("333").getLastName());
	}
	
	@Test
	void testUpdatePhone() {
		cService.addContact("444", "Jill", "Garcia", "9876012345", "13 Grape Ave");
		cService.updatePhone("444", "0000000000");
		assertEquals("0000000000", cService.getContact("444").getPhone());
	}
	
	@Test
	void testUpdateAddress() {
		cService.addContact("555", "Jill", "Garcia", "9876012345", "13 Grape Ave");
		cService.updateAddress("555", "13 Grapeseed Ave");
		assertEquals("13 Grapeseed Ave", cService.getContact("555").getAddress());
	}
}
