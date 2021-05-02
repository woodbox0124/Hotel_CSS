<%@page import="java.io.Console"%>
<%@ page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<head>
<meta charset="UTF-8">
<title>예약</title>
<%
String hotelname = request.getParameter("hotelname");
String hotelseq = request.getParameter("hotelseq");
String u_id = request.getParameter("u_id");
String roomseq = request.getParameter("roomseq");
String checkin = request.getParameter("checkin");
String checkout = request.getParameter("checkout");
int price = Integer.parseInt(request.getParameter("price"));
String guest = request.getParameter("guest");
String u_phone = request.getParameter("u_phone");
String location = request.getParameter("location");
String name = request.getParameter("name");

MemberDTO dto = (MemberDTO) session.getAttribute("login");

String phone = dto.getU_phone();

System.out.println("roomjsp : " + checkin + "\t" + checkout + "\t" + guest + "\t" + hotelseq + "\t" + roomseq +"\t" + price + "\t" + u_id + "\t" + phone) ;
%>
<!-- RoomReserv CSS 시작 -->
<link rel="stylesheet" type="text/css" href="assets/css/RoomReserv.css">
<!-- RoomReserv CSS 끝 -->
</head>
<body>
	<a href="MainServlet" class="main">Hotel UnderBar</a>
	<form action="KakaopayServlet">	
	<!-- kakao pay 값 전달을 위한 코드 -->
	<input type="hidden" name="roomseq" value="<%=roomseq%>">
	<input type="hidden" name="location" value="<%=location%>">
	<input type="hidden" name="hotelseq" value="<%=hotelseq%>">
	<input type="hidden" name="guest" value="<%=guest%>">
	<input type="hidden" name="checkin" value="<%=checkin%>">
	<input type="hidden" name="checkout" value="<%=checkout%>">
	<input type="hidden" name="u_id" value="<%=u_id%>">
	<input type="hidden" name="name" value="<%=name%>">
	<input type="hidden" name="phone" value="<%=phone%>">
	<input type="hidden" name="price" value="<%=price%>">	
		<div class="list-caption">
		<p class="hotelseq" style="text-align: center;">
				호텔이름 : <%=hotelname%></p> <br>
				
			<div class="room">
				객실 이름 : <%=name%><br>
				인원수 : <%=guest%><br> 
				<p class="date"><%=checkin%>
					~
					<%=checkout%></p><br> 
					
				예약자 이름 : <%=u_id%><br> 
				예약자 전화번호 : <input class="number" type="text"
					value="<%=phone%>"> <br><br>
					요금 : <%=price%><br>					
			</div>
			<p><button class="button">결제하기</button></p>
		</div>
	</form>
