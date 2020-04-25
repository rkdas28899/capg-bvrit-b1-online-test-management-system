package com.capg.otms.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.otms.questions.model.Question;

public interface IQuestionRepo extends JpaRepository<Question, Long> {

}
