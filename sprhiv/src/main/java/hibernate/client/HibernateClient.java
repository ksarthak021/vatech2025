package hibernate.client;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import hibernate.Account;
import hibernate.Address;
import hibernate.AtmTx;
import hibernate.Car;
import hibernate.ChequeTx;
import hibernate.Customer;
import hibernate.Student;
import hibernate.StudentAddress;
import hibernate.StudentId;
import hibernate.TellerTx;
import hibernate.Tx;

public class HibernateClient {
	
	
	public static void main(String[] args) {
				SessionFactory sesFac = new  AnnotationConfiguration()
						.addAnnotatedClass(Car.class)
						.addAnnotatedClass(Tx.class)
						.addAnnotatedClass(ChequeTx.class)
						.addAnnotatedClass(AtmTx.class)
						.addAnnotatedClass(TellerTx.class)
						.addAnnotatedClass(Customer.class)
						.addAnnotatedClass(Address.class)
						.addAnnotatedClass(Account.class)
						.addAnnotatedClass(Student.class)
						
						.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		
		//System.out.println(ses.createQuery("FROM Tx t").list());
		
		//ses.createQuery("FROM Tx t").list().stream().forEach(t -> System.out.println(t));
		
		//ses.createQuery("FROM Customer c WHERE c.age > ?").setInteger(0, 25).list().stream().forEach(t -> System.out.println(t));
		
		ses.createQuery("SELECT t.amount FROM Tx t JOIN t.account.customers c WHERE c.age < ?")
		               .setInteger(0, 25).list().stream().forEach(t -> System.out.println(Arrays.asList(t)));
		
//		StudentId id = (StudentId) ses.save(new Student(new StudentId(1,2025),"Abc","Def","CS",123456789L
//				,new StudentAddress("Somewhere","Amd",346483)
//		        ,new StudentAddress("Nowhere","Raj",500981)));
//		System.out.println(ses.load(Student.class, id));
		
//		Account ac = (Account) ses.load(Account.class,1L);
//		Customer cus = (Customer) ses.load(Customer.class,1L);
//		
//		Account ac1 = new Account(50000,"CA");
//		Account ac2 = new Account(30000,"FB");
//		Customer cus1 = new Customer("DEF",32,false);
//		Customer cus2 = new Customer("SIS",36,false);
//		
//		ses.save(ac1);
//		ses.save(ac2);
//		
//		ses.save(cus1);
//		ses.save(cus2);
//		
//		cus.addAccount(ac);
//		cus.addAccount(ac1);
//		cus.addAccount(ac2);
//		cus1.addAccount(ac);
//		cus1.addAccount(ac1);
//		cus2.addAccount(ac);
		
		
		
//		List<Tx> txs = ses.createQuery("from Tx t").list();
//	
//		Account acc = new Account(10000,"SB");
//		ses.save(acc);
//		txs.stream().forEach(t -> acc.addTx(t));

//		Customer c = new Customer("Abc",23,true);
//		ses.save(c);
//		
//		Customer c1 = (Customer) ses.load(Customer.class,1L);
//		System.out.println(c1);
//		System.out.println(c1.getAddress());
//		
		
//		Address a = new Address("Jp nagar","Jpr",696879);
//		c.setAddress(a);
//		a.setCustomer(c);
//		a.setId(c.getId());
//		ses.saveOrUpdate(a);
		
//		List<Tx> txs = ses.createQuery("from Tx t").list();
//		System.out.println(txs);
		
		
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000,123456));
//		ses.save(new TellerTx(3000,"Admin","Jp nagar"));
//		ses.save(new AtmTx(4000,123));
		
//		Long id = (Long)ses.save(new Car(0,"honda","city",2025));
//		System.out.println(id);
//		Car car = (Car)ses.load(Car.class,id);
//		System.out.println(car);
//		car.setName("civic");
//		//car.setName("city");
//		Car car1 = (Car)ses.load(Car.class,id);
//		ses.update(car);
//		ses.flush(); // do not call it on your own 
//		System.out.println(car);
//		System.out.println(car.getClass().getName());
		
		tx.commit();
		ses.close();
		sesFac.close();
	}
	
		


}
