package com.example.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.userInterface.User_Interface;

@Service
public class UserImpl implements User_Interface {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users getByID(Long id) {
		// TODO Auto-generated method stub
		Optional <Users> user=userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
		   
	}

}
