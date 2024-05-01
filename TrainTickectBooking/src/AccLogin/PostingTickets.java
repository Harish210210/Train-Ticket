package AccLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostingTickets {
	public void sendTickets(int pnr, String from, String to, String train, String date, String coach, int len) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/plf_training",
					"plf_training_admin", "pff123");
			Statement st = cn.createStatement();
			String qry = "INSERT INTO h_tickets VALUES (" + pnr + ", '" + date + "', '" + from + "', '" + to + "', '"
					+ coach + "', " + len + ", '" + train + "')";
			st.executeUpdate(qry);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
