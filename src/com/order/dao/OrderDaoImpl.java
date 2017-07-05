package com.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.order.Util.DBUtil;
import com.order.model.Client;
import com.order.model.Commande;
import com.order.model.Vin;

public class OrderDaoImpl{
	
	public static List<Client> getAllClient() {
		List<Client> clientList = new ArrayList<Client>(); //Make a ArrayList where keep all the client information
		
		 try{  // try to select all the data from database table client, if success then add all the data to ArrayList clientList
			 Connection con = DBUtil.getConnection(); //Define the sql connection class variable to connect with database and Call getConnection method in DBUtil class where connection established with database 
	            PreparedStatement ps=con.prepareStatement("select * from client");  // Select all the data from client table and Creates a PreparedStatement object for sending parameterized SQL statements to the database
	            ResultSet rs=ps.executeQuery();  // Keep the data in database resultset and execute the query
	            while(rs.next()){ //if the resultset has value then move the cursor to next  
	            	Client c = new Client();  //Create Client objete to set and get the Data From Client Model
	            	c.setId(rs.getInt(1));
	            	c.setPrenom(rs.getString(2));
	            	c.setNom(rs.getString(3));
	            	c.setNaissance(rs.getString(4));
	            	c.setAdresse(rs.getString(5));
	            	c.setTelephone(rs.getString(6));
	                
	                clientList.add(c);  //add the value to the list
	            }  
	        }catch(Exception e){
	        	e.printStackTrace();
	        } 
		
		return clientList; // return the list
		
	}
	
	public static List<Vin> getAllVin() {
		List<Vin> allvin = new ArrayList<Vin>(); // Create a arraylist to store all the list value of Vin model
		try {
			Connection con = DBUtil.getConnection(); //Define the sql connection class variable to connect with database and Call getConnection method in DBUtil class where connection established with database 
            PreparedStatement ps=con.prepareStatement("select * from vin");  // Select all the data from client table and Creates a PreparedStatement object for sending parameterized SQL statements to the database
            ResultSet rs=ps.executeQuery();  // Keep the data in database resultset and execute the query
            while(rs.next()) { // check the resultset has value or not if the resultset has value then set the value to Vin class object and then get the value
            	Vin v = new Vin(); // Create Vin class object
            	v.setId(rs.getInt(1)); //Set the id to the objet by getting the value from the sql query 
            	v.setDescription(rs.getString(2)); //Set the description to the object by getting the value from the sql query 
            	
            	allvin.add(v); //add all the values which get sql query to the model object
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return allvin;
	}
	
	public static int save(Client c){  // Pass Client class as parameter and create a client class object c
        int status=0;  // creates an int values and assigns this value to 0
        try{  
        	Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into client(prenom,nom,naissance,adresse,telephone) values (?,?,?,?,?)");  // insert the value into the client table
            ps.setString(1, c.getPrenom()); // set the first value for the sql and get the value form Client class getPrenom
            ps.setString(2, c.getNom()); // set the second value for the sql and get the value form Client class getNom
            ps.setString(3, c.getNaissance());
            ps.setString(4, c.getAdresse());
            ps.setString(5, c.getTelephone());                     
              
            status = ps.executeUpdate(); // Exucute the query            
              
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
          
        return status;  // return the status
    }
	public static int saveCommande(Commande cm) { //Pass Commande class as parameter and create a Commande class object cm
		int status = 0;
		try{  
        	Connection con = DBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into commande(ClientId, VinId, dateHeure) values(?,?,now())");  
            ps.setInt(1, cm.getClientId());
            ps.setInt(2, cm.getVinId()); 
            status = ps.executeUpdate();             
              
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return status;
	}
	public static Client getLastClient() {
		Client c = new Client();
		try{  
			Connection con = DBUtil.getConnection(); 
            PreparedStatement ps=con.prepareStatement("select id from client order by id desc limit 1");   
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                c.setId(rs.getInt(1));  
            }  
            //con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        } 
		return c;
	}
	
	public static List<Client> getCommandeConfirmation() {
		List<Client> cc = new ArrayList<Client>();
		try {
			Connection con = DBUtil.getConnection(); 
            PreparedStatement ps=con.prepareStatement("SELECT t1.*, t2.*, t3.description FROM commande t1, client t2, vin t3 WHERE t2.id = t1.ClientId AND t1.vinId = t3.id order by t1.id desc limit 1");   
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
            	Client cl = new Client();
            	cl.setId(rs.getInt(1));
            	cl.setNom(rs.getString(7));
            	cl.setPrenom(rs.getString(6));
            	cl.setAdresse(rs.getString(9));
            	cl.setTelephone(rs.getString(10));
            	cl.setDescription(rs.getString(11));
            	cl.setTime(rs.getString(4));
            	
            	cc.add(cl);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cc;
	}
	
	public static boolean checkClient(int id, String prenom, String nom) {
		boolean st = false;
		
		try {
			Connection con = DBUtil.getConnection(); 
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM client WHERE id =? and prenom =? and nom =?");
			ps.setInt(1, id);
			ps.setString(2, prenom);
			ps.setString(3, nom);
			
			ResultSet rs =ps.executeQuery();
	        st = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return st;
	}
	
	public static List<Commande> getAllCommandes() {
		List<Commande> cc = new ArrayList<Commande>();
		try{  // try to select all the data from database table client, if success then add all the data to ArrayList clientList
			 Connection con = DBUtil.getConnection(); //Define the sql connection class variable to connect with database and Call getConnection method in DBUtil class where connection established with database 
	            PreparedStatement ps=con.prepareStatement("select * from commande LEFT JOIN client ON commande.ClientId= client.id INNER JOIN vin ON commande.vinid = vin.id order by commande.id");  // Select all the data from client table and Creates a PreparedStatement object for sending parameterized SQL statements to the database
	            ResultSet rs=ps.executeQuery();  // Keep the data in database resultset and execute the query
	            while(rs.next()){ //if the resultset has value then move the cursor to next  
	            	Commande c = new Commande(); //Create Client objete to set and get the Data From Client Model
	            	c.setId(rs.getInt(1));
	            	c.setDateHeure(rs.getString(4));
	            	c.setPrenom(rs.getString(6));
	            	c.setNom(rs.getString(7));
	            	c.setAddress(rs.getString(9));
	            	c.setTelephone(rs.getString(10));
	            	c.setDescription(rs.getString(12));
	                
	            	cc.add(c);  //add the value to the list
	            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cc;
	}
	
}
