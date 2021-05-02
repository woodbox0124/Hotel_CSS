package com.controller.hotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.RoomDTO;
import com.dto.RoomInfoDTO;
import com.service.RoomService;

/**
 * Servlet implementation class RoomInfoServlet
 */
@WebServlet("/RoomInfoServlet")
public class RoomInfoServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String seq=request.getParameter("seq");
		System.out.println("시퀀스번호======"+seq);
		RoomService service=new RoomService();
		List<RoomInfoDTO> list=service.roomInfo(seq); //룸인포 리스트
		List<RoomDTO> list2=service.roomList2(seq); //룸 리스트 (룸seq번호로 찾음)
		System.out.println("룸인포===="+list);
		
		request.setAttribute("roominfo", list);
		request.setAttribute("roomlist", list2);
		
		System.out.println("룸상세정보"+list);
		System.out.println("룸시퀀스받아온 룸리스트정보"+list2);
		
		RequestDispatcher dis = request.getRequestDispatcher("hotel/roomdetail.jsp");
		dis.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
