package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

	@Test
	void testDog() {
	    dog Dog = new dog();
		showBehaviour(Dog);
		
		//fail("Should fail.....");
	}

	@Test
	void testCat() {
		showBehaviour(new Cat());
	}

	@Test
	void testTiger() {
		showBehaviour(new tiger());
		
	}
	
	private void showBehaviour(Animal a) {
		a.makeSound();
		a.eat();
		a.sleep();
	}

}



