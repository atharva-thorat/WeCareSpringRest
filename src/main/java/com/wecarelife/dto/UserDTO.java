package com.wecarelife.dto;

import java.time.LocalDate;

public class UserDTO {

	private Integer user_id;
	private String	name;
	private String	gender;
	private LocalDate date_of_birth;//	Date of Birth of User
	private String	password;//Password of User
	private Long mobile_number;	//Mobile Number of User
	private String	email;//Email of User
	private Integer	pincode;//PIN Code of User
	private String city;//	City of User
	private String	state;//State of User
	private String	country;//Country of User
	
	public UserDTO() {}
	
	public UserDTO(Integer user_id, String	name,String	gender,LocalDate date_of_birth,
			    String	password,Long mobile_number,String	email,
	            Integer	pincode, String city, String state, String	country ) {
		
		this.user_id = user_id;
		this.name = name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.password = password;
		this.mobile_number = mobile_number;
		this.email = email;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.country = country;
		
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
