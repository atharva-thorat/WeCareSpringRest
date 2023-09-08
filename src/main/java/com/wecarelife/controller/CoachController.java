package com.wecarelife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import com.wecarelife.dto.BookingDTO;
import com.wecarelife.dto.CoachDTO;
import com.wecarelife.dto.LoginDTO;
import com.wecarelife.exception.WecareException;
import com.wecarelife.service.BookingService;
import com.wecarelife.service.CoachService;

import jakarta.validation.Valid;

@RestController
public class CoachController {

	@Autowired
	CoachService coachService;
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/coaches")
	public ResponseEntity<Integer> createCoach(@Valid @RequestBody CoachDTO coachDTO, Errors error) {
		return ResponseEntity.status(HttpStatus.OK).body(coachService.createCoach(coachDTO));
		
	}
	
	@PostMapping("/coaches/login")
	public ResponseEntity<Boolean>loginCoach(@RequestBody LoginDTO loginDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(coachService.loginCoach(loginDTO));
		
	}
	
	@GetMapping("/coaches/{coachId}")
	public ResponseEntity<CoachDTO>getCoachProfile(@PathVariable("coachId") Integer coachId) throws WecareException {
		return ResponseEntity.status(HttpStatus.OK).body(coachService.getCoachProfile(coachId));
		
	}
	
	@GetMapping("/coaches/all")
	public ResponseEntity<List<CoachDTO>>showAllCoaches() {
		return ResponseEntity.status(HttpStatus.OK).body(coachService.showAllCoaches());
		
	}
	
	@GetMapping("/coaches/booking/{coachId}")
	public ResponseEntity<List<BookingDTO>>showMySchedule(@PathVariable("coachId") String coachId) {
		return ResponseEntity.status(HttpStatus.OK).body(bookingService.findBookingByCoachId(coachId));
		
	}
}
