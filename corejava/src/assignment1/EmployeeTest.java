package assignment1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class EmployeeTest {

    @BeforeEach
    void setup() {
        Employee.allEmp.clear(); 
    }

    @Test
    void testHashCodeVariations() {
        Employee emp1 = new Employee("Kartik", 1, 25, 3, 50000, 4, Gender.MALE);
        Employee emp2 = new Employee("Kartik", 1, 25, 3, 50000, 4, Gender.MALE);
        Employee emp3 = new Employee("Nitin", 2, 30, 4, 60000, 6, Gender.MALE); 
        Employee emp4 = new Employee("Ishita", 3, 28, 3, 55000, 5, Gender.FEMALE);

        assertAll("HashCode Comparisons",
            () -> assertEquals(emp1.hashCode(), emp2.hashCode(), "Equal objects must have same hashCode"),
            () -> assertNotEquals(emp1.hashCode(), emp3.hashCode(), "Different objects should have different hashCodes"),
            () -> assertNotEquals(emp3.hashCode(), emp4.hashCode(), "Distinct objects must have unique hashCodes")
        );
    }

    @Test
    void testEquality() {
        Employee e1 = new Employee("Kartik", 7, 22, 2, 30000, 5, Gender.MALE);
        Employee e2 = new Employee("Kartik", 7, 22, 2, 30000, 5, Gender.MALE);
        
        assertEquals(e1, e2);
        e2.setName("Nitin");
        assertNotEquals(e1, e2);
    }

    @Test
    void testCompareToSorting() {
        Employee e1 = new Employee("Ishita", 1, 25, 3, 50000, 4, Gender.FEMALE);
        Employee e2 = new Employee("Sourav", 2, 28, 3, 50000, 6, Gender.MALE);
        Employee e3 = new Employee("Debo", 3, 30, 2, 40000, 2, Gender.OTHER);
        
        assertTrue(e1.compareTo(e2) < 0); // e1 should be before e2
        assertTrue(e2.compareTo(e3) > 0); // e2 should be after e3
    }

    @Test
    void testTotalSalaryByLevel() {
        Employee.allEmp.addAll(Arrays.asList(
            Employee.builder().name("Ishita").gender(Gender.FEMALE).level(3).salary(50000).build(),
            Employee.builder().name("Sourav").gender(Gender.MALE).level(3).salary(60000).build(),
            Employee.builder().name("Chirag").level(4).salary(72000).build(),
            Employee.builder().name("Tanvi").level(3).salary(50000).build()
        ));

        assertEquals(160000, Employee.getEmployeeByLevel(3));
    }

    @Test
    void testTotalSalaryByGender() {
        Employee.allEmp.addAll(Arrays.asList(
            Employee.builder().name("Ishita").gender(Gender.FEMALE).salary(40000).build(),
            Employee.builder().name("Sourav").gender(Gender.MALE).salary(60000).build(),
            Employee.builder().name("Emma").gender(Gender.FEMALE).salary(52000).build(),
            Employee.builder().name("Mason").gender(Gender.MALE).salary(60000).build()
        ));
        
        assertEquals(92000, Employee.getEmployeeByGender(Gender.FEMALE));
    }
}
