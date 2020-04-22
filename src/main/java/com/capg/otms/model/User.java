package com.capg.otms.model;

public class User {
	private Long userId; 
	private String userName;
	private Test userTest;
	private Boolean isAdmin; 
	private String userPassword;
	public User(String userName, Boolean isAdmin, String userPassword) {
		super();
		this.userName = userName;
		this.isAdmin = isAdmin;
		this.userPassword = userPassword;
	}
	public User(String userName, Test userTest) {
		super();
		this.userName = userName;
		this.userTest = userTest;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Test getUserTest() {
		return userTest;
	}
	public void setUserTest(Test userTest) {
		this.userTest = userTest;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	} 
}
