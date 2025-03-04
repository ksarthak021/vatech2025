package assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import assignment.classes.Item;
import assignment.classes.LiveItem;

@Repository
public class LiveItemDAOImpl implements LiveItemDAO {


	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addLiveItem(LiveItem liveitem) {
		new HibernateTemplate(sessionFactory).save(liveitem);	
	}

	@Override
	public LiveItem getLiveItem(int id) {
		return new HibernateTemplate(sessionFactory).load(LiveItem.class, id);
	}

	@Override
	public List<LiveItem> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LiveItem l");
	}

	@Override
	public void updateLiveItem(LiveItem liveitem) {
		new HibernateTemplate(sessionFactory).update(liveitem);
	}

	@Override
	public void deleteLiveItem(int id) {
		new HibernateTemplate(sessionFactory).delete(getLiveItem(id));
	}

}
