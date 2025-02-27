package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	void questionSevice() {
		long count = questionService.count();
		Question q = questionService.saveQuestion((new Question("What is the colour of Moon?" ,"red","white","blue","yellow","orange","GK")));
		assertTrue(q.getId()>0);
		assertEquals(count+1, questionService.count());
	}

}
