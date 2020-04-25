package com.capg.otms.questions.service;

import java.util.List;

import com.capg.otms.questions.model.Question;

public interface IQuestionService {
	
	 Question addQuestion(Question question);
	
	 Question getQuestion(long questionId);
	 
	 List<Question> getAllQuestions();
	 
	 Question updateQuestion(Question question);
	 
	 Question deleteQuestion(long questionId);

}
