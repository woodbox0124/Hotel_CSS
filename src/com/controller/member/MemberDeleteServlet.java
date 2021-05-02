package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String u_id = request.getParameter("u_id");
		System.out.println(u_id);
		String nextPage = null;
		if (dto!=null) {
			MemberService service = new MemberService();
			int num = service.memberDelete(u_id);
			System.out.println(num);
			nextPage = "MainServlet";				
			session.removeAttribute("login");	
			session.setAttribute("mesg", "회원 탈퇴가 완료되었습니다.");			
		} else {
			session.setAttribute("mesg", "로그인 후 이용바랍니다.");
			nextPage = "LoginUIServlet";
		}		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
