package Proj1;

public class sharesVo {
	private String code;
	private String proverb;
	private String email;
	private String Istop;
	private String Iissue;
	private String Ilow;
	private String Ireport;
	private String Imid;
	private String Ihigh;
	private String Idanger;
	private String market;
	private String sector;
	private int updown;
	private int targetPrice;

	private int cnt = 0;
	static private String Interest_user_shares[];
	static private int Target_updown[];
	static private int Target_price[];

	public sharesVo() {
	}

	public sharesVo(int cnt) {
		this.cnt = cnt;
	}

	public sharesVo(String input[], int cnt, String trigger) {
		sharesVo.Interest_user_shares = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			sharesVo.Interest_user_shares[i] = input[i];
		}
	}

	///
	public void interestshareListing(String input[], int cnt, String trigger) {
		sharesVo.Interest_user_shares = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			sharesVo.Interest_user_shares[i] = input[i];
		}
	}
	///

	public sharesVo(String code, String Istop, String Iissue, String Ilow, String Ireport, String Imid, String Ihigh,
			String Idanger) {
		this.code = code;
		this.Istop = Istop;
		this.Iissue = Iissue;
		this.Ilow = Ilow;
		this.Ireport = Ireport;
		this.Imid = Imid;
		this.Ihigh = Ihigh;
		this.Idanger = Idanger;
	}

	public void setMarketSector(String market) {
		this.market = market;
	}

	public void setTargetUpdown(int input[], int cnt, String trigger) {
		sharesVo.Target_updown = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			sharesVo.Target_updown[i] = input[i];
		}
	}

	public void setTargetPrice(int input[], int cnt, String trigger) {
		sharesVo.Target_price = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			sharesVo.Target_price[i] = input[i];
		}
	}

	public int[] getTarget_updown() {
		return Target_updown;
	}

	public int[] getTarget_price() {
		return Target_price;
	}

	public sharesVo(String trigger, String proverb) {
		this.proverb = proverb;
	}

	public sharesVo(String code) {
		this.code = code;
	}

	public String[] getInterest_user_shares() {
		return Interest_user_shares;
	}

	public int getCnt() {
		return cnt;
	}

	public String getCode() {
		return code;
	}

	public String getProverb() {
		return proverb;
	}

	public String getEmail() {
		return email;
	}

	public String getIstop() {
		return Istop;
	}

	public String getIissue() {
		return Iissue;
	}

	public String getIlow() {
		return Ilow;
	}

	public String getIreport() {
		return Ireport;
	}

	public String getImid() {
		return Imid;
	}

	public String getMarket() {
		return market;
	}

	public String getSector() {
		return sector;
	}

	public String getIhigh() {
		return Ihigh;
	}

	public String getIdanger() {
		return Idanger;
	}

	public int getIUpdown() {
		return updown;
	}

	public int getITargetPrice() {
		return targetPrice;
	}

}