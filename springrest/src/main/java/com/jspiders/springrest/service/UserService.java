package com.jspiders.springrest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springrest.pojo.User;
import com.jspiders.springrest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		boolean flag=true;
		List<User> users=userRepository.findAllUsers();
		if (users !=null && users.size()>0) {
			for (User user2 : users) {
				if (user2.getUserName().equals(user.getUserName()) || user2.getEmail().equals(user.getEmail()) || user2.getPassword().equals(user.getPassword())) {
					flag=false;
					break;
				}
			}
		}
		if (flag) {
			return userRepository.addUser(user);
		}else {
			return null;
		}
		
	}
	
	public User validateUser(String userName, String password) {
		try {
			User user= userRepository.validateUser(userName, password);
			return user;
		} catch (Exception e) {
			return null;
		}
	}
	
	public User updateUser(User user) {
		return userRepository.updateUser(user);
	}
	
	public User deleteUser(int id) {
		return userRepository.deleteUser(id);
	}
	
	public User updateCarListForUser(int userId, int carId) {
		return userRepository.updateCarListForUser(userId, carId);
	}
}
