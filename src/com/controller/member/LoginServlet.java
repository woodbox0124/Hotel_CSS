package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		String savepw = request.getParameter("savepw");
		
		//1.id, pass 이용 map 생성 // userid passwd 키
		HashMap<String, String> map = new HashMap<>();
		map.put("u_id", u_id);
		map.put("u_pw", u_pw);
		MemberService service = new MemberService();
		MemberDTO dto = service.login(map);//login 인증
		//Cookie cookie = new Cookie("u_pw", u_pw);
		
		System.out.println(savepw);
		HttpSession session = request.getSession();
		String nextPage=null;//이동페이지 저장
		if(dto!=null) {//회원인 경우
			if (savepw != null) { // 체크박스 체크여부에 따라 쿠키 저장 확인
				Cookie cookie = new Cookie("savepw", u_pw);
				cookie.setMaxAge(60*60*24*7);
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("savepw", u_pw);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		    nextPage="main.jsp"; // MainServlet 요청 데이터 가져와서 출력
		    session.setAttribute("login", dto);	//로그인 정보 저장	
		    }else { //dto==null 회원이 아닌 경우	
		    	int num  = service.idCheck(u_id);//아이디가 일치하지 않을 경우
		    	int num1 = service.pwchk(u_pw);// 비밀번호가 일치하지 않을 경우
		    	
		    	System.out.println("num \t"+num);
				System.out.println("num1 \t"+num1);
				if(num==1 || num1!=0){
					session.setAttribute("mesg", "아이디 및 비밀번호를 확인 하시길 바랍니다.");
				}else if(num==0 && num1==0) {
						session.setAttribute("mesg", "회원가입 후 이용 바랍니다.");						
					}
		           nextPage="LoginUIServlet";				
	     }//end else
		response.sendRedirect(nextPage); //페이지 두개 중 하나로 이동
	  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
