package servlet.day3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblCustomerDao;
import project.vo.CustomerVO;



@WebServlet(urlPatterns = {"/customers.cc"}, description = "고객 전체 조회")
public class CustomerServlet extends HttpServlet {
	
	private static final long serivalVersionUID = 1L;	// long : 고정 데이터타입 , int : 가변 데이터타입
	private static final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);
	
	//고객 전체 조회 요청은 a 태그 메뉴 이므로 get 방식 요청입니다
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// dao 를 실행하고 리턴받은 list 를 로그로 출력해봅시다
		TblCustomerDao dao = new TblCustomerDao();
		List<CustomerVO>  list = dao.allCustomers();
		
		logger.info("[@,@] 고객전체조회 : {}", list);
		// 정보: [@,@] 고객전체조회 : [mina012, 김미나,  kimm@gmail.com,  32, 2022-03-10, hongGD, 홍길동,  gil@korea.com,  32, 2021-10-21, twice, 박모모,  momo@daum.net,  29, 2021-12-25, wonder, 이나나,  lee@naver.com,  0, 2024-01-26, nayeon, 박나연,  na@gmail.com,  26, 2024-01-29, nayeon33, 박나연3,  na3@gmail.com,  25, 2024-01-29, sana, 최사나,  sana@naver.com,  26, 2024-01-29, sana77, 김사나,  kimsana77@gmail.com,  20, 2024-01-29, dongL, 이길동,  lee@daum.net,  25, 2024-01-29, sana9999, 김사나,  sana@gmail.com,  23, 2024-02-20, momo99, 홍길동,  momo30@gmail.com,  30, 2024-01-29, sana676869, 김사나,  sana@gmail.com,  23, 2024-02-20]

		// 서블릿 : jdbc 관련 프로그램을  실행
		// jsp : 조회결과 웹 페이지를 작성
		// 서블릿은 요청과 응답을 처리하는 컨트롤러가 되고, jsp 는 뷰(View)가 됩니다
		
		// 뷰 jsp 에 애트리뷰트 값을 저장해서 보내기
		// pageContext는 하나의 웹페이지 범위, request 는 하나의 요청 범위로 애트리뷰트 저장
		req.setAttribute("list", list);
		
		// 뷰 jsp 로 요청을 전달하고 애트리뷰트 값을 가져가는 과정이 포함되고 화면을 전환(forward) 해야합니다
		// RequestDispatcher: 화면을 전환하기 위해 만들어진 객체
		RequestDispatcher dispatcher = req.getRequestDispatcher("/day3/customers.jsp");
		dispatcher.forward(req, res);
		// 실행 브라우저 url : http://localhost:8088/jsp1/customer.cc 이고
		//						ㄴ 해당하는 화면의 웹 페이지는 customer.jsp입니다
		
	}
	
	
	
	
}
