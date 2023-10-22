package com.wecarelife.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachDTO {

	private Integer coach_id;

	@NotNull(message="Name should not be null")
	@Size(min = 3, max = 50, message 
    = "Name must be between 3 and 50 characters")
	private String name;
	
	private String gender;
	
	private LocalDate date_of_birth;
	
	@NotNull(message="Password should not be null")
	@Size(min = 5, max = 10, message 
    = "Password must be between 5 and 10 characters")
	private String password;

	@NotNull(message="Mobile Number should not be null")
	@Size(min = 10, max = 10, message 
    = "Mobile Number should be 10 digits ")
	private Long mobile_number;
	
	
	@NotNull(message="Speciality should not be null")
	@Size(min = 3, max = 50, message 
    = "Speciality must be between 3 and 50 characters")
	private String speciality;

}

