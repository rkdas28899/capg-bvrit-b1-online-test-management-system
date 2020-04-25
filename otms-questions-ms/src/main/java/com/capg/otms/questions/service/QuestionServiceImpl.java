package com.capg.otms.questions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.otms.questions.model.Question;
import com.capg.otms.questions.repository.IQuestionRepo;
@Service
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	IQuestionRepo repo;
	
	@Override
	public Question addQuestion(Question question) {
		return repo.save(question);
	}

	@Override
	public Question getQuestion(long questionId) {
		// TODO Auto-generated method stub
		return repo.getOne(questionId);
	}

	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question deleteQuestion(long questionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
