package com.wecarelife.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.wecarelife.dto.CoachDTO;
import com.wecarelife.dto.LoginDTO;
import com.wecarelife.entity.Coach;
import com.wecarelife.exception.ExceptionConstants;
import com.wecarelife.exception.WecareException;
import com.wecarelife.repository.CoachRepository;

@Service
@PropertySource(value = "classpath:ValidateMessage.properties")
public class CoachService {

	@Autowired
	CoachRepository coachRepository;
	
	@Autowired
	private Environment environment;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public Integer createCoach(CoachDTO coachDTO) {
		
		Integer coach_id;
		Coach coach = coachRepository.saveAndFlush(modelMapper.map(coachDTO, Coach.class));
		coach_id = coach.getCoach_id();
		return coach_id;
	}
	
	public boolean loginCoach(LoginDTO loginDTO) {
		
		Optional<Coach> coachOptional = coachRepository.findById(loginDTO.getId());
		Coach coach = null;
		
		if(coachOptional.isPresent()) {
			
			coach = coachOptional.get();
			if(coach.getPassword().equals(loginDTO.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
		
		return false;
	}
	
	public CoachDTO getCoachProfile(Integer coachId) throws WecareException {
		
		Optional<Coach> coachOptional = coachRepository.findById(coachId);
		Coach coach = null;
		
		if(coachOptional.isPresent()) {
			coach = coachOptional.get();
			return modelMapper.map(coach, CoachDTO.class);
		}
		else {
			throw new WecareException(environment.getProperty(ExceptionConstants.COACH_NOT_FOUND.toString()));
		}	
	}
	
	public List<CoachDTO> showAllCoaches() {
		
		List <Coach> coachList = coachRepository.findAll();
		
		TypeToken <List<CoachDTO>> typeToken = new TypeToken<>() {};
		
		return modelMapper.map(coachList, typeToken.getType());
	}
}
