package assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import assignment.classes.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addCustomer(Customer customer) {
		new HibernateTemplate(sessionFactory).save(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		return new HibernateTemplate(sessionFactory).load(Customer.class, id);
	}

	@Override
	public List<Customer> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Customer customer");
	}

	@Override
	public void updateCustomer(Customer customer) {
		new HibernateTemplate(sessionFactory).update(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		new HibernateTemplate(sessionFactory).delete(getCustomer(id));
	}

}
