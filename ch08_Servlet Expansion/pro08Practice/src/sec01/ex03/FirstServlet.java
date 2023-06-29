package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first3")
public class FirstServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//response.sendRedirect("second");
		out.print("<script type='text/javascript'>");
		out.print("location.href='second';");
		out.print("</script>");
	}
}
