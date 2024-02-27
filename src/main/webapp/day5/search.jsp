<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1-상품검색필터조회</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css">
</head>
<body>

	<h3>상품 전체 조회 - day3 product.jsp 에 검색기능 추가</h3>
	<hr>
	<div class="search">
		<!-- form 기본 method = "get" 
			 		action 속성이 없을 때 주소는? 자기 자신입니다
		-->
		<form id="search_form">
			<select name="category" id="category">
				<option value="">카데고리 선택</optoin>
				<c:forEach items="${cateList}" var="cate">
					<option value="${cate.code}"><c:out value="${cate.name}" /> </option>
				</c:forEach>
			</select>
			
			<input text="text" name="keyword" id="keyword" value="${keyword}" placeholder="상품명을 입력하세요">
			
			<span style="paading-left:10px;">가격대별</span>
			
			<input text="text" name="from" id="from" placeholder="10000">
			<b>~</b>
			<input text="text" name="to" id="to" placeholder="50000">
			
			<button type="submit" id="search">조회</button>
			<button id="searchAll" type="button" onclick="location.href='search-product.cc'">전체보기</button>
			
		</form>
	
	</div>
	
	
	<ul>
	<!--  list 이름의 애트리뷰트를 대상으로 합니다. : 애트리뷰트 저장은 서블릿에서 합니다  -->
	<c:forEach items="${list}" var="vo" varStatus="status">
		<li>
	        <ul class="row">
	        	<li><c:out value="${status.index + 1}" /></li>
	           	<li><c:out value="${vo.pcode}" /></li>
	           	<li><c:out value="${vo.category}" /></li>
	           	<li><c:out value="${vo.pname}" /></li>
	           	<li><c:out value="${vo.price}" /></li>
	        </ul>
	     </li>
    </c:forEach>
    </ul>
	
	<script type="text/javascript">
	// js 파일에서는 서버 애트리뷰트를 가져올 수 없습니다
	// 서버 애트리뷰는 jsp 파일 안에 있는 script 태그안에서 사용 할 수 있습니다
		const temp = '${cate}'
	</script>
	
	<script type="text/javascript" src="assets/js/search.js"></script>
	
	
	
	
	
</body>
</html>









