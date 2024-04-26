package AccLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class GetTrains {
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;
	ResultSet rs2 = null;

	public HashMap<Integer, ArrayList<Integer>> getTotalTrains() {
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		try {
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/plf_training", "plf_training_admin",
					"pff123");
			st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from h_stops");
			while (rs.next()) {
				if (hm.containsKey(rs.getInt(1))) {
					ArrayList<Integer> al = new ArrayList<>(hm.get(rs.getInt(1)));
					al.add(rs.getInt(2));
					hm.put(rs.getInt(1), al);
				} else {
					ArrayList<Integer> al = new ArrayList<>();
					al.add(rs.getInt(2));
					hm.put(rs.getInt(1), al);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return hm;
	}

	public ArrayList<String> getTrains(HashMap<Integer, ArrayList<Integer>> hm, String from, String to) {
		ArrayList<String> al = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/plf_training", "plf_training_admin",
					"pff123");
			st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs2 = st.executeQuery(
					"SELECT DISTINCT t.tname FROM h_trains t JOIN h_stops s ON t.tid = s.tid JOIN h_stations st ON s.sid = st.sid WHERE st.sname IN ('"
							+ from + "', '" + to + "') GROUP BY t.tname HAVING COUNT(DISTINCT st.sname) = 2");
			while (rs2.next()) {
				al.add(rs2.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return al;
	}
}
