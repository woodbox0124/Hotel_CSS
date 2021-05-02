<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MemberDTO dto = (MemberDTO) session.getAttribute("login");
String u_id = dto.getU_id();
String u_pw = dto.getU_pw();
String u_name = dto.getU_name();
String u_Phone = dto.getU_phone();
String u_email = dto.getU_email();
%>

<!DOCTYPE HTML>

<!--
	Aerial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets/css/font.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<!-- 글꼴 -->
<!-- table css 시작 -->
<style type="text/css">
*{
	font-family: 'twayair', 'Roboto', 'sans-serif';
}

#container {
	position: relative;
	top: 125px;
	width: 61%;
	top: 129px;
	left: 284px;
}

input {
	border-top: none;
	border-left: none;
	border-right: none;
	border-bottom: 2px solid black;
}

#button {
	position: relative;
	top: 225px;
	width: 250px;
	height: 118px;
	left: 44%;
	text-align: center;
}

#tbody {
	position: relative;
}

#submit {
	margin-bottom: 10px;
}

h1 {
	width: 46%;
	height: 162px;
	text-align: center;
	position: relative;
	left: 42px;
}

#header {
	width: 96%;
	height: 780px;
	position: relative;
	left: 5px;
}

a {
	text-decoration: none
}

 #pw {
	font-family : 'Source Sans Pro', sans-serif;
} 
.update{
		width: 30%;
	}

</style>
<!-- jQuery 시작 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
 $(function() {
	 $("#delete").click(function() {
		 var u_id = $(this).attr("data-xxx");
		 console.log(u_id);
		 location.href="MemberDeleteServlet?u_id="+u_id;
	 })	
});
</script>
<!-- jQuery 끝-->
<!-- table css 끝 -->
<title>MyPage</title>
<meta charset="utf-8">
<!-- main배경 css -->
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap-4.1.2/bootstrap.min.css">

<!-- main배경 css 끝 -->
<%
	String mesg = (String) session.getAttribute("mesg");
if (mesg != null) {
%>
<script type="text/javascript">
     alert('<%=mesg%>
	');
</script>
<%
	session.removeAttribute("mesg");
}
%>
</head>
<body class="is-preload">
	<jsp:include page="menu_mypage.jsp"></jsp:include>
	<div id="overlay"></div>
	<div id="main">
		<nav class="hotelcol-1"></nav>
		<!-- Header -->
		<div id="header">
			<form action="MemberUpdateServlet">
				<table class="container" id="container">
					<tbody id="tbody">
						<tr>
							<td colspan="2">

								<h1><%=u_name%>님의 정보
								</h1>

							</td>
						</tr>

						<tr id="u_id">
							<td>아이디</td>
							<td><%=u_id%><input type="hidden" value="<%=u_id%>"
								name="u_id"></td>
						</tr>
						<tr id="u_name">
							<td>이름</td>
							<td><%=u_name%><input type="hidden" value="<%=u_name%>"
								name="u_name"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" class="update"id="pw" value="<%=u_pw%>"
								name="u_pw"></td>
						</tr>
						<tr>
							<td>비밀번호 확인</td>
							<td><input type="password" class="update" id="pw"></td>
						</tr>

						<tr id="u_phone">
							<td>전화번호</td>
							<td><input type="text" class="update" value="<%=u_Phone%>" name="u_phone"></td>
						</tr>

						<tr id="u_email">

							<td>e-mail</td>
							<td><input type="text" class="update" value="<%=u_email%>"
								name="u_email"></td>

						</tr>

					</tbody>
				</table>
			</form>

			<div id="button">
				<button id="submit" type="submit" class="btn btn-outline-primary">회원정보
					수정하기</button>
				<br>

				<button id="delete" data-xxx="<%=u_id%>"
					class="btn btn-outline-primary">회원 탈퇴하기</button>
			</div>
		</div>
		<script>
			window.onload = function() {
				document.body.classList.remove('is-preload');
			}
			window.ontouchmove = function() {
				return false;
			}
			window.onorientationchange = function() {
				document.body.scrollTop = 0;
			}
		</script>
	</div>
</body>
</html>