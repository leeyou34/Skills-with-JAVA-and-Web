package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDAO {
	/*
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	*/
	private Connection con;
	//private Statement stmt;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO()
	{
		try
		{
			Context ctx = new InitialContext(); // JNDI에 접근하기 위해 기본 경로 (java:/comp/env)
			Context envContext = (Context) ctx.lookup("java:/comp/en");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle"); // 톰캣 context.xml에 설정한 name 값인 jdbc/oracle을 이용해 톰캣이 미리 연결한 DataSource를 받아 온다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
//			connDB(); // 네 가지 정보로 데이터베이스를 연결한다.
			String query = "select*from t_member ";
			System.out.println("prepareStatement" + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(); // SQL문으로 회원 정보를 조회한다.
			while (rs.next()) {
				String id = rs.getString("id"); 		// 조회한 레코드의 각 컬럼 값을 받아 온다.
				String pwd = rs.getString("pwd"); 		// 조회한 레코드의 각 컬럼 값을 받아 온다.
				String name = rs.getString("name"); 	// 조회한 레코드의 각 컬럼 값을 받아 온다.
				String email = rs.getString("email"); 	// 조회한 레코드의 각 컬럼 값을 받아 온다.
				Date joinDate = rs.getDate("joinDate"); // 조회한 레코드의 각 컬럼 값을 받아 온다.
				MemberVO vo = new MemberVO(); 	// 각 컬럼 값을 다시 MemberVO 객체의 속성에 설정한다.
				vo.setId(id);				// 각 컬럼 값을 다시 MemberVO 객체의 속성에 설정한다.
				vo.setPwd(pwd);				// 각 컬럼 값을 다시 MemberVO 객체의 속성에 설정한다.
				vo.setName(name);			// 각 컬럼 값을 다시 MemberVO 객체의 속성에 설정한다.
				vo.setEmail(email);			// 각 컬럼 값을 다시 MemberVO 객체의 속성에 설정한다.
				vo.setJoinDate(joinDate);	// 각 컬럼 값을 다시 MemberVO 객체의 속성에 설정한다.
				list.add(vo);				// 설정된 MemberVO 객체를 다시 ArrayList에 저장한다.
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 조회한 레코드의 개수만큼 MemberVO 객체를 저장한 ArrayList를 반환한다.
	}

/*	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
