package com.controller.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/payFail")
public class PayFail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String guest = request.getParameter("guest");
		String location = request.getParameter("location");
		
		HttpSession session = request.getSession();
		session.setAttribute("checkin", checkin);
		session.setAttribute("checkout", checkout);
		session.setAttribute("guest", guest);
		session.setAttribute("location", location);
		System.out.println("fail : " + checkin + "\t" + checkout + "\t" + guest + "\t" + location);
		
		  RequestDispatcher dis = request.getRequestDispatcher("HotelSearchServlet");
		  dis.forward(request, response);
		 
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
