// By Connie Knupp for SNHU CS-320

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointmentService.AppointmentService;


class AppointmentServiceTest {

	final static DateTimeFormatter formatedDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	AppointmentService newAppointmentService = new AppointmentService();
	
	@Test
	void testAddAppointment() {
		newAppointmentService.addAppointment("123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		for (int i = 0; i < newAppointmentService.appointmentList.size(); i++) {
			if (newAppointmentService.appointmentList.get(i).getAppointmentId() == "123456789") {
				assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentId().equals("123456789"));
				assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentDate().format(formatedDateTime).equals("2024-11-15 09:30"));
				assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentDescription().equals("test appointment description"));
			}
		}
	}

	@Test
	void testAddDuplicateAppointmentId() {
		newAppointmentService.addAppointment("123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointmentService.addAppointment("123456789", LocalDateTime.of(2025, Month.DECEMBER, 15, 9, 30, 0), "dup test appointment description");
		});
	}
	
	@Test
	void testTwoAppointments() {
		newAppointmentService.addAppointment("123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		newAppointmentService.addAppointment("987654321", LocalDateTime.of(2025, Month.JANUARY, 6, 12, 0, 0), "test 2nd appt description");
			for (int i = 0; i < newAppointmentService.appointmentList.size(); i++) {
				if (newAppointmentService.appointmentList.get(i).getAppointmentId() == "123456789") {
					assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentId().equals("123456789"));
					assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentDate().format(formatedDateTime).equals("2024-11-15 09:30"));
					assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentDescription().equals("test appointment description"));
				}
				if (newAppointmentService.appointmentList.get(i).getAppointmentId() == "987654321") {
					assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentId().equals("987654321"));
					assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentDate().format(formatedDateTime).equals("2025-01-06 12:00"));
					assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentDescription().equals("test 2nd appt description"));
				}
			}
	}

	@Test
	void testDeleteAppointment() {
		newAppointmentService.addAppointment("123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		newAppointmentService.deleteAppointment("123456789");
		for (int i = 0; i < newAppointmentService.appointmentList.size(); i++) {
			if (newAppointmentService.appointmentList.get(i).getAppointmentId() == "123456789") {
				fail("Appointment still exists");
			}
		}
	}
	
	@Test
	void testDeleteNonexistantAppointment() {
		newAppointmentService.addAppointment("123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		try {
				newAppointmentService.deleteAppointment("123123123");
			}
		catch (Exception e) {
			fail("Threw exception with delete command");
		}
		for (int i = 0; i < newAppointmentService.appointmentList.size(); i++) {
			if (newAppointmentService.appointmentList.get(i).getAppointmentId() == "123123123") {
				fail("Appointment still exists");
			}
		}
	}

	//The following tests optional functions, please comment out if the customer does not want them included. 
	@Test
	void testUpdateAppointmentDate() {
		newAppointmentService.addAppointment("123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		newAppointmentService.updateAppointmentDate("123456789", LocalDateTime.of(2025, Month.FEBRUARY, 6, 12, 0, 0));
		for (int i = 0; i < newAppointmentService.appointmentList.size(); i++) {
			if (newAppointmentService.appointmentList.get(i).getAppointmentId() == "123456789") {
				assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentDate().format(formatedDateTime).equals("2025-02-06 12:00"));
			}
		}
	}

	@Test
	void testUpdateAppointmentDateNull() {
		newAppointmentService.addAppointment("98654321", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointmentService.updateAppointmentDate("98654321", null);
		});
	}
	
	@Test
	void testUpdateAppointmentDatePastDate() {
		newAppointmentService.addAppointment("97654321", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointmentService.updateAppointmentDate("97654321", LocalDateTime.of(2022, Month.JULY, 15, 9, 30, 0));
		});
	}
	
	@Test
	void testUpdateAppointmentDescription() {
		newAppointmentService.addAppointment("23456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		newAppointmentService.updateAppointmentDescription ("23456789", "new description for appointment");
		for (int i = 0; i < newAppointmentService.appointmentList.size(); i++) {
			if (newAppointmentService.appointmentList.get(i).getAppointmentId() == "23456789") {
				assertTrue(newAppointmentService.appointmentList.get(i).getAppointmentDescription().equals("new description for appointment"));
			}
		}
	}
	
	@Test
	void testUpdateAppointmentDescriptionNull() {
		newAppointmentService.addAppointment("987654321", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointmentService.updateAppointmentDescription("987654321", null);
		});
	}
	
	@Test
	void testUpdateAppointmentDescriptionTooLong() {
		newAppointmentService.addAppointment("0123456789", LocalDateTime.of(2024, Month.NOVEMBER, 15, 9, 30, 0), "test appointment description");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newAppointmentService.updateAppointmentDescription("0123456789", "test appointment description that is way too long to pass this test");
		});
	}
}