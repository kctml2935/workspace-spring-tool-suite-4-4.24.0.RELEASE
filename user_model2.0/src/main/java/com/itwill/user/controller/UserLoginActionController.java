package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLoginActionController implements Controller {
	private UserService userService;
	public UserLoginActionController(){
		try {
			userService=new UserServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/*
		0  . GET방식요청일때 user_login_form.jsp로 redirection
		1  . 요청객체 인코딩설정
		2  . 파라메타 받기
		3  . UserService객체생성
		4  . UserService.login() 메쏘드실행
		*/
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				return "redirect:user_login_form.do";
			}
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			/*
			 * 회원로그인
			 * 
			 * 0:아이디존재안함
			 * 1:패쓰워드 불일치
			 * 2:로그인성공(세션)
			 */
			int result = userService.login(userId, password);
			if (result == 0) {
				//0:아이디존재안함
				String msg1=userId+" 는 존재하지않는 아이디입니다.";
				request.setAttribute("msg1", msg1);
				request.setAttribute("fuser",new User(userId,password,"","" ));
				return "forward:/WEB-INF/views/user_login_form.jsp";
			} else if (result == 1) {
				//1:패쓰워드 불일치
				String msg2="패쓰워드가 일치하지않습니다.";
				request.setAttribute("msg2", msg2);
				request.setAttribute("fuser",new User(userId,password,"","" ));
				return "forward:/WEB-INF/views/user_login_form.jsp";
			} else if (result == 2) {
				//2:로그인성공(세션)
				HttpSession session = request.getSession();
				session.setAttribute("sUserId", userId);
				return "redirect:user_main.do";
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return "";
	}

}