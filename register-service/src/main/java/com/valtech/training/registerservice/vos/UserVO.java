package com.valtech.training.registerservice.vos;

import com.valtech.training.registerservice.entities.User;

public record UserVO(long id,int age ,String name, String mobile,String email, Boolean kid) {
 
	public static UserVO from(User u) {
		return new UserVO(u.getId(), u.getAge(),u.getName(), u.getMobile(), u.getEmail(), u.isKid());
	}
	public User to() {
		return new User(id,name,age,mobile,email,kid);
	}
}