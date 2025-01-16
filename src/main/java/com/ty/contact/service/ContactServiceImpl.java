package com.ty.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.contact.entity.Contact;
import com.ty.contact.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepo contactRepo;

	@Override
	public void saveContact(Contact contact) {
		contactRepo.save(contact);
	}
}
