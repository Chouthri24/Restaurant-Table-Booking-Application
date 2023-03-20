
package com.booking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.payment.Payment;
import com.persondetails.Customer;
import com.persondetails.Restaurant;
import com.restaurantdetails.TableSeats;
import com.main.ConnectionProvider;
import com.main.Main;
import com.payment.*;
public class Booking {
	public static ConnectionProvider cnpv=new ConnectionProvider();
	//public static int cus_order_count=0; 
	 
	public static ArrayList<Booking> bookingobjlist=new ArrayList<Booking>();
	public static int n=1;	
	public static Scanner read=new Scanner(System.in);
	private String order_id;
	private String customerId;
	private String customername;
	private String customerEmailid;
	private String customerphoneno;
	private int billamount;
	private String paymentstatus;
	private String res_id;
	private String res_name;
	private LocalDate nextdate;	
	private String res_address;
	public static boolean continue_var;
	public ShowRestaurant show_restaurant_obj;
	public LinkedHashSet<String> user_choice_seats =new LinkedHashSet<String>(); 
	public ArrayList<Integer> user_choice_seat_keylist_basic =new ArrayList<Integer>();
	public ArrayList<Integer> user_choice_seat_keylist_premium =new ArrayList<Integer>();
	private int order_status;
	public ArrayList<Integer> getUser_choice_seat_list_basic() {
		return user_choice_seat_keylist_basic;
	}


	public ArrayList<Integer> getUser_choice_seat_list_premium() {
		return user_choice_seat_keylist_premium;
	}


	public void setUser_choice_seat_list_basic(ArrayList<Integer> user_choice_seat_keylist_basic) {
		this.user_choice_seat_keylist_basic = user_choice_seat_keylist_basic;
	}


	public void setUser_choice_seat_list_premium(ArrayList<Integer> user_choice_seat_keylist_premium) {
		this.user_choice_seat_keylist_premium = user_choice_seat_keylist_premium;
	}


	public void setBillamount(int billamount) {
		this.billamount = billamount;
	}


	public void setCustomerphoneno(String customerphoneno) {
		this.customerphoneno = customerphoneno;
	}


	public String getCustomerEmailid() {
		return customerEmailid;
	}


	public void setCustomerEmailid(String customerEmailid) {
		this.customerEmailid = customerEmailid;
	}


	public void setNextdate(LocalDate nextdate) {
		this.nextdate = nextdate;
	}


