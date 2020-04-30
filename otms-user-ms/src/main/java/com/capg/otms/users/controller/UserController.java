package com.capg.otms.users.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.capg.otms.users.model.Question;
import com.capg.otms.users.model.Test;
import com.capg.otms.users.model.User;
import com.capg.otms.users.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	IUserService service;
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user){
		return service.addUser(user);
	}
	
	@GetMapping("/user-id/{userId}")
	public User getUser(@PathVariable long userId) {
		return service.getUser(userId);
	}
	
	
	@PostMapping("/add/test")
	public Test addTest(@RequestBody Test test) {
		return service.addTest(test);
	}
	
	@PostMapping("/add/question/test-id/{testId}")
	public Question addQuestion(@PathVariable long testId, @RequestBody Question question) throws RestClientException, URISyntaxException
	{
		return service.addQuestions(testId, question);
	}
	@GetMapping("/message")
	public String getMessage() {
		return "Hello All";
		}
//	@GetMapping("admin/message")
//	public String getAdminMessage() {
//		return "Hello Admin";
//		}
//	@GetMapping("secure/message")
//	public String getPrivateMessage() {
//		return "Hello Users";
//		}
	}
