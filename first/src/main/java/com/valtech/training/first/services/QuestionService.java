package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.QuestionRepo;

public interface QuestionService {

	Question saveQuestion(Question question);

	Question updateQuestion(Question question);

	void deleteQuestion(Question question);

	Question getQuestion(long id);

	List<Question> getAllQuestions();

	long count();

	List<Question> findAllByTopic(String topic);

	long countByTopic(String topic);
	
	long countByTopicAndQuestionTextContaining(String topic, String keyword);

	long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyword);

}