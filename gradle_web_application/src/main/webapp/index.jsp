<%@page import="com.itwill.test.Test"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleheet" type="text/css" href="main.css">
<script type="text/javascript" src="main.js">/</script>
</head>
<body>
<h1>Hello Gradle!! [JSP]</h1><hr>
<%=new Date() %><br>
<%=new Test() %>
</body>
</html>