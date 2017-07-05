package com.order.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.dao.OrderDaoImpl;
import com.order.model.Client;
import com.order.model.Commande;
import com.order.model.Vin;

/**
 * Servlet implementation class Commande
 */
@WebServlet("/Commande")
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		List<Vin> allVin = OrderDaoImpl.getAllVin(); // get All the Client list From DAO(Data Access Object) here DAO name OrderDaoImpl

		request.setAttribute("allVin", allVin); // pass the list value to jsp

		request.getRequestDispatcher("Commande.jsp").include(request, response); // set the jsp page for this servlet
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String prenom = request.getParameter("txtPrenom"); // get the form value with input name txtPrenom
		String nom = request.getParameter("txtNom");
		String naissance = request.getParameter("txtNaissance");
		String adresse = request.getParameter("txtAdresse");
		String telephone = request.getParameter("txtTelephone");

		Client c = new Client(); // Create an object for client model

		c.setPrenom(prenom); // set the value (which we get from form) to the model
		c.setNom(nom);
		c.setNaissance(naissance);
		c.setAdresse(adresse);
		c.setTelephone(telephone);

		int status = OrderDaoImpl.save(c); // Call the save method

		if (status > 0) { // if save method execute successfully then the following code will execute
			Client cl = OrderDaoImpl.getLastClient(); //put the getLastClient value to the Client class object cl
			request.setAttribute("cl", cl); //set the value which we get from getLastClient method in cl objet

			int clientId = cl.getId(); // get the id from cl object
			int vinId = Integer.parseInt(String.valueOf(request.getParameter("txtVin")));// get the vinid from form

			Commande cmd = new Commande(); // Create commande class object
			cmd.setClientId(clientId); // set the client id in commande object
			cmd.setVinId(vinId);

			OrderDaoImpl.saveCommande(cmd); // call the saveCommande method and pass the cmd objet as parameter

			response.sendRedirect("commandeConfirmation"); // redirect the page to the commandeConfirmation url
		} else { // if save method unable to save then show the following message in the servlet
			out.println("Sorry! unable to save record");
		}

	}

}
