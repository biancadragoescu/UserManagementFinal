package com.evozon.usermanagement.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.neo4j.cypher.internal.compiler.v2_1.perty.docbuilders.toStringDocBuilder;
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
	public void updateUsers(List<User> usersList,int index) {
			
		Session s = session.getCurrentSession();
		if( index != -1 ) {
			User user = usersList.get(index);
			s.update(user);
			s.merge(user);
		}
		
	}

	@Override
	public void addUser(User user) {
		Session s = session.getCurrentSession();
		s.save(user);	
	}

}
