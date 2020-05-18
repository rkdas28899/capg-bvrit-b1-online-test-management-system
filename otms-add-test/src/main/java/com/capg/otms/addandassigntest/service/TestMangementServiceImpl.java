
/*************************************************************************
 -Author                : Jagadish Reddy


 -Created/Modified Date : 28/04/2020
 -Description           : TestMangementServiceImpl implements services for ITestManagementService
 						  for Online Test Management System
***************************************************************************/
package com.capg.otms.addandassigntest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.capg.otms.addandassigntest.model.User;
import com.capg.otms.addandassigntest.exceptions.TestNotFoundException;
import com.capg.otms.addandassigntest.model.Question;
import com.capg.otms.addandassigntest.model.Test;
import com.capg.otms.addandassigntest.repository.ITestManagementRepo;

@Service
public class TestMangementServiceImpl implements ITestManagementService {

	@Autowired
	ITestManagementRepo repo;
	
	@Autowired
	RestTemplate rt;
	
	
	
	
	
	@Override
	public List<Test> getAllTests() {
	

		return repo.findAll();
	}
	/*************************************************************************
	 -FunctionName          : getTest
	 -Input Parameters      : long testId
	 -Return Type           : Test
	 -Throws				: TestNotFoundException
	 -Author				: Jagadish Reddy
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	@Override
	public Test getTest(long testId) {
		if(!repo.existsById(testId)) {
			throw new TestNotFoundException("Test with id : ["+testId+"] Not Found"); 
		}
		
		return repo.getOne(testId);
	}
	/*************************************************************************
	 -FunctionName          : addTest
	 -Input Parameters      : Test test
	 -Return Type           : Test
	 -Throws				: RuntimeException
	 -Author				: Jagadish Reddy
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	
	@Transactional
	public Test addTest(Test test) {
		
		if(repo.existsById(test.getTestId())) {
			throw new RuntimeException("Test Already Exists");
		}
		return repo.save(test);
	}
	

	

	
	/*************************************************************************
	 -FunctionName          : assignTest
	 -Input Parameters      : long testId
	 -Return Type           : boolean
	 -Author				: Jagadish Reddy
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	@Override
	public boolean assignTest(long testId) {
		boolean assignedTest = repo.existsById(testId);
		if(assignedTest) {
//			Test test = repo.getOne(testId);
//			if(user.isAdmin()==false) {
//			user.setUserTest(test);
			return true;
		}
		return false;
	}
	
	/*************************************************************************
	 -FunctionName          : deleteTest
	 -Input Parameters      : long testId
	 -Return Type           : Test
	 -Author				: Jagadish Reddy
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	
	@Override
	@Transactional
	public Test deleteTest(long testId) {
		Test deletedTest=repo.getOne(testId);
		//User user=getTest(testId);
		 //return repo.deleteTest(test);
		repo.deleteById(testId);
		return deletedTest;
	}
	/*************************************************************************
	 -FunctionName          : calculateTotalMarks
	 -Input Parameters      : Test test
	 -Return Type           : double
	 -Author				: Jagadish Reddy
	 -Creation Date			: 28/04/2020
	***************************************************************************/
	
	@Override
	public List<Question> getTestQuestions(long testId) {
		// TODO Auto-generated method stub
		Test test = repo.getOne(testId);
		List<Long> qIds = new ArrayList(test.getTestQuestions());
		List<Question> questions = new ArrayList<>();
		for(int i=0; i<qIds.size();i++) {
			Question q = rt.getForObject("http://localhost:8811/question/id/"+qIds.get(i), Question.class);
			questions.add(q);
			//score = score + q.getMarksScored();
		}
		return questions;
	}
	
	@Override
	public double calculateTotalMarks(Test test) {
		double score = 0;
		List<Long> qIds = new ArrayList(test.getTestQuestions());
		for(int i=0; i<qIds.size(); i++) {
			Question q = rt.getForObject("http://localhost:8811/question/id/"+qIds.get(i), Question.class);
			score = score+q.getMarksScored();
		}
		return score;
	}
	
}

