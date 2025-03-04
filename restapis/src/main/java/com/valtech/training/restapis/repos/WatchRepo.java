package com.valtech.training.restapis.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.restapis.entities.Watch;

public interface WatchRepo extends JpaRepository<Watch, Long> {

	List<Watch> findAllByBrand(String brand);

}
