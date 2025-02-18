package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void test() {
		String s = "Hello" ;
		String s1 = "Hello" ;
		
		assertSame(s,s1);           //it check whether the objects s and s1 are same
		String s2 = new String("Hello");
		assertNotSame(s1,s2);
		
		String s3 = "Hell"+"o";       //both side of + constants are so it will give true in assert same
		assertSame(s,s3);
		
		String s4 = "o";
		String s5 = "Hell"+s4;
		assertNotSame(s3,s5);
		
		final String s6 = "o";
		String s7 = "Hell"+s6;
		assertSame(s,s7);
	}

}
