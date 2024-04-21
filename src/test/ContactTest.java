// By Connie Knupp for SNHU CS-320

package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;

class ContactTest {

	@Test
	void testContactClass() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		assertTrue(newContact.getContactID().equals("123456789"));
		assertTrue(newContact.getContactFirstName().equals("TestFirst"));
		assertTrue(newContact.getContactLastName().equals("TestLast"));
		assertTrue(newContact.getContactPhoneNum().equals("5201234567"));
		assertTrue(newContact.getContactAddress().equals("Test the Address, Tucson"));
	}

	@Test
	void testGetContactID() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		assertTrue(newContact.getContactID().equals("123456789"));
	}

	@Test
	void testGetContactFirstName() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		assertTrue(newContact.getContactFirstName().equals("TestFirst"));
	}

	@Test
	void testGetContactLastName() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		assertTrue(newContact.getContactLastName().equals("TestLast"));
	}
	
	@Test
	void testGetContactPhoneNum() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		assertTrue(newContact.getContactPhoneNum().equals("5201234567"));
	}

	@Test
	void testGetContactAddress() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		assertTrue(newContact.getContactAddress().equals("Test the Address, Tucson"));
	}

	@Test
	void testSetContactFirstName() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		newContact.setContactFirstName("New Name");
		assertTrue(newContact.getContactFirstName().equals("New Name"));
	}


	@Test
	void testSetContactLastName() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		newContact.setContactLastName("New Name");
		assertTrue(newContact.getContactLastName().equals("New Name"));
	}

	@Test
	void testSetContactPhoneNum() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		newContact.setContactPhoneNum("1234567520");
		assertTrue(newContact.getContactPhoneNum().equals("1234567520"));
	}

	@Test
	void testSetContactAddress() {
		Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		newContact.setContactAddress("123 New Address, Texas");
		assertTrue(newContact.getContactAddress().equals("123 New Address, Texas"));
	}
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789123", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		});
	}
	
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "TestFirstName", "TestLast", "5201234567", "Test the Address, Tucson");
		});
	}
	
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", null, "TestLast", "5201234567", "Test the Address, Tucson");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "TestFirst", "Test Last Name", "5201234567", "Test the Address, Tucson");
		});
	}
	
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "TestFirst", null, "5201234567", "Test the Address, Tucson");
		});
	}
	
	@Test
	void testPhoneNumTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "TestFirst", "TestLast", "5201234567123", "Test the Address, Tucson");
		});
	}
	
	@Test
	void testPhoneNumNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "TestFirst", "TestLast", null, "Test the Address, Tucson");
		});
	}
	
	@Test
	void testPhoneNumTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "TestFirst", "TestLast", "5201234", "Test the Address, Tucson");
		});
	}
	
	@Test
	void testPhoneHasNonDigit() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "TestFirst", "TestLast", "520123f567", "Test the Address, Tucson");
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address that is super long, Tucson");
		});
	}
	
	@Test
	void testAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789", "TestFirst", "TestLast", "5201234567", null);
		});
	}
	
	@Test
	void testSetFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactFirstName("Test Long First Name");
		});
	}
	
	@Test
	void testSetFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactFirstName(null);
		});
	}
	
	@Test
	void testSetLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactLastName("Test Long Last Name");
		});
	}
	
	@Test
	void testSetLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactLastName(null);
		});
	}
	
	@Test
	void testSetPhoneNumTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactPhoneNum("52012345678956");
		});
	}
	
	@Test
	void testSetPhoneNumTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactPhoneNum("520123456");
		});
	}
	
	@Test
	void testSetPhoneNumNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactPhoneNum(null);
		});
	}
	
	@Test
	void testSetPhoneNumWithNonDigit() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactPhoneNum("520123f567");
		});
	}
	
	@Test
	void testSetAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactAddress("Test the Address that is super long, Tucson");
		});
	}
	
	@Test
	void testSetAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact newContact = new Contact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			newContact.setContactAddress(null);
		});
	}
}
