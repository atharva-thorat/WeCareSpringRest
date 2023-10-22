package com.wecarelife.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDTO {

	Integer	booking_id; 		//Auto-generated Id of booking
	String user_id;				//User Id of User
	String coach_id	;			//Coach Id of Life Coach
	LocalDate appointment_date; //Date of appointment
	String slot;				//Time slot of appointment
	static Integer counter = 101;

}

