package com.demo.fileuplode_serviceI;

import java.util.List;

import com.demo.model.Address;
import com.demo.model.CityName;
import com.demo.model.Document;
import com.demo.model.State;

public interface FileUplode_serviceI {

	Document save(Document doc);

	Document findById(int pid);

	void deleteById(int pid);

	Document update(Document d,int pid);

	//Get All Countries
	List<Address> getAllCountries(String country);

	List<State> getAllStates(String state);

	List<CityName> getAllCities(String city);
	

}
