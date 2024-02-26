package day4.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.CateDto;
import day4.mybatis.dto.ProductDto;
import mybatis.SqlSessionBean;

public class MybatisProductDao {

	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	
	public MybatisProductDao() {
		// TEST DB connection : will remove
		SqlSession sqlSession = sessionFactory.openSession();
		System.out.println("db 연결 및 실행 객체 : " + sqlSession.getClass());
	}
	
	public List<ProductDto> selectAll() {
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectAll");
		sqlSession.close();
		return list;
	}
	
	public List<ProductDto> selectByPname(String pname) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectByPname", pname);
		sqlSession.close();
		return list;
	}
	
	public List<ProductDto> selectByCategory(String category) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectByCategory", category);
		sqlSession.close();
		return list;
	}
	
	//SqlSession 객체 insert, update, delete, select 메소드는 SQL을 실행합니다.
	//			ㄴ 첫번째 인자는 SQL매퍼 파일은 namespace속성.id속성
	//			ㄴ 두번째 인자는 SQL 실행에 파라미터가 있으면 작성합니다. 
	public int insert(ProductDto vo) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblproduct.insert",vo);
		sqlSession.commit();  	//  자동 커밋되지 않음
		sqlSession.close();
		return result;
	}
	
	public int update(Map<String,Object> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.update("tblproduct.update",map);
		sqlSession.commit();  	//  자동 커밋되지 않음
		sqlSession.close();
		return result;
	}
	
	public int delete(String pcode) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.delete("tblproduct.delete", pcode);
		sqlSession.commit();  	//  자동 커밋되지 않음
		sqlSession.close();
		return result;
	}

	public List<ProductDto> search(Map<String, Object> map){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.search", map);
		sqlSession.close();
		return list;
	}
	
	
	public List<CateDto> getCategories() {
		SqlSession sqlSession = sessionFactory.openSession();
		List<CateDto> list = sqlSession.selectList("tblproduct.getCategories");
		sqlSession.close();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
