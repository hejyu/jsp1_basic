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

import project.dao.TblBuyDao;
import project.vo.BuyVO;


@WebServlet(urlPatterns = {"/buys.cc"}, description = "구매 목록 전체 조회")
public class BuyServlet extends HttpServlet {

	private static final long serivalVersionUID = 1L;	// long : 고정 데이터타입 , int : 가변 데이터타입
	private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		TblBuyDao dao = new TblBuyDao();
		List<BuyVO> list = dao.allBuyInfo();
		
		logger.info("[BuyServlet] 구매 목록 전체조회 : {}", list);
	
		// jsp 뷰에 보낼 에트리뷰트 값을 저장합니다
		req.setAttribute("list", list);
		
		// 화면을 전환합니다 (requestDispatcher 객체를 사용)
		RequestDispatcher rd = req.getRequestDispatcher("/day3/buys.jsp");
		rd.forward(req, res);
	}
	
}
