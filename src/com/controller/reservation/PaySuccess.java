package com.controller.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ResvDTO;
import com.service.ResvService;

import javafx.scene.control.Alert;

@WebServlet("/paySuccess")
public class PaySuccess extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hotelseq = request.getParameter("hotelseq");
		String u_id = request.getParameter("u_id");
		String roomseq = request.getParameter("roomseq");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		int price = Integer.parseInt(request.getParameter("price"));
		String guest = request.getParameter("guest");
		
		ResvDTO dto = new ResvDTO();
		dto.setHotelseq(hotelseq);
		dto.setU_id(u_id);
		dto.setRoomseq(roomseq);
		dto.setCheckin(checkin);
		dto.setCheckout(checkout);
		dto.setPrice(price);
		dto.setGuest(guest);
		System.out.println(dto);
		ResvService service = new ResvService();
		int n = service.resvInsert(dto);
		
		response.sendRedirect("ResvMyServlet");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	
}