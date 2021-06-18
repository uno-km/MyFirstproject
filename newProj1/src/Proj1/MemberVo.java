package Proj1;

import java.util.Date;

public class MemberVo {
	private String id;
	private String password;
	private String email;
	private Date time;

	public MemberVo() {

	}

	public MemberVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public MemberVo(String id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public MemberVo(String id, String password, String email, Date time) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.time = time;
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

	public Date getTime() {
		return time;
	}
}