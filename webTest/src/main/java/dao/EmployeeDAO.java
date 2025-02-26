
package dao;

import java.util.List;

public interface EmployeeDAO {
	
	void save(Employee e);
	
	void update(Employee e);
	
	void delete(int id);
	
	Employee get(int id);
	
	List<Employee> getAll();
	
	List<Employee> searchByName(String name);
    List<Employee> searchByAge(int age);
    List<Employee> searchBySalary(float salary, String condition);
    List<Employee> searchByExperience(int experience);
    List<Employee> searchByLevel(int level);
	List<Employee> searchByID(int id);
	List<Employee> searchByGender(String gender);

	List<Employee> sortEmployees(String column, String order);
	List<Employee> getEmployeesByDeptId(int deptId);

	
	
	

}
