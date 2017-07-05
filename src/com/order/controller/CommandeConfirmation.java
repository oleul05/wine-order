package com.order.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.dao.OrderDaoImpl;
import com.order.model.Client;
import com.order.model.Commande;

/**
 * Servlet implementation class CommandeConfirmation
 */
@WebServlet("/CommandeConfirmation") //Servlet name after confirming the order
public class CommandeConfirmation extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) // doget method uses for only show the page
			throws ServletException, IOException {

		List<Client> cl = OrderDaoImpl.getCommandeConfirmation(); // Get the value who successfully make an order, it's call the getCommandeConfirmation in OrderDaoImpl class

		request.setAttribute("cl", cl); // set the value to send the value in front end(jsp)

		request.getRequestDispatcher("CommandeConfirmation.jsp").include(request, response); //set the jsp page for this servlet
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) //doPost method is used for submit the existing client order form
			throws ServletException, IOException {
		response.setContentType("text/html"); // set content type for servlet and jsp
		PrintWriter out = response.getWriter(); // write text in servlet

		int retId 	= Integer.parseInt(String.valueOf(request.getParameter("txtRetId"))); //get the value of txtRetId from form input field which name is txtRetId and convert it to int because in database commade id is int type so when you insert the data from form to database it should match with it's type
		String retPrenom = request.getParameter("txtRetPrenom"); ////get the value of txtRetPrenom from form input field which name is txtRetPrenom input name should be same as with getparameter name
		String retNom = request.getParameter("txtRetNom");
		int retVin 		= Integer.parseInt(String.valueOf(request.getParameter("txtRetVin")));
		
		
		if(OrderDaoImpl.checkClient(retId, retPrenom, retNom)) { // call the checkClient method in OrderDaoImpl class. Where we check the txtRetId, txtRetPrenom, txtRetNom exist in data base and id match with prenom and nom if match then 
			Commande cmd = new Commande(); // Create an object for Commande model where we set the value for the above
			
			cmd.setClientId(retId); // set the form value to the model
			cmd.setVinId(retVin);
			
			OrderDaoImpl.saveCommande(cmd); // call the saveCommande method in OrderDaoImpl class
			
			response.sendRedirect("commandeConfirmation"); // If the form submit successfully then redirect the page to commandeConfirmation url.
		} else {
			out.println("Id doesn't exist or doesn't match with prenom or nom");
			response.sendRedirect("commande"); // otherwise redirect the page to commande
		}
		
		
	}

}
