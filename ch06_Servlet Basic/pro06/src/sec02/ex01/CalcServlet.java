package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	private static float USD_RATE = 1124.70F;
	private static float JPY_RATE = 10.113F;
	private static float CNY_RATE = 163.30F;
	private static float GBP_RATE = 1444.35F;
	private static float EUR_RATE = 1295.97F;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public CalcServlet() {
    //    super();
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //응답은 HttpServletResponse 객체를 이용한다.
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); // 웹 브라우저에서 전송된 데이터의 인코딩을 설정한다.
		response.setContentType("text/html; charset=utf-8"); // setContentType()을 이용해 응답할 데이터 종류가 HTML임을 설정한다.
		PrintWriter pw = response.getWriter(); //HttpServletResponse 객체와 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아 온다.
		String command = request.getParameter("command"); // 수행할 요청을 받아 온다
		String won = request.getParameter("won"); // 변환할 요청을 받아 온다.
		String operator = request.getParameter("operator"); //변환할 외화 종류를 받아 온다.
		
		if (command != null && command.contentEquals("calculate")) // 최초 요청시 command가 null이면 계싼기 화면을 출력하고, command 값이 calculate이면 계싼 결과를 출력한다.
		{
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환 결과 </font><br>");
			pw.print("<html><font size=10>"+ result + "</font><br>");
			pw.print("<a href='/pro06Practice/cal'>환율 계산기</a>");
			return;
		}
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<html><font size=5>환율 계산기 </font><br>");
		pw.print("<form name='frmCalc' method='get' action='/pro06Practice/calc'/>"); // 원화 입력 후 다시 서블릿 calc로 요청한다.
		pw.print("원화: <input type='text' name='won' size=10 /> ");
		pw.print("<select name='operator'>"); // 셀렉트 박스에서 선택된 값을 name으로 전송한다.
		pw.print("<option value='dollar'>달러</option>"); 
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>엔화</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'/>"); // <hidden> 태그를 이용해 계산기에서 서블릿으로 수행할 요청을 전달한다.
		pw.println("<input type='submit' value='변환' />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private String calculate(float won, String operator) {
		// TODO Auto-generated method stub
		String result= null;
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won/USD_RATE);
		} else if (operator.equals("en")) {
			result = String.format("%.6f", won/JPY_RATE);
		} else if (operator.equals("wian")) {
			result = String.format("%.6f", won/CNY_RATE);
		} else if (operator.equals("pound")) {	
			result = String.format("%.6f", won/GBP_RATE);
		} else if (operator.equals("euro")) {
			result = String.format("%.6f", won/EUR_RATE);
		}
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
