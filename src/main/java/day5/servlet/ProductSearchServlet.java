package day5.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.CateDto;
import day4.mybatis.dto.ProductDto;

@WebServlet(urlPatterns = {"/search-product.cc"}, description = "상품 검색")
public class ProductSearchServlet extends HttpServlet{

	
	private static final long serivalVersionUID = 1L;	// long : 고정 데이터타입 , int : 가변 데이터타입
	private static final Logger logger = LoggerFactory.getLogger(ProductSearchServlet.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		MybatisProductDao dao = new MybatisProductDao();
		
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		
		Map<String,Object> map = new HashMap<>();
		
		if(category !=null && category.trim().length() != 0) {
			map.put("category", category);
			req.setAttribute("cate", category);
		}
		
		if(keyword !=null && !keyword.isEmpty()) {
			map.put("keyword", keyword.trim());
			req.setAttribute("keyword", keyword);
		}
		
		if((from !=null && !from.isEmpty()) 
				&& (to !=null && !to.isEmpty())) {
			map.put("from", from.trim());
			map.put("to", to.trim());		
		}
		
		List<ProductDto> list = dao.search(map);
		List<CateDto> cateList = dao.getCategories();
		
		logger.info("[ProductSearchServlet] 쿼리 파라미터 category={},keyword={},from={},to={}" , category, keyword, from, to);
		logger.info("[ProductSearchServlet] 파라미터 Map {}" , map);
		logger.info("[ProductSearchServlet] 상품 검색 {}" , list);
		logger.info("[ProductSearchServlet] 카테고리 " , cateList);
		
		// jsp 뷰에 보낼 애트리뷰트 값을 저장합니다
		req.setAttribute("list", list);
		req.setAttribute("cateList", cateList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/day5/search.jsp");
		dispatcher.forward(req, res);
	}
	
	


	
	
	
	
}
