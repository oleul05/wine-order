package com.order.model;

//Model class for Vin, It's set and get the value for DAO (Data Access Object) Where we set data data for specific field and get the data from that filed
public class Vin {
	private int id; //declare an Integer type field name
	private String description; //declare String type field name
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
