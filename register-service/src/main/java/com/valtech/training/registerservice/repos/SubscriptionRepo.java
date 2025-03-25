package com.valtech.training.registerservice.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.registerservice.entities.Subscription;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long>{
	
	List<Subscription> findAllBySubscriptionEndLessThan(LocalDate date);

}
		