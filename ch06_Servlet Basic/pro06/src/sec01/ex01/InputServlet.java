package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 사용자로부터 입력을 받아 로직을 처리하는 간단한 수강 신청 프로그램
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id"); // 한 개씩 전송된 값은 getParamter()를 이용한다.
		String user_pw = request.getParameter("user_pw"); // 한 개씩 전송된 값은 getParamter()를 이용한다.
		System.out.println("아이디:" + user_id);
		System.out.println("비밀번호:" + user_pw);
		
		String[] subject = request.getParameterValues("subject"); // 하나의 name으로 여러 값을 전송하는 경우 getParamaterValues()를 이용해 배열 형태로 반환한다.
		for (String str:subject) {
			System.out.println("선택한 과목:" + str);
		}
	}
	
	public void destroy() {
		System.out.println("destory 메서드 호출");
	}
}
