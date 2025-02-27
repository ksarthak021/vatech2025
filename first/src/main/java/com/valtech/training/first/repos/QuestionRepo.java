package com.valtech.training.first.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.first.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

	

	//Question save(QuestionRepo question);

}
