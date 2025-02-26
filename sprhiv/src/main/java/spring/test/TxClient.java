package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee;
import spring.tx.EmployeeService;
import spring.tx.Gender;

public class TxClient {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("tx-hib-anno.xml");
		EmployeeService es = ctx.getBean(EmployeeService.class);
		System.out.println(es.getClass().getName());
		es.update(new Employee("Ten",10,Gender.FEMALE,500000,10,10,8));         //(name,age,gender,salary,level,experience,id)
		es.getAll().forEach(e -> System.out.println(e));
		ctx.close();
	}

}