	public void setCustomername(String customername) {
		this.customername = customername;
	}


	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}	

	public HashSet<String> getUser_choice_seats() {
		return user_choice_seats;
	}


	public void setUser_choice_seats(LinkedHashSet<String> user_choice_seats) {
		this.user_choice_seats = user_choice_seats;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public int getOrder_status() {
		return order_status;
	}


	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}


	public String getOrder_id() {
		return order_id;
	}


	public String getRes_id() {
		return res_id;
	}


	public String getRes_address() {
		return res_address;
	}


	public void setRes_address(String res_address) {
		this.res_address = res_address;
	}


	public String getRes_name() {
		return res_name;
	}

	public void setOrder_id2(String id) {
		this.order_id=id;
	}

	public void setOrder_id() {
		
		if(n<10) {
			this.order_id = "ORD00"+n;
		}
		else if(n>=10 && n<100) {
			this.order_id = "ORD0"+n;
		}
		else {
			this.order_id = "ORD"+n;
		}
		n++;
	}


	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}


	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}


	public ShowRestaurant getShow_restaurant_obj() {
		return show_restaurant_obj;
	}


	public void setShow_restaurant_obj(ShowRestaurant show_restaurant_obj) {
		this.show_restaurant_obj = show_restaurant_obj;
	}

	public void orderTicket(int order_status,HashSet<String> user_choice,String orderid,String customerId,String customername,String customerEmailid,String resid,String customerphoneno,
			int billamount2,String paymentstatus,String resname,String resaddress,LocalDate nextdate,Date nxtDate,int cus_order_count) {
		this.order_status= order_status;
		this.order_id=orderid;
		this.customerId=customerId;
		this.customerEmailid=customerEmailid;
		this.customername=customername;
		this.customerphoneno=customerphoneno;
		this.billamount=billamount2;
		this.paymentstatus=paymentstatus;
		this.res_id=resid;
		this.res_name=resname;
		this.res_address=resaddress;
		this.nextdate=nextdate;
		this.user_choice_seats.addAll(user_choice);
		cnpv.orderTicketBooking(cus_order_count,order_status,getUser_choice_seats(),getUser_choice_seat_list_basic(),getUser_choice_seat_list_premium(),orderid,customerId,customername,customerEmailid,resid,customerphoneno,
				billamount2,paymentstatus,resname,resaddress,nxtDate);
		
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public String getCustomername() {
		return customername;
	}
	public String getCustomerphoneno() {
		return customerphoneno;
	}

	public double getBillamount() {
		return billamount;
	}



	public String getPaymentstatus() {
		return paymentstatus;
	}

	public LocalDate getNextdate() {
		return nextdate;
	}

	
	
	
	
	
	
	
	
	
	public static void bookingOperation(Restaurant res_obj,Customer cusobj) {
		HashSet<String> user_choice_seats1 = new HashSet<String>();
	LocalDate locdate=LocalDate.now();
	LocalDate nextday=locdate.plusDays(1);
	Date nxtdate=Date.valueOf(nextday);
	DateTimeFormatter ft=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Tomorrow : "+ nextday.format(ft));
	System.out.println();
	boolean continue_var1;
	String seatct;
	do {
		continue_var1=false;
	 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Note : Maximum 10 Seats to Book in One Order"+"\n");
    System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"How Many Seats You Want : ");
	seatct=read.next();
	while(!Main.isCheckChoice(seatct))
	{
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again..."+"\n");
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Note : Maximum 10 Seats to Book in One Order"+"\n");
	    System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"How Many Seats You Want : ");
		seatct=read.next();
	}
	if(Integer.parseInt(seatct)>10 || Integer.parseInt(seatct)==0) {
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again..."+"\n");
		continue_var1=true;
	}
	
	}while(continue_var1);
    String seat_pos;
    int seatcount=Integer.parseInt(seatct);
    //String arr[]=new String[seatcount];
    int B=0,P=0;
    System.out.println();
    for(int j=0;j<seatcount;j++) {
    	do {
    		int flag=0;
    	continue_var=false;
    	 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Seat "+(j+1)+" ID : ");
    	// arr[j]=read.next();
    	 seat_pos=read.next();
    	
    	 if(seat_pos.charAt(0)=='B') {
    		
    		 
    		 for(Map.Entry hashobj: res_obj.tables.tableSeats.basicseatobj.entrySet())
	    		{
	    			if(seat_pos.equals(hashobj.getValue()))
	    			{
	    				flag=1;
	    				
	    				break;
	    			}
	    		
	    		}
    		 
    	 }else if (seat_pos.charAt(0)=='P') {
    		
    		 for(Map.Entry hashobj:res_obj.tables.tableSeats.premiumseatobj.entrySet())
	    		{
	    			if(seat_pos.equals(hashobj.getValue()))
	    			{
	    				flag=1;
	    				 
	    			break;
	    			}
	    		
	    		}
    	 }
    	
    	 if(flag==0) {
    		 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Seats are Not Avaliable Enter Again...");
    		 continue_var=true;
    	 }
    	}while(continue_var);
    	
    	 if(user_choice_seats1.add(seat_pos)) {
    		 if(seat_pos.charAt(0)=='B') {
    			 B++;
    		 }
    		 else {
    			 P++;
    		 }
    	 }
    }
      // previewBill(B,P,cusobj,seatcount, user_choice_seats1,res_obj,nextday,nxtdate);
    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void bookingOperationJSP(Restaurant res_obj,Customer cusobj,int seatcount,HashSet<String> hs,String cardno,String cardname) {
		
	LocalDate locdate=LocalDate.now();
	LocalDate nextday=locdate.plusDays(1);
	Date nxtdate=Date.valueOf(nextday);
	DateTimeFormatter ft=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Tomorrow : "+ nextday.format(ft));
	System.out.println();
	boolean continue_var1;
	String seatct;

       previewBill(seatcount,0,cusobj,seatcount, hs,res_obj,nextday,nxtdate,cardno,cardname);
    
}
	
