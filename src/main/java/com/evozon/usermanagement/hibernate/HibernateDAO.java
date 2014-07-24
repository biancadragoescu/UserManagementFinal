package com.evozon.usermanagement.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.evozon.usermanagement.dao.UserDAO;
import com.evozon.usermanagement.model.User;

@Primary
@Repository
public class HibernateDAO implements UserDAO{

	@Autowired
	private SessionFactory session;
	
	public HibernateDAO() {
		
	}
	
	@Override
	public List<User> getAllUsers() {
		return session.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void updateUsers(List<User> usersList) {
		//session.getCurrentSession().update();
	}

	@Override
	public void addUser(User user) {
		Session s = session.getCurrentSession();
		s.save(user);	
	}

}
