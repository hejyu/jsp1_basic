/**
 * 
 */

 document.getElementById('search').addEventListener('click', function() {
	 // input에 입력한 값 가져오기
	 let name = document.getElementById('name').value
	 let age = document.getElementById('age').value
	 
	 console.log('입력값 : ',name, age)
	 // url : method="get" 파라미터 포함하여 6_selectBy.jsp 로 보내기 
	 // 		location 객체 href 속성 사용
	 // location.href = "6_selectBy.jsp?name=" + name + "&age=" + age
	 location.href = `6_selectBy.jsp?name=${name}&age=${age}`
	 // 현재 스크립트를 사용하는 파일과 같은 위치인지 확인합니다
	  
 })