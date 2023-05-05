package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		return new ResponseEntity<UserLogin>(ur, HttpStatus.OK);
	}

}
