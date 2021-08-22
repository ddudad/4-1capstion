<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	out.print(request.getAttribute("stdName") + "(" + request.getAttribute("stdNum") + ")" 
	+ request.getAttribute("className") + " 출석 성공");
	%>
</body>
</html>