// CS320
package contact;

public class Contact {
	// Instance variables
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		// Validate contact data
		boolean valid = validateInput(id, 10);
		
		if (valid) {
			this.id = id;
		}
		
		valid = valid && setFirstName(firstName);
		valid = valid && setLastName(lastName);
		valid = valid && setPhone(phone);
		valid = valid && setAddress(address);
		
		if (!valid) {
			throw new IllegalArgumentException("Invalid input");
		}
	}
	
	// Setters
	public boolean setFirstName(String newFirst) {
		boolean valid = validateInput(newFirst, 10);
		if (valid) {
			firstName = newFirst;
		}
		return valid;
	}
	
	public boolean setLastName(String newLast) {
		boolean valid = validateInput(newLast, 10);
		if (valid) {
			lastName = newLast;
		}
		return valid;
	}
	
	public boolean setAddress(String newAddress) {
		boolean valid = validateInput(newAddress, 30);
		if (valid) {
			address = newAddress;
		}
		return valid;
	}
	
	public boolean setPhone(String newPhone) {
		boolean valid = newPhone.matches("\\d{10}");
		if (valid) {
			phone = newPhone;
		}
		return valid;
	}
	
	// Getters
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	// Check input for null and length
	private boolean validateInput(String item, int length) {
		return (item != null && item.length() <= length);
	}
}
