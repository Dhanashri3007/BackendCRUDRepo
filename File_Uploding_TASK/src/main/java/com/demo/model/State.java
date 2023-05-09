package com.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String state;
	@OneToMany(cascade = CascadeType.ALL)
	private List<CityName> city;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<CityName> getCity() {
		return city;
	}
	public void setCity(List<CityName> city) {
		this.city = city;
	}
	
	
}
