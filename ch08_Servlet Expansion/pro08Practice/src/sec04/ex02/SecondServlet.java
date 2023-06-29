package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Dispatch 방식
@WebServlet("/second8")
public class SecondServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out =response.getWriter();

		String address=(String)request.getAttribute("address"); // 전달된 request에서 getAttribute()를 이용해 address의 값을 가져옵니다.
		out.println("<html><body>");
		out.println("주소:"+ address);
		out.println("<br>");
		out.println("redirect 이용한 바인딩 실습입니다.");
		out.println("</body></html>");
	}
}
