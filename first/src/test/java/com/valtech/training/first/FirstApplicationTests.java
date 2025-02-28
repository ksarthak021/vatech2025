package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
class FirstApplicationTests {
	
	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService ;

	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200,5, 20));
	}
	
	@Test
	void questionService() {
		assertEquals(8, questionService.countByTopic("GK"));
		assertEquals(6, questionService.countByTopic("JAVA"));
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("JAVA","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("JAVA","interface"));
		
	}
	
	@BeforeEach
	void initData() {
		System.out.println("Question service class name =" +questionService.getClass().getName());
		long count = questionService.count();
		if(count!=0) return;
		Question q = questionService.saveQuestion(
			    new Question("What is the colour of Moon?", "red", "white", "blue", "yellow", "orange", "GK")
			);

			questionService.saveQuestion(
			    new Question("What is the colour of Moon?", "red", "white", "blue", "yellow", "orange", "GK")
			);

			questionService.saveQuestion(
			    new Question("What is the colour of Mars?", "red", "white", "blue", "yellow", "orange", "GK")
			);

			questionService.saveQuestion(
			    new Question("What is the colour of Sun?", "red", "white", "blue", "yellow", "orange", "GK")
			);

			questionService.saveQuestion(
			    new Question("What is the colour of Sky?", "red", "white", "blue", "yellow", "orange", "GK")
			);

			questionService.saveQuestion(
			    new Question("What is the colour of Jupiter?", "red", "white", "blue", "yellow", "orange", "GK")
			);

			questionService.saveQuestion(
			    new Question("What is the colour of Saturn?", "red", "white", "blue", "yellow", "orange", "GK")
			);

			questionService.saveQuestion(
			    new Question("What is the colour of Venus?", "red", "white", "blue", "yellow", "orange", "GK")
			);
			
			//java question
			
			questionService
			.saveQuestion(new Question("What is the super class of Exception?", "Object", "Exception", "Throwable", "Error", "Throwable", "JAVA"));
	 
			questionService
			.saveQuestion(new Question("What class is used to create Dynamic String?", "String", "DynamicString", "Builder", "StringBuilder", "StringBuilder", "JAVA"));
	 
			questionService
			.saveQuestion(new Question("How many method are in marker Interface?", "One", "Two", "Zero", "Many", "Zero", "JAVA"));
	 
			questionService
			.saveQuestion(new Question("How many method are in Functional Interface?", "One", "Two", "Zero", "Many", "One", "JAVA"));
	 
			questionService
			.saveQuestion(new Question("Can an Interface have private method?", "Yes", "No", "Both", "none", "Yes", "JAVA"));
	 
			questionService
			.saveQuestion(new Question("Which subclass of Exception is not checked by the complier?", "Exception", "Error", "Runtime", "Compiletime", "Runtime", "JAVA"));
	 
	
	}

}
