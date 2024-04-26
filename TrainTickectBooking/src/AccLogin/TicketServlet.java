package AccLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PostingTickets pt = new PostingTickets();
		pt.sendTickets(pnr, from, to, train, date, coach, len);
		response.setContentType("plain/text");
		PrintWriter out = response.getWriter();
		out.print("success");
	}

}
