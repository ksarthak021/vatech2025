package com.valtech.training.springsecurity.services;

import com.valtech.training.springsecurity.entities.User;
import com.valtech.training.springsecurity.vos.ChangePassword;

public interface UserManagerService {

	void registerUser(User user);

	void changePassword(String username, ChangePassword changePassword);

}