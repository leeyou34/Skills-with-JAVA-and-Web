package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member3")
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
      MemberDAO dao=new MemberDAO(); // SQL문으로 조회할 MemberDAO 객체를 생성한다.
      PrintWriter out=response.getWriter();
      String command = request.getParameter("command");
      
      if (command !=null && command.contentEquals("addMember"))
      {
    	  String _id = request.getParameter("id");
    	  String _pwd = request.getParameter("pwd");
    	  String _name = request.getParameter("name");
    	  String _email = request.getParameter("email");
    	  
    	  MemberVO vo = new MemberVO();
    	  
    	  vo.setId(_id);
    	  vo.setPwd(_pwd);
    	  vo.setName(_name);
    	  vo.setEmail(_email);
    	  dao.addMember(vo);
      } else if (command !=null && command.contentEquals("delMember"))
      {
    	  String id = request.getParameter("id"); // command 값이 delMember인 경우 ID를 가져와 SQL문으로 전달해서 삭제한다.
    	  dao.delMember(id);
      }
      List<MemberVO> list=dao.listMembers(); // listMembers() 메서드로 회원 정보를 조회한다.
      out.print("<html><body>");
      out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
     
     for (int i=0; i<list.size();i++){ // 조회한 회원 정보를 for문과 <tr>태그를 이용해 리스트로 출력한다.
		MemberVO memberVO=(MemberVO) list.get(i);
		String id=memberVO.getId();
		String pwd = memberVO.getPwd();
		String name=memberVO.getName();
		String email=memberVO.getEmail();
		Date joinDate = memberVO.getJoinDate();
		out.print("<tr><td>"+id+"</td><td>"+
			                pwd+"</td><td>"+
			                name+"</td><td>"+
			                email+"</td><td>"+
			                joinDate+"</td></tr>"+
			                "<a href='/pro07Practice/member3?command=delMember&id="+id+"'>삭제</a></td></tr>");		
      }
      out.print("</table></body></html>");
      out.print("<a href='/pro07Practice/memberForm.html'> 새 회원 등록하기 </a>");
   }
}
