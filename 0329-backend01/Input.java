import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/input")
public class Input extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("상품등록");
		String pname = req.getParameter("pname");
		System.out.println("상품명 : " + pname);
		String pprice = req.getParameter("pprice");
		System.out.println("상품가격 : " + pprice);
		String pdesc = req.getParameter("pdesc");
		System.out.println("상품설명 : " + pdesc);
	}
}
