package com.SringFramework.TelegramLongPollingBot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataBase {
	
	
	public static void data(String name,String userSurname,String userName,String userQ) {
		UserFullName full = new UserFullName();
		full.setName(name);
		full.setUserSurname(userSurname);
		full.setUserName(userName);
		
		UserInfo info = new UserInfo();
		info.setId(0);
		info.setName(full);
		info.setUserQ(userQ);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class).addAnnotatedClass(UserFullName.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss=  sf.openSession();
		Transaction tr = ss.beginTransaction();
		ss.save(info);
		tr.commit();
		
	}

}
