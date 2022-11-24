package com.wecarelife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wecarelife.dto.BookingDTO;
import com.wecarelife.dto.LoginDTO;
import com.wecarelife.dto.UserDTO;
import com.wecarelife.exception.WecareException;
import com.wecarelife.service.BookingService;
import com.wecarelife.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/users")
	public ResponseEntity<Integer> createUser(@RequestBody UserDTO userDTO, Errors error) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userDTO));
		
	}
	
	/*@PostMapping("/users/{userId}/{mobile}")
	public String create(@PathVariable String userId,@PathVariable String mobile) {
		//return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userDTO));
		return userId + mobile;
		
	}*/
	
	@PostMapping("/users/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody LoginDTO loginDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(loginDTO));
		
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDTO>getUserProfile(@PathVariable("userId") Integer userId) throws WecareException {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserProfile(userId));
		
	}
	
	@GetMapping("/users/booking/{userId}")
	public ResponseEntity<List<BookingDTO>>showMyAppointments(@PathVariable("userId") String userId) {
		return ResponseEntity.status(HttpStatus.OK).body(bookingService.findBookingByUserId(userId));
	}
}
