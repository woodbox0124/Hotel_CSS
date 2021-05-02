<%@page import="java.text.DateFormat"%>
<%@page import="com.dto.ResvMyDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.ResvDTO"%>
<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 글꼴 CSS 시작-->
<link rel="stylesheet" type="text/css" href="assets/css/font.css">
<link rel="stylesheet" type="text/css" href="assets/css/default.css">
<!-- 글꼴 CSS 끝-->
<!-- table CSS 시작 -->
<style type="text/css">
* {
	font-family: 'twayair', 'Roboto', 'sans-serif' !important;
}

form {
	border: 3px solid;
	position: relative;
	top: 67px;
	width: 99%;
	left: 10px;
	height: 255px;
}

h1 {
	border: 3px solid;
}

#test {
	border: 3px solid;
}
</style>
<!-- jQuery 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
 $(function() {
     $(".cancel").click(function() {
        var seq = $(this).attr("data-xxx");
        if(confirm("취소하시겠습니까?")){
        	location.href="ResvCancle?seq="+seq;
          }
     })   
 });
</script>
<!-- jQuery 끝-->
<title>예약확인</title>
<meta charset="utf-8">
<%
   String mesg = (String)session.getAttribute("mesg");
   if(mesg!=null){
%>
<script type="text/javascript">
     alert('<%=mesg%>');
   </script>
<%
session.removeAttribute("mesg");
   }
%>
</head>

<%
	MemberDTO mdto = (MemberDTO)session.getAttribute("login");
    String mu_id = mdto.getU_id();
    String mu_name = mdto.getU_name();
%>


		
				<form action="MemberUpdateServlet">
					<table class="container">
						<tbody>
							<tr>
								<td colspan="2">
									<center>
										<h1><%=mu_name%>님의 예약정보</h1>
									</center>
								</td>
							</tr>
							<tr id="test">

								<td>예약번호</td>
								<td>평점</td>
								<td>호텔이름</td>
								<td>룸 종류</td>
								<td>체크인 날짜</td>
								<td>체크아웃 날짜</td>
								<td>예약날짜</td>
								<td>인원 수</td>
								<td>가격</td>
								<td>수정</td>
								<td>취소</td>
								
							</tr>
							<% 		List<ResvMyDTO> list = (List<ResvMyDTO>)request.getAttribute("resvMy");
	for(int i = 0; i <list.size();i++)
	{
		ResvMyDTO dto = list.get(i);
		
		int seq = dto.getSeq();
		double rating = dto.getRating();
		String hotelname = dto.getHotelname();
		String addr = dto.getAddr();
		String roomname = dto.getRoomname();
		String checkin = dto.getCheckin();
		String checkout = dto.getCheckout();
		String resvdate = dto.getResvdate();
		int guest = dto.getGuest();
		int price = dto.getPrice();
		int cancel = dto.getCancel();
		
		if(cancel ==  0){					
	%>

							<tr>

								<td><%= seq %></td>
								<td><%= rating %></td>
								<td><%=hotelname %></td>
								<td><%= roomname %></td>
								<td><%= checkin %></td>
								<td><%= checkout %></td>
								<td><%= resvdate %></td>
								<td><%= guest %></td>
								<td><%= price %></td>
							
								<td>
		<button type="button" class="btn btn-outline-primary" style="margin-bottom: 15px">수정</button>
								</td>
								<td>
								<button type="button" class="btn btn-outline-primary cancel"
									style="margin-bottom: 15px" data-xxx="<%=seq%>">취소</button>
								</td>
							</tr>
			<%}
	}%>
						</tbody>
					</table>
				</form>