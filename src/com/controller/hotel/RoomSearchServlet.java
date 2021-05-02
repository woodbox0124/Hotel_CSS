package com.controller.hotel;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.RoomDTO;
import com.service.RoomService;

@WebServlet("/RoomSearchServlet")
public class RoomSearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelname = request.getParameter("hotelname");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String place = request.getParameter("place");
		 String seq=request.getParameter("seq");//호텔시퀀스받아오기
			System.out.println("hotelseq"+seq);
		    RoomService service = new RoomService(); 
		   List<RoomDTO> list =service.roomList(seq); 
		   System.out.println("list :" + hotelname + checkin + checkout + place + seq);
		    request.setAttribute("roomlist", list); //해당 호텔의 룸리스트
		    HttpSession session = request.getSession();
		    session.setAttribute("hotelname", hotelname);
		    session.setAttribute("checkin", checkin);
		    session.setAttribute("checkout", checkout);
		    session.setAttribute("place", place);
		    

			RequestDispatcher dis = request.getRequestDispatcher("roomlist.jsp");
			dis.forward(request, response);
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
