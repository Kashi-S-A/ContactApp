package com.ty.contact.service;

import java.util.Optional;

import com.ty.contact.entity.User;

public interface UserService {

	boolean registerUser(User user);
	
	Optional<User> findByEmail(String email);

	User findById(Integer uid);

}
