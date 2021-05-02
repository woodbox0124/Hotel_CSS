package com.controller.hotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.HotelDTO;
import com.dto.PageDTO;
import com.service.HotelService;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 리스트 화
				String curPage = request.getParameter("curPage");//현재 페이지 얻기
				if(curPage==null)curPage = "1";
				
		String location = request.getParameter("location");
		HotelService service = new HotelService();
		PageDTO pDTO = null;
		System.out.println(location);
		System.out.println(pDTO);
	    List<HotelDTO> list =null;
	    
	    String checkin = request.getParameter("date1"); 
		  String checkout =request.getParameter("date2"); 
		  String guest = request.getParameter("guest");

		  if(location!="") { 
		  pDTO = service.hotelList1(Integer.parseInt(curPage), location); 
		  }else {
		  pDTO = service.hotelList1(Integer.parseInt(curPage));
		  } 
		  request.setAttribute("pDTO", pDTO);
		  request.setAttribute("location", location);
		  System.out.println("pDTO"+pDTO);
		  System.out.println("location"+location);
		  
		  HttpSession session = request.getSession(); 
		  session.setAttribute("checkin",checkin); 
		  session.setAttribute("checkout", checkout);
		  session.setAttribute("location", location); 
		  session.setAttribute("guest",guest);
        
		
		
		request.setAttribute("hotel", list);

		RequestDispatcher dis = request.getRequestDispatcher("hotelList.jsp");
		dis.forward(request, response);       
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
