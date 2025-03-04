package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hibernate1.LiveOrderItem;
import java.util.List;

@Repository
public class LiveOrderItemDAOImpl implements LiveOrderItemDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<LiveOrderItem> getAllLiveOrderItems() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM LiveOrderItem").list();
    }
}

