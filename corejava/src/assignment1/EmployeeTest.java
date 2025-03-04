package assignment1;


import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import assignment1.Employee;

class EmployeeTest {

    @Test
    void testHashCode() {
        Employee emp1 = new Employee("Ishita", 200, 22, 1, 30000, 12, Gender.FEMALE);
        Employee emp2 = new Employee("Kishan", 100, 21, 3, 20000, 16, Gender.MALE);
        
        assertEquals(emp1.hashCode(), emp1.hashCode());
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    void testEquals() {
        Employee emp1 = new Employee("Ishita", 200, 22, 1, 30000, 12, Gender.FEMALE);
        Employee emp2 = new Employee("Kishan", 100, 22, 1, 30000, 16, Gender.MALE);
        Employee emp3 = new Employee("Ishita", 200, 22, 1, 30000, 12, Gender.FEMALE);
        
        assertFalse(emp1.equals(emp2));
        assertTrue(emp1.equals(emp3));
    }

    @Test
    void testStreamOperations() {
        List<Employee> employees = Arrays.asList(
            Employee.builder().id(1).name("Sourav").age(23).salary(50000).gender(Gender.MALE).experience(3).level(2).build(),
            Employee.builder().id(2).name("Kashvee").age(12).salary(20000).gender(Gender.FEMALE).experience(5).level(5).build(),
            Employee.builder().id(3).name("Saanvi").age(45).salary(80000).gender(Gender.FEMALE).experience(7).level(8).build(),
            Employee.builder().id(4).name("YAash").age(32).salary(90000).gender(Gender.MALE).experience(4).level(8).build(),
            Employee.builder().id(5).name("Khushi").age(45).salary(430000).gender(Gender.FEMALE).experience(2).level(2).build(),
            Employee.builder().id(6).name("Sameer").age(32).salary(23000).gender(Gender.MALE).experience(6).level(12).build()
        );
        
        assertEquals(6, employees.size());

        // Filter employees with salary > 10,000
        List<Employee> highSal = employees.stream().filter(emp -> emp.getSalary() > 10000).collect(Collectors.toList());
        assertEquals(6, highSal.size());
        
        
        List<Employee> nameFilter = employees.stream().filter(emp -> emp.getName().equalsIgnoreCase("Kashvee")).collect(Collectors.toList());
        assertEquals(1, nameFilter.size());
        
        // Employees grouped by gender
        Map<Gender, List<String>> empByGender = employees.stream()
            .collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
        assertEquals(2, empByGender.size());
        
        // Employees sorted by name
        List<Employee> sortedByName = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        assertEquals("Kashvee", sortedByName.get(0).getName());
        
        // Total salary per level
        Map<Integer, Double> salaryByLevel = employees.stream()
            .collect(Collectors.groupingBy(Employee::getLevel, Collectors.summingDouble(Employee::getSalary)));
        assertTrue(salaryByLevel.containsKey(8));
        
        // Total salary per gender
        Map<Gender, Double> salaryByGender = employees.stream()
            .collect(Collectors.groupingBy(Employee::getGender, Collectors.summingDouble(Employee::getSalary)));
        assertTrue(salaryByGender.get(Gender.FEMALE) > 0);
    }

    @Test
    void testEmptyListOperations() {
        List<Employee> employees = new ArrayList<>();
        
        // Test filtering on an empty list
        List<Employee> highSal = employees.stream().filter(emp -> emp.getSalary() > 10000).collect(Collectors.toList());
        assertEquals(0, highSal.size());
        
        // Test grouping on an empty list
        Map<Gender, List<String>> empByGender = employees.stream()
            .collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
        assertTrue(empByGender.isEmpty());
    }
}








//package assignment1;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.util.Arrays;
//
//class EmployeeTest {
//
//    @BeforeEach
//    void setup() {
//        Employee.allEmp.clear(); 
//    }
//
//    @Test
//    void testHashCodeVariations() {
//        Employee emp1 = new Employee("Kartik", 1, 25, 3, 50000, 4, Gender.MALE);
//        Employee emp2 = new Employee("Kartik", 1, 25, 3, 50000, 4, Gender.MALE);
//        Employee emp3 = new Employee("Nitin", 2, 30, 4, 60000, 6, Gender.MALE); 
//        Employee emp4 = new Employee("Ishita", 3, 28, 3, 55000, 5, Gender.FEMALE);
//
//        assertAll("HashCode Comparisons",
//            () -> assertEquals(emp1.hashCode(), emp2.hashCode(), "Equal objects must have same hashCode"),
//            () -> assertNotEquals(emp1.hashCode(), emp3.hashCode(), "Different objects should have different hashCodes"),
//            () -> assertNotEquals(emp3.hashCode(), emp4.hashCode(), "Distinct objects must have unique hashCodes")
//        );
//    }
//
//    @Test
//    void testEquality() {
//        Employee e1 = new Employee("Kartik", 7, 22, 2, 30000, 5, Gender.MALE);
//        Employee e2 = new Employee("Kartik", 7, 22, 2, 30000, 5, Gender.MALE);
//        
//        assertEquals(e1, e2);
//        e2.setName("Nitin");
//        assertNotEquals(e1, e2);
//    }
//
//    @Test
//    void testCompareToSorting() {
//        Employee e1 = new Employee("Ishita", 1, 25, 3, 50000, 4, Gender.FEMALE);
//        Employee e2 = new Employee("Sourav", 2, 28, 3, 50000, 6, Gender.MALE);
//        Employee e3 = new Employee("Debo", 3, 30, 2, 40000, 2, Gender.OTHER);
//        
//        assertTrue(e1.compareTo(e2) < 0); // e1 should be before e2
//        assertTrue(e2.compareTo(e3) > 0); // e2 should be after e3
//    }
//
//    @Test
//    void testTotalSalaryByLevel() {
//        Employee.allEmp.addAll(Arrays.asList(
//            Employee.builder().name("Ishita").gender(Gender.FEMALE).level(3).salary(50000).build(),
//            Employee.builder().name("Sourav").gender(Gender.MALE).level(3).salary(60000).build(),
//            Employee.builder().name("Chirag").level(4).salary(72000).build(),
//            Employee.builder().name("Tanvi").level(3).salary(50000).build()
//        ));
//
//        assertEquals(160000, Employee.getEmployeeByLevel(3));
//    }
//
//    @Test
//    void testTotalSalaryByGender() {
//        Employee.allEmp.addAll(Arrays.asList(
//            Employee.builder().name("Ishita").gender(Gender.FEMALE).salary(40000).build(),
//            Employee.builder().name("Sourav").gender(Gender.MALE).salary(60000).build(),
//            Employee.builder().name("Emma").gender(Gender.FEMALE).salary(52000).build(),
//            Employee.builder().name("Mason").gender(Gender.MALE).salary(60000).build()
//        ));
//        
//        assertEquals(92000, Employee.getEmployeeByGender(Gender.FEMALE));
//    }
//}
