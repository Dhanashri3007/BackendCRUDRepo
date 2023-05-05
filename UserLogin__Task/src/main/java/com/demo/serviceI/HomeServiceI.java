package com.demo.serviceI;

import java.util.List;

import com.demo.model.UserLogin;

public interface HomeServiceI {

	UserLogin save(UserLogin u);

	List<UserLogin> findAll();

}
