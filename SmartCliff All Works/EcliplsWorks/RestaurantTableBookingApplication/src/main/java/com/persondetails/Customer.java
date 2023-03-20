package com.persondetails;

import java.time.LocalDate;
import java.util.ArrayList;

import com.booking.Booking;
import com.main.ConnectionProvider;

public class Customer extends Person{
	public static ArrayList<Customer> customer_obj_list=new ArrayList<Customer>();
	public static int n=1;	
	private String customer_id;
	private int cus_order_count;
	private int isActive;
    public int getIsActive() {
		return isActive;
	}


	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}


	public Account account_obj3=new Account();
    
	public int getCus_order_count() {
		return cus_order_count;
	}


	public void setCus_order_count(int cus_order_count) {
		this.cus_order_count = cus_order_count;
	}

	public void setCustomerId2(String id) {
		this.customer_id=id;
	}
	
	public String getCustomerId() {
		return customer_id;
	}


	public void setCustomerId() {
		if(n<10) {
			this.customer_id = "CU00"+n;
		}
		else if(n>=10 && n<100) {
			this.customer_id = "CU0"+n;
		}
		else {
			this.customer_id = "CU"+n;
		}
		n++;
		this.account_obj3.setUserID(customer_id);
		
	}
	public void accountSignUp(ConnectionProvider cnpv,int isActive,String person_name,String person_password,String person_emailid
			,String person_contactno,String person_gender,int person_age,String person_address,String usertype) {
		
		this.account_obj3.setIsActive(isActive);
		this.account_obj3.setUserID(getUser_id());
		this.account_obj3.setUserName(person_name);
		this.account_obj3.setUser_emailid(person_emailid);
		this.account_obj3.setUserPassword(person_password);
		this.account_obj3.setUserType(usertype);
		this.account_obj3.getAccount_obj_list().add(account_obj3);
		
		this.setName(person_name);
		this.setEmail_id(person_emailid);
		this.setAge(person_age);
		this.setGender(person_gender);
		this.setContact_no(person_contactno);
		this.setAddress(person_address);
	    this.setIsActive(isActive);
	    cnpv.accountCustomerSignUp(getCustomerId(),getCus_order_count(),getUser_id(),isActive,person_name,person_password,person_emailid
				,person_contactno,person_gender,person_age,person_address,usertype);
	    	
	}

	public Account getAccountObj3() {
		return account_obj3;
	}


	
}
