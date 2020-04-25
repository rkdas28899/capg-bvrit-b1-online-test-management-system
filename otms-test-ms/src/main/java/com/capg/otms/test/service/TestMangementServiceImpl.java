package com.capg.otms.test.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.otms.test.model.Test;
import com.capg.otms.test.repo.ITestManagementRepo;

@Service
public class TestMangementServiceImpl implements ITestManagementService {

	@Autowired
	ITestManagementRepo repo;
	
	
	@Override
	public Test addTest(Test test) {

		
		return repo.save(test);
	}

	@Override
	public Test updateTest(Test test) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Test deleteTest(long testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Test fetchTest(long testId) {
		return repo.getOne(testId);
	}

	@Override
	public List<Test> fetchAllTests() {
		// TODO Auto-generated method stub
		return null;
	}

}
