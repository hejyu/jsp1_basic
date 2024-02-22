<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
<!-- JSP 파일을 실행할 때는 아래와 같이 CSS 를 적용합니다 -->
<!-- <link rel="stylesheet"    href="../assets/css/register.css" > -->
<!-- Servlet 으로 실행될 때는 아래와 같이 적용합니다 -->
<link rel="stylesheet"    href="assets/css/register.css" > 
</head>
<body>
  <div class="contents-wrap">
  <h3 style="text-align: center;">고객 등록</h3>
  <hr>
          <form action="register.cc" method="post">
            <ul class="join-wrap">
              <li>아이디</li>
              <li>
                <input class="id-input" id="member_id" name="userid" type="text" 
                  placeholder="아이디를 입력해 주세요." />
              </li>
              <li>이름</li>
              <li><input  name="name" type="text" placeholder="이름" /></li>
              <li>이메일</li>
              <li><input id="email" id="member_contact" name="email" type="text" placeholder="이메일을 입력해 주세요." /></li>
              <li>나이</li>
              <li><input type="text" id="birth_day" name="age" placeholder="생일" /></li>
            </ul>
            <button type="button" id="join" class="join-btn">회원가입</button>
          </form>
	</div>
  	<script src="assets/js/script.js"></script>
</body>
</html>