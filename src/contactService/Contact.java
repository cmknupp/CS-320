// By Connie Knupp for SNHU CS-320
package contactService;

public class Contact {

	private final String contactID;
	private String contactFirstName;
	private String contactLastName;
	private String contactPhoneNum;
	private String contactAddress;
	
	//variables for parameter checks
	private int maxLengthContactID = 10;
	private int maxLengthFirstName = 10;
	private int maxLengthLastName = 10;
	private int lengthPhoneNum = 10;
	private int maxLengthAddress = 30;
	
	//function for parameter checks
	public boolean checkParameters(String newVariable, int maxLength) {
		if ((newVariable == null) || (newVariable.length()>maxLength)) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean checkPhoneParameters(String phoneNum) {
		if((phoneNum == null) || (phoneNum.length()!= lengthPhoneNum)) {
			return false;
		}
		for (int i = 0; i < 10; i++) {
			if (Character.isDigit(phoneNum.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	
	//create new contact
	public Contact (String contactID, String contactFirstName, String contactLastName, String contactPhoneNum, String contactAddress) {
		if(checkParameters(contactID, maxLengthContactID) == false) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		if(checkParameters(contactFirstName, maxLengthFirstName) == false) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if(checkParameters(contactLastName, maxLengthLastName) == false) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if(checkPhoneParameters(contactPhoneNum) == false) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if(checkParameters(contactAddress, maxLengthAddress) == false) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.contactID = contactID;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.contactPhoneNum = contactPhoneNum;
		this.contactAddress = contactAddress;
	}
	
	
	//getters
	public String getContactID() {
		return contactID;
	}
	public String getContactFirstName() {
		return contactFirstName;
	}
	public String getContactLastName() {
		return contactLastName;
	}
	public String getContactPhoneNum() {
		return contactPhoneNum;
	}
	public String getContactAddress() {
		return contactAddress;
	}

	//setters with checks included
	public void setContactFirstName (String newFirstName) {
		 if (checkParameters(newFirstName, maxLengthFirstName) == false) {
			throw new IllegalArgumentException("Invalid first name");
		}
		 contactFirstName = newFirstName;
	}
	public void setContactLastName (String newLastName) {
		if(checkParameters(newLastName, maxLengthLastName) == false) {
			throw new IllegalArgumentException("Invalid last name");
		}
		contactLastName = newLastName;
	}
	public void setContactPhoneNum (String newPhoneNum) {
		if(checkPhoneParameters(newPhoneNum) == false) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		contactPhoneNum = newPhoneNum;
	}
	
	public void setContactAddress (String newAddress) {
		if(checkParameters(newAddress, maxLengthAddress) == false) {
			throw new IllegalArgumentException("Invalid address");
		}
		contactAddress = newAddress;

	}
}
