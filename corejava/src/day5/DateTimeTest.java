package day5;

import static org.junit.jupiter.api.Assertions.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void test() throws Exception {
		Date now = new Date();
		System.out.println(now);
		Date independenceDay = new Date(47,7,15);      // here years starts from 1900 so for 1947 it will be 47 and for 2025 it will be 125
		System.out.println(independenceDay);             //  and months starts from 0th index so august it wll be 7
		/*
		 * yyyy -> year yy
		 * MM -> numeric month MM -> alpha
		 * dd-> day
		 * Hour -> hh
		 * Minute -> mm
		 * Seconds -> ss
		 * */
		DateFormat df = new SimpleDateFormat("dd-MM-yyy");
		System.out.println(df.format(independenceDay));
		
		Date republicDay = df.parse("26-01-1950");
		System.out.println(republicDay);
	}

}
