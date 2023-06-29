package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Dispatch 방식
@WebServlet("/second6")
public class SecondServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out =response.getWriter();
		String name=request.getParameter("name"); // 다른 서블릿에서 전달된 데이터를 가져온다.
		out.println("<html><body>");
		out.println("이름:"+ name);
		out.println("<br>");
		out.println("dispatch 이용한 forward 실습입니다.");
		out.println("</body></html>");
	}
}
