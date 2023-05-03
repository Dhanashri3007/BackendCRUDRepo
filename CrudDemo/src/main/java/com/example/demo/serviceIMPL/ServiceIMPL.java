package com.example.demo.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product__Multifrom;
import com.example.demo.ServiceI.ServiceI;
import com.example.demo.repositry.HomeRepositry;

@Service
public class ServiceIMPL implements ServiceI {

	@Autowired
	HomeRepositry hr;

	@Override
	public Product__Multifrom save(Product__Multifrom p) {
		return hr.save(p);
	}
}
