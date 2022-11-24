package com.wecarelife.dto;

import java.time.LocalDate;

public class AppointmentDTO {
	
	private String slot;
	private LocalDate appointmentDate;
	
	public AppointmentDTO() {}
	
	public AppointmentDTO(String slot,LocalDate appointmentDate) {
		
		this.slot = slot;
		this.appointmentDate = appointmentDate;
	}
	
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
}
