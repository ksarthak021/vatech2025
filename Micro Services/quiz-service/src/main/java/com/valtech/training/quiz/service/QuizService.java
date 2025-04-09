package com.valtech.training.quiz.service;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valtech.training.quiz.entities.QuestionWrapper;
import com.valtech.training.quiz.entities.Response;
import com.valtech.training.quiz.vos.QuizVO;


@SpringBootApplication
public interface QuizService {
	
	QuizVO createQuiz(String topic, int numQ, String quiztitle);
	
	List<QuestionWrapper> getQuizQuestions(Long quizId);
	
	int calculateResult(Long quizId, List<Response> responses,String userName);
	
	
}
