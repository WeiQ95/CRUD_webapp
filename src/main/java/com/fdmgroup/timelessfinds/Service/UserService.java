package com.fdmgroup.timelessfinds.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.timelessfinds.Model.User;
import com.fdmgroup.timelessfinds.Repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
    @Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public void save(User user) {
		user.setPassword(user.getPassword());
		userRepo.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
}
