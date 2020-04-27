package com.capg.otms.updateanddeletetest.service;

import java.util.List;

import com.capg.otms.updateanddeletetest.model.Test;



public interface TestServiceImp {
	
		
		public Test addtest(Test test);
		public Test updateTest(Test test);
		public Test deleteTest(long testId);
		
		public List<Test> fetchAllTests();

	}


