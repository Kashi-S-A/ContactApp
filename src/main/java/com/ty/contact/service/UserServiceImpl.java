package com.ty.contact.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.contact.entity.User;
import com.ty.contact.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	/*
	 * used to register user
	 * @param : it takes user entity register it if success return true else false
	*/
	@Override
	public boolean registerUser(User user) {
		Optional<User> opt = userRepo.findByEmail(user.getEmail());
		
		if (opt.isPresent()) {
			return false;
		} else {
			return userRepo.save(user)!=null;//return true if registered succ else false
		}
	}

	/*
	 * used to check whether user is registered or not
	 * @param : it takes String email
	*/
	@Override
	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public User findById(Integer uid) {
		return userRepo.findById(uid).get();
	}
}
