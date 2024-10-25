package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserRemoveActionController implements Controller{
	private UserService userService;
	public UserRemoveActionController() {
		try {
			userService=new UserServiceImpl();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/***************로그인체크[loginCheck.jspf]***********/
		HttpSession session=request.getSession();
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId==null) {
			return "redirect:user_login_form.do";
		}
		/*****************************************/
		 /*
		0.login 여부체크
		1.GET방식이면 user_main.do redirection
		2.요청객체인코딩설정
		3.세션에있는 sUserId를 사용해서 UserService.remove(sUserId) 메쏘드호출
		4.성공: redirect --> user_main.do
		  실패: forward  --> user_error.jsp 
		  */
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				return "redirect:user_main.do";		
			}
			userService.remove(sUserId);
			session.invalidate();
			return "redirect:user_main.do";
		}catch (Exception e) {
			e.printStackTrace();
			return "forward:/WEB-INF/views/user_error.jsp";
		}
	}

}