package com.valtech.training.question.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.question.entities.Question;
import com.valtech.training.question.entities.QuestionWrapper;
import com.valtech.training.question.entities.Response;
import com.valtech.training.question.repos.QuestionRepo;
import com.valtech.training.question.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	
	public List<QuestionVO> getAllQuestion(){
	       return questionRepo.findAll().stream().map(q->QuestionVO.from(q)).collect(Collectors.toList());	
	}


	@Override
	public QuestionVO getQuestion(long id) {
	    return QuestionVO.from(questionRepo.getReferenceById(id));
	}


//	@Override
//	public QuestionVO saveQuestion(QuestionVO q) {
//		Question question =q.to();
//		Question savedQuestion=questionRepo.save(question);
//		return QuestionVO.from(savedQuestion);
//	}
	
	@Override
	public QuestionVO saveQuestion(QuestionVO q) {
		Question question =q.to();
		return QuestionVO.from(questionRepo.save(question));
		//(savedQuestion);
	}


	@Override
	public QuestionVO updateQuestion(QuestionVO vo,long id) {
	     Question q=questionRepo.getReferenceById(id);
	     vo.updateTo(id, q);
	     return QuestionVO.from(q);	     
	       
	}
	
	
	@Override
	public List<QuestionVO> getQuestionsByTopic(String topic) {
	    List<Question> questions = questionRepo.findByTopic(topic);
	    return questions.stream().map(q->QuestionVO.from(q)).collect(Collectors.toList());	
	}
	
	
	@Override
	public List<Long> getQuestionsForQuiz(String topicName, Long numQuestions) {
	    return questionRepo.findRandomQuestionsByTopic(topicName, numQuestions);
	}
	
	
	@Override
	public List<QuestionWrapper> getQuestionsFromId(List<Long> questionIds) {
	    return questionRepo.findAllById(questionIds).stream()
	            .map(q -> new QuestionWrapper(
	                q.getId(),
	                q.getQuestionTitle(),
	                q.getOption1(),
	                q.getOption2(),
	                q.getOption3(),
	                q.getOption4()
	            )).collect(Collectors.toList());
	}

	
	@Override
	public int getScore(List<Response> responses) {
	    int score = 0;
	    
	    for (Response response : responses) {
	        Question question = questionRepo.findById(response.getId()).orElse(null);
	        
	        if (question != null && question.getRightAnswer().equals(response.getResponse())) {
	            score++;
	        }
	    }
	    
	    return score;
	}

	
}
