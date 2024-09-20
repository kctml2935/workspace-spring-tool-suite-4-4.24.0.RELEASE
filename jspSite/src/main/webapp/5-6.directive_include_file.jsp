<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>include 지시어[file]</h1>
<h2>형태:&lt;%@include file="xxx.jspf"&gt;</h2>
<hr/>
<jsp:include page="6-2.action_tag_included_top.jsp"/>
<ol>
<li>content</li>
<li>content</li>
<li>content</li>
<li>content</li>
<li>content</li>
<li>content</li>
<li>content</li>
<li>content</li>
<li>content</li>
</ol>

<jsp:include page="6-2.action_tag_included_footer.jsp"/>
</body>
</html>
