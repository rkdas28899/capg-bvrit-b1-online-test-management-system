package com.capg.otms.questions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.otms.questions.model.Question;
import com.capg.otms.questions.service.IQuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	IQuestionService service;
	
	@PostMapping("/add")
	public Question addQuestion(@RequestBody Question question) {
		return service.addQuestion(question);
	}
	
	@GetMapping("/id/{questionId}")
	public Question getQuestion(@PathVariable long questionId) {
		return service.getQuestion(questionId);
	}
	
	
	

}
