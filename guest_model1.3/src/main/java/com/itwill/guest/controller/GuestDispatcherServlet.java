package com.itwill.guest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.servlet.DispatcherServlet;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/guest_main","/guest_list",
							"/guest_view","/guest_write_form",
							"/guest_modify_form","/guest_write_action",
							"/guest_remove_action","/guest_modify_action"})
public class GuestDispatcherServlet extends HttpServlet {
	private GuestService guestService;
	public GuestDispatcherServlet() throws Exception{
		guestService = new GuestService();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		<< 요청url(command)>>
		/guest_main 	
		/guest_list			
		/guest_view		
		/guest_write_form	
		/guest_write_action	
		/guest_modify_form	
		/guest_modify_action	
		/guest_remove_action
		 */
		/*
		 * 1. GuestDispatcherServlet이 클라이언트의 요청URI를 사용해서 요청분석
		 */
		String requestURI = request.getRequestURI();
		String contextPath=request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		/*
		 * 2.GuestDispatcherServlet이 클라이언트 요청에따른 비지니스실행[Service객체사용]
		 */
		String forwardPath="";
		if(command.equals("/guest_main")) {
			forwardPath="forward:/WEB-INF/views/guest_main.jsp";
		}else if(command.equals("/guest_list")) {
			try {
				request.setCharacterEncoding("UTF-8");
				List<Guest> guestList=guestService.guestList();
				request.setAttribute("guestList", guestList);
				forwardPath="forward:/WEB-INF/views/guest_list.jsp";
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				
			}
		}else if(command.equals("/guest_view")) {
			try {
				request.setCharacterEncoding("UTF-8");
				String guest_noStr = request.getParameter("guest_no");
				if (guest_noStr == null || guest_noStr.equals("")) {
					forwardPath="redirect:guest_list";
				}else {
					Guest guest = 
							guestService.guestDetail(Integer.parseInt(guest_noStr));
					request.setAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_view.jsp";
				}
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				
			}
		}else if(command.equals("/guest_modify_action")) {
			try {
				if(request.getMethod().equalsIgnoreCase("GET")){
					forwardPath="redirect:guest_main";
				}else {
					String guest_no=request.getParameter("guest_no");
					String guest_name=request.getParameter("guest_name");
					String guest_email=request.getParameter("guest_email");
					String guest_homepage=request.getParameter("guest_homepage");
					String guest_title=request.getParameter("guest_title");
					String guest_content=request.getParameter("guest_content");
					GuestService guestService=new GuestService();
					int rowCount=guestService.guestUpdate(Guest.builder()
											.guestNo(Integer.parseInt(guest_no))
											.guestName(guest_name)
											.guestEmail(guest_email)
											.guestHomepage(guest_homepage)
											.guestTitle(guest_title)
											.guestContent(guest_content)
											.build()
							);
					forwardPath="redirect:guest_view?guest_no="+guest_no;
				}
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}else if(command.equals("/guest_modify_form")) {
			try {
				if(request.getMethod().equalsIgnoreCase("GET")){
					forwardPath="redirect:guest_main";
				}else {
					request.setCharacterEncoding("UTF-8");
					String guest_noStr=request.getParameter("guest_no");
					Guest guest=guestService.guestDetail(Integer.parseInt(guest_noStr));
					request.setAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
				}
			}catch(Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}else if(command.equals("/guest_remove_action")) {
			try {
				if (request.getMethod().equalsIgnoreCase("GET")) {
					forwardPath="redirect:guest_main";
				}else {
					request.setCharacterEncoding("UTF-8");
					String guest_noStr = request.getParameter("guest_no");
					int rowCount = 
							guestService.guestDelete(Integer.parseInt(guest_noStr));
					forwardPath="redirect:guest_list";
				}
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}else if(command.equals("/guest_write_form")) {
			forwardPath="forward:/WEB-INF/views/guest_write_form.jsp";
		}else if(command.equals("/guest_write_action")) {
			try {
				if (request.getMethod().equalsIgnoreCase("GET")) {
					forwardPath = "redirect:guest_main";
				} else {
					String guest_name = request.getParameter("guest_name");
					String guest_email = request.getParameter("guest_email");
					String guest_homepage = request.getParameter("guest_homepage");
					String guest_title = request.getParameter("guest_title");
					String guest_content = request.getParameter("guest_content");

					int guest_no = guestService.guestWrite(Guest.builder().guestName(guest_name).guestEmail(guest_email)
							.guestHomepage(guest_homepage).guestTitle(guest_title).guestContent(guest_content).build());
					forwardPath = "redirect:guest_view?guest_no=" + guest_no;
				}
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
			}
		
		}
			
		
		
		/**********forward or redirect**************************/
		/*
		 forward    --> forward:/WEB-INF/views/guest_xxx.jsp
		 redirect   --> redirect:guest_xxx
		 */
		String[] pathArray=forwardPath.split(":");
		String forwardOrRedirect=pathArray[0];
		String path=pathArray[1];
		if(forwardOrRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}else {
			response.sendRedirect(path);
		}
		/*******************************************************/
	
	}
}