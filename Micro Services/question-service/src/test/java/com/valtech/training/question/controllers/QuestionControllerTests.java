package com.valtech.training.question.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.question.vos.QuestionVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionControllerTests {
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void addQuestions() {
		List ques=restTemplate.getForObject("http://localhost:"+port+"/api/v1/questions/", List.class);
		if(ques.size()==0){
			
			System.out.println("Adding Questions.... to db....");
			
			
			QuestionVO ques1=restTemplate.postForObject
					("http://localhost:"+port+"/api/v1/questions/", 
							new QuestionVO(0, "What is the default value of a boolean in Java?", "true", "false", "null", "undefined", "false", "Easy", "Java"),
							QuestionVO.class);
			
			QuestionVO ques2=restTemplate.postForObject
					("http://localhost:"+port+"/api/v1/questions/", 
							new QuestionVO(0, "Which of the following is a valid keyword in Java?", "abstract", "package", "enum", "goto", "abstract", "Medium", "Java"),
							QuestionVO.class);

			QuestionVO ques3=restTemplate.postForObject
					("http://localhost:"+port+"/api/v1/questions/", 
							new QuestionVO(0, "Which method is used to start a thread in Java?", "run()", "start()", "begin()", "execute()", "start()", "Medium", "Java"),
							QuestionVO.class);

			QuestionVO ques4=restTemplate.postForObject
					("http://localhost:"+port+"/api/v1/questions/", 
							new QuestionVO(0, "Which of the following is used for exception handling in Java?", "try-catch", "if-else", "for-each", "do-while", "try-catch", "Easy", "Java"),
							QuestionVO.class);

		

			
		}
		
	}

}
