package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import hibernate1.Item;
import java.util.List;

@Repository
public class ItemDAOImpl implements ItemDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Item> getAllItems() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Item").list();
    }
}
