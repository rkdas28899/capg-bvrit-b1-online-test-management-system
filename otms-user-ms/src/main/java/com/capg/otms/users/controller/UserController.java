package com.capg.otms.users.controller;

import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

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
	
	
	
	@PostConstruct
	public void addDummyUser() {
		User user=new User(101452641L,"ramanuj",1011102L,true,"password");
		service.addUser(user);
		User user1=new User(124513146L,"keerthi",1022112L,false,"abcd");
		service.addUser(user1);
	}
	
	@PostMapping("/p/add")
	public User addUser(@RequestBody User user){
		return service.addUser(user);
	}
	
	@GetMapping("/p/user-id/{userId}")
	public User getUser(@PathVariable long userId) {
		return service.getUser(userId);
	}
	
	
	@PostMapping("/a/add/test")
	public Test addTest(@RequestBody Test test) {
		return service.addTest(test);
	}
	
	@PostMapping("/a/add/question/test-id/{testId}")
	public Question addQuestion(@PathVariable long testId, @RequestBody Question question) throws RestClientException, URISyntaxException
	{
		return service.addQuestions(testId, question);
	}
	@GetMapping("/a/message")
	public String getMessage() {
		return "Hello Admin";
		}
	
	@GetMapping("/p/user-name/{userName}")
	public User getUserByName(@PathVariable String userName) {
		return service.getUserByName(userName);
	}
	
	
	
	@GetMapping("/u/message")
	public String getPrivateMessage() {
		return "Hello Users";
		}
	
	
	
	}
