package com.College.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.College.entity.User;
import com.College.repo.UserRepo;

@Controller
public class CollegeUIController {

	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public String getLogin() {
		return "index";
	}

	@GetMapping("/logout")
	public String getLogout() {
		return "index";
	}
	
//	@GetMapping("/login")
//	public ModelAndView login() {
//		ModelAndView mav = new ModelAndView("login");
//		mav.addObject("user", new User());
//		return mav;
//	}
	
//	@GetMapping("/login")
//	public String getMain() {
//		return "main";
//	}
	
	@GetMapping("/home")
	public String getMain1() {
		return "home";
	}
	
	@GetMapping("/forget")
	public String getforget() {
		return "forget";
	}
	
	@GetMapping("/signup")
	public String getSignupPage() {
		return "signup";
	}
	
	@GetMapping("/success")
	public String getSuccess() {
		return "signupCompletion";
	}
	
	@GetMapping("/{token}/activate/account")
	public String getSuccessPage(@PathVariable("token") String token) {
		Optional<User> user=userRepo.findByToken(token);
		if(user.isPresent()) {
			User user1=user.get();
			user1.setIsActive(true);
			user1.setToken(null);
			userRepo.save(user1);
			return "success";
		}
		return "notFound";
	}
	
	@GetMapping("/signupCompletion")
	public String saveUserInfo() {
		return "signupCompletion" ;
	}
	
	@GetMapping("/changePassword")
	public String getReset1() {
		return "reset";
	}
	
	@GetMapping("/{token2}/reset/password")
	public String getResetPage(@PathVariable("token2") String token2) {
		Optional<User> user=userRepo.findByToken2(token2);
		if(user.isPresent()) {
			User user1=user.get();
			user1.setIsActive(true);
			user1.setToken2(null);
			userRepo.save(user1);
			return "changePassword";
		}
		return "notFound";
	}
	
	@GetMapping("/resetPasswordMail")
	public String getResetMail() {
		return "resetPasswordMail";
	}
	
	@GetMapping("/reset")
	public String getReset() {
		return "reset";
	}
	
	@GetMapping("/{token3}/change/password")
	public String getPasswordChangePage(@PathVariable("token3") String token3) {
		Optional<User> user=userRepo.findByToken3(token3);
		if(user.isPresent()) {
			User user1=user.get();
			user1.setIsActive(true);
			user1.setToken3(null);
			userRepo.save(user1);
			return "updatedPasswordSuccess";
		}
		return "notFound";
	}
	
	@GetMapping("/updatedPassword")
	public String getupdatedMail() {
		return "updatedPassword";
	}
	
	@GetMapping("/updatedPasswordSuccess")
	public String getSuccessMail() {
		return "updatedPassword";
	}
}
