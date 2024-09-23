<%@page import="com.itwill.guest.Guest"%>
<%@page import="java.util.Date"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
GET방식이면 guest_main.jsp redirection

	0.요청객체encoding설정
	1.파라메타받기(guest_no,guest_name,guest_email,guest_homepage,guest_title,guest_content)
	 Guest객체생성
	2.GuestService객체생성
	3.GuestService객체 updateGuest(Guest객체) 메쏘드호출
	4.guest_view.jsp로 redirection
*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("guest_list.jsp");
		return;
	}
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("guest_no");
	String name = request.getParameter("guest_name");
	String homepage = request.getParameter("guest_homepage");
	String email = request.getParameter("guest_email");
	String title = request.getParameter("guest_title");
	String content = request.getParameter("guest_content");
	
	Guest guest = new Guest(Integer.parseInt(no), name, null, email, homepage, title, content);
	GuestService guestService = new GuestService();
		
	guestService.guestUpdate(guest);
	
	response.sendRedirect("guest_view.jsp");
%>
