<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<!-- JSP 파일을 실행할 때는 아래와 같이 CSS 를 적용합니다 -->
<!-- <link rel="stylesheet"    href="../assets/css/register.css" > -->
<!-- Servlet 으로 실행될 때는 아래와 같이 적용합니다 -->
<link rel="stylesheet"    href="assets/css/register.css" > 
</head>
<body>
  <div class="contents-wrap">
  <h3 style="text-align: center;">상품 등록</h3>
  <hr>
          <form action="productReg.cc" method="post">
            <ul class="join-wrap">
              <li>상품코드</li>
              <li>
                <input class="id-input" name="pcode" type="text" 
                  placeholder="상품코드을 입력해 주세요." />
              </li>
              <li>카테고리</li>
              <li><input id="category" name="category" type="text" placeholder="카테고리" /></li>
              <li>상품명</li>
              <li><input  id="pname" name="pname" type="text" placeholder="상품명을 입력해 주세요." /></li>
              <li>가격</li>
              <li><input id="price" name="price" type="text" placeholder="가격" /></li>
            </ul>
            <button type="button" id="join" class="join-btn">상품등록</button>
          </form>
	</div>
  <script src="assets/js/script.js"></script>
</body>
</html>