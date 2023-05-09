package com.demo.fileuplode_serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.InvalidPersonId;
import com.demo.fileuplode_repositry.AddressRepo;
import com.demo.fileuplode_repositry.CityRepo;
import com.demo.fileuplode_repositry.FileUplodeRepositry;
import com.demo.fileuplode_repositry.StateRepo;
import com.demo.fileuplode_serviceI.FileUplode_serviceI;
import com.demo.model.Address;
import com.demo.model.CityName;
import com.demo.model.Document;
import com.demo.model.State;


@Service
public class FileUplode_serviceIMPL implements FileUplode_serviceI {

	@Autowired
	FileUplodeRepositry fr;
	@Autowired
	AddressRepo ar;
	
	@Autowired
	StateRepo sr;
	
	@Autowired 
	CityRepo cr;
	
	
	@Override
	public Document save(Document doc) {
		System.out.println("SAVe=E");
		return fr.save(doc);
	}

	@Override
	public Document findById(int pid) {
		Optional<Document> findById = fr.findById(pid);
		return findById.get();
	}

	@Override
	public void deleteById(int pid) {
		Optional<Document> findById = fr.findById(pid);
		if(findById.isPresent())
		{
			fr.deleteById(pid);
		}
		else {
		 throw new InvalidPersonId("This Pesron Id Not Present In DataBase");
		}
	}

	@Override
	public Document update(Document d,int pid) {
		Optional<Document> findById = fr.findById(pid);
		if(findById.isPresent())
		{
			System.out.println(d.getAdharPhoto());
			System.out.println(d.getPanPhoto());
			d.setPid(pid);
			return fr.save(d);
		}
		else
		{
			throw new InvalidPersonId("This Pesron Id Not Present In DataBase");
		}
	
	}

	@Override
	public List<Address> getAllCountries(String country) {
		return ar.findAllByCountry( country);
	}

	@Override
	public List<State> getAllStates(String state) {
		return sr.findByState(state);
	}

	@Override
	public List<CityName> getAllCities(String city) {
		return cr.findAllByCityname(city);
	}

}
