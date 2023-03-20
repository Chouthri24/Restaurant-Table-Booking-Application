package com.notification;

import java.time.format.DateTimeFormatter;

import com.booking.Booking;

public class Notification {
	
	 Booking bookingobj=new Booking();
	 int flag2=0;
	  public void cusOrderTickets(String cusid) {
		  DateTimeFormatter ft1=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    	for(Booking obj:bookingobj.bookingobjlist) {
	    		
	    		if(obj.getCustomerId().equalsIgnoreCase(cusid) && obj.getOrder_status()==1) {
	    			
	    			flag2=1;
	    			System.out.println("\t"+"\t"+"---------------------------------------------------------");
	    			System.out.println("\t"+"\t"+"						Ticket			 				 ");
	    			System.out.println("\t"+"\t"+"---------------------------------------------------------");
	    			System.out.println("\t"+"\t"+"\t"+"Order Id : "+obj.getOrder_id());
	    			System.out.println("\t"+"\t"+"\t"+"Date : "+obj.getNextdate().format(ft1));
	    			System.out.println("\t"+"\t"+"\t"+"Restaurant Name : " +obj.getRes_name()+" Restaurant");
	    			System.out.println("\t"+"\t"+"\t"+"Restaurant Address : "+obj.getRes_address());
	    			System.out.print("\t"+"\t"+"\t"+"Table Seats : ");
	    			obj.getUser_choice_seats().stream().forEach(cus_seat->System.out.print(cus_seat+" "));
	    			/*for(String cus_seat:obj.getUser_choice_seats()) {
	    				System.out.print(cus_seat+" ");
	    			}*/
	    			System.out.println("\n"+"\t"+"\t"+"\t"+"Amount : "+obj.getBillamount());
	    			System.out.println("\t"+"\t"+"\t"+"Payment Status : "+obj.getPaymentstatus());
	    			System.out.println("\t"+"\t"+"---------------------------------------------------------");
	    			System.out.println();
	    		}
	    	}
	
	    	if(flag2==0) {
	    		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"No Booking History...");
	    	}
	    }
	  int flag=0;
	  public void all_CusOrderTickets(String cusid) {
	    	
		  
		 	DateTimeFormatter ft=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    	for(Booking obj:bookingobj.bookingobjlist) {
	    		
	    		if(cusid.equalsIgnoreCase(obj.getCustomerId())) {
	    			 System.out.println("\t"+"\t"+"---------------------------------------------------------");
	    				System.out.println("\t"+"\t"+"						Ticket			 				 ");
	    				System.out.println("\t"+"\t"+"---------------------------------------------------------");
	    				
	    			flag=1;
	    			System.out.println("\t"+"\t"+"\t"+"Order Id : "+obj.getOrder_id());
	    			System.out.println("\t"+"\t"+"\t"+"Date : "+obj.getNextdate().format(ft));
	    			System.out.println("\t"+"\t"+"\t"+"Restaurant Name : " +obj.getRes_name()+" Restaurant");
	    			System.out.println("\t"+"\t"+"\t"+"Restaurant Address : "+obj.getRes_address());
	    			System.out.print("\t"+"\t"+"\t"+"Table Seats : ");
	    			
	    			obj.getUser_choice_seats().stream().forEach(cus_seat->System.out.print(cus_seat+" "));
	    			/*for(String cus_seat:obj.getUser_choice_seats()) {
	    				System.out.print(cus_seat+" ");
	    			}*/
	    			System.out.println("\n"+"\t"+"\t"+"\t"+"Amount : "+obj.getBillamount());
	    			System.out.println("\t"+"\t"+"\t"+"Payment Status : "+obj.getPaymentstatus());
	    			System.out.println("\t"+"\t"+"---------------------------------------------------------");
	    			
	    		}
	    	}
	    	if(flag==0) {
	    		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"No Booking History...");
	    	}
	    	
	    	
	    }
	  
	  
}
