<%@page import="project.vo.CustomerVO"%>
<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2_jdbc</title>
</head>
<body>
	<h3>모든 고객을 출력</h3>
	<p>Tbl Customer Dao 클래스의 메소드로 db에 접속하고 행을 가져와 출력하는 연습입니다.</p>
	
	<hr>
	
	<%
	TblCustomerDao dao = new TblCustomerDao();
	List<CustomerVO> list = dao.allCustomers();
	%>
	
	<table>
	
	<%
	for(CustomerVO vo : list) {
	%>
	
	<tr>
		<td><%=vo.getCustomId() %></td>
		<td><%=vo.getName() %></td>
		<td><%=vo.getEmail() %></td>
		<td><%=vo.getAge() %></td>
		<td><%=vo.getReg_date() %></td>		
	</tr>
	
	<%
		}										//for 끝
	%>
	
	
	
	</table>
	
	
</body>
</html>