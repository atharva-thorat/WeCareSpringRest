package com.wecarelife.dto;

import java.time.LocalDate;


public class CoachDTO {

	private Integer coach_id;

	private String name;
	
	private String gender;
	
	private LocalDate date_of_birth;
	
	private String password;

	private Long mobile_number;
	
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

