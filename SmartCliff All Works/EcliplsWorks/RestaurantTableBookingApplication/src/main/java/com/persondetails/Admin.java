package com.persondetails;

import java.util.ArrayList;

public class Admin extends Person{
	public static ArrayList<Admin> admin_obj_list=new ArrayList<Admin>();
	private Account account_obj1=new Account();	
	public static int adm=1;
	private String admin_user_id;
	private int isActive;
	
	public int getIsActive() {
		return isActive;
	}
	

	public static ArrayList<Admin> getAdmin_obj_list() {
		return admin_obj_list;
	}


	public static void setAdmin_obj_list(ArrayList<Admin> admin_obj_list) {
		Admin.admin_obj_list = admin_obj_list;
	}


	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getAdmin_user_id() {
		return admin_user_id;
	}
	
	public void setAdmin_user_id(String admin_user_id) {
		
		if(adm<10) {
			this.admin_user_id  = "AU00"+adm;
		}
		else if(adm>=10 && adm<100) {
			this.admin_user_id  = "AU0"+adm;
		}
		else {
			this.admin_user_id  = "AU"+adm;
		}
		adm++;
		this.account_obj1.setUserID(admin_user_id);
	}
	
	public Account getAccount_obj1() {
		return account_obj1;
	}
	public void setAccount_obj1(Account account_obj1) {
		this.account_obj1 = account_obj1;
	}
	
	
	
}
