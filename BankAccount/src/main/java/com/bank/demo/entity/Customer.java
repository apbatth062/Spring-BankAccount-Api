package com.bank.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Customer {
	@Id
	private int id;
	private String name;
	private String address;
	
	@OneToMany(targetEntity=Account.class ,cascade=CascadeType.ALL)
	   @JoinColumn(name="CA_fk",referencedColumnName="id")
		private List<Account> account;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	public Customer(int id, String name, String address, List<Account> account) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.account = account;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

	
	
}
