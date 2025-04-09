package com.valtech.training.question.services;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valtech.training.question.entities.Question;
import com.valtech.training.question.entities.QuestionWrapper;
import com.valtech.training.question.entities.Response;
import com.valtech.training.question.vos.QuestionVO;

@SpringBootApplication
public interface QuestionService {
	List<QuestionVO> getAllQuestion();
	
	QuestionVO getQuestion(long id);
	
	QuestionVO saveQuestion(QuestionVO q);
	
	QuestionVO updateQuestion(QuestionVO q,long id );

	List<QuestionVO> getQuestionsByTopic(String topic);

	List<Long> getQuestionsForQuiz(String topicName, Long numQuestions);

	List<QuestionWrapper> getQuestionsFromId(List<Long> questionIds);


	int getScore(List<Response> responses);
}
