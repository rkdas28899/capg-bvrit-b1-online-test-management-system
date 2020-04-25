package com.capg.otms.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.otms.question.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{
	
}
