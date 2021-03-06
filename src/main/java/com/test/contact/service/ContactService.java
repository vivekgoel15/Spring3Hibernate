package com.test.contact.service;

import java.util.List;

import com.test.contact.form.Contact;

public interface ContactService {
	
	public void addContact(Contact contact);
	public Contact getContact(Integer id);
	public void updateContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
