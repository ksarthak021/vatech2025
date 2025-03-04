package assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import assignment.classes.OrderEn;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addOrder(OrderEn order) {
		new HibernateTemplate(sessionFactory).save(order);
	}

	@Override
	public OrderEn getOrder(int id) {
		return new HibernateTemplate(sessionFactory).load(OrderEn.class, id);
	}

	@Override
	public List<OrderEn> getAll() {
		return new HibernateTemplate(sessionFactory).find("from OrderEn");
	}

	@Override
	public void updateOrder(OrderEn order) {
		new HibernateTemplate(sessionFactory).update(order);
	}

	@Override
	public void deleteOrder(int id) {
		new HibernateTemplate(sessionFactory).delete(getOrder(id));
	}

}
