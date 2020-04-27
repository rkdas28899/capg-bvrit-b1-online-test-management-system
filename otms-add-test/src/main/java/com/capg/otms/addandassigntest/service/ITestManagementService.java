package com.capg.otms.addandassigntest.service;

import java.util.List;


import com.capg.otms.addandassigntest.model.Test;
import com.capg.otms.addandassigntest.model.User;

public interface ITestManagementService {
	
	public Test addTest(Test test);
	public Test getTest(long testId);
	public List<Test> getAllTests();
	public boolean assignTest(long testId);

}
