package com.order.Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static Connection conn; //Define the sql connection class variable to connect with database

	public static Connection getConnection() {
		if (conn != null) //if not connected then return null
			return conn;

		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties"); // Get all the database and information from db.properties file which resides in root src directory such driver name(in my case MySQL), database name, database location/url, database password  
		Properties properties = new Properties(); //persistent set of properties, loaded from inputStream(db.properties file)
		try {
			properties.load(inputStream);
			String driver = properties.getProperty("driver"); //get the JDBC MySQL driver from db.properties here com.mysql.jdbc.Driver 
			String url = properties.getProperty("url"); // get the url from db.properties here jdbc:mysql://localhost:3306/winesite
			String user = properties.getProperty("user"); // get the username from db.properties  here root
			String password = "root"; // get the password from db.properties here root
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password); // make the connection
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConnection(Connection toBeClosed) { //Close the connection
		if (toBeClosed == null)
			return;
		try {
			toBeClosed.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}