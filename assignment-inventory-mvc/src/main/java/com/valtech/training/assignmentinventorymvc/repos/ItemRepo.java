package com.valtech.training.assignmentinventorymvc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.assignmentinventorymvc.entities.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{

}
