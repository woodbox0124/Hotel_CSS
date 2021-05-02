package com.controller.reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RoomReservServlet
 */
@WebServlet("/RoomReservServlet")
public class RoomReservServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hotelname = request.getParameter("hotelname");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String guest = request.getParameter("guest");
		
		String hotelseq = request.getParameter("hotelseq");
		String roomseq = request.getParameter("roomseq");
		int price = Integer.parseInt(request.getParameter("price"));
		String u_id = request.getParameter("u_id");
		String location = request.getParameter("location");
		String name = request.getParameter("name");
		System.out.println("roomservlet : " + checkin + "\t" + checkout + "\t" + guest + "\t" + hotelseq + "\t" + roomseq +"\t" + price + "\t" + u_id + "\t" + location + "\t" + name);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("RoomReserv.jsp");
		dis.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
