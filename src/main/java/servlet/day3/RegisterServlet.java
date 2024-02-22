package servlet.day3;

import java.io.IOException;

import javax.naming.PartialResultException;
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

@WebServlet(urlPatterns = {"/register.cc"}, description = "고객 등록")
public class RegisterServlet extends HttpServlet{

	private static final long serivalVersionUID = 1L;	// long : 고정 데이터타입 , int : 가변 데이터타입
	private static final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);

	
	// 화면을 보여주는 서블릿이므로 GET 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("[RegisterServlet] 고객 등록 화면 요청");
		
		// forward 만 필요합니다
		RequestDispatcher dispatcher = request.getRequestDispatcher("day3/register.jsp");
		dispatcher.forward(request, response);
	}
	
	// register.jsp 화면에서 입력된 값을 post 방식으로 전달 받기
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("[RegisterServlet doPost] 고객 등록 저장이 요청되었습니다");
	
		// POST : 요청값 인코딩 필수
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// 나이가 필수 입력 항목이 아니면 값이 비어 있을 수도 있음 그 때 parseInt 결과를 확인합시다  => 오류
		// form 태그 요소의 name = "age"  가 있으므로 temp 가 null 인 경우는 없습니다
		String temp = request.getParameter("age");		
		int age = 0;
		if(temp.length() != 0 ) age = Integer.parseInt(temp);
		
		
		
		// dao 의 메소드 인자로 전달할 vo 객체 생성하기
		CustomerVO vo = new CustomerVO(userid, name, email, age, null);
		
		logger.info("\t 입력 값 vo : {}", vo);
		
		// DB 에 저장하기
		TblCustomerDao dao = new TblCustomerDao();
		dao.join(vo); 	// pk 아이디 중복값 있으면 무결성 오류
	
		
		// 서버가 클라이언트에게 "customer.cc 로 요청을 보내라" 응답을 보냅니다
		// 
		response.sendRedirect("customers.cc");
		// 리다이렉트는 웹페이지의 자바스크립트, out.print 출력을 못합니다. 
		//					ㄴ 자바스크립트, html 코드를 삽입할 수 없음
		
	}
	
}
