package com.controller.reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.ResvMyDTO;
import com.service.ResvService;


@WebServlet("/ResvMyServlet")
public class ResvMyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null; //이동할 페이지
		
		//2. 
		// 사용자 id를 꺼내 sevice.mypage(id)이용 DB에서 데이터를 다시 가져오기
		if(dto!=null) {//로그인 정보가 있는 경우
			nextPage = "resvMy.jsp";
			String u_id = dto.getU_id();
			System.out.println(u_id);
			ResvService service = new ResvService();
			
		List<ResvMyDTO> list= service.resvMy(u_id);
		for (ResvMyDTO resvDTO : list) {
			System.out.println(resvDTO);
		}
		request.setAttribute("resvMy", list);
		}else {//로그인이 안된 경우
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");			
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
