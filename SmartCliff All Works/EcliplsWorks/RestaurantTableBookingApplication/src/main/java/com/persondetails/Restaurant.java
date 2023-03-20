package com.persondetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.booking.Booking;
import com.main.ConnectionProvider;
import com.payment.Payment;
import com.restaurantdetails.FoodItems;
import com.restaurantdetails.Tables;

public class Restaurant extends Person{
	public static ArrayList<Restaurant> restaurant_obj_list=new ArrayList<Restaurant>();
   public static int m=1;
  
	 private String restaurant_id;
	 private String restaurant_name;
	private String restaurant_address;
	private String restaurant_location;
	private float restaurant_distance;
	private int restaurant_isActive;
	public FoodItems fooditems;
	public Tables tables;
	
	
	public int getRestaurant_isActive() {
		return restaurant_isActive;
	}
	public void setRestaurant_isActive(int restaurant_isActive) {
		this.restaurant_isActive = restaurant_isActive;
	}
	public FoodItems getFooditems() {
		return fooditems;
	}
	public Tables getTables() {
		return tables;
	}
	public void setFooditems(FoodItems fooditems) {
		this.fooditems = fooditems;
	}
	public void setTables(Tables tables) {
		this.tables = tables;
	}
	

	public float getRestaurant_distance() {
		return restaurant_distance;
	}
	public void setRestaurant_distance(float restaurant_distance) {
		this.restaurant_distance = restaurant_distance;
	}


	public Account account_obj2=new Account();
	
	public Account getAccountObj2() {
	return account_obj2;
}

	public String getRestaurantName() {
		return restaurant_name;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurant_name = restaurantName;
	}

	public String getRestaurantAddress() {
		return restaurant_address;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurant_address = restaurantAddress;
	}

	public String getRestaurantLocation() {
		return restaurant_location;
	}

	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurant_location = restaurantLocation;
	}

	
	 public String getRestaurantID() {
			return restaurant_id;
		}
	 
	 	public void setRestaurantID2(String s) {
	 			this.restaurant_id=s;
	 	}
		public void setRestaurantID1() {
			
			if(m<10)
			{
				this.restaurant_id="RU00"+m;
				
			}else if(m>=10 &&m<100) {
				this.restaurant_id="RU0"+m;
				
			}else {
				this.restaurant_id="RU"+m;
				
			}
			this.account_obj2.setUserID(restaurant_id);
		}
	
	public void accountRestaurantSignUp(ConnectionProvider cnpv,int isActive,String usertype,String restaurantname,String resownername,String resowneremailid,
			String restaurantaddress,String restaurantpassword
			,String restaurantlocation,String restaurant_contactno,float restaurantdistance)  {
		setUser_id();
		setRestaurantID1();
		this.account_obj2.setIsActive(isActive);
		this.account_obj2.setUserType(usertype);
		this.setName(resownername);
		this.setEmail_id(resowneremailid);
		this.account_obj2.setUser_emailid(resowneremailid);
		this.account_obj2.setUserName(restaurantname);
		this.account_obj2.setUserPassword(restaurantpassword);
		this.account_obj2.setUserID(getUser_id());
		this.account_obj2.getAccount_obj_list().add(account_obj2);
		
		this.setRestaurant_isActive(isActive);
		this.setRestaurantName(restaurantname);
		this.setRestaurantAddress(restaurantaddress);
		this.setRestaurantLocation(restaurantlocation);
		this.setContact_no(restaurant_contactno);
		this.setRestaurant_distance(restaurantdistance);
		cnpv.accountRestaurantSignUp(getRestaurantID(),getUser_id(),1,usertype,restaurant_name,resownername,resowneremailid,restaurant_address,restaurantpassword, restaurant_location, restaurant_contactno,restaurantdistance);
		
		m++;
	}
	
	
	Booking bookingobj=new Booking();
    public void viewBookingList(Restaurant res_obj) {
    	System.out.println("----------------------------------------------------------------------------"
    			+ "----------------------------------------------------------------------------------");
		System.out.println("									 		BOOKING LIST                                                                             		 ");
		System.out.println("----------------------------------------------------------------------------"
    			+ "----------------------------------------------------------------------------------");
		System.out.printf("%5s%18s%18s%21s%21s%21s%21s%16s%21s\n","ORDER_ID",
				"DATE","CUS_ID","CUS_NAME","CUS_EMAIL_ID","CUS_CONTACT_NO","SEATS","AMOUNT","PAYMENT_STATUS");
    			System.out.println("----------------------------------------------------------------------------"
    	    			+ "----------------------------------------------------------------------------------");	int flag=0;
    	for(Booking obj:bookingobj.bookingobjlist) {
    			
    		if(obj.getRes_id().equalsIgnoreCase(res_obj.getRestaurantID()) && obj.getOrder_status()==1) 
    		{
    			
    			flag=1;
    			System.out.printf("%5s%18s%18s%21s%21s%21s%21s%16s%21s\n",obj.getOrder_id(),
    					obj.getNextdate(),obj.getCustomerId(),obj.getCustomername(),obj.getCustomerEmailid(),obj.getCustomerphoneno(),obj.getUser_choice_seats(),obj.getBillamount(),obj.getPaymentstatus());
    	}
    		
    	}
    	if(flag==0) {
    		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Booking Not Happen...");
    	}
    	System.out.println("----------------------------------------------------------------------------"
    			+ "----------------------------------------------------------------------------------"+"\n");
    	}
	Payment payment_obj=new Payment();
    public void viewPaymentList(Restaurant res_obj) {
    	int flag=0;
    	System.out.println("----------------------------------------------------------------------------"
    			+ "----------------------------------------------------------------------------------");
    	System.out.println("								         PAYMENT LIST                                                               ");
    	System.out.println("----------------------------------------------------------------------------"
    			+ "----------------------------------------------------------------------------------");System.out.printf("%5s%23s%23s%23s%23s%23s%23s\n","ORDER_ID","PAYMENT_TYPE","CARD_NO","ACC_HOLDER_NAME","UPI","AMOUNT","PAYMENT_STATUS");
		
    			System.out.println("----------------------------------------------------------------------------"
    	    			+ "----------------------------------------------------------------------------------");	
		for(Payment obj:payment_obj.paymentobjlist) {
			
			
			if(obj.getRes_id().equalsIgnoreCase(res_obj.getRestaurantID()) && obj.getOrder_status_obj()==1) {
			
			flag=1;
			System.out.printf("%5s%23s%23s%23s%23s%23s%23s\n",obj.getOrder_id(),obj.getPayment_type(),obj.card_obj_main.getCard_number(),obj.card_obj_main.getCard_holder_name()
					,obj.ui_obj_main.getUpi_id(),obj.getAmount(),obj.getPayment_status());
			}
		}
		if(flag==0)
		{
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Booking Not Happen...");
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		
    }
    
    
    public int compareTo(Restaurant obj) {
    	if(restaurant_distance==obj.restaurant_distance) {
    		return 0;
    	}
    	else if(restaurant_distance>obj.restaurant_distance) {
    		return -1;
    	}
    	else {
    		return 1;
    	}
    	
    }
    
}
