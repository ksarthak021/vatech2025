package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Question saveQuestion(Question question) {
		System.out.println("question repo class = " + questionRepo.getClass().getName());
		return questionRepo.save(question);
		
	}
	
	@Override
	public Question updateQuestion(Question question) {
		return questionRepo.save(question);	
	}
	
	@Override
	public void deleteQuestion(Question question) {
		questionRepo.delete(question);	
	}
	
	@Override
	public Question getQuestion(long id) {
		return questionRepo.getReferenceById(id);	
	}
	
	@Override
	public List<Question> getAllQuestions() {
		return questionRepo.findAll();
	}
	
	@Override
	public long count() {
		return questionRepo.count();
	}
	

}
