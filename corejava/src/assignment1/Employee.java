package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

enum Gender {
    MALE, FEMALE, OTHER;
}

public class Employee implements Comparable<Employee> {
    private String name;
    private int id;
    private int age;
    private int level;
    private float salary;
    private int experience;
    private Gender gender;

    public static List<Employee> allEmp = new ArrayList<>();

    public Employee() {}

    public Employee(String name, int id, int age, int level, float salary, int experience, Gender gender) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.level = level;
        this.salary = salary;
        this.experience = experience;
        this.gender = gender;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    // Methods to get employees based on criteria
    public static Map<Gender, List<Employee>> getEmployeesByGender() {
        return allEmp.stream().collect(Collectors.groupingBy(Employee::getGender));
    }

    public static double getEmployeeByLevel(int level) {
        return allEmp.stream()
                     .filter(e -> e.level == level)
                     .mapToDouble(Employee::getSalary)
                     .sum();
    }

    public static double getEmployeeByGender(Gender gender) {
        return allEmp.stream()
                     .filter(e -> e.gender == gender)
                     .mapToDouble(Employee::getSalary)
                     .sum();
    }

    public static double getEmployeeByName(String name) {
        return allEmp.stream()
                     .filter(e -> e.name.equals(name))
                     .mapToDouble(Employee::getSalary)
                     .sum();
    }

    public static double getEmployeeByGenderLevel(int level, Gender gender) {
        return allEmp.stream()
                     .filter(e -> e.gender == gender && e.level == level)
                     .mapToDouble(Employee::getSalary)
                     .sum();
    }

    // Override equals() and hashCode()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return id == other.id && age == other.age && level == other.level &&
               Float.compare(other.salary, salary) == 0 &&
               experience == other.experience &&
               Objects.equals(name, other.name) && gender == other.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age, level, salary, experience, gender);
    }

    // Builder Pattern
    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {
        private String name;
        private int id;
        private int age;
        private int level;
        private float salary;
        private int experience;
        private Gender gender;

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder id(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder age(int age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder level(int level) {
            this.level = level;
            return this;
        }

        public EmployeeBuilder salary(float salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder experience(int experience) {
            this.experience = experience;
            return this;
        }

        public EmployeeBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Employee build() {
            return new Employee(name, id, age, level, salary, experience, gender);
        }
    }

    // compareTo() method comparing all fields
    @Override
    public int compareTo(Employee other) {
        int result = Integer.compare(this.level, other.level);
        if (result != 0) return result;

        result = Integer.compare(this.experience, other.experience);
        if (result != 0) return result;

        result = this.gender.compareTo(other.gender);
        if (result != 0) return result;

        result = Float.compare(this.salary, other.salary);
        if (result != 0) return result;

        result = Integer.compare(this.age, other.age);
        if (result != 0) return result;

        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", age=" + age + ", level=" + level + ", salary=" + salary
                + ", experience=" + experience + ", gender=" + gender + "]";
    }

    public static void main(String[] args) {
        Employee obj = new Employee("Badal", 7, 22, 2, 30000, 5, Gender.MALE);
        System.out.println(obj);
    }
}
