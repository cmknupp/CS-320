// By Connie Knupp for SNHU CS-320

package appointmentService;

import java.util.ArrayList;
import java.time.*;

public class AppointmentService {
	
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		
		//add Appointment
		public void addAppointment(String newAppointmentID, LocalDateTime newAppointmentDate, String newAppointmentDescription) {
			Appointment appointmentToAdd = new Appointment(newAppointmentID, newAppointmentDate, newAppointmentDescription);
			for (int i = 0; i < appointmentList.size(); i++) {
				if (appointmentList.get(i).getAppointmentId() == newAppointmentID){
					throw new IllegalArgumentException("Appointment ID already exists!");
				}
			}
			appointmentList.add(appointmentToAdd);
		}
	
		
		//delete Appointment
		public void deleteAppointment(String appointmentIdToDelete) {
			for (int i = 0; i < appointmentList.size(); i++) {
				if (appointmentList.get(i).getAppointmentId() == appointmentIdToDelete){
					appointmentList.remove(i);
				}
			}
		}
		
	//The following functions were not requirements for this project, please discuss if functionality is needed with customer. 
		//  Comment code out if unnecessary. 
		//update Appointment functions
		
		public void updateAppointmentDate (String appointmentIdToUpdate, LocalDateTime updatedAppointmentDate) {
			for (int i = 0; i < appointmentList.size(); i++) {
				if (appointmentList.get(i).getAppointmentId() == appointmentIdToUpdate){
					appointmentList.get(i).setAppointmentDate(updatedAppointmentDate);
				}
			}
		}
		public void updateAppointmentDescription (String appointmentIdToUpdate, String updatedAppointmentDescription) {
			for (int i = 0; i < appointmentList.size(); i++) {
				if (appointmentList.get(i).getAppointmentId() == appointmentIdToUpdate){
					appointmentList.get(i).setAppointmentDescription(updatedAppointmentDescription);
				}
			}
		}
	
		//
}
