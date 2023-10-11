package com.wecarelife.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@GenericGenerator(name = "idgen", strategy = "increment")
public class Booking {

	    @Id
		@GeneratedValue(generator = "idgen")
		private Integer	booking_id; 		//Auto-generated Id of booking
		private String user_id;				//User Id of User
		private String coach_id	;			//Coach Id of Life Coach
		private LocalDate appointment_date; //Date of appointment
		private String slot;				//Time slot of appointment
		static Integer counter = 101;

}

