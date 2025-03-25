package com.valtech.training.quiz.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.valtech.training.quiz.entities.QuestionWrapper;
import com.valtech.training.quiz.entities.Response;
import com.valtech.training.quiz.service.QuizService;
import com.valtech.training.quiz.vos.QuizVO;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    
    @Autowired
    private QuizService quizService;
    
    @PostMapping("/create")
    public QuizVO createQuiz(
            @RequestParam String topic,  
            @RequestParam int numQ,
            @RequestParam String title) {
        return quizService.createQuiz(topic, numQ, title);
    }

    @PostMapping("/{quizId}/submit")
    public int calculateResult(
            @PathVariable Long quizId, 
            @RequestBody List<Response> responses, 
            @RequestParam String userName) {
        return quizService.calculateResult(quizId, responses, userName);
    }

    @GetMapping("/{quizId}/play")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Long quizId) {
        return quizService.getQuizQuestions(quizId);
    }
}