public static void previewBill(int B,int P,Customer cusobj,int seatcount,HashSet<String> user_choice_seats,Restaurant obj,LocalDate nextday,Date nxtdate,String cardNo,String cardName) {
	DateTimeFormatter ft=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	boolean con;
	do {
		con=false;
	
	Booking booking_self_obj=new Booking();
		int order_status;
    	System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"*** P R E V I E W   B I L L ***"+"\n");
    	System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Date : "+ nextday.format(ft));
    	System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Name    : "+cusobj.getName());
    	System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Email ID : "+cusobj.getEmail_id());
    	System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Contact : "+cusobj.getContact_no());
    	System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Seats List :");
    	System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"   ");
    	for(String seat:user_choice_seats) {
        	 System.out.print(seat+" ");
        	 
        }
    	 System.out.println();
    	 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Amount : "+"Basic - "+B+"*"+obj.tables.getBasictableseatamount()+" = "+B*obj.tables.getBasictableseatamount());
    	 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Amount : "+"Premium - "+P+"*"+obj.tables.getPremiumtableseatamount()+" = "+P*obj.tables.getPremiumtableseatamount());
    	 int billamount=B*obj.tables.getBasictableseatamount()+(P*obj.tables.getPremiumtableseatamount());
    	 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Total Amount : Rs."+billamount);
    	boolean continue_var1;
    		do {
    			
    	continue_var1=false;
    	 System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Confirm to Pay ??? 1.YES 2.NO ");
    	 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
    	 String choice="1";
			while(!Main.isCheckChoice(choice))
			{
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
				choice=read.next();
			}
    	 if(Integer.parseInt(choice)==1) {
    		 Payment pay_obj=new Payment();
    		 
    		 System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"------P A Y M E N T   D E T A I L S--------"+"\n");
    		 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Card");
    		 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.UPI");
    		 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Back"+"\n");
    		do {
    			continue_var=false;
    		 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
    		 String choice1="1";
 			while(!Main.isCheckChoice(choice1))
 			{
 				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
 				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
 				choice1=read.next();
 			}
     	
    		 switch(Integer.parseInt(choice1)) {
    		 
    		 case 1:
    			 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Your Card No : ");
    			
    			 String cardno=cardNo;
    			 
    			 while(!Main.isCheckCardNo(cardno))
    				{
    					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Card No!!! Pls Enter Again...");
    					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Card No : ");
    					cardno=read.nextLine();
    				}
    			 
    			 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Account Holder Name : ");
    			 
    			 String acc_hol_name=cardName;
    			 
    			 while(!Main.isCheckName(acc_hol_name))
    				{
    					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Name!!! Pls Enter Again...");
    					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Name : ");
    					acc_hol_name=read.next();
    				}
    			 
    			 System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"*** Account Detected **");
    			 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter OTP :");
    			 String m="12345";
    			 while(!Main.isCheckPin(m))
 				{
 					System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Payment Failed.....OTP Must Be 4 Digit number ");
 					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Pin : ");
 					m=read.next();
 				}
    			 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Payment Successful....");
    			// cus_order_count++;
    			// System.out.println("OlD :"+cusobj.getCus_order_count());
    			 cusobj.setCus_order_count(cusobj.getCus_order_count()+1);
    			// System.out.println("New : "+cusobj.getCus_order_count());
    			 //cnpv.makeResCustomer(cusobj.getCustomerId(),cusobj.getCus_order_count());
    			 order_status=1;
    			 booking_self_obj.setOrder_id();
    			 Card card_obj=new Card();
    			 card_obj.setCard_holder_name(acc_hol_name);
    			 card_obj.setCard_number(cardno);
    			 pay_obj.setCard_obj_main(card_obj);
    			 UPI upi_obj=new UPI();
    			 upi_obj.setUpi_id("*,*,*,*,*");
    			 pay_obj.setUi_obj_main(upi_obj);
    			
    			 makeBooking(obj,user_choice_seats,booking_self_obj,cnpv);
    			 booking_self_obj.orderTicket(order_status,user_choice_seats,booking_self_obj.getOrder_id(),cusobj.getCustomerId(),cusobj.getName(),cusobj.getEmail_id(),obj.getRestaurantID() ,cusobj.getContact_no(), (int) billamount, "SUCCESS", obj.getRestaurantName(), obj.getRestaurantAddress(), nextday,nxtdate,cusobj.getCus_order_count());
    			 bookingobjlist.add(booking_self_obj);
    			 pay_obj.paymentOperation(cnpv,card_obj.getCard_number(),card_obj.getCard_holder_name(),upi_obj.getUpi_id(),cusobj.getCustomerId(),order_status,booking_self_obj.getOrder_id(),obj.getRestaurantID(),"CARD", billamount,"SUCCESS");
    			 pay_obj.paymentobjlist.add(pay_obj);
    			 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Booking Successfully Completed...."+"\n");
    			 continue_var1=false;
    			 // System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrk Successful....");
    				 
    			 break;
    		 case 2:
    			
    			 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Your UPI ID : ");
    			
    			 String upi_id=read.next();
    			 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter UPI PIN :");
    			 String pin=read.next().trim();
    			 
    				while(!Main.isCheckPin(pin))
    				{
    					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid UPI PIN Pls Enter Again...");
    					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter UPI PIN : ");
    					pin=read.next().trim();
    				}
    			
    			 
    			 if(pin.length()<4) {
 				 	System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Payment Failed.....OTP Must Be 4 number or More");
 				 }else {
 					 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Payment Successful...."+"\n");
 					
 					 //cus_order_count++;
 	    			 cusobj.setCus_order_count(cusobj.getCus_order_count()+1);
 	    			 //cnpv.makeResCustomer(cusobj.getCustomerId(),cusobj.getCus_order_count());
 					 order_status=1;
 					 booking_self_obj.setOrder_id();
 					 Card card_obj1=new Card();
 	    			 card_obj1.setCard_holder_name("***");
 	    			 card_obj1.setCard_number("***");
 	    			 pay_obj.setCard_obj_main(card_obj1);
 	    			 
 	    			 UPI upi_obj1=new UPI();
 	    			 upi_obj1.paymentUPIOperation(upi_id);
 	    			 pay_obj.setUi_obj_main(upi_obj1);
 					 makeBooking(obj,user_choice_seats,booking_self_obj,cnpv);
 					 booking_self_obj.orderTicket(order_status,user_choice_seats,booking_self_obj.getOrder_id(),cusobj.getCustomerId(),cusobj.getName(),cusobj.getEmail_id(),obj.getRestaurantID() ,cusobj.getContact_no(), (int) billamount, "SUCCESS", obj.getRestaurantName(), obj.getRestaurantAddress(), nextday,nxtdate,cusobj.getCus_order_count());
 	    			 bookingobjlist.add(booking_self_obj);
 	    			 pay_obj.paymentOperation(cnpv,card_obj1.getCard_number(),card_obj1.getCard_holder_name(),upi_obj1.getUpi_id(),cusobj.getCustomerId(),order_status,booking_self_obj.getOrder_id(),obj.getRestaurantID(),"UPI", billamount,"SUCCESS");
 					 pay_obj.paymentobjlist.add(pay_obj);
 					 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Booking Successfully Completed...."+"\n");
 					 //System.out.println("Wrk Successful....");
 					continue_var1=false;
 				 }
    			 break;
    		 case 3:
    			 con=true;
    			 break;
    		 default:
    			 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
    			continue_var=true;
    			 break;
    		 }
    		}while(continue_var);
    		
    		 
    	 }
    	 else if(Integer.parseInt(choice)==2) {
    		 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Thank You...");
    	 }
    	 else {
    			 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again..."); 
    			 continue_var1=true;
    	 }
    	 
		}while(continue_var1);
    		
	}while(con);		
    }
