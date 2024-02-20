package project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import project.vo.BuyVO;
import project.vo.CustomBuyVO;

/**
 * tbl_buy DAO : tbl_buy 테이블 데이터에 접근하는 객체
 * insert, update, delete
 */
public class TblBuyDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME ="c##idev";
    public static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // executeUpdate 메소드는 insert, update, delete 가 정상 실행(반영된 로우 있으면)되고 나면 1을 리턴하고,
    //                                  ㄴ update, delete 는 조건에 맞는 로우가 없어서 반영된 로우가 없으면 0을 리턴함.
    // 구매하기 
    public int insert(BuyVO vo){
        String sql = "insert into tbl_buy(buy_idx, customid, pcode, quantity, buy_date) "+
                    "values(buy_pk_seq.nextval,?,?,?,sysdate)";

        int result = 0;
           
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            // 매개변수 바인딩
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());
            result = pstmt.executeUpdate();
            
        } catch (Exception e) {
            // customid(custom 테이블) 와 pcode(product 테이블) 는 참조테이블에 존재하는 값으로 안하면 무결성 위반 오류 
           System.out.println("구매 상품 추가 오류 발생 : " + e.getMessage());
        }
        return result;
    }

    // 장바구니 모두 구매 addBatch
    // ㄴ batch (배치) 는 일괄처리 : 실행할 insert, update, delete 등 데이터 저장 dml 을 모아 두었다가
    //                               한번에 실행시킵니다.
    // ㄴ 트랜잭션 : 특졍 요구사항에 대한 기능을 실행할 여러 sql 명령들로 구성된 `작업단위`
    //                  ㄴ 예시 : cart 에 저장된 상품 중 하나라도 참조값이 없는 pcode 가 있으면 rollback
    //                                  모두 정상이면 commit
    //                     트랜잭션 commit 모드가 auto 에서 수동으로 변경.
    public int insertMany(List<BuyVO> cart){                        // 여러번의 insert를 실행 
        String sql = "insert into tbl_buy(buy_idx, customid, pcode, quantity, buy_date) "+
                    "values(buy_pk_seq.nextval,?,?,?,sysdate)";     // 위의 insert를 복붙하세요
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        int count = 0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            conn.setAutoCommit(false);  // auto 커밋 해제
            // 매개변수 바인딩
            for (BuyVO vo : cart) {
                pstmt.setString(1, vo.getCustomId());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch();           // sql 을 메모리에 모아두기 , batch 기능은 데이터베이스 하나에  
                                            // insert sql 에 대입되는 매개변수 값이 매번 다릅니다.
                count++;
            }
            pstmt.executeBatch();           // 모아둔 sql을 일괄 실행하기. 실행 중에 무결성 오류 생기면                           
            conn.commit();                  //  catch 에서 rollback 
        } catch (Exception e) {             // 예외발생 : 트랜잭션 처리 

            try {
                conn.rollback();
                pstmt.close();
                conn.close();
            } catch (SQLException el) {     }      // 트랜잭션 처리 
            count = -1;
            System.out.println("구매 불가능한 상품이 있습니다.");
            System.out.println("장바구니 구매 실행 예외 발생 : " + e.getMessage());
            // customid(custom 테이블) 와 pcode(product 테이블) 는 참조테이블에 존재하는 값으로 안하면 무결성 위반 오류 
           System.out.println("구매 상품 추가 오류 발생 : " + e.getMessage());
        } finally {
            try {           //트랜잭션 처리를 위해 conn을 직접 사용해야 하므로 직접 close 했습니다.
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return result;
    }

    // 구매 수량 수정 - pk 는 행을 식별합니다. 특정 행을 수정하려면 where 조건컬럼은 buy_idx(pk)
    public int modify(int count, int buy_idx){
        String sql = "update tbl_buy set quantity=? where buy_idx = ?";
        int result = 0;
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            // 매개변수 바인딩
            pstmt.setInt(1, count);
            pstmt.setInt(2, buy_idx);
            result = pstmt.executeUpdate();
            
        } catch (Exception e) {
           System.out.println("구매 상품 수량 변경 오류 발생 : " + e.getMessage());
        }
        
        return result;
    }

    public int modify(Map<String,Integer> arg){
        String sql = "update tbl_buy set quantity=? where buy_idx =?";
        int result = 0;
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            // 매개변수 바인딩
            pstmt.setInt(1, arg.get("buy_idx"));
            pstmt.setInt(2, arg.get("quantity"));
            result = pstmt.executeUpdate();
            // buy_idx 컬럼에 없는 값이면 오류는 아니고 update 반영한 로우 개수가 0 이됩니다
        } catch (Exception e) {
           System.out.println("구매 상품 수량 변경 오류 발생 : " + e.getMessage());
        }
        
        return result;
    }

    // 구매 취소 - pk 는 행을 식별합니다 . 특정 행을 삭제하려면 where 조건 컬럼을 buy_idx(pk)
    public int delete(int buy_idx){
        String sql = "delete tbl_buy where buy_idx = ?";
        int result = 0; 
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            // 매개변수 바인딩
            pstmt.setInt(1, buy_idx);
            result = pstmt.executeUpdate();
            // buy_idx 컬럼에 없는 값이면 오류는 아니고 update 반영한 로우 개수가 0 이됩니다
        } catch (Exception e) {
           System.out.println("구매 상품 삭제 오류 발생 : " + e.getMessage());
        }
        
        return result;
    }


    //마이페이지 기능
    public List<CustomBuyVO> selectCustomBuyList(String customId) {
        String sql = "SELECT buy_idx, tb.pcode, pname, price, quantity, buy_date \r\n" + //
                "FROM TBL_BUY tb \r\n" + //
                "JOIN TBL_PRODUCT tp \r\n" + //
                "ON tb.PCODE  = tp.PCODE \r\n" + //
                "WHERE tb.CUSTOMID = ?\r\n" + //
                "ORDER BY BUY_DATE desc";

        List<CustomBuyVO> list = new ArrayList<>();

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, customId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CustomBuyVO(rs.getInt(1),
                                         rs.getString(2), 
                                         rs.getString(3),
                                         rs.getInt(4), 
                                         rs.getInt(5),
                                         rs.getTimestamp(6)));
            }
        } catch (SQLException e) {
            System.out.println(" selectCustomBuyList 오류 발생 : " + e.getMessage());
        }

        return list;
    }
    

    public List<BuyVO> selectBuyList(String customId) {
        List<BuyVO> list = new ArrayList<>();
        String sql = "SELECT buy_idx, pcode, quantity   FROM tbl_buy WHERE CUSTOMID = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, customId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BuyVO vo = new BuyVO(customId, rs.getString(1),rs.getInt(2));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(" selectBuyList 오류 발생 : " + e.getMessage());
        }


        return list;
    }


    public int money_of_dayByCustomer(String customid,String buydate){
        String sql = "{ call money_of_day(?,?,?) }";
        int money=0;
        try (
            Connection connection = getConnection();
            CallableStatement cstmt = connection.prepareCall(sql)
        ) {
            //프로시저의 IN 매개변수값 전달 : setXXX
            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);

            //프로시저 OUT 매개변수 1) 타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();      //프로시저 실행
            // OUT 매개변수 2) 결과값 가져오기 : getXXX
            money = cstmt.getInt(3);
            
        } catch (SQLException e) {
            System.out.println("money_of_dayByCustomer 프로시저 실행 예외 : " + e.getMessage());
        }

        return money;
    }
    
}

/**
 * 재료로 만든 클래스
 * 
 */