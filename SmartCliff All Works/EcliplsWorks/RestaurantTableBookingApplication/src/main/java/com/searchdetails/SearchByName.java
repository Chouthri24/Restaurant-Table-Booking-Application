package com.searchdetails;

import com.persondetails.Customer;
import com.persondetails.Restaurant;
import com.booking.Booking;
import com.booking.ShowRestaurant;
import com.main.*;
public class SearchByName implements search{
	
	
	Restaurant mainobj=new Restaurant();
	   public void searchRestaurant(String element,Customer cusobj) {
		   int flag=0;
		   System.out.println("\n"+"-------------------------------------------------------------------"
					+ "--------------------------------------------------");
			System.out.printf("%5s%10s%23s%23s%23s%23s\n","No.","Name","Location","Distance","Address","ContactNo");
			 System.out.println("\n"+"-------------------------------------------------------------------"
						+ "--------------------------------------------------");
				for(Restaurant obj2:mainobj.restaurant_obj_list) {
				
				if(obj2.getRestaurantName().equalsIgnoreCase(element) && obj2.getRestaurant_isActive()==1) {
				System.out.printf("%5s%10s%23s%23s%23s%23s\n","1.",obj2.getRestaurantName(),obj2.getRestaurantLocation(),obj2.getRestaurant_distance(),obj2.getRestaurantAddress(),
						obj2.getContact_no());
				 System.out.println("\n"+"-------------------------------------------------------------------"
							+ "--------------------------------------------------");
				
				flag=1;
					
					boolean continue_var;
					String choice;
					 do {
						 continue_var=false;
						 System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Back 0");
				    System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choose Restaurant No : ");
				    choice=read.next();
				
				while(!Main.isCheckChoice(choice))
				{
					System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
					 System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Back 0"); 
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choose Restaurant No : ");
					choice=read.next();
				}
				
				if(Integer.parseInt(choice)>1) {
					
					System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
					continue_var=true;
				}
				
					 }while(continue_var);
				
					
					if(Integer.parseInt(choice)==1) {
						 ShowRestaurant show_res_obj=new ShowRestaurant();
						 Booking book_obj=new Booking();
						 book_obj.setShow_restaurant_obj(show_res_obj);
						 
						 if( book_obj.show_restaurant_obj.showRestaurantDetails(obj2)) {
							 
							 if(cusobj.getCustomerId()!="Guest0") {
							 book_obj.bookingOperation(obj2, cusobj);
								 }else {
										System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Sry You Need To Create Account..."+"\n");
										
									}
							 
						 }
					}
				
				break;
			}
			}
			if(flag==0) {
				
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Not Found ...");
				 System.out.println("\n"+"-------------------------------------------------------------------"
							+ "--------------------------------------------------");
					
			}
			
			
			
		   
	   }
}
