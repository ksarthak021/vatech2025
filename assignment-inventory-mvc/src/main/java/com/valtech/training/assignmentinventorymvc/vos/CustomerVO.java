package com.valtech.training.assignmentinventorymvc.vos;

import com.valtech.training.assignmentinventorymvc.entities.Customer;
import com.valtech.training.assignmentinventorymvc.enums.CustomerStatus;

public record CustomerVO(int id,String name,int age,String address,String permanentAddress,CustomerStatus status) {
	public static CustomerVO from(Customer c) {
		return new CustomerVO(c.getId(),c.getName(),c.getAge(),c.getAddress(),c.getPermanentAddress(),c.getStatus());
	}
	public Customer to() {
		return new Customer(id,name,age,address,permanentAddress,status);
	}
	public void updateTo(int id, Customer c) {
		c.setName(name);
		c.setAddress(address);
		c.setPermanentAddress(permanentAddress);
		c.setAge(age);
		c.setStatus(status);
	}
}
