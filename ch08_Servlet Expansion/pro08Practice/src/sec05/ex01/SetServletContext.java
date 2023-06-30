package sec05.ex01;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cset")
public class SetServletContext extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context =getServletContext(); // Servlet COntext 객체를 가져온다.
//		List member = new ArrayList(); // 이 코드가 맞으나, 오류가 있어서 하기 코드로 대체함.
		ArrayList member = new ArrayList();
		member.add("이순신");
		member.add(30);
		context.setAttribute("member", member); // ServletContext 객체에 데이터를 바인딩 한다.
		out.print("<html><body>");
		out.print("이순신과 30 설정");
		out.print("</body></html>");
	}
}
