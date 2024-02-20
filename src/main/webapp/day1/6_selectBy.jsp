<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@page import="project.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	TblCustomerDao dao = new TblCustomerDao();
	List<CustomerVO> list = new ArrayList(); 
	String name = request.getParameter("name");
	String temp = request.getParameter("age");
	
	if((name != null && name.length() != 0) && (temp != null && temp.length() != 0) ) {	
		int age = Integer.parseInt(temp);
		list = dao.selectByNameAge(name, age);
		
		for(CustomerVO vo : list){
			
			out.print("<h4> 고객이름 :"+ vo.getName() + "</h4>");
			out.print("<h4> 나이 : " + vo.getAge() + "</h4>");
	
		}
		
	}else {
		out.print("<h4>모든 파라미터가 전송되어야만 출력을 확인할 수 있습니다</h4>");
	}
	
	
%>

</body>
</html>