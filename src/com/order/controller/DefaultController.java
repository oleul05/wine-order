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


/**
 * Servlet implementation class DefaultController
 */
@WebServlet("/DefaultController")
public class DefaultController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();                   
        
        List<Client> list = OrderDaoImpl.getAllClient(); //get All the Client list From DAO(Data Access Object) here DAO name OrderDaoImpl
        
        request.setAttribute("list", list); //pass the list value to jsp
        
        request.getRequestDispatcher("Clients.jsp").include(request, response); //set the jsp page
        
	}

}
