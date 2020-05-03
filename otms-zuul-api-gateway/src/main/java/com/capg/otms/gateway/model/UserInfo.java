package com.capg.otms.gateway.model;



public class UserInfo {

	private long userId ;
	private String userName ;
	private long userTest ;
	private boolean isAdmin ;
	private String userPassword;
	
	public UserInfo() { }
	
	

	public UserInfo(long userId, String userName, long userTest, boolean isAdmin, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userTest = userTest;
		this.isAdmin = isAdmin;
		this.userPassword = userPassword;
	}



	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserTest() {
		return userTest;
	}

	public void setUserTest(long userTest) {
		this.userTest = userTest;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
