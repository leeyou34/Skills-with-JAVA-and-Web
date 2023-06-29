package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member4")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
                                                    throws ServletException, IOException
		{
			doHandle(request, response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			doHandle(request, response);
		}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  request.setCharacterEncoding("utf-8");
	  response.setContentType("text/html;charset=utf-8");
      PrintWriter out=response.getWriter();
      MemberDAO dao=new MemberDAO(); // SQL문으로 조회할 MemberDAO 객체를 생성한다.
      List memberList=dao.listMembers();
      
	  request.setAttribute("membersList",memberList); // 조회된 회원 정보를 ArrayList 객체에 저장한 후 request에 바인딩 합니다.
	  RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
	  dispatch.forward(request, response); // 바인딩한 reqeust를 viewMembers 서블릿으로 포워딩합니다.
   }
}
