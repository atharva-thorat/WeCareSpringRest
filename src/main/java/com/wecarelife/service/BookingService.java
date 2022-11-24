package com.wecarelife.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.wecarelife.dto.AppointmentDTO;
import com.wecarelife.dto.BookingDTO;
import com.wecarelife.entity.Booking;
import com.wecarelife.exception.ExceptionConstants;
import com.wecarelife.exception.WecareException;
import com.wecarelife.repository.BookRepository;

@Service
@PropertySource("classpath:ValidateMessage.properties")
public class BookingService {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	private Environment environment;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public boolean bookAppointment(String userId, String coachId,AppointmentDTO appointment ) throws WecareException {
		
		String slot = appointment.getSlot();
		LocalDate date = appointment.getAppointmentDate();
		
		Booking book = bookRepository.findAllBookings(userId, slot,date);
		
		if(book == null) {	
			Booking book1 = new Booking();
			book1.setUser_id(userId);
			book1.setCoach_id(coachId);
            book1.setAppointment_date(date);
			book1.setSlot(slot);
			bookRepository.saveAndFlush(book1);
			return true;
		}
		else {
			throw new WecareException(environment.getProperty(ExceptionConstants.BOOKING_ALREADY_EXISTS.toString()));
		}
	}
	
	public boolean rescheduleAppointment(Integer bookingId,AppointmentDTO appointment) {
		
		String slot = appointment.getSlot();
		LocalDate date = appointment.getAppointmentDate();
		
		Optional<Booking> bookf = bookRepository.findById(bookingId);
		
		Booking book = null;
		
		if( bookf.isPresent()) {
			book = bookf.get();
			book.setAppointment_date(date);
			book.setSlot(slot);
			bookRepository.saveAndFlush(book);
			return true;	
		}
		else {
			//throw new WecareException(environment.getProperty(ExceptionConstants.BOOKING_ALREADY_EXISTS.toString()));
			return false;
		}
	}
	
	public boolean cancelAppointment(Integer bookingId) {
		
        Optional<Booking> bookf = bookRepository.findById(bookingId);
		
		if(bookf.isPresent()) {
			bookRepository.deleteById(bookingId);
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<BookingDTO> findBookingByCoachId(String coachId){
		LocalDate today = LocalDate.now();
		List<Booking> bookings = bookRepository.findBookingByCoachId(coachId, today);
		
		TypeToken <List<BookingDTO>> typeToken = new TypeToken<>() {};
		return modelMapper.map(bookings, typeToken.getType());
	}
	
	public List<BookingDTO> findBookingByUserId(String userId) {
		
		LocalDate today = LocalDate.now();
		List<Booking> bookings = bookRepository.findBookingByUserId(userId,today);
		
		TypeToken <List<BookingDTO>> typeToken = new TypeToken<>() {};
		return modelMapper.map(bookings, typeToken.getType());
	}
}
