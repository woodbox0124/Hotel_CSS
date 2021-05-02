<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">

#menu_bar {
	font-family: 'twayair', 'Roboto', 'sans-serif' !important;
	font-size: 17px;
	font-weight: bold;
	position: relative;
	left: 2px;
	text-decoration: none
}

#a_login {
	font-size: 17px;
	font-weight: bold;
}
.a{
	color: blue;
}
</style>
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("login");

if (dto != null) {
	String u_id = dto.getU_id();
%>
<div id=menu_bar>
	<a class="a1"><%=u_id%>님 어서오세요.</a>
    <a href="LogoutServlet" class="a">&nbsp;로그아웃</a>
	<a href="MyPageServlet" class="a">&nbsp;마이페이지&nbsp;</a>
	<a href="ResvMyServlet" class="a">예약 확인</a>
	<%
		} else {
	%>
	<a href="login_register.jsp" class="a" id="a_login">로그인·회원가입</a>


	<%
		} //end if~else
	%>

</div>