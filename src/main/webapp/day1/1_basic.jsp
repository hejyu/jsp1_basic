<%@page import="project.vo.CustomerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_basic</title>
</head>
<body>
	<p>jsp 는 html 태그와 함께 자바명령어, 변수 출력 등을 할 수 있다</p>
<%
	String[] names = {"sana","nayeon","momo","jjywi", "dahyeon"};
	List<String> list = List.of("sana","nayeon","momo","jjywi", "dahyeon");
	CustomerVO vo = new CustomerVO("sana","김사나","sana@gmail.com",23, null);
	
	
%>

	<h4>배열 names</h4>
	<ul>
	<!-- 자바로 names 배열 요소값은 출력  -->
	<%
		for(int i=0 ; i<names.length ; i++) { 	//for 시작             	 
	%>
		<li><%= names[i] %></li>
	<%
		}										//for 끝
	%>
	</ul>
	
	<hr>
	
	<h3>컬렉션</h3>
	<ul>
	<%
		for(int i=0 ; i < list.size() ; i++) { 	//for 시작             	 
	%>
		<li><%= list.get(i) %></li>
	<%
		}										//for 끝
	%>
	
	</ul>
	
	<hr>	
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

	
</body>
</html>
<!-- 단축키 정리
		ctrl + d (한줄 삭제)
		ctrl+alt+방향키 (한줄 복사)
		alt + 방향키 (라인 이동)
		ctr + shift + / (주석)
		shift + 엔터 (다음 라인 커서 이동)
		ctrl + 스페이스바 (참조, import, auto completion)


 -->




