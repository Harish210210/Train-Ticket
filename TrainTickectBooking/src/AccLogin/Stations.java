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

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class Stations
 */
public class Stations extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
			Connection cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/plf_training",
					"plf_training_admin", "pff123");
			Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select * from h_stations");
			JSONArray jsonArray = new JSONArray();
			while (rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("sid", rs.getString(1));
				obj.put("sname", rs.getString(2));
				jsonArray.put(obj);
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(jsonArray.toString());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
