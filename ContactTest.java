package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	// Test that object is created correctly
	@Test
	void testContact() {
		Contact contact = new Contact("000", "John", "Smith", "0123456789", "12 Apple Lane");
		assertTrue(contact.getId().equals("000"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getPhone().equals("0123456789"));
		assertTrue(contact.getAddress().equals("12 Apple Lane"));
	}
	
	// Test ID
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("01234567890", "John", "Smith", "0123456789", "12 Apple Lane");
		});
	}
	
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Smith", "0123456789", "12 Apple Lane");
		});
	}
	
	// Test first name
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("000", "Johnnnnnnnn", "Smith", "0123456789", "12 Apple Lane");
		});
	}
	
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("000", null, "Smith", "0123456789", "12 Apple Lane");
		});
	}
	
	// Test last name
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("000", "John", "Smithhhhhhh", "0123456789", "12 Apple Lane");
		});
	}
	
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("000", "John", null, "0123456789", "12 Apple Lane");
		});
	}
	
	// Test phone number
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("000", "John", "Smith", "01234567890", "12 Apple Lane");
		});
	}
	
	@Test
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("000", "John", "Smith", "012345", "12 Apple Lane");
		});
	}
	
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			new Contact("000", "John", "Smith", null, "12 Apple Lane");
		});
	}
	
	// Test address
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("000", "John", "Smith", "0123456789", "11223344556677889900 Apple Lane");
		});
	}
	
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("000", "John", "Smith", "0123456789", null);
		});
	}
}
