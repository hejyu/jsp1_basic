package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//서블릿이 되기 위한 몇가지(별도정리)
// URL 이 필요합니다.
@WebServlet(name="first.cc", description = "처음 만드는 서블릿")
public class FirstServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	// 로거를 작동시키기 위한 변수 선언 : 메소드 인자는 현재 클래스 이름
	private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);
	
	public FirstServlet() {
		super();
	}

	
	//get 요청을 처리하는 메소드 - 인자 2개 (XXXRequest, XXXResponse .. 요청과 응답에 대한 처리 가능)
	//사용자 요청을 request 객체에 저장하면서 동시에 응답을 전달할 객체 response가 생성됨	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	

}


/* 서블릿
 *  - 서버에서 실행되다가 웹 브라우저에서 요청을 하면 해당 기능을 수행한 후 웹 브라우저에 결과를 전송(응답)하는데, 이러한 역할을 수행하는 것
 * 
 */