package com.order.model;

import java.sql.Date;

//Model class for client, It's set and get the value for DAO (Data Access Object) Where we set data data for specific field and get the data from that filed
public class Client {
	
	private int id; //declare an Integer type field name
	private String Prenom; //declare String type field name
	private String Nom;
	private String Naissance;
	private String Adresse;
	private String Telephone;
	
	private String description;
	private String time;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getNaissance() {
		return Naissance;
	}
	public void setNaissance(String naissance) {
		Naissance = naissance;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
