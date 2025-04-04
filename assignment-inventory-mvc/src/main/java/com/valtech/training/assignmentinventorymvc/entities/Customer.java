package com.valtech.training.assignmentinventorymvc.entities;
import java.util.List;

import com.valtech.training.assignmentinventorymvc.enums.CustomerStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

 
@Entity
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
	@SequenceGenerator(name = "custseq",sequenceName = "cust_seq",allocationSize = 1)
	private int id;
	private String name;
	private int age;
	private String address;
	private String permanentAddress;
	@Enumerated(EnumType.STRING)
	private CustomerStatus status;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> orders;
	
	
	public Customer() {
		
	}
	public Customer(int id,String name, int age, String address, String permanentAddress, CustomerStatus status) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.permanentAddress = permanentAddress;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public CustomerStatus getStatus() {
		return status;
	}
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", permanentAddress="
		+ permanentAddress + ", status=" + status + "]";
		}
	}