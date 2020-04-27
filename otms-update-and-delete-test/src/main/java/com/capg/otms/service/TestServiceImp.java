package com.capg.otms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.otms.model.Test;

@Service
public class TestServiceimp implements TestService {
@Autowired
Test dao;


@Override
public void removeTest(int testId) {

dao.removeTest(testId);
}
@Override
public void updateTest(Test test,String testTitle);

@Override
public List<TestBean>getAllTests() {
	return dao.getAllTests();
}}
