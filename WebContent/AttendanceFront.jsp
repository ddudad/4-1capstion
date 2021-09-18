<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>출석체크</title>
</head>
<body>
<center>
	<h2>확인할 수업명을 입력해주세요</h2>
<form action="AttendanceProc.jsp" method="post" accept-charset="utf-8">
<table width="400">
	<tr height="400">
	<td width="350" align="center"> <input type="text" name="input_class" size="40" placeholder="수업명을 입력해주세요"></td>
	<td><input type="submit" value="확인"></td>
</table>
</form>	
</center>
</body>
</html>