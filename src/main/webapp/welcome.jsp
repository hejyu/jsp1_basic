<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- language="java" : java 언어로 컴파일 된다는 의미
	contentType="text/html; charset=UTF-8" : 서버 응답으로 만들어질 파일 형식은 html을 의미
-->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>WELCOME</h1>
    <h3>회원 가입이 완료되었습니다.</h3>
    
<!-- 스크립틀릿: 자바 프로그래밍 스크립트 작성 부분 -->
<%

	// form  태그 안의 입력양식이 서버로 제출될 때, 그 값을 받아 저장하는 코드 입니다.
	// getParameter : 메소드이므로 입력 요소를 파라미터라고 부르겠습니다
	// 			인자 : input 요소 name 속성 값
	String id = request.getParameter("member_id");			// 아이디		
	String password = request.getParameter("member_password");	// 패스워드

	out.print("<h3>아이디</h3>");
	out.print(id);
	
	out.print("<h3>비밀번호</h3>");
	out.print(password);
	
%>
	<hr>
	<p>form 제출 확인 페이지 입니다.</p>
	
</body>
</html>