package com.capg.otms.updateanddeletetest.controller;



import java.time.LocalDateTime;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.otms.updateanddeletetest.model.Test;
import com.capg.otms.updateanddeletetest.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	 TestService service;
	
	@PostConstruct
	public void init() {
	Set<Long> questions=new HashSet<>();
	questions.addAll(Arrays.asList(501L,304L,521L));
	Test test=new Test(107L, "spring Test", LocalTime.of(1, 30),questions , 100, 0, 1L, LocalDateTime.of(2020, 05,2, 14, 0), LocalDateTime.of(2020, 05,2, 15, 30));
	service.addtest(test);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Test>> getAllTests(){
	List<Test> allTests=service.fetchAllTests();	
	return new ResponseEntity<List<Test>>(allTests,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Test> addTest(@RequestBody Test test){
		service.addtest(test);
		return new ResponseEntity<Test>(test,HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Test> updateTest(@RequestBody Test test){
		Test newTest=service.updateTest(test);
		return new ResponseEntity<Test>(test,HttpStatus.OK);
	}

	@PutMapping("/assign/{testId}")
	public ResponseEntity assignTest(@PathVariable long testId){
		boolean status = service.assignTest(testId);
		if(status) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/id/{testId}")
	public ResponseEntity<Test> deleteTest(@PathVariable long testId){
	Test deleted = service.deleteTest(testId);
	if(deleted.getTestId()==testId)
		return new ResponseEntity<Test>(HttpStatus.OK);
	  return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
	
	}
		
	
}




