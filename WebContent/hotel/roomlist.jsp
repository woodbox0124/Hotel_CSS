<%@page import="com.dto.HotelDTO"%>
<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dto.RoomDTO"%>
<%@ page import="java.util.List"%>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<!-- 글꼴 CSS 시작-->
<link rel="stylesheet" type="text/css" href="assets/css/font.css">
<link rel="stylesheet" type="text/css" href="assets/css/default.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<!-- 글꼴 CSS 끝-->
<style type="text/css">
* {
	font-family: 'twayair', 'Roboto', 'sans-serif' !important;
}
.cards {
	width: 1200px;
	height:600px;
	margin:0 auto;
	
}

.cards .card {
	width: 450px;
	height: 500px;
	margin: 30px;
	float:left;
	
}

#aa{
	margin:0 auto;
	width:1020px;
	height:100%;
}
img {
	width: 100%;
	height: 100%;
}
#wrapper{
	width:100%;
	
}
#resv{
    font-size: 20px;
    position: absolute;
    right: 10px;
    bottom: 14px;
    color:#000;
}

</style>
<script type="text/javascript">

	var bDisplay = true;
    function doDisplay() {
        var con = document.getElementById("myDIV");
        if(con.style.display == 'block'){
            con.style.display = 'none';
        }else{
            con.style.display = 'block';
        }
    }  	

</script>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>
	<div id="wrapper">
	<div class="cards">
	<div id="aa">
		<% 
	String hotelname = (String)session.getAttribute("hotelname");
	String checkin = (String)session.getAttribute("checkin");
	String checkout = (String)session.getAttribute("checkout");
	String guest = (String)session.getAttribute("guest");
	String location = (String)session.getAttribute("location");
	System.out.println(checkin+"list checkin");
	
	MemberDTO dto2 = (MemberDTO)session.getAttribute("login");
	String u_id = dto2.getU_id();
	


List<RoomDTO> list = (List<RoomDTO>)request.getAttribute("roomlist");
List<HotelDTO> list2 = (List<HotelDTO>)request.getAttribute("hotel");
for(int i=0; i<list.size(); i++){
	RoomDTO dto = list.get(i);
	
	String seq = dto.getSeq();
	String name = dto.getName();
	String hotelseq = dto.getHotelseq();
	int price = dto.getPrice();
	int max_guest = dto.getMax_guest();
	String room_img = dto.getRoom_img();
	String room_img_real = dto.getRoom_img_real();
	
	request.setAttribute("list", list);
%>
		<div class="card">
		
			<img src="images/room/<%= room_img %>.jpg" class="card-img-top"
				alt="...">
			<div class="card-body">
				<h5 class="card-title"><%= name %></h5>
				<p class="card-text">
					<span id="price">가격 <%= price %></span>
				</p>

				<a href="RoomReservServlet?u_id=<%=u_id %>&checkin=<%=checkin%>
				&checkout=<%=checkout%>&guest=<%=guest%>&hotelseq=<%=hotelseq%>&hotelname=<%=hotelname%>
				&roomseq=<%=seq%>&price=<%=price%>&location=<%=location%>&name=<%=name%>" id="resv">지금예약</a>
				<ul>
					<li><a href="RoomInfoServlet?seq=<%=seq%>"
						style="color: black">객실 정보 자세히보기</a><br>
				</ul>
			</div>
		</div>

		<%} %>
		</div>
</div>		
</div><!-- end cards  -->
<jsp:include page="footer.jsp" flush="true"></jsp:include>
