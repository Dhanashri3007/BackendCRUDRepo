package com.example.demo.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product__Multifrom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private double pprice;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SupplierMulti supplier;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPprice() {
		return pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public SupplierMulti getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierMulti supplier) {
		this.supplier = supplier;
	}
	
	
}
