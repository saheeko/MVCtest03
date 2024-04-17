<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!-- core를 사용하려면 추가해야됨 prefix는  jstl태그를 사용하기위해서 중복을 막기위함으로 씀--> 
<%
	List<String> list=new ArrayList<String>();
	list.add("김사희");
	list.add("사희");
	list.add("희");
	list.add("와우");
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="sw" items="${list}">
	${sw}<br>
</c:forEach>
</body>
</html>