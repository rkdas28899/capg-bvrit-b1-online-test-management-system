package com.capg.otms.users.service;

import java.net.URISyntaxException;

import org.springframework.web.client.RestClientException;

import com.capg.otms.users.model.Question;
import com.capg.otms.users.model.Test;
import com.capg.otms.users.model.User;

public interface IUserService {

	Test addTest(Test test);
	Question addQuestions(long testId,Question question) throws RestClientException, URISyntaxException;
	boolean assignTest(long userId,long testId);
	
	
	User addUser(User user);
	User deleteUser(long userId);
	User updateUser(User user);
	User getUser(long userId);
	User getUserByName(String userName);
}
