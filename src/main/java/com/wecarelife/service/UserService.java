package com.wecarelife.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.wecarelife.exception.WecareException;
import com.wecarelife.exception.ExceptionConstants;
import com.wecarelife.dto.LoginDTO;
import com.wecarelife.dto.UserDTO;
import com.wecarelife.entity.User;
import com.wecarelife.repository.UserRepository;

@Service
@PropertySource("classpath:ValidateMessage.properties")
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private Environment environment;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public Integer createUser(UserDTO userDTO) {
		
		Integer user_id;
		User user = userRepository.saveAndFlush(modelMapper.map(userDTO, User.class));
		user_id = user.getUser_id();
		
		return user_id;
	}
	
	public boolean loginUser(LoginDTO loginDTO) {
		
		Optional<User> userOptional = userRepository.findById(loginDTO.getId());
		User user = null;
		
		if(userOptional.isPresent()) {
			user = userOptional.get();
			
			if(user.getPassword().equals(loginDTO.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;	
	}
	
	public UserDTO getUserProfile(Integer userId) throws WecareException {
		
		Optional<User> userOptional = userRepository.findById(userId);
		User user = null;
		
		if(userOptional.isPresent()) {
			user = userOptional.get();
			return modelMapper.map(user, UserDTO.class);
		}
		else {
			throw new WecareException(environment.getProperty(ExceptionConstants.USER_NOT_FOUND.toString()));
		}
	}
}