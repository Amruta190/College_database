package com.College.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.College.entity.User;
import com.College.service.UserService;


@RestController
public class CollegeDataController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/saveUserInfo")
	public ResponseEntity<User> saveUserInfo(@RequestBody User user, HttpServletRequest httpServletRequest) {
		return new ResponseEntity<User>(userService.saveUserInfo(user, httpServletRequest), HttpStatus.CREATED);
	}
	
	@PostMapping("/sendMail")
	public ResponseEntity<User> sendMail(@RequestBody User user, HttpServletRequest httpServletRequest) {
		return new ResponseEntity<User>(userService.sendMail(user, httpServletRequest), HttpStatus.OK);
	}
	
	@PostMapping("/change")
	public ResponseEntity<User> change(@RequestBody User user,HttpServletRequest httpServletRequest) {
		return new ResponseEntity<User>(userService.change(user, httpServletRequest), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user,HttpServletRequest httpServletRequest) {
		return new ResponseEntity<User>(userService.login(user, httpServletRequest), HttpStatus.OK);
	}
	
//	@PostMapping("/login")
//	public String login(@ModelAttribute("user") User user) {
//		User oauthUser = userService.login(user.getEmail(), user.getPassword());
//		if(Objects.nonNull(oauthUser))
//		{
//			return "redirect:/";
//			return "/";
//		}
//		else {
//			return "redirect:/login";
//			return "/login";
//		}
//	}

//	@RequestMapping(value= {"/logout"}, method=RequestMethod.POST)
//	public String logoutDo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
//	{
//		return "redirect:/main";
//		return "/login";
//		window.location.assign(location.origin + "/login")
//	}

}
