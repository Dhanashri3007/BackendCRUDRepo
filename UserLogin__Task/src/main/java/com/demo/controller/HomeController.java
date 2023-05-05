package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.UserLogin;
import com.demo.serviceI.HomeServiceI;

@RestController
public class HomeController {
	@Autowired
	HomeServiceI hi;
	
	@PostMapping("loginUser")
	public ResponseEntity<UserLogin> addloginUser(@RequestBody UserLogin u)
	{
		UserLogin ur=hi.save(u);
		return new ResponseEntity<UserLogin>(ur, HttpStatus.CREATED);
	}
	
	@GetMapping("getAllUser")
	public ResponseEntity<List<UserLogin>> getAllUser()
	{
		List<UserLogin> ul=hi.findAll();
		return new ResponseEntity<List<UserLogin>>(ul, HttpStatus.OK);
	}
	
	

}
