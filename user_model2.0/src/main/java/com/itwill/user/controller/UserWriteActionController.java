package com.itwill.user.controller;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserWriteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		/*
		0  . GET방식요청일때 user_main.do로 redirection
		1  . 요청객체 인코딩설정
	    2  . 파라메타 받기
	    3  . UserService객체생성
	    4  . UserService.create() 메쏘드실행
	    5-1. 아이디중복이면 user_write_form.jsp forward 
	    5-2. 가입성공이면   user_login_form.do 로 redierction
	*/
	String forwardPath="";
	try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:user_main.do";
				return forwardPath;
			}
			
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			User newUser=new User(userId,password,name,email);
			
			UserService userService=new UserServiceImpl();
			int result=userService.create(newUser);
			if(result ==-1){
				/*##############아이디중복##############*/
				String msg=userId+" 는 이미존재하는 아이디입니다.";
				request.setAttribute("msg", msg);
				request.setAttribute("fuser", newUser);
				forwardPath="forward:/WEB-INF/views/user_write_form.jsp";
				return forwardPath;
			}else if(result ==1){
				//가입성공
				forwardPath="redirect:user_login_form.do";
				return forwardPath;
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
			return forwardPath;
		}	
		return "";
	}//end method
}//end class