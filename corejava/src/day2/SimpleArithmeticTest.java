package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleArithmeticTest {
	
	private Arithmetic ari = new SimpleArithmetic();

	@Test
	void testAdd() {
		
		
	}
	
	@Test
	void testSub() {
	
	}
	
	@Test
	void testMulti() {
		
	}
	
	@Test
	void testDivWithInt() {
		assertEquals(2,ari.div(4, 2));
		assertEquals(3,ari.div(7, 2));
	}
	
	@Test
	void testDivWithDouble() {
		//5./3 = 1.666666
		//expect = 1.666 +- 0.001
		assertEquals(1.6666666666, ari.div(5.,3),0.0001);
		assertEquals(Double.POSITIVE_INFINITY,ari.div(5., 0),0.0001);
		
	}
	@Test
	void testDivWithIntDenomIsZero() {
		try {
		ari.div(3, 1);	
		fail("Exception was Expected.... ecuse 3 should be divided by 0");
	}catch(Exception e) {
	}
 }

}
