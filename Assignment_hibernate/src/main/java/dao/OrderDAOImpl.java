package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hibernate1.order;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<order> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Order").list();
    }
}
