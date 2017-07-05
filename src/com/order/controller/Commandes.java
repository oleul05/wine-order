package com.order.controller;

import java.io.IOException;
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
 * Servlet implementation class Commandes
 */
@WebServlet("/Commandes")
public class Commandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Commande> cl = OrderDaoImpl.getAllCommandes(); // Get all the client who made order(call the getAllCommande method from OrderDaoImpl class )

		request.setAttribute("cl", cl); //set the value to send the value in front end

		request.getRequestDispatcher("Commandes.jsp").include(request, response); // set the jsp page for this servlet
	}

}
