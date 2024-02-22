package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//서블릿이 되기 위한 몇가지(별도정리)
// URL 이 필요합니다.
@WebServlet(name = "first.cc", urlPatterns = { "/first.cc" })
public class FirstServlet1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	// 로거를 작동시키기 위한 변수 선언 : 메소드 인자는 현재 클래스 이름
	private static final Logger logger = LoggerFactory.getLogger(FirstServlet1.class);
	
	public FirstServlet1() {
		super();
	}

	
	//get 요청을 처리하는 메소드 - 인자 2개 (XXXRequest, XXXResponse .. 요청과 응답에 대한 처리 가능)
	//사용자 요청을 request 객체에 저장하면서 동시에 응답을 전달할 객체 response가 만들어짐
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 사용자의 요청에 대한 정보 출력 (request 객체의 속성값) : 로그 출력에서 {} 는 결과값 표시
		logger.info("\n[MyInfo] : request URL : {}, URL : {}, 컨텍스트패스 : {}",
					req.getRequestURI(), req.getRequestURI(), req.getContextPath()
				);
		
		// [MyInfo] : request URL : /jsp1/first.cc, URL : /jsp1/first.cc, 컨텍스트패스 : /jsp1

		// 테스트 : 서블릿에서 html 출력 응답도 만들어봅시다
		// out 은 jsp 기본제공 객체입니다(선언없이 사용가능) , 서블릿은 직접 생성(response 객체로 생성)
		res.setContentType("text/html; charset=UTF-8");		// ㅌ
		PrintWriter out = res.getWriter();		// response 객체 출력스트림 생성
		out.print("<html>");
		out.print("<head><title>WELCOME</title></head>");
		out.print("<body><h2>Hello World </h2>");
		out.print("현재 날짜와 시간 : " + LocalDateTime.now());
		out.print("</body>");
		out.print("</html>");
		
		
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