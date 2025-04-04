package com.valtech.training.assignmentinventorymvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.assignmentinventorymvc.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
