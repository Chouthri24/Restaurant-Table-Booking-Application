package com.persondetails;

public class Person implements Comparable<Restaurant>{
	public Account account_obj5=new Account();
	public static int useridcount=1;	
	private String user_id;
	private String name;
	private String email_id;
	private String contact_no;
	private String gender;
	private int age;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public String getContact_no() {
		return contact_no;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Restaurant o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id() {
		if(useridcount<10)
		{
			this.user_id="US000"+useridcount;
			
		}else if(useridcount>=10 &&useridcount<100) {
			
			this.user_id="US00"+useridcount;
			
		}else if(useridcount>=100 &&useridcount<1000) {
			
			this.user_id="US0"+useridcount;
			
		}
		else {
			this.user_id="US"+useridcount;
			
		}
		this.account_obj5.setUserID(user_id);
		useridcount++;
	}

}
