package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao = new EmployeeDAOImpl();
		//dao.save(new Employee("Priya",26,Gender.FEMALE,9200,5,1,4));
		Employee e = new Employee("DEF",26,Gender.FEMALE,9200,2,2,4);
		//dao.update(e);
		e=dao.get(1);
		assertEquals(1, e.getId());
		assertEquals("Test", e.getName());
		assertEquals(23, e.getAge());
		assertEquals(1200, e.getSalary());
		assertEquals(Gender.MALE, e.getGender());	
		assertEquals(2, e.getLevel());
		assertEquals(5, e.getExperience());
		
		//assertTrue(dao.getAll().size()>1);
		 int totalEmployees = dao.getAll().size();
		    System.out.println("Total Employees: " + totalEmployees);
		    assertTrue(totalEmployees > 1, "Employee count should be greater than 1");
		
		 dao.delete(2);
		
	}
}

