package AccLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SetPassengers {
	public void sendPassengers(String from, String to, String coach, int pnr, ArrayList<String> names,
			ArrayList<String> gender, ArrayList<String> age, ArrayList<String> preferences) {
		try {
			int fare = 0;
			Class.forName("org.postgresql.Driver");
			Connection cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/plf_training",
					"plf_training_admin", "pff123");
			Statement st = cn.createStatement();
			Statement st2 = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery(
					"select * from h_distancefair where distance > ABS((select distance_in_km from h_distances where from_station = 'Vishakapatnam' and to_station = '"
							+ from
							+ "') - (select distance_in_km from h_distances where from_station = 'Vishakapatnam' and to_station = '"
							+ to + "')) Limit 1");
			rs.next();
			if (coach.equals("Sleeper")) {
				fare = (int) rs.getInt(2);
			} else if (coach.equals("1st AC")) {
				fare = (int) rs.getInt(2) + 150;
			} else if (coach.equals("2nd Ac")) {
				fare = (int) rs.getInt(2) + 100;
			} else {
				fare = (int) rs.getInt(2) + 50;
			}
			for (int i = 0; i < names.size(); i++) {
				String str = names.get(i);
				if (!str.equals("*")) {
					int k = Integer.parseInt(age.get(i));
					double price = 0;
					if (k <= 12) {
						price = fare - ((double) fare / 2);
					} else if (k >= 65) {
						price = fare - ((double) fare * 3 / 10);
					} else {
						price = fare;
					}
					st.addBatch("insert into h_passengers values(" + pnr + ", '" + names.get(i) + "', " + k + ", '"
							+ gender.get(i) + "', '" + preferences.get(i) + "', " + price + ")");
				} else {
					break;
				}
			}
			st.executeBatch();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
