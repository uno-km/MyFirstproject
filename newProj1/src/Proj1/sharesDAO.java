package Proj1;

import java.sql.*;
import java.util.*;

public class sharesDAO extends Source {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "unokim";
	String password = "unokim";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public boolean delete_user_interest_list(String name, String id) {
		boolean b = false;
		try {
			connDB();
			String queryInsert = "delete from user_interest_list where id ='" + id + "' and interest_name= '" + name
					+ "'";
			b = stmt.execute(queryInsert);
			if (!b) {
				System.out.println("delete success.");
			} else {
				System.out.println("delete fail.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return !b;
	}

	public boolean set_user_target_price(String name, int updown, String target) {
		boolean b = false;
		try {
			connDB();
			System.out.println(name);
			System.out.println(updown);
			System.out.println(target);
			String queryInsert = "update user_interest_list set updown='" + updown + "' , TARGETPRICE= '" + target
					+ "' where INTEREST_NAME ='" + name + "'";
			b = stmt.execute(queryInsert);
			if (!b) {
				System.out.println("delete success.");
			} else {
				System.out.println("delete fail.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return !b;
	}

	public boolean delete_user_target_price(String name) {
		boolean b = false;
		try {
			connDB();
			System.out.println(name);
			String queryInsert = "update user_interest_list set updown='' , TARGETPRICE='' where INTEREST_NAME ='"
					+ name + "'";
			b = stmt.execute(queryInsert);
			if (!b) {
				System.out.println("delete success.");
			} else {
				System.out.println("delete fail.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return !b;
	}

	public ArrayList<sharesVo> insert_interest(String id, String name) {
		ArrayList<sharesVo> list = new ArrayList<sharesVo>();
		try {
			String code = "";
			sharesDAO dao = new sharesDAO();
			shareslist = dao.select_shares_info(name);
			for (int i = 0; i < shareslist.size(); i++) {
				sharesVo data = (sharesVo) shareslist.get(i);
				code = data.getCode();
			}
			connDB();
			String queryVal = "select * from user_interest_list	where id='" + id + "' and interest_name ='" + name
					+ "'";
			rs = stmt.executeQuery(queryVal);
			System.out.println("SQL : " + queryVal);
			rs.last();
//			System.out.println("rs.getRow() : " + rs.getRow());
			if (rs.getRow() == 0) {
//				System.out.println("It can be added");
				String insertQuery = "INSERT INTO user_interest_list VALUES('" + id + "','" + name + "','" + code
						+ "','' ,'')";
				System.out.println("SQL : " + insertQuery);
				rs = stmt.executeQuery(insertQuery);
				rs.last();
				while (rs.next()) {
					String code2 = rs.getString("code");
					sharesVo data = new sharesVo(code2);
					list.add(data);
				}
			} else {
				System.out.println("It existed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<sharesVo> select_shares_info(String name) {
		ArrayList<sharesVo> list = new ArrayList<sharesVo>();

		try {
			connDB();
			String query = "select * from shares_fin_info where NAME='" + name + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("It doesn't exist...");
			} else {
//				System.out.println(rs.getString("code") + " Code number Right?");
				rs.previous();
				while (rs.next()) {
					String code = rs.getString("code");
					sharesVo data = new sharesVo(code);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<sharesVo> show_trade_val(String name) {
		ArrayList<sharesVo> list = new ArrayList<sharesVo>();

		try {
			connDB();
			String query = "select * from shares_trade_info where NAME='" + name + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("It doesn't exist...");
			} else {
				rs.previous();
				while (rs.next()) {
					String code = rs.getString("code");
					String stop_trade = rs.getString("STOP_trading");
					String issue = rs.getString("issue");
					String warning_low = rs.getString("WARNIG_LOW");
					String shit_report = rs.getString("SHIT_REPORT");
					String warning_mid = rs.getString("WARNING_MID");
					String warning_high = rs.getString("WARNING_HIGH");
					String danger = rs.getString("DANGER");
					sharesVo data = new sharesVo(code, stop_trade, issue, warning_low, shit_report, warning_mid,
							warning_high, danger);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<sharesVo> show_market(String name) {
		ArrayList<sharesVo> list = new ArrayList<sharesVo>();

		try {
			connDB();
			String query = "select * from shares_fin_info where name='" + name + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("It doesn't exist...");
			} else {
				rs.previous();
				while (rs.next()) {
					String EXCHANGE = rs.getString("EXCHANGE");
					sharesVo data = new sharesVo();
					data.setMarketSector(EXCHANGE);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<sharesVo> select_proverb(int num) {
		ArrayList<sharesVo> select_proverb = new ArrayList<sharesVo>();

		try {
			connDB();
			String query = "select * from proverb where num='" + num + " '";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("It doesn't exist...");
			} else {
				rs.previous();
				while (rs.next()) {
					String proverb = rs.getString("contents");
					sharesVo data = new sharesVo("1", proverb);
					select_proverb.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return select_proverb;
	}

	public ArrayList<sharesVo> interest_MAX_cnt(String id) {
		ArrayList<sharesVo> list = new ArrayList<sharesVo>();

		try {
			connDB();
			String queryInsert = "select 	count(*) from 	user_interest_list	where id='" + id + "'";
			System.out.println("SQL : " + queryInsert);
			rs = stmt.executeQuery(queryInsert);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("It doesn't exist...");
			} else {
				rs.previous();
				while (rs.next()) {
					int cnt = rs.getInt("count(*)");
					sharesVo data = new sharesVo(cnt);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<sharesVo> Load_user_interest_list(String id, int cnt) {
		ArrayList<sharesVo> list = new ArrayList<sharesVo>();

		try {
			connDB();
			String queryInsert = "select *from 	user_interest_list	where id='" + id + "'";
			System.out.println("SQL : " + queryInsert);
			rs = stmt.executeQuery(queryInsert);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			if (rs.getRow() == 0) {
				System.out.println("존재하지않는 데이터");
			} else {
				System.out.println("loaded your interested sharesNames");
				rs.first();
				String interestList[] = new String[cnt];
				int TargetUDList[] = new int[cnt];
				int TargetPriceList[] = new int[cnt];
				for (int i = 0; i < cnt; i++) {
					interestList[i] = rs.getString("interest_name");
					TargetUDList[i] = rs.getInt("updown");
					TargetPriceList[i] = rs.getInt("targetprice");
					System.out.println("1이면 이상, 0이면 이하 : " + TargetUDList[i]);
					System.out.println("목표설정가 : " + TargetPriceList[i]);
					rs.next();
				}
//				sharesVo data = new sharesVo(interestList, cnt, "");
				sharesVo data = new sharesVo();
				data.interestshareListing(interestList, cnt, "");
				data.setTargetUpdown(TargetUDList, cnt, "");
				data.setTargetPrice(TargetPriceList, cnt, "");
				System.out.println("save completed");
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
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

}
