package com.jspiders.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.User;
import com.jspiders.springrest.response.ResponseStructure;
import com.jspiders.springrest.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/user")
	public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user){
		User addedUser= userService.addUser(user);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (addedUser !=null) {
			responseStructure.setMessage("User added");
			responseStructure.setData(addedUser);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("User already exists");
			responseStructure.setData(addedUser);
			responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping(path="/user")
	public ResponseEntity<ResponseStructure<User>> validateUser(@RequestParam(name="userName") String userName,@RequestParam(name="password") String password){
		User user=userService.validateUser(userName, password);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (user !=null) {
			responseStructure.setMessage("User Found");
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
			
		}else {
			responseStructure.setMessage("User Not Found");
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path="/user")
	public ResponseEntity<ResponseStructure<User>> updateUser(User user){
		User updatedUser=userService.updateUser(user);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (updatedUser !=null) {
			responseStructure.setMessage("User U[dated");
			responseStructure.setData(updatedUser);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("User NOt Found");
			responseStructure.setData(updatedUser);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/user")
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id){
		User deletedUser=userService.deleteUser(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (deletedUser !=null) {
			responseStructure.setMessage("User Deleted");
			responseStructure.setData(deletedUser);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("User NOt Found");
			responseStructure.setData(deletedUser);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<User>> updateCarListForUser(int userId, int carId) {
		User updatedUser=userService.updateCarListForUser(userId, carId);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (updatedUser !=null) {
			responseStructure.setMessage("Car List For The User is Updated");
			responseStructure.setData(updatedUser);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("User NOt Found");
			responseStructure.setData(updatedUser);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
		
	}

}
