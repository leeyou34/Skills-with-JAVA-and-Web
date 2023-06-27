package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guguTest2")
public class GuguTest2 extends HttpServlet{
	public void init()
	{
		System.out.println("init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("dan")); // 전송된 dan의 값을 받아 온다.
		out.print("<table border=1 width=800 align=center>");
		out.print("<tr align=center bgcolor='#FFFF06'>");
		out.print("<td colspan=2>" + dan + " 단 출력 </td>");
		out.print("</tr>");
		
		for (int i = 1;  i <10; i++) { // for 문을 이용해 연속해서 결과를 테이블 행으로 출력한다.
			if( i % 2 == 0)
			{
				out.print("<tr align=center bgcolor='#ACFA58'>");
			} else {
				out.print("<tr align=center bgcolor='#81BEF7'>");
			}
				out.print("<td width=400>");
				out.print(dan + " * " + i );
				out.print("</td>");
				out.print("<td width=400>");
				out.print(i * dan);
				out.print("</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		}
		public void destroy()
		{
			System.out.println("destory 메소드 호출");
	}

}
