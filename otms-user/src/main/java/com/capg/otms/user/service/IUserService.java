package com.capg.otms.user.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.client.RestClientException;

import com.capg.otms.user.model.Question;
import com.capg.otms.user.model.Test;
import com.capg.otms.user.model.User;

public interface IUserService {

	Test addTest(Test test);
	Test deleteTest(long testId) throws RestClientException, URISyntaxException;
	Test updateTest(Test test) throws RestClientException, URISyntaxException;
	Question addQuestions(long testId,Question question) throws RestClientException, URISyntaxException;
	Question updateQuestions(long testId,Question question);
	Question deleteQuestions(long testId,Question question) throws RestClientException, URISyntaxException;
	boolean assignTest(long userId,long testId);
	double getResult(Test test);
	
	
	User addUser(User user);
	User deleteUser(long userId);
	User updateUser(User user);
	User getUser(long userId);
	List<User> getAllUsers();
	
}
