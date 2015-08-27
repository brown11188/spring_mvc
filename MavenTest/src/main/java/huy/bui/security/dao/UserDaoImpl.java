package huy.bui.security.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import huy.bui.security.model.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		Session session = this.sessionFactory.openSession();
		users = session.createQuery("from User where username=?").setParameter(0, username).list();
		if (users.size() > 0) {			
			return users.get(0);
		} else {
			return null;
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}