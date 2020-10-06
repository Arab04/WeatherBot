package com.SringFramework.TelegramLongPollingBot;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_info")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private UserFullName name;
	private String userQ;
	private String date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserFullName getName() {
		return name;
	}
	public void setName(UserFullName name) {
		this.name = name;
	}
	public String getUserQ() {
		return userQ;
	}
	public void setUserQ(String userQ) {
		this.userQ = userQ;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
