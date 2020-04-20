package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.entity.User;

@Service
public class UserServiceImpl {
	
	static HashMap<Integer, User> userdata=new HashMap<Integer, User>();
	static {
		userdata.put(1, new User(1,"Das","974215647"));
		userdata.put(2, new User(2,"David","9895947612"));
	}
	public User addUser(User user) {
		System.out.println("added");
		userdata.put(new Integer(user.getId()), user);
		return user;	
	}
	
	public List<User> retrieveAllData() {
		return userdata.values().stream()
                .collect(Collectors.toList());
	}
	
	public User retrievebyId(Integer id) {
		return userdata.get(id);
	}

}
