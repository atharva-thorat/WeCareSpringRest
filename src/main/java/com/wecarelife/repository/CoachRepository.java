package com.wecarelife.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wecarelife.entity.Coach;


public interface CoachRepository extends JpaRepository<Coach,Integer>{

	public Optional<Coach> findById(Integer coach_id);
}
