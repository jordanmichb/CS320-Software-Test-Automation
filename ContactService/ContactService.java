package contact;

import java.util.HashMap;

public class ContactService {
	private HashMap<String, Contact> contactMap;
	
	// Constructor
	public ContactService() {
		contactMap = new HashMap<String, Contact>();
	}
	
	// Method to add a new contact
	public void addContact(String id, String firstName, String lastName,
			   String phone, String address) {
		// Check for repeat ID
		if (contactMap.containsKey(id)) {
			throw new IllegalArgumentException("ID already used.");
		}
		// Create new contact object
		Contact newContact = new Contact(id, firstName, lastName, phone, address);
		// Add to hash map with ID as key
		contactMap.put(newContact.getId(), newContact);
	}
	
	// Method to delete a contact by ID
	public void deleteContact(String id) {
		// Will remove mapping, if present
		contactMap.remove(id);
	}
	
	public Contact getContact(String id) {
		return contactMap.get(id);
	}
	
	// Methods to update contact data by specified ID
	public void updateFirstName(String id, String newFirst) {
		getContact(id).setFirstName(newFirst);
	}
	
	public void updateLastName(String id, String newLast) {
		getContact(id).setLastName(newLast);
	}
	
	public void updatePhone(String id, String newPhone) {
		getContact(id).setPhone(newPhone);
	}
	
	public void updateAddress(String id, String newAddress) {
		getContact(id).setAddress(newAddress);
	}
}
