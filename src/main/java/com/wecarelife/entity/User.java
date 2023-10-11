package com.wecarelife.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

	@Id
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

}

