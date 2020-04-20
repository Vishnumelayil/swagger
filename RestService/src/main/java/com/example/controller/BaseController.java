package com.example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.entity.User;
import com.example.service.UserServiceImpl;

@RestController
public class BaseController {
	
	@Autowired
	UserServiceImpl userservice;
	
	@GetMapping("/user/alldata")
	public List<User> fetchAlldata() {
		return userservice.retrieveAllData();
	}
	
	@GetMapping("/user/alldata/{userid}")
	public User fetchAlldata(@PathVariable Integer userid) {
		return userservice.retrievebyId(userid);
	}
	
	@PostMapping("/user/adduser")
	public ResponseEntity<Object> addUser(@RequestBody User user) { 
		System.out.println("adduser" +user.getId());
		userservice.addUser(user);
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{userid}")
				.buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
