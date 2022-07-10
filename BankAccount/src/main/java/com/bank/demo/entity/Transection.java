package com.bank.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transection {
	
	@Id
	private int Sender_id;
	private int Sender_accNumber;
	private int Reciever_id;
	private int Reciever_accNumber;
	private int balance;
	public int getSender_id() {
		return Sender_id;
	}
	public void setSender_id(int sender_id) {
		Sender_id = sender_id;
	}
	public int getSender_accNumber() {
		return Sender_accNumber;
	}
	public void setSender_accNumber(int sender_accNumber) {
		Sender_accNumber = sender_accNumber;
	}
	public int getReciever_id() {
		return Reciever_id;
	}
	public void setReciever_id(int reciever_id) {
		Reciever_id = reciever_id;
	}
	public int getReciever_accNumber() {
		return Reciever_accNumber;
	}
	public void setReciever_accNumber(int reciever_accNumber) {
		Reciever_accNumber = reciever_accNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
