package com.valtech.training.registerservice.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Subscription {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sub_seq")
	@SequenceGenerator(name = "sub_seq",sequenceName = "sub_seq",allocationSize = 1)
	private long id;
	private int amount;
	private LocalDate subscriptionStart;
	private LocalDate subscriptionEnd;
	
	@OneToMany(targetEntity = User.class)
	private List<User> user;
	
	public Subscription() {}

	public Subscription(long id, int amount, LocalDate subscriptionStart, LocalDate subscriptionEnd) {
		super();
		this.id = id;
		this.amount = amount;
		this.subscriptionStart = subscriptionStart;
		this.subscriptionEnd = subscriptionEnd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getSubscriptionStart() {
		return subscriptionStart;
	}

	public void setSubscriptionStart(LocalDate subscriptionStart) {
		this.subscriptionStart = subscriptionStart;
	}

	public LocalDate getSubscriptionEnd() {
		return subscriptionEnd;
	}

	public void setSubscriptionEnd(LocalDate subscriptionEnd) {
		this.subscriptionEnd = subscriptionEnd;
	}
	
	public void setUser(List<User> user) {
		this.user = user;
	}
	
	public List<User> getUser() {
		return user;
	}
	
	
	


}
