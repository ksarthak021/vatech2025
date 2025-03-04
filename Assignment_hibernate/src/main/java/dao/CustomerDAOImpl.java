package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hibernate1.customer;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(customer customer) {
        getSession().saveOrUpdate(customer);
    }

    @Override
    public void delete(customer customer) {
        getSession().delete(customer);
    }

    @Override
    public customer findById(int customerId) {
        return getSession().get(customer.class, customerId);
    }

    @Override
    public List<customer> findAll() {
        return getSession().createQuery("FROM Customer").list();
    }
}

