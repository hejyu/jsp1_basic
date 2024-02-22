<%@page import="java.util.List"%>
<%@page import="project.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11_forEach_list</title>
</head>
<body>
<!-- 7. 자바 객체 컬렉션(리스트) 활용하기 -->
	<h5>자바 객체 컬렉션(리스트) 활용하기</h5>
	<%
	// jdbc 로 sql 조회한 결과 List 에 활용합니다.
	List<CustomerVO> list = List.of(new CustomerVO("momo12","강모모","momo12@daum.net",29,null),
			new CustomerVO("momo13","강모모","momo13@daum.net",25,null),
			new CustomerVO("momo14","강모모","momo14@daum.net",26,null),
			new CustomerVO("momo15","강모모","momo15@daum.net",27,null),
			new CustomerVO("momo22","강모모","momo22@daum.net",28,null));
	
	pageContext.setAttribute("list", list);
	%>
	<!-- 컬렉션 list 에서 값을 하나씩 가져와 애트리뷰트 이름 vo 에 저장하기 -->
	<c:forEach items="${list }" var="vo" varStatus="status">
		<!-- varStatus 속성 index 는 지금처럼 items 로 컬렉션 다룰 때 사용합니다. -->
		<c:out value="${status.index }"/>,<c:out value="${vo }"/>
		<!-- vo 에 저장된 객체 속성을 각각 출력하기 -->
		<ul>
			<li><c:out value="${vo.customId }"/></li>
			<li><c:out value="${vo.name }"/></li>
			<li><c:out value="${vo.email }"/></li>
			<li><c:out value="${vo.age }"/></li>
		
		</ul>
		
	</c:forEach>
</body>
</html>







