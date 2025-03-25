package spring.aop.revision;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Gender;

public class TxAdviceClient {
	
	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("tx-advice.xml");
		EmployeeDAO dao = (EmployeeDAO)appCtx.getBean("employeeDAO");
		SessionFactory factory = appCtx.getBean(SessionFactory.class);
		dao.save(factory.openSession(), new Employee("TXGuy",23,Gender.MALE,30000,3,1,3));
	}

}
