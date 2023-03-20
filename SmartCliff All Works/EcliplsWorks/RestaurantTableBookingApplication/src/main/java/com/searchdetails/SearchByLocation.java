package com.searchdetails;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.booking.Booking;
import com.booking.ShowRestaurant;
import com.main.Main;
import com.persondetails.Customer;
import com.persondetails.Restaurant;
import com.restaurantdetails.TableSeats;

public class SearchByLocation  implements search {
	
	public static boolean  continue_var;
	Restaurant mainobj=new Restaurant();
	TableSeats tableseatobj=new TableSeats();
	int flag;
	List<Restaurant> resObj1=new LinkedList<Restaurant>();
	   public void searchRestaurant(String element,Customer cusobj) {
		   do {
			continue_var=false;
		   int count=1;
		   System.out.println("\n"+"-------------------------------------------------------------------"
					+ "--------------------------------------------------");
			System.out.printf("%5s%10s%23s%23s%23s%23s\n","No.","Name","Location","Distance","Address","ContactNo");
			 System.out.println("\n"+"-------------------------------------------------------------------"
						+ "--------------------------------------------------");
			
			for(Restaurant obj2:mainobj.restaurant_obj_list) {
				
				if(obj2.getRestaurantLocation().equalsIgnoreCase(element) && obj2.getRestaurant_isActive()==1) {
					
					System.out.printf("%5s%10s%23s%23s%23s%23s\n",count++,obj2.getRestaurantName(),obj2.getRestaurantLocation(),obj2.getRestaurant_distance(),obj2.getRestaurantAddress(),
							obj2.getContact_no());
						flag=1;
							resObj1.add(obj2);
					}
			}
			
			if(flag==1) {
				 System.out.println("\n"+"-------------------------------------------------------------------"
							+ "--------------------------------------------------");
				
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
			
			if(resObj1.size()<Integer.parseInt(choice)) {
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				continue_var=true;
			}
			
			
				 }while(continue_var);
			
				
			
			int i=0,B=0,P=0;
			for(Restaurant obj:resObj1) {
				 i++;
				 if(i==Integer.parseInt(choice)) {
					 ShowRestaurant show_res_obj=new ShowRestaurant();
					 Booking book_obj=new Booking();
					 book_obj.setShow_restaurant_obj(show_res_obj);
					 
					 if( book_obj.show_restaurant_obj.showRestaurantDetails(obj)) {
						 
						 if(cusobj.getCustomerId()!="Guest0") {
						 book_obj.bookingOperation(obj, cusobj);
						 }else {
								System.out.println("Sry You Need To Create Account...");
								continue_var=true;
							}
					 }
					 else {
					 continue_var=true;
					 }
				 
				 }
				}
			}
			else {
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Not Found ...");
		
				 System.out.println("\n"+"-------------------------------------------------------------------"
							+ "--------------------------------------------------");
					
			}
			
		   
		}while(continue_var);
					 
					 
	 }
			
			
	   
	 }
