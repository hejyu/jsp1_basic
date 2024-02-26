package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.mybatis.dto.ProductDto;
import jdbc.day1.OracleConnectionUtil;
import project.vo.ProductVO;

/**
 * tbl_buy DAO : tbl_buy 테이블 데이터에 접근하는 객체
 * insert, update, delete
 */
public class TblProductDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME ="c##idev";
    public static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
    	Connection conn = null;
    	try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
        return conn;
    }


    // product 삭제
    public void delete(String pcode){
        String sql = "delete tbl_product where pcode = ?";
           
        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, pcode);
            ps.executeUpdate();
            
            
        } catch (Exception e) {
           System.out.println("상품 delete 오류 발생 : " + e.getMessage());
        }
    }

    //2.카테고리로 검색하기
    public List<ProductVO> selectByCategory(String category) {
        List<ProductVO> list = new ArrayList<>();
        String sql = "select * from tbl_product where category = ? order by pname";

        try(
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {  
                list.add(new ProductVO(rs.getString(1)
                        ,rs.getString(2)
                        ,rs.getString(3)
                        ,rs.getInt(4)));
            }

        } catch(SQLException e) {
            System.out.println("selectCategory 예외 발생" + e.getMessage());
        }
        
        return list;
    }


    //3.상품명으로 검색하기 (유사검색 -> `검색어가 포함된 상품명` 을 조회하기)
    public List<ProductVO> selectByPname(String pname) {
        List<ProductVO> list = new ArrayList<>();
        String sql="SELECT * FROM TBL_PRODUCT tp \n"+ 
                    "WHERE pname LIKE '%'|| ? || '%' ";
            
        try (
                Connection connection = OracleConnectionUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, pname);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                list.add(new ProductVO(rs.getString(1), 
                                       rs.getString(2), 
                                       rs.getString(3), 
                                       rs.getInt(4)));
            }    
        
        }catch (SQLException e) {
            System.out.println("selectByPname 예외 발생" + e.getMessage());
        }
        
        return list;
    }


    public Map<String, Integer> getPriceTable() {
        Map<String,Integer> map = new HashMap<>();
        String sql = "select PCODE, PRICE from tbl_product";

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                map.put(rs.getString(1), rs.getInt(2));
            }    
        
        } catch (SQLException e) {
            System.out.println("getPriceTable 예외 발생" + e.getMessage());
        }
        
        return map;
    }

    
    public List<ProductVO> allProducts() {
    	List<ProductVO> list = new ArrayList<>();
    	String sql = "SELECT pcode, category, pname, price FROM tbl_product";
    	
    	try(
    		Connection conn = getConnection();
    		PreparedStatement ps = conn.prepareStatement(sql);
    	) {
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			list.add(new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
    		}
    		
    	} catch (Exception e) {
    		System.out.println("allProducts 예외 발생" + e.getMessage());
		}
    	
    	return list;
    }

    
    /**
     * 상품 등록-저장
     * @param vo
     * @return int
     */
    public int registerProduct(ProductVO vo) {
    	String sql = "insert into tbl_product(pcode, category, pname, price) "+
    				"values(?,?,?,?)";
    
    	int result = 0;
    	try( Connection conn = getConnection();
    		 PreparedStatement ps = conn.prepareStatement(sql);
    	) {
    		ps.setString(1, vo.getPcode());
    		ps.setString(2, vo.getCategory());
    		ps.setString(3, vo.getPname());
    		ps.setInt(4, vo.getPrice());
    		
    		result = ps.executeUpdate();

    		
    		System.out.println("registerProduct 실행");
    	} catch(Exception e) {
    		System.out.println("registerProduct 예외 발생" + e.getMessage());
		}
    	
    	return result;
    }
    
  


}
