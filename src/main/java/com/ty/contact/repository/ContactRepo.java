package com.ty.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.contact.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer>{

}
