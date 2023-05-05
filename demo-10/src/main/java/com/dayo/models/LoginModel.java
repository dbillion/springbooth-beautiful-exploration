package com.dayo.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

	@NotNull(message="user name is required")
	@Size(min =4, max= 15, message="please use a name longer than 3 and 15")
	private String username;
	@NotNull
	@Size(min =5, max= 12, message="please use a password longer than 8 and 12")
	private String password;
	
	public LoginModel() {
		super();
	}

	public LoginModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginModel [username=" + username + ", password=" + password + "]";
	}
	
	
	
	

	
	
	
	
	
}
