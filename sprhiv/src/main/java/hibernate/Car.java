package hibernate;

import javax.persistence.*;

@Entity
public class Car {
	
//	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "carseq")       //IDENTITY
//	@SequenceGenerator(name = "carseq", sequenceName = "car_seq", allocationSize = 1)
	@Id @GeneratedValue(strategy = GenerationType.TABLE , generator = "cartab")
	@TableGenerator(name="cartab",table = "car_pk")
	private long id ;
	private String manufacturer ;
	private String name ;
	private int year ;
	
	@Version
	private int version ;
	
	public Car()  {}
	
	public Car(long id, String manufacturer, String name, int year) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.name = name;
		this.year = year;
	}

	
	@Override
	public String toString() {
		return "Car [id=" + id + ", manufacturer=" + manufacturer + ", name=" + name + ", year=" + year + ", version="
				+ version + "]";
	}

	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	

}
