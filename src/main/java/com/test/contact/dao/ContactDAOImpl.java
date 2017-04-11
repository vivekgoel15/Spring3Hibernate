package com.test.contact.dao;

import java.util.List;

import com.test.contact.form.Contact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	public Contact getContact(Integer id) {
		return (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
	}
	
	public void updateContact(Contact contact) {
		sessionFactory.getCurrentSession().update(contact);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> listContact() {
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
		if (contact!=null) {
			sessionFactory.getCurrentSession().delete(contact);
		}
	}
}
