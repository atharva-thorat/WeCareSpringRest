package com.wecarelife.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wecarelife.entity.Booking;


public interface BookRepository extends JpaRepository<Booking,Integer>{


	@Query("SELECT b FROM Booking b WHERE b.user_id=?1 AND b.appointment_date=?2")
	public List<Booking> findBookingByUserId(String userId, LocalDate today);
	
	@Query("SELECT b FROM Booking b WHERE b.coach_id=?1 AND b.appointment_date=?2")
	public List<Booking> findBookingByCoachId(String coachId, LocalDate today);
	
	@Query("SELECT b FROM Booking b WHERE b.user_id=?1 AND b.slot=?2 AND appointment_date=?3")
	public Booking findAllBookings(String user_id, String slot,LocalDate appointment_date);
}
