<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 // String data=(String)request.getAttribute("data");
	String data=request.getParameter("data");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 controller에서 받은 값을 출력테스트 01<br> 나의 이름은 : <%=data%>
</body>
</html>