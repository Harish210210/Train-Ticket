package AccLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class GetPassengerDetails {
	public HashMap<String, ArrayList<String>> getPassengers(int pnr) {
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/plf_training",
					"plf_training_admin", "pff123");
			Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st
					.executeQuery("select pname, page, pgen, ppref, pprice from h_passengers where tpnr = " + pnr);
			hm.put("pname", new ArrayList<String>());
			hm.put("page", new ArrayList<String>());
			hm.put("pgen", new ArrayList<String>());
			hm.put("ppref", new ArrayList<String>());
			hm.put("pprice", new ArrayList<String>());
			while (rs.next()) {
				ArrayList<String> pname = new ArrayList<>(hm.get("pname"));
				pname.add(rs.getString(1));
				ArrayList<String> page = new ArrayList<>(hm.get("page"));
				page.add(rs.getString(2));
				ArrayList<String> pgen = new ArrayList<>(hm.get("pgen"));
				pgen.add(rs.getString(3));
				ArrayList<String> ppref = new ArrayList<>(hm.get("ppref"));
				ppref.add(rs.getString(4));
				ArrayList<String> pprice = new ArrayList<>(hm.get("pprice"));
				pprice.add(rs.getString(5));
				hm.put("pname", pname);
				hm.put("page", page);
				hm.put("pgen", pgen);
				hm.put("ppref", ppref);
				hm.put("pprice", pprice);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return hm;
	}
}
