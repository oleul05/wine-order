package com.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.dao.OrderDaoImpl;
import com.order.model.Vin;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vin> allVin = OrderDaoImpl.getAllVin(); //get All the Client list From DAO(Data Access Object) here DAO name OrderDaoImpl
        
        request.setAttribute("allVin", allVin); //pass the list value to jsp
        
        request.getRequestDispatcher("Menu.jsp").include(request, response); // set the page for the MenuServlet Servlet
	}

}
