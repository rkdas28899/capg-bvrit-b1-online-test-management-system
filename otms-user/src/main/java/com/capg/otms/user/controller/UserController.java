package com.capg.otms.user.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.capg.otms.user.model.Question;
import com.capg.otms.user.model.Test;
import com.capg.otms.user.model.User;
import com.capg.otms.user.service.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService service;
	
	@PostMapping("/users/add")
	public User addUser(@RequestBody User user){
		return service.addUser(user);
	}
	
	@PutMapping("/users/update")
	public User updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
	
	@DeleteMapping("/users/delete/id/{userId}")
	public User deleteUser(@PathVariable long userId){
		return service.deleteUser(userId);
	}
	
	@GetMapping("/users/user-id/{userId}")
	public User getUser(@PathVariable long userId) {
		return service.getUser(userId);
	}
	
	@GetMapping("/users/all")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	
	@PostMapping("/add/test")
	public Test addTest(@RequestBody Test test) {
		return service.addTest(test);
	}
	
	@PutMapping("/update/test")
	public Test updateTest(@RequestBody Test test) throws RestClientException, URISyntaxException {
		return service.updateTest(test);
	}
	
	@DeleteMapping("/delete/test/id/{testId}")
	public Test deleteTest(@PathVariable long testId) throws RestClientException, URISyntaxException {
		return service.deleteTest(testId);
	}
	
	@PostMapping("/add/question/test-id/{testId}")
	public Question addQuestion(@PathVariable long testId, @RequestBody Question question) throws RestClientException, URISyntaxException
	{
		return service.addQuestions(testId, question);
	}
	
	@PutMapping("/update/question/test-id/{testId}")
	public Question updateQuestion(@PathVariable long testId, @RequestBody Question question) throws RestClientException, URISyntaxException
	{
		return service.updateQuestions(testId, question);
	}
	
	@DeleteMapping("/delete/question/test-id/{testId}")
	public Question deleteQuestion(@PathVariable long testId, @RequestBody Question question) throws RestClientException, URISyntaxException
	{
		return service.deleteQuestions(testId, question);
	}
	
	@GetMapping("user/test/result")
	public double getResult(@RequestBody Test test) {
		return service.getResult(test);
	}
	
}
