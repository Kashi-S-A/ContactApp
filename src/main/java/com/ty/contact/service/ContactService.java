package com.ty.contact.service;

import com.ty.contact.entity.Contact;

public interface ContactService {

	void saveContact(Contact contact);

	Contact findById(Integer cid);

	void deleteById(Integer cid);

}
