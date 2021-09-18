<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 1. 임포트 하기 -->
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>데이터 베이스 연결 </title>
</head>
<body>
	<%
		// 연결하기
		Connection conn = null;
		String url="jdbc:mysql://localhost:3306/test";
		String user="root";
		String password="1234";
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
	%>
</body>
</html>