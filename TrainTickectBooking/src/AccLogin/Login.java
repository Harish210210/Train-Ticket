package AccLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
// @WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 = request.getParameter("un");
		String s2 = request.getParameter("ps");
		try {
			Class.forName("org.postgresql.Driver");
			Connection cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/plf_training",
					"plf_training_admin", "pff123");
			Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select * from h_logins where username='" + s1 + "' and pass='" + s2 + "'");
			if (rs.next()) {
				response.setContentType("text/plain");
				PrintWriter out = response.getWriter();
				try {
					out.println("trains.html");
				} finally {
					out.close();
				}
			} else {
				response.setContentType("text/plain");
				PrintWriter out = response.getWriter();
				try {
					out.println("error");
				} finally {
					out.close();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
