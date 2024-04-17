<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!-- core를 사용하려면 추가해야됨 prefix는  jstl태그를 사용하기위해서 중복을 막기위함으로 씀-->     
<c:set  var="cnt" value="7"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<!-- 자바 스위치케이스문이랑 동일한 것  -->
	<c:when test="${cnt%2==0}">
		짝수입니다.
	</c:when>
	<c:when test="${cnt%2!=0}">
		홀수입니다.
	</c:when>
	<c:otherwise>
	일치하는 when절이 없는 경우에 실행한다 <!--default값과 같으  -->
	</c:otherwise>
</c:choose>
</body>
</html>