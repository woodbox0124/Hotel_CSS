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


@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("utf-8");
     HttpSession session = request.getSession();
	//데이터 파싱 후 memberDTO생성
		//1. sysout
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		String u_name = request.getParameter("u_name");
		String u_email = request.getParameter("u_email");
		String u_phone = request.getParameter("u_phone");
		MemberDTO dto = new MemberDTO();
		dto.setU_id(u_id);
		dto.setU_pw(u_pw);
		dto.setU_name(u_name);
		dto.setU_email(u_email);
		dto.setU_phone(u_phone);		
		System.out.println("파싱데이터======"+dto);
		
	//SERVICE.memberAdd()에  dto  전송  db 에 insert(SERVICE->DAO이용->MAPPER 이용)
		MemberService service = new MemberService();
	      int n = service.mamberAdd(dto);
	//2. num, 디벨로퍼에서 확인
		System.out.println(n);
		String nextPage = null;
	//이후  SESSION에 회원가입 성공여부 로그인 정보 저장(다음 줄 코드임) 
		if(n==1){		
		session.setAttribute("login", dto);
		session.setAttribute("mesg", "회원가입성공");
		}else {
	    session.setAttribute("mesg", "비정상적인 접근입니다.");	
		}
	//메인화면으로 이동//추후 설명  //3.sysout 세션의 데이터
	    RequestDispatcher dis = request.getRequestDispatcher("MainServlet");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
