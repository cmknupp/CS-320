// By Connie Knupp for SNHU CS-320

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.ContactService;

class ContactServiceTest {
	ContactService newContactService = new ContactService();
	
	@Test
	void testAddContact() {
		newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
			for (int i = 0; i < newContactService.contactList.size(); i++) {
				if (newContactService.contactList.get(i).getContactID() == "123456789") {
					assertTrue(newContactService.contactList.get(i).getContactID().equals("123456789"));
					assertTrue(newContactService.contactList.get(i).getContactFirstName().equals("TestFirst"));
					assertTrue(newContactService.contactList.get(i).getContactLastName().equals("TestLast"));
					assertTrue(newContactService.contactList.get(i).getContactPhoneNum().equals("5201234567"));
					assertTrue(newContactService.contactList.get(i).getContactAddress().equals("Test the Address, Tucson"));
				}
			}
	}

	@Test
	void testAddDuplicateContactIdThrowsExcep() {
		newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContactService.addContact("123456789", "DupFirst", "DupLast", "5201111111", "Duplicate, Tucson");
		});
	}
	
	@Test
	void testTwoContacts() {
		newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		newContactService.addContact("987654321", "2ndfirst", "2ndlast", "5200000007", "Testing in Tucson");
			for (int i = 0; i < newContactService.contactList.size(); i++) {
				if (newContactService.contactList.get(i).getContactID() == "123456789") {
					assertTrue(newContactService.contactList.get(i).getContactID().equals("123456789"));
					assertTrue(newContactService.contactList.get(i).getContactFirstName().equals("TestFirst"));
					assertTrue(newContactService.contactList.get(i).getContactLastName().equals("TestLast"));
					assertTrue(newContactService.contactList.get(i).getContactPhoneNum().equals("5201234567"));
					assertTrue(newContactService.contactList.get(i).getContactAddress().equals("Test the Address, Tucson"));
				}
				if (newContactService.contactList.get(i).getContactID() == "987654321") {
					assertTrue(newContactService.contactList.get(i).getContactID().equals("987654321"));
					assertTrue(newContactService.contactList.get(i).getContactFirstName().equals("2ndfirst"));
					assertTrue(newContactService.contactList.get(i).getContactLastName().equals("2ndlast"));
					assertTrue(newContactService.contactList.get(i).getContactPhoneNum().equals("5200000007"));
					assertTrue(newContactService.contactList.get(i).getContactAddress().equals("Testing in Tucson"));
				}
			}
	}	
		
	
	@Test
	void testDeleteContact() {
		newContactService.addContact("987654321", "Testfirst", "Testlast", "5200000007", "Testing in Tucson");
		newContactService.deleteContact("987654321");
		for (int i = 0; i < newContactService.contactList.size(); i++) {
			if (newContactService.contactList.get(i).getContactID() == "987654321") {
				fail("Contact still exists");
			}
		}
	}

	@Test
	void testDeleteNonexistantContact() {
		newContactService.addContact("987654321", "Testfirst", "Testlast", "5200000007", "Testing in Tucson");
		try {
				newContactService.deleteContact("987654321");
			}
		catch (Exception e) {
			fail("Threw exception with delete command");
		}
		for (int i = 0; i < newContactService.contactList.size(); i++) {
			if (newContactService.contactList.get(i).getContactID() == "987654321") {
				fail ("Contact still exists");
			}
		}
	}
	
	@Test
	void testUpdateContactFirstName() {
		newContactService.addContact("123456789", "Testfirst", "Testlast", "5200000007", "Testing in Tucson");
		newContactService.updateContactFirstName("123456789", "newFirst");
		for (int i = 0; i < newContactService.contactList.size(); i++) {
			if (newContactService.contactList.get(i).getContactID() == "123456789") {
				assertTrue(newContactService.contactList.get(i).getContactFirstName().equals("newFirst"));
			}
		}
	}

	@Test
	void testUpdateContactLastName() {
		newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		newContactService.updateContactLastName("123456789", "newLast");
		for (int i = 0; i < newContactService.contactList.size(); i++) {
			if (newContactService.contactList.get(i).getContactID() == "123456789") {
				assertTrue(newContactService.contactList.get(i).getContactLastName().equals("newLast"));
			}
		}
	}

	@Test
	void testUpdateContactPhoneNum() {
		newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		newContactService.updateContactPhoneNum("123456789", "0000000000");
		for (int i = 0; i < newContactService.contactList.size(); i++) {
			if (newContactService.contactList.get(i).getContactID() == "123456789") {
				assertTrue(newContactService.contactList.get(i).getContactPhoneNum().equals("0000000000"));
			}
		}
	}
	
	@Test
	void testUpdateContactAddress() {
		newContactService.addContact("123456789", "TestFirst", "TestLast", "5201234567", "Test the Address, Tucson");
		newContactService.updateContactAddress("123456789", "65432 Greener Pastures");
		for (int i = 0; i < newContactService.contactList.size(); i++) {
			if (newContactService.contactList.get(i).getContactID() == "123456789") {
				assertTrue(newContactService.contactList.get(i).getContactAddress().equals("65432 Greener Pastures"));
			}
		}
	}
}