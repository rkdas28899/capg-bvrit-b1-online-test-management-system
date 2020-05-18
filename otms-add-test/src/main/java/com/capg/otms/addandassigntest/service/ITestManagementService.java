package com.capg.otms.addandassigntest.service;

import java.util.List;

import com.capg.otms.addandassigntest.model.Question;
import com.capg.otms.addandassigntest.model.Test;

public interface ITestManagementService {
	
	public Test addTest(Test test);
	public Test getTest(long testId);
	public List<Test> getAllTests();
	public Test deleteTest(long testId);
	public boolean assignTest(long testId);
	public List<Question> getTestQuestions(long testId);
	public double calculateTotalMarks(Test test);
}
