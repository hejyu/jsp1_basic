package servlet.day3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.dao.TblProductDao;
import project.vo.ProductVO;


@WebServlet(urlPatterns = {"/productReg.cc"}, description = "상품 등록")
public class ProductRegister extends HttpServlet{

	private static final long serivalVersionUID = 1L;	// long : 고정 데이터타입 , int : 가변 데이터타입
	private static final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);

	
	// 화면을 보여주는 서블릿이므로 GET 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("[ProductRegister] 상품 등록 화면 요청");
		
		// forward 만 필요합니다
		RequestDispatcher dispatcher = request.getRequestDispatcher("day3/productRegister.jsp");
		dispatcher.forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		logger.info("[ProductRegister doPost] 상품 등록 저장이 요청되었습니다");
		
		request.setCharacterEncoding("UTF-8");
		
		String pcode = request.getParameter("pcode");
		String category = request.getParameter("category");
		String pname = request.getParameter("pname");
		String temp = request.getParameter("price");
		
		int price = 0;
		
		if(temp.length() != 0) price = Integer.parseInt(temp);
		
		
		logger.info("파라미터 값 {} {} {} {} {}", pcode, category, pname, temp, price);
		
		// 상품 등록 메소드 인자로 전달할 vo 생성하기
		ProductVO vo = new ProductVO(pcode, category, pname, price);
		
		TblProductDao dao = new TblProductDao();
		dao.registerProduct(vo);
		
		response.sendRedirect("products.cc");
		
		
		
		
	} 
}
