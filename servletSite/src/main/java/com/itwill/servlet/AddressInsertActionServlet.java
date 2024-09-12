package com.itwill.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;
@WebServlet("/address_insert_action")
public class AddressInsertActionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("address_main");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/*
			 * 0.요청객체encoding설정
			 * 1.파라메타받기
			 * 2.AddressService객체생성
			 * 3.AddressService.addressWrite()메쏘드실행
			 * 4.address_list 로 redirection
			 */
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String addr = request.getParameter("address");
			if(name==null || phone==null || addr==null || name.equals("") || phone.equals("") || addr.equals("")) {
				response.sendRedirect("address_list");
				return;
			}
			
			
			AddressService addressService = new AddressService();
			addressService.addressWrite(new Address(name,phone,addr));
			response.sendRedirect("address_list");
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("address_error");
		}
	}
}