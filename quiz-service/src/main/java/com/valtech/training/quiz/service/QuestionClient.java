package com.valtech.training.quiz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.valtech.training.quiz.entities.QuestionWrapper;
import com.valtech.training.quiz.entities.Response;
import java.util.List;

@Service
public class QuestionClient {

    private String QUESTION_SERVICE_URL = "http://localhost:9020/api/v1/questions";
    private RestTemplate restTemplate = new RestTemplate();

    public List<Integer> getQuestionsForQuiz(String topic, long numQuestions) {
        String url = QUESTION_SERVICE_URL + "/generate?topicName=" + topic + "&numQuestions=" + numQuestions;
        return restTemplate.getForObject(url,List.class);
    }

    public List<QuestionWrapper> getQuestionsFromId(List<Integer> questionIds) {
        String url = QUESTION_SERVICE_URL + "/getQuestions";
        return restTemplate.postForObject(url, questionIds, List.class);
    }

    public int getScore(List<Response> responses) {
        String url = QUESTION_SERVICE_URL + "/getScore";
        return restTemplate.postForObject(url, responses, Integer.class);
    }
}

