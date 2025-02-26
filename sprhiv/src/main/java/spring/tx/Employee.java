package spring.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Employee implements Comparable<Employee>{
	private String name;
	@Id
    private int id;
    private int age;
    private int level;
    private float salary;
    private int experience;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    
	
    public Employee() {}

    public Employee(String name, int age, Gender gender, float salary, int experience, int level,int id ) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.level = level;
        this.salary = salary;
        this.experience = experience;
        this.gender = gender;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

   

    @Override
    public int hashCode() {
        return Objects.hash(name, id, age, level, salary, experience, gender);
    }
    
    @Override
    public String toString() {
		return  new StringBuilder().append("ID : ")
								.append(id)
								.append(" Name : ")
								.append(name)
								.append(" Age : ")
								.append(age)
								.append(" Salary : ")               //("Roy", 22,Gender.MALE,30000, 2,5,4) give or fill data like this only 
								.append(salary)                     //name,age,gender,salary,level,experience,id
								.append(" Experiance : ")
								.append(experience)
								.append(" Gender : ")
								.append(gender)
								.toString();
	}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return id == other.id && age == other.age && level == other.level && Float.compare(other.salary, salary) == 0
                && experience == other.experience && Objects.equals(name, other.name) && gender == other.gender;
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder(new Employee());
    }

    public static class EmployeeBuilder {
        private Employee employee;

        public EmployeeBuilder(Employee employee) {
            this.employee = employee;
        }

        public Employee build() {
            return employee;
        }

        public EmployeeBuilder id(int id) {
            employee.setId(id);
            return this;
        }

        public EmployeeBuilder name(String name) {
            employee.setName(name);
            return this;
        }

        public EmployeeBuilder age(int age) {
            employee.setAge(age);
            return this;
        }

        public EmployeeBuilder salary(float salary) {
            employee.setSalary(salary);
            return this;
        }

        public EmployeeBuilder level(int level) {
            employee.setLevel(level);
            return this;
        }

        public EmployeeBuilder experience(int experience) {
            employee.setExperience(experience);
            return this;
        }

        public EmployeeBuilder gender(Gender gender) {
            employee.setGender(gender);
            return this;
        }
    }

    @Override
    public int compareTo(Employee o) {
        int result = Integer.compare(level, o.level);
        if (result != 0) return result;

        result = Integer.compare(experience, o.experience);
        if (result != 0) return result;

        result = gender.compareTo(o.gender);
        if (result != 0) return result;

        return Float.compare(salary, o.salary);
    }

    public static void main(String[] args) {
        Employee obj = new Employee("Roy", 22,Gender.MALE,30000, 2,5,4);
        System.out.println(obj);
    }
}
