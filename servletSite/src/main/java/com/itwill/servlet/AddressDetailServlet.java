package com.itwill.servlet;
import java.io.IOException;
import java.io.PrintWriter;


import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddressDetailServlet
 */
@WebServlet("/address_detail")
public class AddressDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			/*
			 * 요청URL
			 *   http://localhost/addressSite/address_detail?no=1
			 *   http://localhost/addressSite/address_detail?no=2
			 *   http://localhost/addressSite/address_detail?no=3
			 *   http://localhost/addressSite/address_detail?no=4
			 *   http://localhost/addressSite/address_detail?no=5
			 */
			/*
			 * 0.요청객체encoding설정
			 * 1.파라메타받기
			 * 2.AddressService객체생성
			 * 3.AddressService객체 addressDetail(1) 메쏘드호출
			 * 4.Address객체 출력
			 */

			request.setCharacterEncoding("UTF-8");
			String noStr=request.getParameter("no");
			/*
			 null ==> http://localhost/addressSite/address_detail
			 ""   ==> http://localhost/addressSite/address_detail?no=
			 */
			if(noStr==null || noStr.equals("")) {
				response.sendRedirect("address_list");
				return;
			}
			
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>[김경호님 주소록상세보기]</h1><hr>");
			out.println("<div>");
			out.println("	<a href='address_main'>[메인]</a>");
			out.println("	<a href='address_insert_form'>[주소록쓰기폼]</a>");
			out.println("	<a href='address_list'>[주소록리스트]</a>");
			out.println("	<a href='address_delete_action?no=1'>김경호님삭제[GET]</a>");
			out.println("	<a href='address_update_form'>[김경호님 주소록수정폼]</a>");
			out.println("</div>");
			out.println("<p>");
			out.println("	번호:1<br>");
			out.println("	이름:김경호<br>");
			out.println("	전화:123-4568<br>");
			out.println("	주소:경기도 성남시<br>");
			out.println("</p>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}