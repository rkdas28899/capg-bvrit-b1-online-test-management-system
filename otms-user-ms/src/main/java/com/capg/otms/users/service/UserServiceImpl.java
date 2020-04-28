package com.capg.otms.users.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.capg.otms.users.model.Question;
import com.capg.otms.users.model.Test;
import com.capg.otms.users.model.User;
import com.capg.otms.users.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	IUserRepo repo;
	
	@Override
	public Test addTest(Test test) {
		// TODO Auto-generated method stub
		return rt.postForObject("http://localhost:8020/test/add", test, Test.class);
	}

	@Override
	public Question addQuestions(long testId, Question question) throws RestClientException, URISyntaxException {
		// TODO Auto-generated method stub
		Question q=rt.postForObject("http://localhost:8030/questions/add", question, Question.class);
		rt.put(new URI("http://localhost:8020/test/assign/"+testId+"/question/"+q.getQuestionId()),null);
		return q;
	}

	@Override
	public boolean assignTest(long userId, long testId) {
		// TODO Auto-generated method stub
		User user=repo.getOne(userId);
		if(user==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		user.setUserTest(testId);
		return true;
		
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public User deleteUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return repo.getOne(userId);
		}

}
