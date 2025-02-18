package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	
	@Test
	void testhashcode() {
		Car car = new Car("honda","city","vx","2024",7);
		int hash = car.hashCode();
		System.out.println(car+""+car.hashCode());
		assertEquals(hash,car.hashCode());
		assertEquals(hash,new Car("honda","city","vx","2024",7).hashCode());
		
		car.setVariant("zx");
		System.out.println(car+""+car.hashCode());
		assertNotEquals(hash,car.hashCode());
		
		car.setVersion(6);
		System.out.println(car+""+car.hashCode());
		assertNotEquals(hash,car.hashCode());
		
		car.setModel("Jazz");
		System.out.println(car+""+car.hashCode());
		assertNotEquals(hash,car.hashCode());
	}

	@Test
	void testToString() {
		Car car = new Car("honda","city","vx","2024",7);
		assertEquals("honda city vx 2024 7",car.toString());
		car.setVariant("zx");
		assertEquals("honda city zx 2024 7",car.toString());
		car.setModel("city");
		assertEquals("honda city zx 2024 7",car.toString());
	}

}
