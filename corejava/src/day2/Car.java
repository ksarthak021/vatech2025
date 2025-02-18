package day2;

import java.util.Objects;

public class Car {
	private String make;
	private String model;
	private String variant;
	private String year;
	private int version;
	
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(String make, String model, String variant, String year, int version) {
		super();
		this.make = make;
		this.model = model;
		this.variant = variant;
		this.year = year;
		this.version = version;
	}
	
	public static CarBuilder builder() {
		return new CarBuilder(new Car());
	}
	
	@Override
	public boolean equals(Object obj) {
		//if obj is a car
		if( !(obj instanceof Car)) return false;
		Car car = (Car)obj ; 
		//compare obj with this
		return year == car.year && version == car.version && make.equals(car.make) && model.equals(car.model) && variant.equals(car.variant) ;
	}   //compare using hash code and 
	
	
	@Override
	public int hashCode() {
		return (toString()+"Car").hashCode();
	}

	@Override
	public String toString() {
		//return make + " " + model + " " + variant + " " + year + " " + version;
		return new StringBuilder().append(make)
				                  .append(" ")
				                  .append(model)
				                  .append(" ")
				                  .append(variant)
				                  .append(" ")
				                  .append(year)
				                  .append(" ")
				                  .append(version)
				                  .toString();
	}
	

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;    
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String Variant) {
		this.variant = Variant;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	public static class CarBuilder {
		private Car car ;
		
		public CarBuilder(Car car) {
			this.car = car;
		}
		public Car build() {
			return car ;
		}
		public CarBuilder make(String make) {
			car.setMake(make);
			return this;
		}
		public CarBuilder model(String model) {
			car.setModel(model);
			return this;
		}
		public CarBuilder variant(String variant) {
			car.setVariant(variant);
			return this;
		}
		public CarBuilder year(String year) {
			car.setVariant(year);
			return this;
		}
		public CarBuilder version(int version) {
			car.setVersion(version);
			return this;
		}
		
	}
	

}
