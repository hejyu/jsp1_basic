<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5_param_receive</title>
</head>
<body>

	<h3>url 주소에서 보낸 파라미터를 받아 값을 저장하는 연습 - 조회</h3>

	<%
	// getParameter 리턴 타입 : String
	String name = request.getParameter("name");
	String temp = request.getParameter("age");
	
	
	// 입력 파라미터 값 유효성 검사 : 자바스크립트 
	// 모든 파라미터가 전송되었을 때만 실행하는 조건식 작성
	if((name != null && name.length() != 0) && (temp != null && temp.length() != 0)) {
		
		out.print("<h4>name</h4>");
		out.print(name);
		out.print("<h4>age</h4>");
		out.print(temp);
	
		// name 과 age 값으로 테이블 에서 조회하고 결과 출력 
		// 			ㄴ age 는 정수 타입
		int age = Integer.parseInt(temp);
		
		out.print("<h4>int age</h4>");
		out.print(age);
		
	}else {
		out.print("<h4>모든 파라미터가 전송되어야만 출력을 확인할 수 있습니다</h4>");
	}
	
	
	%>
</body>
</html>