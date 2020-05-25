<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입 정보 <hr/>

아이디 : ${param.id} <br/>
이름 : ${param.name} <br/>
나이 : ${param.age} <br/>
<br/>
아이디 : ${memberVO.id} <br/>
이름 : ${memberVO.name} <br/>
나이 : ${memberVO.age} <br/>
</body>
</html>