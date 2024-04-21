// By Connie Knupp for SNHU CS-320

package appointmentService;

import java.time.*;

public class Appointment {

	private final String appointmentId;
	private LocalDateTime appointmentDate;
	private String appointmentDescription;
	
	//variables for parameter checks
	private int maxLengthAppointmentID = 10;
	private int maxLengthAppointmentDescription = 50;
	
	//functions for parameter checks
	public boolean checkParameters(String newVariable, int maxLength) {
		if (newVariable == null || newVariable.length()>maxLength) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean checkDateParameters (LocalDateTime appointmentDate) {
		if (appointmentDate == null || appointmentDate.isBefore(LocalDateTime.now())) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	//create new appointment
	public Appointment(String newAppointmentID, LocalDateTime newAppointmentDate, String newAppointmentDescription) {
		if(checkParameters(newAppointmentID, maxLengthAppointmentID) == false) {
			throw new IllegalArgumentException("Invalid appointment ID.");
		}
		if(checkDateParameters(newAppointmentDate) == false) {
			throw new IllegalArgumentException("Invalid appointment date.");
		}
		if(checkParameters(newAppointmentDescription, maxLengthAppointmentDescription) == false) {
			throw new IllegalArgumentException("Invalid appointment description.");
		}

		this.appointmentId = newAppointmentID;
		this.appointmentDate = newAppointmentDate;
		this.appointmentDescription = newAppointmentDescription;
	}
	
	
	//getters
	public String getAppointmentId() {
		return appointmentId;
	}
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	public String getAppointmentDescription() {
		return appointmentDescription;
	}


	//setters with checks included 
	/* These functions were not included in requirements document however the 
	 * functionality was implied as the document specifies only the Appointment ID was not updatable.  
	 * please verify with customer if functionality is needed.  */
	
	public void setAppointmentDate(LocalDateTime newAppointmentDate) {
		if(checkDateParameters(newAppointmentDate) == false) {
			throw new IllegalArgumentException("Invalid appointment date.");
		}
		appointmentDate = newAppointmentDate;
	}
	public void setAppointmentDescription (String newAppointmentDescription) {
		if(checkParameters(newAppointmentDescription, maxLengthAppointmentDescription) == false) {
			throw new IllegalArgumentException("Invalid appointment description.");
		}
		appointmentDescription = newAppointmentDescription;
	}
}