public static void makeBooking(Restaurant obj,HashSet<String> user_choice_seats,Booking booking_self_obj,ConnectionProvider cnpv) {
	
		ArrayList<Integer> user_choice_seat_list_basic =new ArrayList<Integer>();
		ArrayList<Integer> user_choice_seat_list_premium =new ArrayList<Integer>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
			
			 for(String seat:user_choice_seats) {
			    	
			    	if(seat.charAt(0)=='B') {
			    		
			    		for(Map.Entry hashobj: obj.tables.tableSeats.basicseatobj.entrySet())
			    		{
			    			if(seat.equals(hashobj.getValue()))
			    			{
			    				int key=(int) hashobj.getKey();
			    				
			    				user_choice_seat_list_basic.add(key);
			    				cnpv.putNullToBasicSeat(obj.getRestaurantID(), key,con);
			    				hashobj.setValue("_**_");
			    				
			    			}
			    		
			    		}
			    	}
			    	
			    	if(seat.charAt(0)=='P') {
			    		
			    		for(Map.Entry hashobj:obj.tables.tableSeats.premiumseatobj.entrySet())
			    		{
			    			if(seat.equals(hashobj.getValue()))
			    			{
			    				int key=(int) hashobj.getKey();
			    				user_choice_seat_list_premium.add(key);
			    				cnpv.putNullToPremiumSeat(obj.getRestaurantID(), key,con);
			    				hashobj.setValue("_**_");
			    				
			    			}
			    		
			    		}
			    	}
			    	
			    }
			    booking_self_obj.setUser_choice_seat_list_basic(user_choice_seat_list_basic);
			    booking_self_obj.setUser_choice_seat_list_premium(user_choice_seat_list_premium);
			   /* System.out.println("*** After Booking ***");
				System.out.println("*** Basic Seat - "+obj.tables.getBasictableseatamount()+" ***");
				obj.tables.tableSeats.getBasicTableSeatArrangement();
				System.out.println("*** Premium Seat - "+obj.tables.getPremiumtableseatamount()+" ***");
				obj.tables.tableSeats.getPremiumTableSeatArrangement();
			*/
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	   
		}

		public static void cancelBooking(Customer cus_obj,String orderid) {
				
			try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
			 //System.out.println("OLD : "+cus_obj.getCus_order_count());
			   cnpv.updateCancelOperation(orderid,cus_obj.getCustomerId(),cus_obj.getCus_order_count()-1,con);
				for(Booking obj_check :bookingobjlist) {
					
					
					if(obj_check.getOrder_id().equalsIgnoreCase(orderid)) {
							
						
						String res_id=obj_check.getRes_id();
						
						Restaurant res_obj_call=new Restaurant();
						
						for(Restaurant res_obj_iter:res_obj_call.restaurant_obj_list) {
							
							if(res_id.equalsIgnoreCase(res_obj_iter.getRestaurantID())) {
									
								
								for(Integer key:obj_check.getUser_choice_seat_list_basic()) {
									
									for(Map.Entry hashobj: res_obj_iter.tables.tableSeats.basicseatobj.entrySet())
						    		{
										
										
						    			if(key.equals(hashobj.getKey()))
						    			{
						    				if(key<10) {
						    					hashobj.setValue("B00"+key);
						    					cnpv.putValueToBasicSeat(cus_obj.getCustomerId(),res_obj_iter.getRestaurantID(),orderid,key,"B00"+key,con) ;
						    				}
						    				else if(key>9 &&key<100) {
						    					hashobj.setValue("B0"+key);
						    					cnpv.putValueToBasicSeat(cus_obj.getCustomerId(),res_obj_iter.getRestaurantID(),orderid,key,"B0"+key,con) ;
						    				}
						    				else {
						    					hashobj.setValue("B"+key);
						    					cnpv.putValueToBasicSeat(cus_obj.getCustomerId(),res_obj_iter.getRestaurantID(),orderid,key,"B"+key,con) ;
						    				}
				
						    				
						    			}
						    		
						    		}
								}
								
								for(Integer key:obj_check.getUser_choice_seat_list_premium()) {
									
									for(Map.Entry hashobj: res_obj_iter.tables.tableSeats.premiumseatobj.entrySet())
						    		{
						    			if(key.equals(hashobj.getKey()))
						    			{
						    				if(key<10) {
						    					hashobj.setValue("P00"+key);
						    					cnpv.putValueToPremiumSeat(cus_obj.getCustomerId(),res_obj_iter.getRestaurantID(),orderid,key,"P00"+key,con) ;
						    				}
						    				else if(key>9 &&key<100) {
						    					hashobj.setValue("P0"+key);
						    					cnpv.putValueToPremiumSeat(cus_obj.getCustomerId(),res_obj_iter.getRestaurantID(),orderid,key,"P0"+key,con) ;
						    				}
						    				else {
						    					hashobj.setValue("P"+key);
						    					cnpv.putValueToPremiumSeat(cus_obj.getCustomerId(),res_obj_iter.getRestaurantID(),orderid,key,"P"+key,con) ;
						    				}
						    			}
						    		
						    		}
								}
								//obj_check.setCus_order_count(obj_check.getCus_order_count()-1);
								cus_obj.setCus_order_count(cus_obj.getCus_order_count()-1);
								obj_check.setOrder_status(0);
								obj_check.setPaymentstatus("REFUND INITIATED");
							}
							
							
						}
						
					}
				}
			
			
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Successfully Cancel Booking Order");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}



}