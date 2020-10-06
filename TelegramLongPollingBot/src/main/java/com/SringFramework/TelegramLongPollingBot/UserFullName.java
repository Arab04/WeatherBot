package com.SringFramework.TelegramLongPollingBot;

import javax.persistence.Embeddable;

@Embeddable

public class UserFullName {

	private String  name;
	private String  userSurname;
	private String  userName;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
