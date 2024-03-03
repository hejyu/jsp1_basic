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


-- 상품 카테고리 테이블 생성
CREATE TABLE tbl_category(
        code varchar2(20) PRIMARY KEY ,
        name varchar2(40) NOT NULL
);

select distinct CATEGORY
from TBL_PRODUCT;

select *
from TBL_CATEGORY;

INSERT INTO
    TBL_CATEGORY
VALUES
    ( 'A1','과일')   -- 함수로 문자열에서 날짜형식 변환. 문자열의 패턴이 필요.
    ;
INSERT INTO
    TBL_CATEGORY
VALUES
    ( 'B1', '식료품')   -- 함수로 문자열에서 날짜형식 변환. 문자열의 패턴이 필요.
;

INSERT INTO
    TBL_CATEGORY
VALUES
    ( 'B2', '통조림/캔')   -- 함수로 문자열에서 날짜형식 변환. 문자열의 패턴이 필요.
;