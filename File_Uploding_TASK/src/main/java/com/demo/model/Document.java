package com.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String name;
	@Lob
	private byte[] adharPhoto;
	@Lob
	private byte[] panPhoto;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getAdharPhoto() {
		return adharPhoto;
	}
	public void setAdharPhoto(byte[] adharPhoto) {
		this.adharPhoto = adharPhoto;
	}
	public byte[] getPanPhoto() {
		return panPhoto;
	}
	public void setPanPhoto(byte[] panPhoto) {
		this.panPhoto = panPhoto;
	}
	
	

}
