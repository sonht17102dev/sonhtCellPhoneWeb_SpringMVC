package model;

public class Account {
	@Override
	public String toString() {
		return "Account [usermail=" + usermail + ", password=" + password + ", account_role=" + account_role
				+ ", user_name=" + user_name + ", address=" + address + ", phone=" + phone + "]";
	}

	private String usermail;
	private String password;
	private int account_role;
	private String user_name;
	private String address;
	private String phone;

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccount_role() {
		return account_role;
	}

	public void setAccount_role(int account_role) {
		this.account_role = account_role;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
