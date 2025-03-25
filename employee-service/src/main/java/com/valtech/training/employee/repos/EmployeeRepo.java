package com.valtech.training.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.employee.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
