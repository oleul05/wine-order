package com.order.model;

//Model class for Commande, It's set and get the value for DAO (Data Access Object) Where we set data data for specific field and get the data from that filed
public class Commande {
	
	private int Id; //declare an Integer type field name
	private int ClientId;
	private int VinId;
	private String dateHeure; //declare String type field name
	
	private String prenom;
	private String nom;
	private String address;
	private String telephone;
	
	private String description;
	
	public int getId() { // get the value of id
		return Id;
	}
	public void setId(int id) { // set the value of that id
		Id = id;
	}
	public int getClientId() {
		return ClientId;
	}
	public void setClientId(int clientId) {
		ClientId = clientId;
	}
	public int getVinId() {
		return VinId;
	}
	public void setVinId(int vinId) {
		VinId = vinId;
	}
	public String getDateHeure() {
		return dateHeure;
	}
	public void setDateHeure(String dateHeure) {
		this.dateHeure = dateHeure;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
