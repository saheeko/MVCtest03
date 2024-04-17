<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!-- core를 사용하려면 추가해야됨 prefix는  jstl태그를 사용하기위해서 중복을 막기위함으로 씀-->   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--반복문  step 1씩 증가한다는 의미  -->
<c:forEach var="i" begin="1" end="5" step="1">
<font size="${i}">야호~~</font>
</c:forEach>
</body>
</html>