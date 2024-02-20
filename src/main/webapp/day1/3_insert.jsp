<%@page import="project.vo.CustomerVO"%>
<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3_jdbc</title>
</head>
<body>
	<h3>모든 고객을 출력</h3>
	<p>Tbl Customer Dao 클래스의 메소드로 db에 접속하고 행을 가져와 출력하는 연습입니다.</p>
	
	<hr>
	
	<%
	CustomerVO vo = new CustomerVO("sana676869","김사나","sana@gmail.com",23, null);
	TblCustomerDao dao = new TblCustomerDao();
	
	dao.join(vo);
	
	%>
	
	<h3>CustomerVO Object</h3>
	<table style="width:600px;">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>나이</th>
			<th>가입날짜</th>
		</tr>
		<tr>
			<td><%=vo.getCustomId() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getEmail() %></td>
			<td><%=vo.getAge() %></td>
			<td><%=vo.getReg_date() %></td>
		</tr>
	</table>

	<p>insert 성공 확인</p>
	<a href="2_jdbc.jsp">insert 성공 확인하기</a>
	
	
</body>
</html>