package day4.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.CustomerDto;
import mybatis.SqlSessionBean;

public class MybatisCustomerDao {

	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	
	public MybatisCustomerDao() {
		// TEST DB connection : will remove
		SqlSession sqlSession = sessionFactory.openSession();
		System.out.println("db 연결 및 실행 객체 : " + sqlSession.getClass());
	}
	
	public List<CustomerDto> selectAll() {
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustom.selectAll");
		sqlSession.close();
		return list;
	}
	

	public List<CustomerDto> selectCustomerByCustomId(String custom_id) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustom.selectCustomerByCustomId", custom_id);
		sqlSession.close();
		return list;
	}
	
	public List<CustomerDto> selectByNameAge(Map<String, Object> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustom.selectByNameAge", map);
		sqlSession.close();
		return list;
	}
	
	
	public int insert(CustomerDto vo) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblcustom.insert",vo);
		sqlSession.commit();  	//  자동 커밋되지 않음
		sqlSession.close();
		return result;
	}
	
	public int update(Map<String,Integer> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.update("tblcustom.update",map);
		sqlSession.commit();  	//  자동 커밋되지 않음
		sqlSession.close();
		return result;
	}
	
	public int delete(String custom_id) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.delete("tblcustom.delete",custom_id);
		sqlSession.commit();  	//  자동 커밋되지 않음
		sqlSession.close();
		return result;
	}
		
	
	
	
}


/**
 * 마이바티스의 주요 특징 3가지
 * 1. 테이블 컬럼과 자바 객체 자동으로 맵핑
 * 2. SQL xml 파일 관리 가능
 * 3. 동적 쿼리  
 * 
 * 마이바티스 메소드 
 * 종류
 * - insert
 * - update
 * - delete
 * - selectList : 리턴타입 List<Collection>
 * - selectOne : 1개 행 조회(pk컬럼)
 * 
 * 	메소드의 리턴타입 
 *    resultType
 * 	- selectOne
 *  - selectList
 *  => Mapper xml 파일에서 resultType="데이터형"을 반드시 작성해야합니다
 *  
 *  마이바티스 메소드의 인자 
 *    parameterType
 *  - insert
 *  - update
 *  - delete
 *  - selectOne 
 *  => 반드시 parameterType="데이터형"를 작성해야합니다
 * 	 
 *  
 * 
 */




