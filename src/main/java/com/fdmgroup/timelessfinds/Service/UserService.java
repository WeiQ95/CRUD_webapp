package com.fdmgroup.timelessfinds.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.timelessfinds.Model.User;

import Repository.UserRepository;

@Service
public class UserService {
    @Autowired
	private UserRepository userRepo;
	
	public void save(User user) {
		user.setPassword(user.getPassword());
		userRepo.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
}
