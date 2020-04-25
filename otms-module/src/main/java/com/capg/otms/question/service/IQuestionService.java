package com.capg.otms.question.service;

import java.util.List;

import com.capg.otms.question.model.Question;

public interface IQuestionService {
	 
	 List<Question> getListOfQuestions();
	 
	 Question getQuestionById(long QuestionId);
	 
	 Question addQuestion(Question question);
	 
	 Question updateQuestion(Question question);
	 
	 Question deleteQuestion(long questionId);

}