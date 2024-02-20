<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>a 태그 url 주소에 파라미터 값과 함께 전송시키기는 연습</h3>
	<p>이것은 메뉴 또는 조회 동작 시 사용되는 방식입니다</p>
	<ul>
		<li><a href="5_parameter_receive.jsp?name=sana&age=24">name, age 파라미터 2개 보내기</a>
			: name == "sana", age == ""
		</li>
		<li><a href="5_parameter_receive.jsp?name=sana">name 파라미터 1개 보내기 - age 파라미터 없을때</a>
			: age == null
		</li>
		<li><a href="5_parameter_receive.jsp?name=sana&age=">name, age 파라미터 2개 보내기 - age 파라미터 없을때 </a> 
			: age == ""
		
		</li>
	</ul>
	
	<hr>
	<ul>
		<li><a href="6_selectBy.jsp?name=김사나&age=20">name, age 파라미터 2개 보내기</a>
			: name == "sana", age == "20"
		</li>
		<li><a href="6_selectBy.jsp?name=최사나">name 파라미터 1개 보내기 - age 파라미터 없을때</a>
			: age == null
		</li>
		<li><a href="6_selectBy.jsp?name=김사나&age=">name, age 파라미터 2개 보내기 - age 파라미터 없을때 </a> 
			: age == ""
		
		</li>
	</ul>
</body>
</html>