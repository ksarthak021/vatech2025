package com.valtech.training.jaxwsclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaws.HelloWorld;

@SpringBootTest
class JaxwsclientApplicationTests {
	
	@Autowired
	private HelloWorld helloWorld;

	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello("Valtech"));
	}

}
