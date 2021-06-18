package Proj1;

public class Logininfo {
	private String id;
	private String password;
	private String email;
	private String time;
	private int logoffnow = 0;

	Logininfo() {

	}

	Logininfo(String id, String pw, String email) {
		this.id = id;
		this.password = pw;
		this.email = email;
	}

	Logininfo(String id, String pw, String email, String time) {
		this.id = id;
		this.password = pw;
		this.email = email;
		this.time = time;
	}

	Logininfo(String id, String pw, String email, String time, int logoffnow) {
		this.id = id;
		this.password = pw;
		this.email = email;
		this.time = time;
		this.logoffnow = logoffnow;
	}

	Logininfo(String id, String pw) {
		this.id = id;
		this.password = pw;
	}

	Logininfo(String id) {
		this.id = id;
	}

	public void setLogoffnow(int logoffnow) {
		this.logoffnow = logoffnow;
	}

	public int getLogoffnow() {
		return logoffnow;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String pw) {
		this.password = pw;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getTime() {
		return time;
	}
}
