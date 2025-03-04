package com.valtech.training.restapis.entities;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
 
@Entity
public class Watch {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "watchseq")
	@SequenceGenerator(name = "watchseq",sequenceName = "watch_seq",allocationSize = 1)
	private long id;
	private String brand;
	private String model;
	private String color;
	private float price;
	private String type;
	
	@ManyToOne(targetEntity = Owner.class, cascade = CascadeType.ALL)
	@JoinColumn(name="owner_id",referencedColumnName = "id")
	private Owner owner;
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public Owner getOwner() {
		return owner;
	}
		
	public Watch() {}

	public Watch(String brand,String color, String model, float price, String type) {
		super();
		this.brand = brand;
		this.color = color;
		this.model = model;
		this.price = price;
		this.type = type;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
 
 