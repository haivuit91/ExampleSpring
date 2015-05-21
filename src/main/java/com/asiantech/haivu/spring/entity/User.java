package com.asiantech.haivu.spring.entity;

public class User {

	private int userId;
	private String userName;
	private String pwd;
	private String firstName;
	private String lastName;
	private String email;
	private boolean isActive;

	public User() {
	};

	public User(int userId, String userName, String pwd, String firstName,
			String lastName, String email, boolean isActive) {
		this.userId = userId;
		this.userName = userName;
		this.pwd = pwd;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isActive = isActive;
	};

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
