/*************************************************************************
 -Author                : Jagadish Reddy
 -Created/Modified Date : 28/04/2020
 -Description           : Controller for Adding and Assign the tests
***************************************************************************/
package com.capg.otms.addandassigntest.controller;

import java.time.LocalDateTime
;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.otms.addandassigntest.model.Question;
import com.capg.otms.addandassigntest.model.Test;
import com.capg.otms.addandassigntest.service.ITestManagementService;
@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:4200")
public class TestManagementController {

	@Autowired
	ITestManagementService service;
	
	@PostConstruct
	public void init() {
	Set<Long> questions=new HashSet<>();
	questions.addAll(Arrays.asList(208L,209L,210L));
	Test test=new Test(6016L, "Java Test", LocalTime.of(1, 30),questions , 100, 0, 1L, LocalDateTime.of(2020, 05,2, 14, 0), LocalDateTime.of(2020, 05,2, 15, 30));
	service.addTest(test);
	}
	

	@GetMapping("/all")
	public ResponseEntity<List<Test>> getAllTest(){
		List<Test> allTests=service.getAllTests();
		
		return new ResponseEntity<List<Test>>(allTests,HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Test> addTest(@RequestBody Test test) {
		 service.addTest(test);
		return new ResponseEntity<Test>(test,HttpStatus.CREATED);
		}
	
	@GetMapping("/id/{testId}")
	public ResponseEntity<Test> getTestData(@PathVariable long testId) {
		Test test=service.getTest(testId);
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
	@DeleteMapping("/delete/{testId}")
	public ResponseEntity<Test> deleteTest(@PathVariable long testId){
	Test deleted = service.deleteTest(testId);
	if(deleted.getTestId()==testId)
		return new ResponseEntity<Test>(HttpStatus.OK);
	  return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
	
	}
	
	@GetMapping("/questions/{testId}")
	public List<Question> getTestQuestions(@PathVariable long testId){
		return service.getTestQuestions(testId);
	}
	
	@GetMapping("/calculate")
	public ResponseEntity<Double> calculateTotalMarks(@RequestBody Test test){
		double result=service.calculateTotalMarks(test);
		return new ResponseEntity<Double>(result,HttpStatus.OK);
	}

	
}
