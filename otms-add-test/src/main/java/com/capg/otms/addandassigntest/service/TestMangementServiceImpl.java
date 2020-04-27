package com.capg.otms.addandassigntest.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.otms.addandassigntest.model.User;
import com.capg.otms.addandassigntest.exceptions.TestNotFoundException;
import com.capg.otms.addandassigntest.model.Test;
import com.capg.otms.addandassigntest.repository.ITestManagementRepo;

@Service
public class TestMangementServiceImpl implements ITestManagementService {

	@Autowired
	ITestManagementRepo repo;
	
	User user = new User(101l, "Jaggu", null ,false,"password");
	
	@Override
	public List<Test> getAllTests() {
	

		return repo.findAll();
	}
	@Override
	public Test getTest(long testId) {
		if(!repo.existsById(testId)) {
			throw new TestNotFoundException("Test with id : ["+testId+"] Not Found"); 
		}
		
		return repo.getOne(testId);
	}
	
	@Transactional
	public Test addTest(Test test) {
		
		return repo.save(test);
	}
	

	

	

	@Override
	public boolean assignTest(long testId) {
		// TODO Auto-generated method stub
		boolean assignedTest = repo.existsById(testId);
		if(assignedTest) {
			Test test = repo.getOne(testId);
			if(user.isAdmin()==false) {
			user.setUserTest(test);
			return true;
			}
		}
		return false;
	}
	
//	@Override
//	public User getUserStatus(long userId) {
//		if(user.getUserId()!=userId) {
//			return null;
//		}
//		return user;
//	}

}

