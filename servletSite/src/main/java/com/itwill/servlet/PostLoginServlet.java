package com.itwill.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/post_login")
public class PostLoginServlet extends HttpServlet {
	/*
	 * GET,POST요청에의해 실행되는 메쏘드
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>호갱님죄송합니다.[잘못된요청방식(405)]</h3>");
		out.println("<a href='05-02.login_post.html'>로그인</a>");
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		/*
		 * 1.요청시 전송되는 파라메타받기
		 *   -파라메타이름은 input_element의 name속성의 값
		 *   <form action="get_login" method="get">
		 *		아이디:<input type="text" name="id"><br/>
		 *		패에쓰:<input type="password" name="pass"><br/><br/>
		 *	 </form>
		 */
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		
		/*
		 * 2.서비스 객체를 사용해서 업무(로그인실행)
		 */
		/*
		 ------------
		   id | pass
		 ------------
		 xxxx | 1111
		 yyyy | 2222
		 */
		boolean isMember1=id.equals("xxxx") && pass.equals("1111");
		boolean isMember2=id.equals("yyyy") && pass.equals("2222");
		/*
		 * 3.클라이언트로 출력
		 */
		out.println("<h1>GET 로그인결과</h1><hr>");
		if(isMember1 || isMember2) {
			out.println("<h3>"+id+"님 로그인성공</h3>");
			out.println("<a href='index.html'>메인으로</a>");
		}else {
			out.println("<h3>"+id+"님 로그인실패</h3>");
			out.println("<a href='05-02.login_post.html'>다시</a>");
		}
		
		
		
	}

}
