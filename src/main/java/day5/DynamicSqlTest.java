package day5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;

public class DynamicSqlTest {

	public static void main(String[] args) {
		testAllFilter();
	}
	
	
	public static void testNoFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.search(null);
	
		System.out.println("검색 필터 없음 : " + list); 	// 전체 조회
	}
	
	public static void testOrderBy() {
		MybatisProductDao dao = new MybatisProductDao();
		
		Map<String, Object> map = new HashMap<>();
		map.put("column", "category");		// 컬럼명 price로 정렬하기
		
		List<ProductDto> list = dao.search(map);
		System.out.println("검색 필터 없음 : " + list); 	// 전체 조회
	}
	
	
	public static void testCateFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("category", "A2");		// key : 파라미터이름, value : 검색어
		
		List<ProductDto> list = dao.search(map);
	
		System.out.println("검색 필터 - 카데고리 : " + list); 
	}
	
	public static void testPnameFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", "햇반");
		
		List<ProductDto> list = dao.search(map);
	
		System.out.println("검색 필터 - 상품명 : " + list); 	
	}
	
	public static void testCatePnameFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", "애플망고");
		map.put("category", "A2");
		
		List<ProductDto> list = dao.search(map);
	
		System.out.println("검색 필터 - 카데고리 & 상품명 : " + list);
	}
	
	public static void testAllFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", "");		// key : 파라미터이름, value : 검색어
		map.put("category", "A2");		// key : 파라미터이름, value : 검색어
		map.put("from", "");		// key : 파라미터이름, value : 검색어
		map.put("to", "");		// key : 파라미터이름, value : 검색어
		
		List<ProductDto> list = dao.search(map);

		System.out.println("검색 필터 - 카데고리 & 상품명 그리고 가격 : " + list); 
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
