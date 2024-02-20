<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>고객 조회에 필요한 조건값(name, age)을 input에 입력하고 전송하는 연습</h3>
	<hr>
	
	<form action="6_selectBy.jsp">
		<input typpe="text" name="name" placeholder="이름을 입력하세요" required="required">
		<input typpe="text" name="age" placeholder="나이을 입력하세요" required="required">
		<button>조회하기</button>
		<!-- type = "submit" : 기본값, action 속성의 주소로 이동합니다 -->
		
		
		<!-- form method = "get" : 기본값, 파라미터를 url에 포함해 조회하는 것 
		-->
	</form>
</body>
</html>