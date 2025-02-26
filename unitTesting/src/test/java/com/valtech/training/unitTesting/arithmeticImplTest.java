package com.valtech.training.unitTesting;
import org.junit.jupiter.api.BeforeEach ;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


class arithmeticImplTest {
	
	private Arithmetic arithmetic ;
	
	@BeforeAll
	public static void asad() {
		System.out.println("Before All....");
	}
	
	@BeforeEach
	public void some() {
		System.out.println("Init ....");
		arithmetic = new arithmeticImpl() ;
	}
	
	static Stream<Arguments> addArgumentsProvider() {
		return Stream.of(Arguments.of(2,3,5),
				         Arguments.of(-2,1,-1),
				         Arguments.of(5,0,5) 
				         );
	}
	
	@ParameterizedTest(name = "Add with Method Source A = {0} B = {1} Result = {2}")
	@MethodSource(value = "addArgumentsProvider")
	void testAddWithMethodsource(int a, int b, int res) {
		assertEquals(res, arithmetic.add(a,b));
	}

	
	@ParameterizedTest(name = "Add with csv file A = {0} B = {1} Result = {2}")
	@CsvFileSource(files = "data.csv")
	void testAddWithCSVFile(int a, int b, int res) {
		assertEquals(res, arithmetic.add(a,b));
	}
	

	
	@ParameterizedTest(name = "Add with csv source A = {0} B = {1} Result = {2}")
	@CsvSource(value = {"2,3,5","-1,3,3","0,3,3","-1,-1,-2"})     // making it to fail to see which failed
	void testAddWithCSV(int a, int b, int res) {
		assertEquals(res, arithmetic.add(a,b));
	}
	
	
	@ParameterizedTest(name = "Add with multiple values")
	@ValueSource(strings = {"5,2,3","4,2,2","0,3,-3"})
	void testAddAgain(String param) {
		List<Integer>args =  Arrays.asList(param.split(",")).stream().map(it -> Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(args.get(0), arithmetic.add(args.get(2), args.get(1)));
	}

	@Test
	void testAdd() {
		System.out.println("Add ....");
		assertEquals(5, arithmetic.add(2, 3));
	}
	
	@Test
	void testSub() {
		System.out.println("Sub ....");
		assertEquals(5, arithmetic.sub(8, 3));
	}

}
