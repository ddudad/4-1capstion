<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	out.print(request.getAttribute("stdName") + "(" + request.getAttribute("stdNum") + ")" 
	+ request.getAttribute("className") + " 출석 성공");
	%>
</body>
</html>