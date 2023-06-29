package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Dispatch 방식
@WebServlet("/second5")
public class SecondServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out =response.getWriter();
		out.println("<html><body>");
		out.println("dispatch를 이용한 forward 실습입니다."); // name으로 이전 서블릿에서 전달된 lee를 받습니다.
		out.println("</body></html>");
	}
}
