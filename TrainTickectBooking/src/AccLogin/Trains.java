package AccLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class Trains
 */
public class Trains extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		GetTrains gt = new GetTrains();
		HashMap<Integer, ArrayList<Integer>> hm = gt.getTotalTrains();
		ArrayList<String> al = gt.getTrains(hm, from, to);
		JSONArray jsonArray = new JSONArray();
		for (String st : al) {
			JSONObject obj = new JSONObject();
			obj.put("tname", st);
			jsonArray.put(obj);
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toString());
	}

}
