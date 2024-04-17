<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!-- core를 사용하려면 추가해야됨 prefix는  jstl태그를 사용하기위해서 중복을 막기위함으로 씀--> 
<%
	MemberVO vo=new MemberVO();
	vo.setNum(1);
	vo.setId("sahee");
	vo.setName("사희");
	vo.setPhone("010-4624-2451");
	request.setAttribute("vo", vo);
	
	List<MemberVO> list=new ArrayList<MemberVO>();
	list.add(vo);
	list.add(vo);
	list.add(vo);
	list.add(vo);
	list.add(vo);
	
	request.setAttribute("list", list); //객체바인딩
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>휴대전화</td>
	</tr>
<c:forEach var="vo" items="${list}">
	<tr>
		<td>${vo.num}</td>
		<td>${vo.id}</td>
		<td>${vo.name}</td>
		<td>${vo.phone}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>