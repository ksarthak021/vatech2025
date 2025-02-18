package day1;

public interface Animal {
	
	int ZERO = 0; // by default variable are static and constant in interface 
	
	public void makeSound();   // all the methods of interface are public and abstract by default
    
	void eat();
	
	void sleep();
}
