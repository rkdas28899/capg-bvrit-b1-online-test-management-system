package com.capg.otms.test.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.otms.test.model.Test;
import com.capg.otms.test.service.ITestManagementService;
@RestController
@RequestMapping("/test")
public class TestManagementController {

	@Autowired
	ITestManagementService service;
	
	@PostConstruct
	public void init() {
	Set<Long> questions=new HashSet<>();
	questions.addAll(Arrays.asList(501L,304L,521L));
	Test test=new Test(101L, "Java Test", LocalTime.of(1, 30),questions , 100, 0, 1L, LocalDateTime.of(2020, 05,2, 14, 0), LocalDateTime.of(2020, 05,2, 15, 30));
	service.addTest(test);
	}
	
	
	@PostMapping("/add")
	public Test addTest(@RequestBody Test test) {
		return service.addTest(test);
		}
	
	@GetMapping("/test-id/{testId}")
	public Test getTestData(@PathVariable long testId) {
		return service.fetchTest(testId);
	}
	
	@PutMapping("/assign/{testId}/question/{questionId}")
	public Test assignQuestion(@PathVariable long testId, @PathVariable long questionId) {
		
		Test test=service.fetchTest(testId);
		if(test!=null) {
		test.getTestQuestions().add(questionId);
		return service.updateTest(test);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
}
