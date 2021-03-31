

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		if("last".equals(act)) {
			input(request, response);
			response.sendRedirect(root + "/user/last.jsp");
		} else if("login".equals(act)) {
			login(request, response);
		} else if("input".equals(act)) {
			response.sendRedirect(root + "/user/input.jsp");
		} 
	}

	private void input(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("pnum");
		String name = request.getParameter("pname");
		String price = request.getParameter("pprice");
		String desc = request.getParameter("pdesc");
		
		Cookie numc = new Cookie("num", num);
		Cookie namec = new Cookie("name", name);
		Cookie pricec = new Cookie("price", price);
		Cookie descc = new Cookie("desc", desc);
		numc.setPath(request.getContextPath());
		namec.setPath(request.getContextPath());
		pricec.setPath(request.getContextPath());
		descc.setPath(request.getContextPath());
		response.addCookie(numc);
		response.addCookie(namec);
		response.addCookie(pricec);
		response.addCookie(descc);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpwd");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
			String sql = "select username, email \n";
			sql += "from ssafy_member \n";
			sql += "where userid = ? and userpwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserName(rs.getString("username"));
				memberDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		String path = "/user/last.jsp";
		if(memberDto != null) { // 성공
//			session 설정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);

			
//			request.setAttribute("userinfo", memberDto);
//			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else { // 실패
			request.setAttribute("msg", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			path = "/user/login.jsp";
//			response.sendRedirect(request.getContextPath() + "/user/login.jsp");
		}
		
//		response.sendRedirect(request.getContextPath() + path);
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

	
}
