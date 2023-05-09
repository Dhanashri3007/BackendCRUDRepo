package com.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.fileuplode_serviceI.FileUplode_serviceI;
import com.demo.model.Address;
import com.demo.model.CityName;
import com.demo.model.Document;
import com.demo.model.State;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
public class FileUplodeController {
	@Autowired
	FileUplode_serviceI fi;
	
	@PostMapping("uplodeDocument")
	public ResponseEntity<Document> uplodeFile(@RequestParam MultipartFile adharPhoto,@RequestParam MultipartFile panPhoto,@RequestParam String name ) throws IOException
	{
		byte[] adhar = adharPhoto.getBytes();
		byte[] pan = panPhoto.getBytes();
		ObjectMapper obj=new ObjectMapper();
		Document doc = obj.readValue(name,Document.class);
		System.out.println(doc);
		doc.setAdharPhoto(adhar);
		doc.setPanPhoto(pan);
		Document d=fi.save(doc);
		return new ResponseEntity<Document>(d, HttpStatus.OK);
	}
	
	@GetMapping ("getAdharImg/{pid}")
	public ResponseEntity<byte[]> getAdharImage(@PathVariable int pid) throws IOException
	{
		Document d =fi.findById(pid);
		byte[] adharPhoto = d.getAdharPhoto();
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(adharPhoto);
	}
	@GetMapping ("getPanImg/{pid}")
	public ResponseEntity<byte[]> getPanImage(@PathVariable int pid) throws IOException
	{
		Document d =fi.findById(pid);
		byte[] panPhoto = d.getPanPhoto();
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(panPhoto);
	}
	
	@DeleteMapping ("delete/{pid}")
	public ResponseEntity<String> deletePersonInfo(@PathVariable int pid) 
	{
						fi.deleteById(pid);
		return new ResponseEntity<String>("Delete SucessFully", HttpStatus.OK);
	}
	
	@PutMapping("updateData/{pid}")
	public ResponseEntity<Document> updateData(@RequestParam("adharPhoto") MultipartFile file1, @RequestParam("panPhoto") MultipartFile file2,
			@RequestParam String name, @PathVariable int pid) throws IOException
	{
		byte[] adhar = file1.getBytes();
		byte[] pan = file2.getBytes();
		ObjectMapper obj =new ObjectMapper();
		Document d = obj.readValue(name,Document.class);
		d.setAdharPhoto(adhar);
		d.setPanPhoto(pan);
		Document doc=fi.update(d,pid);
		return new ResponseEntity<Document>(doc, HttpStatus.OK);
	}
	
	@GetMapping("getAllCountry")
	public ResponseEntity<List<Address>>getAllCountry(String country)
	{
		List<Address> allcountries=fi.getAllCountries(country);
		return new ResponseEntity<List<Address>>(allcountries, HttpStatus.OK);
	}
	
	
	@GetMapping("getAllStates")
	public ResponseEntity<List<State>>getAllStates(@PathVariable String state)
	{
		List<State> allstate=fi.getAllStates(state);
		return new ResponseEntity<List<State>>(allstate, HttpStatus.OK);
	}

	@GetMapping("getAllcities")
	public ResponseEntity<List<CityName>>getAllCities(@PathVariable String city)
	{
		List<CityName> allcities=fi.getAllCities(city);
		return new ResponseEntity<List<CityName>>(allcities, HttpStatus.OK);
	}
}
