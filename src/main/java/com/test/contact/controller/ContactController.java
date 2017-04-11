package com.test.contact.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.contact.form.Contact;
import com.test.contact.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping("/")
	public String homepage(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "contact";
	}

	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {

		contactService.addContact(contact);

		return "redirect:/index";
	}

	@RequestMapping(value = "/edit/{contactId}")
	public String editContact(Map<String, Object> map, @PathVariable("contactId") Integer contactId) {

		Contact contact = contactService.getContact(contactId);
		map.put("contact", contact);
		map.put("contactList", contactService.listContact());
		
		return "contact";
	}
	
	@RequestMapping(value = "/edit/add", method = RequestMethod.POST)
	public String updateContact(@ModelAttribute("contact") Contact contact, BindingResult result) {

		contactService.updateContact(contact);

		return "redirect:/index";
	}
	
	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);

		return "redirect:/index";
	}
}
