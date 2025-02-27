package hibernate1;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAO<T> {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    public List<T> getAll(Class<T> cla) {
        Session session = sessionFactory.openSession();
        List<T> list = session.createQuery("from " + cla.getName()).list();
        session.close();
        return list;
    }
}
