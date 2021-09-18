<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>출석 확인</title>
</head>
<body>
	<%@ include file="DB_conn.jsp" %>
	<table width="300">
		<tr>
			<th> 이름 </th>
			<th> 번호 </th>
			<th> 수업명 </th>
			<th> 출석수 </th>
		</tr>
	<%
		//post방식 한글이 깨질수 있기에
		request.setCharacterEncoding("utf-8");
		//수업명 가져오기
		String input_class = request.getParameter("input_class");
		
		ResultSet rs = null;
		PreparedStatement pstmt = null; 
		
		try{
		String sql = "select STDNAME,STDNUM,CLASSNAME, count(STDNUM) as 'COUNT' from test_table where CLASSNAME= '" + input_class + "'group by STDNUM";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			String std_name = rs.getString("STDNAME");
			String std_num = rs.getString("STDNUM");
			String class_name = rs.getString("CLASSNAME");
			String count = rs.getString("COUNT");
			
	%>
	<tr>
			<td><%= std_name %></td>
			<td><%= std_num %></td>
			<td><%= class_name %></td>
			<td><%= count %></td>
		</tr>
<%
			} //while 닫기
		} catch (SQLException e) { //try 닫기
				out.print("member 테이블 호출에 실패 <br>");
				out.print("SQLException: " + e.getMessage());
		} finally { //생성역순종료
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
		}
	%>
</table>
</body>
</html>