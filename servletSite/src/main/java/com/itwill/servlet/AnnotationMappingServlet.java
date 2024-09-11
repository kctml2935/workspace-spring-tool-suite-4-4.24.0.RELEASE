package com.itwill.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * <servlet>
    <description></description>
    <display-name>AnnotationMappingServlet</display-name>
    <servlet-name>AnnotationMappingServlet</servlet-name>
    <servlet-class>com.itwill.servlet.AnnotationMappingServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>AnnotationMappingServlet</servlet-name>
    <url-pattern>/Annotation_Mapping</url-pattern>
  </servlet-mapping>
 */
@WebServlet("/annotation_mapping")
public class AnnotationMappingServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		PrintWriter out=response.getWriter();
		
		
	}

}
