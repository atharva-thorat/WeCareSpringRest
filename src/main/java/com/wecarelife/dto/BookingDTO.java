package com.wecarelife.dto;

import java.time.LocalDate;

public class BookingDTO {

	Integer	booking_id; 		//Auto-generated Id of booking
	String user_id;				//User Id of User
	String coach_id	;			//Coach Id of Life Coach
	LocalDate appointment_date; //Date of appointment
	String slot;				//Time slot of appointment
	static Integer counter = 101;
	
	public BookingDTO() {}
	
	public BookingDTO(String user_id,String coach_id,LocalDate appointment_date,String slot) {
		
		this.user_id = user_id;
		this.coach_id = coach_id;
		this.appointment_date = appointment_date;
		this.slot = slot;
	}

	public Integer getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}

	public LocalDate getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(LocalDate appointment_date) {
		this.appointment_date = appointment_date;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}
}

