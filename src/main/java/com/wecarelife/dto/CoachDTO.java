package com.wecarelife.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


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
	
	public CoachDTO() {}
	
	public CoachDTO(Integer coach_id,String name,String gender,LocalDate date_of_birth,
			String password,Long mobile_number,String speciality) {
		
		this.coach_id = coach_id;
		this.name = name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.password = password;
		this.mobile_number = mobile_number;
		this.speciality = speciality;
	}

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
}

