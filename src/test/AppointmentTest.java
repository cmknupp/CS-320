// By Connie Knupp for SNHU CS-320

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

import appointmentService.Appointment;

class AppointmentTest {
	final static DateTimeFormatter formatedDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	@Test
		void testAppointment() {
		Appointment newAppointment = new Appointment("123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		assertTrue(newAppointment.getAppointmentId().equals("123456789"));
		assertTrue(newAppointment.getAppointmentDate().format(formatedDateTime).equals("2024-11-15 09:30"));
		assertTrue(newAppointment.getAppointmentDescription().equals("test appointment description"));
	}

	@Test
	void testAppointmentIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		});
	}
	
	@Test
	void testAppointmentIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("01234567890", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		});
	}
	
	@Test
	void testAppointmentDateisNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", null, "test appointment description");
		});
	}
	
	
	@Test
	void testAppointmentDateInPast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", LocalDateTime.of(2023, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		});
	}
	
	
	@Test
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description that is way too long to pass this test");
		});
	}
	
	@Test
	void testAppointmentDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), null);
		});
	}
	
	@Test
	void testGetAppointmentId() {
		Appointment newAppointment = new Appointment ("0123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		assertTrue(newAppointment.getAppointmentId().equals("0123456789"));
	}


	@Test
	void testGetAppointmentDescription() {
		Appointment newAppointment = new Appointment ("0987654321", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		assertTrue(newAppointment.getAppointmentDescription().equals("test appointment description"));
	}
	
	
	//The following tests are for the optional functionality that will be discussed with customer.  Please comment out if those functions are going to be removed. 
	@Test
	void testSetAppointmentDate() {
		Appointment newAppointment = new Appointment ("987654321",LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		newAppointment.setAppointmentDate(LocalDateTime.of(2025, Month.MARCH, 10, 14, 45, 0));
		assertTrue(newAppointment.getAppointmentDate().format(formatedDateTime).equals("2025-03-10 14:45"));
	}
	
	@Test
	void testSetAppointmentDateisNull() {
		Appointment newAppointment = new Appointment ("987654321",LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointment.setAppointmentDate(null);
		});
	}
	
	@Test
	void testSetAppointmentDateInPast() {
		Appointment newAppointment = new Appointment ("987654321",LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointment.setAppointmentDate(LocalDateTime.of(2023, Month.MARCH, 10, 14, 45, 0));
		});
	}
	
	
	@Test
	void testSetAppointmentDescription() {
		Appointment newAppointment = new Appointment ("987654321",LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		newAppointment.setAppointmentDescription("New Appointment Description");
		assertTrue(newAppointment.getAppointmentDescription().equals("New Appointment Description"));
	}

	@Test
	void testSetDescriptionNull () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment newAppointment = new Appointment("1023456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
			newAppointment.setAppointmentDescription(null);
		});
	}
	
	@Test
	void testSetAppointmentDescriptionTooLong () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment newAppointment = new Appointment("1023456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
			newAppointment.setAppointmentDescription("test appointment description that is way too long to pass this test");
		});
	}

}