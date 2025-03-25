package com.valtech.training.registerservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public interface UserRepo extends JpaRepository<Subscription, Long>{
	
	 List<User> findByKidTrue();

}
