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
 * Servlet implementation class TicketServlet
 */
public class TicketServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String from = request.getParameter("fr");
		String to = request.getParameter("tt");
		String train = request.getParameter("tr");
		String date = request.getParameter("dt");
		String coach = request.getParameter("ch");
		int pnr = Integer.parseInt(request.getParameter("pn"));
		int len = Integer.parseInt(request.getParameter("ln"));
		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> gender = new ArrayList<>();
		ArrayList<String> age = new ArrayList<>();
		ArrayList<String> preferences = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			names.add(request.getParameter("name" + i));
			gender.add(request.getParameter("gender" + i));
			age.add(request.getParameter("age" + i));
			preferences.add(request.getParameter("pref" + i));
		}
		PostingTickets pt = new PostingTickets();
		pt.sendTickets(pnr, from, to, train, date, coach, len);
		SetPassengers sp = new SetPassengers();
		sp.sendPassengers(from, to, coach, pnr, names, gender, age, preferences);
		GetPassengerDetails pd = new GetPassengerDetails();
		HashMap<String, ArrayList<String>> hm = pd.getPassengers(pnr);
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < (hm.get("pname")).size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("pname", (hm.get("pname")).get(i));
			obj.put("page", (hm.get("page")).get(i));
			obj.put("pgen", (hm.get("pgen")).get(i));
			obj.put("ppref", (hm.get("ppref")).get(i));
			obj.put("pprice", (hm.get("pprice")).get(i));
			jsonArray.put(obj);
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toString());
	}

}
