package com.wecarelife.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wecarelife.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	public Optional<User>findById(Integer userId);
}
