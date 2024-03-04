package mybatis;

import java.util.List;

import day4.mybatis.dao.MybatisBuyDao;
import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CustomerBuyDto;

public class MybatisSessionTest {

	public static void main(String[] args) {
		
		MybatisBuyDao dao = new MybatisBuyDao();	
		System.out.println("dao 객체 : " + dao.getClass());
		
		System.out.println("==== selectAll 테스트 ====");
		List<BuyDto> list = dao.selectAll();
		System.out.println(list);
		
		System.out.println("==== insert 테스트 ====");
		int result = dao.insert(new BuyDto(0, "mina012", "CJBAb12g", 3, null));
		System.out.println("반영된 행 개수 :" + result);
			
		System.out.println("==== selectAll 테스트 ====");
		list = dao.selectAll();
		System.out.println(list);

		
		testBuy();
		
	
	}

	
	public static void testProduct() {
		MybatisProductDao dao = new MybatisProductDao();
		System.out.println("dao 객체 : " + dao.getClass());
	}
	
	
	public static void testCustomer() {
		MybatisCustomerDao dao = new MybatisCustomerDao();
		System.out.println("dao 객체 : " + dao.getClass());
	}
	
	public static void testBuy() {
		MybatisBuyDao dao = new MybatisBuyDao();
		System.out.println("MybatisBuyDao dao 객체 : " + dao.getClass());
		
		System.out.println("==== selectBuyMyPage 테스트 ====");
		String customid = "mina012";
		List<CustomerBuyDto> list = dao.selectBuyMyPage(customid);
		System.out.println(list);
		
		System.out.println("==== selectBuyByCustomid 테스트 ====");
		List<BuyDto> list2 = dao.selectBuyByCustomid(customid);
		System.out.println(list2);
		
		
	}
	
	
	
	
	
	
	
}
