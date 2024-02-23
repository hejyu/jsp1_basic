package day4.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CustomerBuyDto;
import mybatis.SqlSessionBean;
import project.vo.BuyVO;


public class MybatisBuyDao {

	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	
	public MybatisBuyDao() {
		// TEST DB connection : will remove
		SqlSession sqlSession = sessionFactory.openSession();
		System.out.println("db 연결 및 실행 객체 : " + sqlSession.getClass());
	}
	
	public List<BuyDto> selectAll() {
		SqlSession sqlSession = sessionFactory.openSession();
		List<BuyDto> list = sqlSession.selectList("tblbuy.selectAll");
		sqlSession.close();
		return list;
	}
	
	public List<CustomerBuyDto> selectBuyMyPage(String customid) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerBuyDto> list = sqlSession.selectList("tblbuy.selectBuyMyPage",customid);
		sqlSession.close();
		return list;
	}
	
	public List<BuyVO> selectBuyByCustomid(String customid) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<BuyVO> list = sqlSession.selectList("tblbuy.selectBuyByCustomid",customid);
		sqlSession.close();
		return list;
	}
	
	
	//SqlSession 객체 insert, update, delete, select 메소드는 SQL을 실행합니다.
	//			ㄴ 첫번째 인자는 SQL매퍼 파일은 namespace속성.id속성
	//			ㄴ 두번째 인자는 SQL 실행에 파라미터가 있으면 작성합니다. 
	public int insert(BuyDto vo) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblbuy.insert",vo);
		sqlSession.commit();  	//  자동 커밋되지 않음
		sqlSession.close();
		return result;
	}
	
	public int update(Map<String,Integer> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.update("tblbuy.update",map);
		sqlSession.close();
		return result;
	}
	
	public int delete(int buy_idx) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.delete("tblbuy.delete",buy_idx);
		sqlSession.close();
		return result;
	}
	
	
	
	

	
}
