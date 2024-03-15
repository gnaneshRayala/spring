package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.userInterface.User_Interface;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/demo2")
public class Demo2_Controller {
	@Autowired
	private User_Interface user_Interface;

	@CrossOrigin(origins = "http://localhost:8081")

	@GetMapping("/{id}")
	public Users getUserById(@PathVariable("id") Long id) {
		return user_Interface.getByID(id);

	}

}
