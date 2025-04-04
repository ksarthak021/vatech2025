package com.valtech.training.assignmentinventorymvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.assignmentinventorymvc.entities.LineItem;

public interface LineItemRepo extends JpaRepository<LineItem, Integer> {

}
