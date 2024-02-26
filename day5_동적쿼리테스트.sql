-- 전체조회
select * from tbl_product;

-- 카테고리 조회
select * from tbl_product where category = 'B1';

-- 상품명 조회
select * from tbl_product where pname like '%' || '사과' || '%';

-- 가격대 조회
select from tbl_product where price between 10000 and 40000;

-- 위의 3가지 한번에 조회하기
select * from tbl_product
where category = 'B2' 
	and pname like '%' || '사과' || '%'
	and (price between 10000 and 40000);