package Proj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "unokim";
	String password = "unokim";

	private Connection con;
	private Statement stmt;
	private ResultSet rs, rsCheckpassoword;

	public boolean insert(String id, String password, String email) {
		boolean b = false;
		try {
			connDB();
			String queryInsert = "INSERT INTO user_info VALUES('" + id + "','" + password + "','" + email + "')";
			System.out.println(queryInsert);
			b = stmt.execute(queryInsert);
			if (!b) {
				System.out.println("Insert success.");
			} else {
				System.out.println("Insert fail.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return !b;
	}

	public ArrayList<MemberVo> Login(String id) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();
			String query = "select * from user_info where id='" + id + "'";
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println(query);
			System.out.println(rs.getRow());
			Date today = new Date();
			String password = rs.getString("password");
			String email = rs.getString("e_mail");
			System.out.println("SQL : " + query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			String query2 = "insert into login_info values ( '" + id + "','" + password + "','" + email + "','" + today
					+ "')";
			System.out.println(query2);
			rs = stmt.executeQuery(query2);
			if (rs.getRow() == 0) {
				MemberVo data = new MemberVo(id, password, email, today);
				list.add(data);
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
					System.out.println("Áßº¹");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean Logout(String id) {
		boolean b = false;
		try {
			connDB();
			String queryInsert = "delete from login_info where id = '" + id + "'";
			System.out.println(queryInsert);
			b = stmt.execute(queryInsert);
			if (!b) {
				System.out.println("·Î±×¾Æ¿ô ¿Ï·á");
			} else {
				System.out.println("Logout fail.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return !b;
	}

	public boolean modificationInfo(String id, String pw, String email) {
		boolean b = false;
		boolean b2 = false;
		try {
			connDB();
			String queryInsert = "update user_info set password='" + pw + "', e_mail='" + email + "' where id='" + id
					+ "'";
			String queryInsert2 = "update login_info set login_password='" + pw + "', login_e_mail='" + email
					+ "' where id='" + id + "'";
			System.out.println(queryInsert);
			System.out.println(queryInsert2);
			b = stmt.execute(queryInsert);
			if (!b) {
				System.out.println("Change succes.");
			} else {
				System.out.println("Change fail.");
			}
			b2 = stmt.execute(queryInsert2);
			if (!b2) {
				System.out.println("Change login success.");
			} else {
				System.out.println("Change login fail.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return !b;
	}

	public boolean withrawalUser(String id) {
		boolean b = false;
		try {
			connDB();
			String queryInsert = "delete from user_interest_list where id ='" + id + "'";
			b = stmt.execute(queryInsert);
			String queryInsert2 = "delete from user_info where id ='" + id + "'";
			System.out.println(queryInsert2);
			b = stmt.execute(queryInsert2);
			if (!b) {
				System.out.println("È¸¿øÅ»Åð¿Ï·á");
			} else {
				System.out.println("Å»Åð½ÇÆÐ");
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

		return !b;
	}

	public boolean SaveSuggestionDater(String id, String sg, int survey) {
		boolean b = false;
		try {
			connDB();
			String queryInsert = "insert into suggestion (suggestion_id,reason, survey) values ('" + id + "', '" + sg
					+ "', '" + survey + "')";
			System.out.println(queryInsert);
			b = stmt.execute(queryInsert);
			if (!b) {
				System.out.println("Suggestion save succes.");
			} else {
				System.out.println("Suggestion save fail.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return !b;
	}

	public ArrayList<MemberVo> list(String name) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();
			String query = "SELECT * from user_info";
			if (name != null) {
				query += " where id='" + name.toLowerCase() + "'";
			}
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
					String id = rs.getString("id");
					String password = rs.getString("password");
					String email = rs.getString("password");
					MemberVo data = new MemberVo(id, password, email);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<MemberVo> findIdenty(String email) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();
			String query = "SELECT * from user_info";
			if (email != null) {
				query += " where E_mail='" + email.toLowerCase() + "'";
			}
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
					String id = rs.getString("id");
					String password = rs.getString("password");
					String Email = rs.getString("e_mail");
					MemberVo data = new MemberVo(id, password, Email);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<MemberVo> findPassword(String id, String email) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();
			String query = "SELECT * from user_info";
			if (id != null) {
				query += " where id='" + id.toLowerCase() + "'";
			}
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.previous();
				while (rs.next()) {
					String ID = rs.getString("id");
					String password = rs.getString("password");
					String Email = rs.getString("e_mail");
					MemberVo data = new MemberVo(ID, password, Email);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<Logininfo> Loginlist() {
		ArrayList<Logininfo> Loginlist = new ArrayList<Logininfo>();

		try {
			connDB();
			String query = "SELECT * from Login_info";
			rsCheckpassoword = stmt.executeQuery(query);
			rsCheckpassoword.last();
			if (rsCheckpassoword.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rsCheckpassoword.getRow() + " rows selected...");
				rsCheckpassoword.previous();
				while (rsCheckpassoword.next()) {
					String id = rsCheckpassoword.getString("id");
					String password = rsCheckpassoword.getString("login_password");
					String email = rsCheckpassoword.getString("login_e_mail");
					System.out.println(email);
					String time = rsCheckpassoword.getString("time");
					System.out.println(time);
					Logininfo data = new Logininfo(id, password, email, time);
					Loginlist.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Loginlist;
	}

	public ArrayList<Logininfo> Search_login_list(String id) {
		ArrayList<Logininfo> Loginlist = new ArrayList<Logininfo>();

		try {
			connDB_silence();
			String query = "select * from login_info where id='" + id + "'";
			rs = stmt.executeQuery(query);
			rs.last();
			if (rs.getRow() == 0) {
				String nowId = "###";
				String password = "###";
				String email = "###";
				String time = "###";
				int logoffnow = 1;
				Logininfo data = new Logininfo(nowId, password, email, time, logoffnow);
				Loginlist.add(data);
			} else {
				String nowId = rs.getString("id");
				String password = rs.getString("login_password");
				String email = rs.getString("login_e_mail");
				String time = rs.getString("time");
				int logoffnow = 2;
				Logininfo data = new Logininfo(nowId, password, email, time, logoffnow);
				Loginlist.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Loginlist;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void connDB_silence() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}