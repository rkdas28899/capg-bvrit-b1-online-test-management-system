package com.capg.otms.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.otms.question.model.Question;
import com.capg.otms.question.service.QuestionServiceImpl;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Question>> getAllQuestions(){
		List<Question> allQuestions=service.getListOfQuestions();
		return new ResponseEntity<List<Question>>(allQuestions,HttpStatus.OK);
	}
	
	@GetMapping("/id/{questionId}")	
	public ResponseEntity<Question> getQuestionById(@PathVariable long questionId){
		Question question= service.getQuestionById(questionId);
		return new ResponseEntity<Question>(question,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		service.addQuestion(question);
		return new ResponseEntity<Question>(question,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		Question newQuestion=service.updateQuestion(question);
		return new ResponseEntity<Question>(question,HttpStatus.OK);	
	}
		
	@DeleteMapping("/id/{questionId}")
	public ResponseEntity<Question> deleteQuestion(@PathVariable long questionId) {
		Question deleted = service.deleteQuestion(questionId);
		if(deleted.getQuestionId()==questionId)
			return new ResponseEntity<Question>(HttpStatus.OK);
		return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
		
	}

}
