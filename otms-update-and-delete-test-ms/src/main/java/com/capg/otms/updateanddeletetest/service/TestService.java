package com.capg.otms.updateanddeletetest.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.otms.updateanddeletetest.exception.TestNotFoundException;
import com.capg.otms.updateanddeletetest.model.Question;
import com.capg.otms.updateanddeletetest.model.Test;
import com.capg.otms.updateanddeletetest.model.User;
import com.capg.otms.updateanddeletetest.repository.ITestJpaRepo;

@Service
public class TestService implements ITestServiceImp{

//	@Autowired
//	UserRepo repo;
	
	@Autowired(required = true)
	ITestJpaRepo testRepo;
	
	@Autowired
	RestTemplate rt;
	
	double score;
	//User user= new User(1022,"Sumani",null,false,"password");
	
	@Override
	public List<Test> fetchAllTests(){	
		return testRepo.findAll();
	}
	
	@Override
	public Test getTest(long testId) {
		
		if(!testRepo.existsById(testId)) {
			throw new TestNotFoundException("Test with id : ["+testId+"] Not Found"); 
		}
		return testRepo.getOne(testId);
	}

  @Override
 @Transactional
  public Test addtest (Test test) {
	  System.out.println(test);
	  if(testRepo.existsById(test.getTestId())) {
		 throw new RuntimeException("Test Already Exits");
	  }
	 return testRepo.save(test);
  }	
  
	@Override
	@Transactional
	public Test deleteTest(long testId) {
		Test deletedTest=testRepo.getOne(testId);
		//User user=getTest(testId);
		 //return repo.deleteTest(test);
		testRepo.deleteById(testId);
		return deletedTest;
	}
	
	@Override
	public boolean assignTest(long testId) {
		
		boolean assignedTest =testRepo.existsById(testId);
		if(assignedTest) {
			Test test = testRepo.getOne(testId);
			//if(user.isAdmin()==false) {
			//user.setUserTest(test);
			return true;
			
		}
		return false;
	}
	
	
	@Transactional
	public Test updateTest(Test newTestData) {
		Test test=testRepo.getOne(newTestData.getTestId());		
		test.setTestTitle(newTestData.getTestTitle());
		test.setTestDuration(newTestData.getTestDuration());
		test.setTestQuestions(newTestData.getTestQuestions());
		test.setTestTotalMarks(newTestData.getTestTotalMarks());
		test.setTestMarksScored(newTestData.getTestMarksScored());
		test.setCurrentQuestion(newTestData.getCurrentQuestion());
		test.setStartTime(newTestData.getStartTime());
		test.setEndTime(newTestData.getEndTime());
		testRepo.save(test);
		return test;
}
	
	@Override
	public List<Question> getTestQuestions(long testId) {
		// TODO Auto-generated method stub
		Test test = testRepo.getOne(testId);
		List<Long> qIds = new ArrayList(test.getTestQuestions());
		List<Question> questions = new ArrayList<>();
		for(int i=0; i<qIds.size();i++) {
			Question q = rt.getForObject("http://localhost:8030/question/id/"+qIds.get(i), Question.class);
			questions.add(q);
			//score = score + q.getMarksScored();
		}
		return questions;
	}

	@Override
	public double calculateTotalMarks(long testId) {
		// TODO Auto-generated method stub
		double score=0;
		Test test = testRepo.getOne(testId);
		List<Long> qIds = new ArrayList(test.getTestQuestions());
		for(int i=0; i<qIds.size();i++) {
			Question q = rt.getForObject("http://localhost:8030/question/id/"+qIds.get(i), Question.class);
			score = score + q.getMarksScored();
		}
		return score;
	}
}


