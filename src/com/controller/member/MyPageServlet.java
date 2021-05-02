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


@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 세션에서 로그인 정보 가져옴
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null; //이동할 페이지
		
		//2. 
		// 사용자 id를 꺼내 sevice.mypage(id)이용 DB에서 데이터를 다시 가져오기
		if(dto!=null) {//로그인 정보가 있는 경우
			nextPage = "mypage.jsp";
			String userid = dto.getU_id();
			MemberService service = new MemberService();
		MemberDTO x = service.mypage(userid);
		System.out.println(x);
		session.setAttribute("login", x);//다시 session에 저장	
		}else {//로그인이 안된 경우
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");			
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		//가져온 정보를 다시 세션에 login이라는 키로 저장 후 WebContent/mypage.jsp로 이동
		//=> include / top.jsp, menu.jsp, member/mypage.jsp
		//3. 로그인 정보가 없는 경우  request에 'mesg' '로그인 필요한 작업입니다.' 저장 후
		//로그인 페이지로 이동
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
