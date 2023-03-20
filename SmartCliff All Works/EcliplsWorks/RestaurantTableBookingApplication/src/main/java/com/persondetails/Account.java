package com.persondetails;

import java.util.ArrayList;

public class Account {
	
	public static ArrayList<Account> account_obj_list=new ArrayList<Account>();
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_emailid;
	private String usertype;
	private int isactive;
	
	
	  public static ArrayList<Account> getAccount_obj_list() {
		return account_obj_list;
	}


	public static void setAccount_obj_list(ArrayList<Account> account_obj_list) {
		Account.account_obj_list = account_obj_list;
	}


	public String getUser_emailid() {
		return user_emailid;
	}


	public void setUser_emailid(String user_emailid) {
		this.user_emailid = user_emailid;
	}


	public int getIsActive() {
		return isactive;
	}


	public void setIsActive(int isActive) {
		this.isactive = isActive;
	}


	public String getUserID() {
		return user_id;
	}


	public void setUserID(String userID) {
		this.user_id = userID;
	}


	public String getUserName() {
		return user_name;
	}


	public void setUserName(String userName) {
		this.user_name = userName;
	}


	public String getUserPassword() {
		return user_password;
	}


	public void setUserPassword(String userPassword) {
		this.user_password = userPassword;
	}


	public String getUserType() {
		return usertype;
	}


	public void setUserType(String userType) {
		this.usertype = userType;
	}

/*
	public String toString() { 
		  return "ID :"+user_id+"Type :"+usertype+"\n"+"Name :"+user_name+"\n"+"Pass :"+user_password+"\n"+"..."+"\n";
		  }

*/
	
}
