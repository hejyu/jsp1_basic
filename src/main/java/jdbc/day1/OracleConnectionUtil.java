package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 오라클 새 데이터베이스 연결 관리 Manager 클래스
 */
public class OracleConnectionUtil {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USERNAME = "c##idev";
    public static final String PASSWORD = "1234";

    // Connection 타입 객체 생성 메서드. 
    // 사용 예
    // Connection conn = OracleConnectionUtil.getConnection()
    public static Connection getConnection() {
        Connection conn = null;
        
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(Exception e) {
            System.out.println("데이터베이스 연결 예외 발생 했습니다. \n\t : " + e.getMessage());
        }

        return conn;
    }
    // 실행 순서 : 1) getConnection 2)SQL 실행  3)close
    // SQL 실행 : 개발 프로그램에서 가장 많이 실행하는 SQL 은 DML 입니다.(SELECT, INSERT, UPDATE, DELETE)
    //              OracleConnectionUtil 은 새 데이터베이스 연결할 때와 연결 해제할 때 사용합니다


    // 인자로 전달된 Connection 객체를 close, sql 실행이 종료되면 close 해야 합니다.
    public static void close(Connection conn) {
        try {
            if(conn != null) conn.close();


        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 해제 예외 발생");
        }
    }
}

/**
 * 팀원들끼리 연습 (각자 코딩하고 샘플 데이터만 공유합니다)
 *  - 주제 : 키오스크(메뉴데이터, 매출데이터), 단어장, 주소록
 *          테이블 1~3개
 * 
 *  - 간단한 jdbc 연습 프로그램
 * 
 *  1. 조별로 주제를 통일해서 합니다
 *  2. 샘플 데이터를 분담해서 입력합니다
 *  3. 코딩은 각자 dml 연습 하면서 질의응답하세요
 *  
 *  4. main 함수가 메뉴 선택 등 인터페이스 복잡해질 수 는 있습니다
 *  5. jdbc 는 기본 형식에 따라 연결, 연결해제 합니다 
 * 
 *  
 * 
 */