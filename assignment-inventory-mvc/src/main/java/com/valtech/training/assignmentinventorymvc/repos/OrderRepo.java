package com.valtech.training.assignmentinventorymvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.assignmentinventorymvc.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
