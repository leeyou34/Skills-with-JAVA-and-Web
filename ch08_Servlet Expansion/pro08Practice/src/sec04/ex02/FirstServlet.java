package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 바인딩. HttpServletRequest를 이용한 redirect 포워딩 시 바인딩
@WebServlet("/first8")
public class FirstServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("address", "서울시 성북구"); // 웹 브라우저의 최초 요청 request에 바인딩 합니다.
		RequestDispatcher dispatch = request.getRequestDispatcher("second8");
		dispatch.forward(request, response);
		} 
}
