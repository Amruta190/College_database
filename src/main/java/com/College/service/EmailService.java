package com.College.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.College.entity.User;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(User user,HttpServletRequest httpServletRequest, String subject) {
		String url=httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + "/" + user.getToken() + "/activate/account";
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(user.getEmail());
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(url);
		javaMailSender.send(simpleMailMessage);
	}
	
	public void sendMail2(User user,HttpServletRequest httpServletRequest, String subject) {
		String url=httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + "/" + user.getToken2() + "/reset/password";
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(user.getEmail());
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(url);
		javaMailSender.send(simpleMailMessage);
	}

	public void sendMail3(User userUpdated, HttpServletRequest httpServletRequest, String string) {
		String url=httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + "/" + userUpdated.getToken3() + "/change/password";
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(userUpdated.getEmail());
		simpleMailMessage.setSubject(string);
		simpleMailMessage.setText(url);
		javaMailSender.send(simpleMailMessage);
	}
}
