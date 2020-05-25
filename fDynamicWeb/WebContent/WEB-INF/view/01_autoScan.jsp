<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

시작페이지 <hr/>
<a href="autoScan.do"> 모델 VO 데이터 얻어오기 </a>

결과 보는 뷰단입니다.<br/>
이름 : ${vo.name}<br/> <!-- ${vo.name} : vo 객체에서 getName 호출  -->
아이디 : ${vo.id}<br/>
나이 : ${vo.age}<br/>
</body>
</html>