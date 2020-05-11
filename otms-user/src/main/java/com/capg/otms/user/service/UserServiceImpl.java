package com.capg.otms.user.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.capg.otms.user.model.Question;
import com.capg.otms.user.model.Test;
import com.capg.otms.user.model.User;
import com.capg.otms.user.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	IUserRepo repo;
	
	@Override
	public Test addTest(Test test) {
		// TODO Auto-generated method stub
		return rt.postForObject("http://otms-test-ms/test/add", test, Test.class);
	}

	@Override
	public Question addQuestions(long testId, Question question) throws RestClientException, URISyntaxException {
		// TODO Auto-generated method stub
		Question q=rt.postForObject("http://otms-question-ms/question/add", question, Question.class);
		rt.put(new URI("http://otms-test-ms/test/assign/"+testId+"/question/"+q.getQuestionId()),null);
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
		User deletedUser = repo.getOne(userId);
		repo.deleteById(userId);
		return deletedUser;
	}

	@Override
	public User updateUser(User newUser) {
		// TODO Auto-generated method stub
		User user = repo.getOne(newUser.getUserId());
		user.setUserName(newUser.getUserName());
		user.setUserPassword(newUser.getUserPassword());
		user.setUserTest(newUser.getUserTest());
		user.setAdmin(newUser.isAdmin());
		return user;
	}

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return repo.getOne(userId);
		}

	@Override
	public Test deleteTest(long testId) throws RestClientException, URISyntaxException {
		// TODO Auto-generated method stub
		Test test = rt.getForObject("http://otms-test-ms/test/id/"+testId,Test.class);
		//test = rt.postForObject("http://localhost:8020/test/delete/id/", test, Test.class);
		rt.delete(new URI("http://otms-test-ms/test/delete/id/"+testId));
		return test;
	}
	@Override
	public Test updateTest(Test test) throws RestClientException, URISyntaxException {
		// TODO Auto-generated method stub
		if(test!=null) {
			rt.put(new URI("http://otms-test-ms/test/update/"), test);
		}
		return test;
	}

	@Override
	public Question updateQuestions(long testId, Question question) {
		// TODO Auto-generated method stub
		Test test = rt.getForObject("http://otms-test-ms/test/id/"+testId,Test.class);
		if(test!=null) {
			test.setCurrentQuestion(question.getQuestionId());
		}
		return question;
	}

	@Override
	public Question deleteQuestions(long testId, Question question) throws RestClientException, URISyntaxException {
		// TODO Auto-generated method stub
		Test test = rt.getForObject("http://otms-test-ms/test/id/"+testId,Test.class);
		if(test!=null) {
			rt.delete(new URI("http://otms-question-ms/question/delete/id/"+question.getQuestionId()));
		}
		return question;
	}

	@Override
	public double getResult(Test test) {
		// TODO Auto-generated method stub
		double result = test.getTestMarksScored();
		return result;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return repo.getByUserName(userName);
		}

}
