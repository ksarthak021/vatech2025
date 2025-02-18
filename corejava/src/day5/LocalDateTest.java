package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class LocalDateTest {

	
	@Test
	void testDateTime() {
		LocalDateTime independenceDay = LocalDateTime.of(1947,8,15, 9,15,10);       // date and time  it can be used for otp 
		System.out.println(independenceDay); 
	}
	
	@Test
	void test() {
		LocalDate independenceDay = LocalDate.of(1947,8,15);
		System.out.println(independenceDay);
		
		LocalDate preIndependenceDay = independenceDay.minusDays(1);
		System.out.println(preIndependenceDay); 
		
		LocalDate postIndependenceDay = independenceDay.plusDays(2);
		System.out.println(postIndependenceDay);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(dtf.format(independenceDay));
		System.out.println(LocalDate.parse("1947-08-15"));
	}

}
