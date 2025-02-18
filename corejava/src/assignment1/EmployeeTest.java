package assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
    void testHashCode() {
        Employee employee = new Employee("Kartik", 7, 22, 2, 30000, 5, Gender.Male);
        int hash = employee.hashCode();
        System.out.println(employee + " " + employee.hashCode());
        assertEquals(hash, employee.hashCode());
        assertEquals(hash, new Employee("Kartik", 7, 22, 2, 30000, 5, Gender.Male).hashCode());

        employee.setName("Nitin");
        System.out.println(employee + " " + employee.hashCode());
        assertNotEquals(hash, employee.hashCode());
    }

    @Test
    void testEquals() {
        Employee e1 = new Employee("Kartik", 7, 22, 2, 30000, 5, Gender.Male);
        Employee e2 = new Employee("Kartik", 7, 22, 2, 30000, 5, Gender.Male);
        assertEquals(e1, e2);

        e2.setName("Nitin");
        assertNotEquals(e1, e2);
    }

    @Test
    void testCompareTo() {
        Employee e1 = new Employee("Ishita", 1, 25, 3, 50000, 4, Gender.Female);
        Employee e2 = new Employee("Sourav", 2, 28, 3, 50000, 6, Gender.Male);
        Employee e3 = new Employee("Debo", 3, 30, 2, 40000, 2, Gender.Other);

        assertTrue(e1.compareTo(e2) < 0); // Compare by experience
        assertTrue(e2.compareTo(e3) > 0); // Compare by level
    }

    @Test
    void testEmployeeByLevel() {
        Employee e1 = Employee.builder().name("Ishita").level(3).salary(50000).build();
        Employee e2 = Employee.builder().name("Sourav").level(3).salary(60000).build();
        Employee.allEmp.add(e1);
        Employee.allEmp.add(e2);

        double totalSalary = Employee.getEmployeeByLevel(3);
        assertEquals(110000, totalSalary);
    }

    @Test
    void testEmployeeByGender() {
        Employee e1 = Employee.builder().name("Ishita").gender(Gender.Female).salary(40000).build();
        Employee e2 = Employee.builder().name("Sourav").gender(Gender.Male).salary(60000).build();
        Employee.allEmp.add(e1);
        Employee.allEmp.add(e2);

        double femaleSalary = Employee.getEmployeeByGender(Gender.Female);
        assertEquals(40000, femaleSalary);
    }
}