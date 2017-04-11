package com.test.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.contact.dao.ContactDAO;
import com.test.contact.form.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	
	@Transactional
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Transactional
	public Contact getContact(Integer id) {
		return contactDAO.getContact(id);
	}
	
	@Transactional
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);
	}
	
	@Transactional
	public List<Contact> listContact() {
		return contactDAO.listContact();
	}

	@Transactional
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}
}
