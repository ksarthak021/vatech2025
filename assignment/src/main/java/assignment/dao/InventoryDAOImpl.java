package assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import assignment.classes.Item;

@Repository
public class InventoryDAOImpl implements InventoryDAO {


	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addInventory(Item item) {
		new HibernateTemplate(sessionFactory).save(item);
	}

	@Override
	public Item getInventory(int id) {
		return new HibernateTemplate(sessionFactory).load(Item.class, id);
	}

	@Override
	public List<Item> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Item item");

	}

	@Override
	public void updateInventory(Item item) {
		new HibernateTemplate(sessionFactory).update(item);
	}

	@Override
	public void deleteInventory(int id) {
		new HibernateTemplate(sessionFactory).delete(getInventory(id));
	}

	@Override
    public Item getItem(int itemId) {
        Session session = sessionFactory.getCurrentSession();
        return (Item) session.get(Item.class, itemId); 
    }

	@Override
    public void updateItem(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.update(item);
    }

}
