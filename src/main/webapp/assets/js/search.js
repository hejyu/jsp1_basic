/**
 * 상품 검색어 입력을 확인하기 위한 스크립트입니다
 */
const category = document.querySelector('select[name="category"]')
const keyword =  document.querySelector('input[name="keyword"]')
const from = document.querySelector('input[name="from"]')
const to = document.querySelector('input[name="to"]')



console.log(temp)
// 카데고리 조히시에만 temp가 null이 아니다
if(temp != null) category.value = temp


document.getElementById('category').addEventListener('change', (e)=>{
	console.log(this)
	
	document.forms[0].submit()
})


document.getElementById('keyword').addEventListener('change', (e)=>{
	
	document.forms[0].submit()
})


if(from.value.length != 0 && to.value.length !=0 ){
	document.getElementById('from').addEventListener('change', (e)=>{
		console.log(e)
		
		document.forms[0].submit()
	})
	
}

document.getElementById('search').addEventListener('click', ()=>{
	let isValid = true
	if(keyword.value.length == 0 && category.value.length == 0
		&& from.value.length == 0 && to.value.length == 0
	){
		isValid = false
		alert("검색어를 입력하세요")	
	}
	
	console.log(keyword.value)
	console.log(keyword.value)
	console.log(from.value)
	console.log(to.value)
	
})



