package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Author;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.PublisherRepo;
import com.valtech.training.first.services.AuthorService;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
//@Transactional(propagation = Propagation.REQUIRED)
class FirstApplicationTests {
	
	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService ;
	
	@Autowired
    private PublisherService publisherService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

//	@Test
//	void testArithmetic() {
//		assertEquals(10, arithmetic.add(4, 6));
//		assertEquals(200, simpleInterest.compute(200,5, 20));
//	}
//	
	@Test
	//@Rollback()
	void questionService() {
		assertEquals(8, questionService.countByTopic("GK"));
		assertEquals(6, questionService.countByTopic("JAVA"));
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("JAVA","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("JAVA","interface"));	
	}
	
	@Test
    void testPublisherService() {
//		Publisher publisher = new Publisher(1, "Penguin Books", new ArrayList<>());
//		publisherService.savePublisher(publisher);
//		
//		
//			    
//		Publisher publisher1 = new Publisher(2, "HarperCollins", new ArrayList<>());
//		publisherService.savePublisher(publisher1);
//			    
//		Publisher publisher2 = new Publisher(3, "Random House", new ArrayList<>());
//	    publisherService.savePublisher(publisher2);
//	    
//	    List<Publisher> publishers = publisherService.getAllPublishers();
//	    
//	    publisherService.countPublishers();
	    
//	    List<Publisher> Publisher = publisherService.findAll();
//		assertEquals(12, Publisher.size());
		
		assertEquals(5, bookService.getbookStoreByYearBetween(2000,2006).size());
		assertEquals(2, bookService.getbookByPriceGreaterThan(120).size());
		assertEquals(2, bookService.findAllPriceByAuthorsId(1).size());
		System.out.println(bookService.findAllPriceByAuthorsId(1));
		System.out.println(bookService.getBookInfoByAuthor(2));
		
		
		

	    
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




