package com.wecarelife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wecarelife.dto.AppointmentDTO;
import com.wecarelife.exception.WecareException;
import com.wecarelife.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/users/{userId}/booking/{coachId}")
	public ResponseEntity<Boolean> bookAppointment(@PathVariable String userId,@PathVariable String coachId,@RequestBody AppointmentDTO appointment) throws WecareException {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.bookAppointment(userId, coachId, appointment));

	}
	
	@PutMapping("/booking/{bookingId}")
	public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable Integer bookingId, @RequestBody AppointmentDTO appointment) {
		return ResponseEntity.status(HttpStatus.OK).body(bookingService.rescheduleAppointment(bookingId, appointment));
		
	}
	
	@DeleteMapping("/booking/{bookingId}")
	public ResponseEntity<?>cancelAppointment(@PathVariable Integer bookingId) {
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK).body(bookingService.cancelAppointment(bookingId));
	}
}
