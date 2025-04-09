package com.valtech.training.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.valtech.training.quiz.entities.QuestionWrapper;
import com.valtech.training.quiz.entities.Quiz;
import com.valtech.training.quiz.entities.Response;
import com.valtech.training.quiz.repos.QuizRepo;
import com.valtech.training.quiz.vos.QuizVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionClient questionClient;
    
    @Autowired
    private ResultClient resultClient;
    
   
   @Override
    public QuizVO createQuiz(String topic, int numQ, String title) {
        List<Integer> questionIds = questionClient.getQuestionsForQuiz(topic, numQ);
        
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestionIds(questionIds);
        quizRepo.save(quiz);

        return QuizVO.from(quiz);
    }

  @Override
  public List<QuestionWrapper> getQuizQuestions(Long quizId) {
    Quiz quiz = quizRepo.findById(quizId)
            .orElseThrow(() -> new RuntimeException("Quiz not found"));
    List<Integer> questionIds = quiz.getQuestionIds();
    return questionClient.getQuestionsFromId(questionIds);
}


    @Override
    public int calculateResult(Long quizId, List<Response> responses,String userName) {
       int score= questionClient.getScore(responses);
       resultClient.saveResult(quizId, userName, score);
       return score;
        
    }


	
}
