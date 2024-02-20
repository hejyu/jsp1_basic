package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.CustomerVO;


/**
 * tbl_customer DAO : tbl_customer 테이블 데이터에 접근하는 객체
 */
public class TblCustomerDao {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

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

    //회원 가입
    // insert into tbl_custom(custom_id, name, email, age, reg_date) values(?,?,?,?,sysdate) 
    public void join(CustomerVO vo) {
        String sql = "insert into tbl_custom(custom_id, name, email, age, reg_date) values(?,?,?,?,sysdate)";        // insert
        
        try(
            // Try-with-resources 는 
            // try에 자원 객체를 전달하면, try 코드 블록이 끝나면 자동으로 자원을 종료해주는 기능
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ) {
            //매개변수 바인딩
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());
            pstmt.executeUpdate();
            
            System.out.println("join : insert ");
        } catch(SQLException e){
        	System.out.println("join: " + e.getMessage());
        } 
    }

    //회원 정보 수정 
    // UPDATE TBL_CUSTOM SET email = ?, age = ? WHERE CUSTOM_ID = ?
    public void modify(CustomerVO vo) {
        String sql = "update tbl_custom set email=?, age=? WHERE custom_id=?";
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            // 매개변수 바인딩
            pstmt.setString(1, vo.getEmail());
            pstmt.setInt(2, vo.getAge());
            pstmt.setString(3, vo.getCustomId());
            pstmt.executeUpdate();
        } catch (Exception e) {

        }   // try with resource  자동으로 자원을 종료합니다
    }

    //회원 탈퇴
    // DELETE FROM TBL_CUSTOM WHERE CUSTOM_ID = ?;
    public void delete(String customerId) {
        String sql = "delete tbl_custom WHERE custom_id=?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            // 매개변수 바인딩
            pstmt.setString(1, customerId);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
        }  // try with resource  자동으로 자원을 종료합니다
    }

    //회원정보 조회 : select * from tbl_customer where custom_id = ?
    public CustomerVO getCustomer(String customerId) {
        String sql = "select * from tbl_custom where custom_id = ?";
        CustomerVO vo = null;
        
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, customerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                vo = new CustomerVO(rs.getString(1), 
                                    rs.getString(2),
                                    rs.getString(3), 
                                    rs.getInt(4),
                                    rs.getDate(5));
                
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  // try with resource  자동으로 자원을 종료합니다

        return vo;
    }

    //관리자를 위한 기능 : 모든 회원정보 조회
    // select * from tbl_customer
    public List<CustomerVO> allCustomers() {
        String sql = "select * from tbl_custom";
        List<CustomerVO> list = new ArrayList<>();

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                list.add(new CustomerVO(rs.getString(1), 
                rs.getString(2),
                rs.getString(3), 
                rs.getInt(4),
                rs.getDate(5)));       // add() 
            }
            
            System.out.println("allCustomers : 전체 고객 출력");
            
        } catch (Exception e) {
        	System.out.println("allCustomers : " + e.getMessage());
        	
        }  // try with resource  자동으로 자원을 종료합니다

        return list;
    } 

    
    public List<CustomerVO> selectByNameAge(String name, int age) {
    	String sql = "select * from tbl_custom where name = ? and age = ?";
    	List<CustomerVO> list = new ArrayList<>();
    	
    	try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
            ) {
    			pstmt.setString(1, name);
    			pstmt.setInt(2, age);
                ResultSet rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    list.add(new CustomerVO(rs.getString(1), 
                    rs.getString(2),
                    rs.getString(3), 
                    rs.getInt(4),
                    rs.getDate(5)));       // add() 
                }
                
                System.out.println("selectByNameAge : 고객 출력하기");
                
            } catch (Exception e) {
            	System.out.println("selectByNameAge : " + e.getMessage());
            	
            }  // try with resource  자동으로 자원을 종료합니다
    	
    	return list;
    }

}


/**
 * 데이터에 접근하는 객체가 할 일
 * 할 일1: SQL 작성
 * 할 일2: 매개변수 바인딩
*/ 