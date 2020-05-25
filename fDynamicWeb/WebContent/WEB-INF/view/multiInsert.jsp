<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 태그 라이브러리 추가  -->
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 멤버 리스트 </h2>

<table border='2'>
	<tr>
		<td>이름</td> <td>아이디</td> <td>나이</td>
	</tr>
	<c:forEach var='vo' items='${memberVOList.list}'>
	<!-- for(변수 vo : List ) 자바의 향상된 for문 일 경우-->
		<c:if test="${vo.state}">
			<tr>
				<td>${vo.name}</td>
				<td>${vo.id}</td>
				<td>${vo.age}</td>
			</tr>
		</c:if>
	</c:forEach>	
</table>

</body>
</html>