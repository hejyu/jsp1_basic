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

import project.dao.TblProductDao;
import project.vo.ProductVO;


@WebServlet(urlPatterns = {"/products.cc"}, description = "상품 전체 조회")
public class ProductServlet extends HttpServlet {

	private static final long serivalVersionUID = 1L;	// long : 고정 데이터타입 , int : 가변 데이터타입
	private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		TblProductDao dao = new TblProductDao();
		List<ProductVO> list = dao.allProducts();
		
		logger.info("[ProductServlet] 상품 전체 목로 조회 {}" , list);
		
		// jsp 뷰에 보낼 애트리뷰트 값을 저장합니다
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/day3/products.jsp");
		
		dispatcher.forward(req, res);
	}
	
}
