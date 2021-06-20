package com.leens.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leens.tech.dao.UserRepository;
import com.leens.tech.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> createUsers(List<User> user) {
		return userRepository.saveAll(user);
	}
	
	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}
	
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	
	public User updateUser(User user) {		
		Optional<User> optionalUser =userRepository.findById(user.getuId());
		if(optionalUser.isPresent()) {
			User oldUser = optionalUser.get();
			oldUser.setuId(user.getuId());
			oldUser.setUname(user.getUname());
			oldUser.setuAddr(user.getuAddr());			
			return userRepository.save(user);
		}
		else {
			
			return new User();
		}	
		
	}
	
	public String  deleteUser(int id ) {
		
		userRepository.deleteById(id);
		return "user got deleted";
		
	}
	
	
	

}
