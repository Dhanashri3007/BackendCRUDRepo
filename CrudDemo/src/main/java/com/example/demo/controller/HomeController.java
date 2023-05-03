package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product__Multifrom;
import com.example.demo.ServiceI.ServiceI;

@CrossOrigin("*")
@RestController
public class HomeController {
	@Autowired
	ServiceI si;
	
	@PostMapping("addProductData")
	public ResponseEntity<Product__Multifrom> getData(@RequestBody Product__Multifrom p)
	{
		Product__Multifrom pro=si.save(p);
		return new ResponseEntity<Product__Multifrom>(pro, HttpStatus.OK);
	}

}
