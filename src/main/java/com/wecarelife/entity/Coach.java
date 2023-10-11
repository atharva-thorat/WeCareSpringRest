package com.wecarelife.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@GenericGenerator(name = "idgen", strategy = "increment")
public class Coach {

		@Id
		@GeneratedValue(generator = "idgen")
		private Integer coach_id;
		private String name;
		private String gender;
		private LocalDate date_of_birth;
		private String password;
		private Long mobile_number;
		private String speciality;
		
}