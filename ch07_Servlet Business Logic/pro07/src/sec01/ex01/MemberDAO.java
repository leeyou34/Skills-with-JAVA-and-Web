package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	private Connection con;
	private Statement stmt;

	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB(); // 네 가지 정보로 데이터베이스를 연결한다.
			String query = "select * from t_member ";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query); // SQL문으로 회원 정보를 조회한다.
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
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; // 조회한 레코드의 개수만큼 MemberVO 객체를 저장한 ArrayList를 반환한다.
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
