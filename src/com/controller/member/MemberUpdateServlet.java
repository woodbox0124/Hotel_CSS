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


@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String nextPage = null;
	    if (dto!=null) {
	    	String u_id = request.getParameter("u_id");
	    	String u_name = request.getParameter("u_name");
			String u_pw = request.getParameter("u_pw");
			String u_phone = request.getParameter("u_phone");
			String u_email = request.getParameter("u_email");			
			MemberDTO dto1 = new MemberDTO();
			dto1.setU_id(u_id);
			dto1.setU_pw(u_pw);
			dto1.setU_name(u_name);
			dto1.setU_phone(u_phone);
			dto1.setU_email(u_email);		
			System.out.println(dto1);
			MemberService service = new MemberService();
			int n = service.memberUpdate(dto1);
			session.setAttribute("login", dto1);
			session.setAttribute("mesg", "회원 정보 수정 완료");
			nextPage = "mypage.jsp";
		} else {
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인 후 이용하시길 바랍니다.");
		}
		  RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		  dis.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
