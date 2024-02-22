<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1-고객전체조회</title>
<link rel="stylesheet" href="assets/css/customers.css">
</head>
<body>
	<h3>고객 전체 조회</h3>
	<hr>
	<!--  list 이름의 애트리뷰트를 대상으로 합니다. : 애트리뷰트 저장은 서블릿에서 합니다  -->
	<c:forEach items="${list}" var="vo" varStatus="status">
		<li>
	        <ul>
	        	<li><c:out value="${status.index + 1}" /></li>
	           <li><c:out value="${fn:toUpperCase(vo.customId)}" /></li>
	           <li><c:out value="${vo.name}" /></li>
	           <li><c:out value="${vo.email}" /></li>
	           <li><fmt:formatDate value="${vo.reg_date}"  
	           			pattern="yyyy-MM-dd a hh:mm:ss" /></li>
	        </ul>
	     </li>
      </c:forEach>
</body>
</html>













