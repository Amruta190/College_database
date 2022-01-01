package com.college.service;

import java.util.Optional;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.entity.User;
import com.college.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmailService emailService;
	
	public User saveUserInfo(User user, HttpServletRequest httpServletRequest) {
		Optional<User> userFound=userRepo.findByEmail(user.getEmail());
		if(userFound.isPresent()) {
			throw new RuntimeException("Email Exists");
		}
		user.setIsActive(false);
		user.setToken(UUID.randomUUID().toString());
		User userCreated=userRepo.save(user);
		emailService.sendMail(user, httpServletRequest,"Activate Account");
		return userCreated;
	}

	public User sendMail(User user, HttpServletRequest httpServletRequest) {
		User userFound = userRepo.findByEmail(user.getEmail()).orElseThrow(()->new RuntimeException("Email not Exists"));
		userFound.setToken2(UUID.randomUUID().toString());
		userFound.setIsActive(false);
		User userCreated=userRepo.save(userFound);
		emailService.sendMail2(userCreated, httpServletRequest,"Reset Password!!");
		return userCreated;
	}
	
	public User change(User user, HttpServletRequest httpServletRequest) {
		User userFound = userRepo.findByEmail(user.getEmail()).orElseThrow(()->new RuntimeException("Email not Exists"));
		userFound.setPassword(user.getPassword());
		userFound.setToken3(UUID.randomUUID().toString());
		userFound.setIsActive(false);
		User userUpdated=userRepo.save(userFound);
		emailService.sendMail3(userUpdated, httpServletRequest,"Updated Password!!");
		return userUpdated;
	}
	
	public User login(User user, HttpServletRequest httpServletRequest) {
		User userFound = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElseThrow(()->new RuntimeException("Email not Exists"));
//		userFound.setPassword(user.getPassword());
//		userFound.setToken3(UUID.randomUUID().toString());
//		userFound.setIsActive(false);
//		User userUpdated=userRepo.save(userFound);
//		emailService.sendMail3(userUpdated, httpServletRequest,"Updated Password!!");
		return userFound;
	}
	
//	public User login(User user, HttpServletRequest httpServletRequest) {
//		User userFound=userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
//		return userFound;)
//	}
//	public User login(String email, String password) {
//		User user = userRepo.findByEmailAndPassword(email,password);
//		return user;
//	}
}
