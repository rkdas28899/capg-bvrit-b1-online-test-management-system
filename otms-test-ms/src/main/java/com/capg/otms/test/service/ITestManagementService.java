package com.capg.otms.test.service;

import java.util.List;

import com.capg.otms.test.model.Test;

public interface ITestManagementService {
	
	public Test addTest(Test test);
	public Test updateTest(Test test);
	public Test deleteTest(long testId);
	public Test fetchTest(long testId);
	public List<Test> fetchAllTests();

}
