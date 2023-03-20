package com.main;
import com.booking.Booking;
import com.notification.Notification;
import com.persondetails.Account;
import com.persondetails.Admin;
import com.persondetails.Customer;
import com.persondetails.Person;
import com.persondetails.Restaurant;
import com.restaurantdetails.FoodItems;
import com.restaurantdetails.TableSeats;
import com.restaurantdetails.Tables;
import com.searchdetails.SearchByDistance;
import com.searchdetails.SearchByLocation;
import com.searchdetails.SearchByName;
import com.searchdetails.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
enum GENDER{
	MALE,
	FEMALE,
	TRANSGENDER
};
public class Main {
	
	public static Scanner read=new Scanner(System.in);
	public static Admin admin_obj=new Admin();
	public static Restaurant res_main_obj;
	public static Customer cus_main_obj;
	public static ConnectionProvider cnpv=new ConnectionProvider();
	public static boolean  continue_var;
	public static boolean continueMethod() {
		 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Do you Want to Continue Again ? 1.YES 2.NO");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Waiting : ");
			String n=read.next().trim();
			while(!isCheckChoice(n))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
				n=read.next().trim();
			}
			if(Integer.parseInt(n)==2) {
				return false;
			}else if(Integer.parseInt(n)==1){
				return true;
			}else {
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
				n=read.next().trim();
			}
			return true;
	}
	public static void choice() {
		do {
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"....M A I N   M E N U...."+"\n");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Admin");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Customer");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Restaurant");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.Guest");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"5.Exit"+"\n");
		
		continue_var=false;
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice :");
		String main_choice=read.next().trim();
		while(!isCheckChoice(main_choice))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
			main_choice=read.next().trim();
		}
		
		switch(Integer.parseInt(main_choice)) {
		case 1:
			 admin_obj.setAdminDetails();
		     adminChoice();
		     continue_var=true;
			break;
		case 2:
			customerChoice();
			 continue_var=true;
			break;
		case 3:
			restaurantChoice();
			 continue_var=true;
			break;
		case 4:
			Customer dummy_obj=new Customer();
			dummy_obj.setCustomerId2("Guest0");
			searchRestaurant(dummy_obj);
			continue_var=true;
			break;
		case 5:
			 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Exited...");
			break;
		default :
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
			continue_var=continueMethod();
			break;
		}
		}while(continue_var);
	}
	public static void restaurantChoice() {
		do {
		String userType3="RESTAURANT";
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"....R E S T A U R A N T   M E N U...."+"\n");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.SignIn");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Back"+"\n");
		
			continue_var=false;
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice :");
		
		String restaurantChoice=read.next().trim();
		while(!isCheckChoice(restaurantChoice))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
			restaurantChoice=read.next().trim();
		}
		switch(Integer.parseInt(restaurantChoice)) {
		case 1:
			signIn(userType3);
			break;
		case 2:
			 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Exited...");
				break;
		default:
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
			continue_var=continueMethod();
			break;
		}
		}while(continue_var);
		 
	}
	public static void customerChoice() {
		String userType2="CUSTOMER";
		do {
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"....C U S T O M E R   M E N U...."+"\n");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.SignUp");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.SignIn");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Back"+"\n");
		
			continue_var=false;
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice :");
			String customer_choice=read.next().trim();
		while(!isCheckChoice(customer_choice))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
			customer_choice=read.next().trim();
		}
		switch(Integer.parseInt(customer_choice)) {
		case 1:
			signUp(userType2);
			signIn(userType2);
			break;
		case 2:
			signIn(userType2);
			break;
		case 3:
			 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Exited...");
			break;
		default:
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
			continue_var=continueMethod();
			break;
		}
		}while(continue_var);
		
	}
	public static void adminChoice() {
		String userType1="ADMIN";
		do {
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"....A D M I N   M E N U...."+"\n");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.SignIn");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Back To Main Menu"+"\n");
			continue_var=false;
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice :");
		String admin_choice=read.next().trim();
		while(!isCheckChoice(admin_choice))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
			admin_choice=read.next().trim();
		}
		switch(Integer.parseInt(admin_choice)) {
		case 1:
			signIn(userType1);
			
			break;
		case 2:
			 
				break;
		default:
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
			continue_var=continueMethod();
			break;
		}
		}while(continue_var);
		 
	}
	
	public static void signIn(String user_type) {
		Account acc_main_obj=new Account();
		do {
			continue_var=false;
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"....S I G N I N   P A G E..."+"\n");
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"User Email ID :");
		String user_emailid=read.next().trim();
		while(!isCheckEmail(user_emailid))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Email ID Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"User Email ID : ");
			user_emailid=read.next().trim();
		}
		
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"User Password :");
		String user_password=read.next().trim();
		while(!isCheckPassword(user_password))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Password Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"User Password : ");
			user_password=read.next().trim();
		}
		int flag=0;
		switch(user_type) {
		case "ADMIN":
			
			for(Account acc_obj:acc_main_obj.getAccount_obj_list()) {
				
				
				//System.out.println(acc_obj.getUserID());
				if(user_emailid.equalsIgnoreCase(acc_obj.getUser_emailid())&&
			    		user_password.equalsIgnoreCase(acc_obj.getUserPassword())&&
			    		user_type.equalsIgnoreCase(acc_obj.getUserType()) && acc_obj.getIsActive()==1) {
					   flag=1;
					   //System.out.println(acc_obj.getUserID());
					   System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Admin Sign In Successfully...");
					   adminDashBoard(admin_obj);
					  
						break;
					}
				}
				if(flag==0) {
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Sign in Failed ...");
					continue_var=continueMethod();
				}    
		    
			break;
		case "CUSTOMER":
			for(Account acc_obj:acc_main_obj.getAccount_obj_list()) {
			if(user_emailid.equalsIgnoreCase(acc_obj.getUser_emailid())&&
		    		user_password.equalsIgnoreCase(acc_obj.getUserPassword())&&
		    		user_type.equalsIgnoreCase(acc_obj.getUserType()) && acc_obj.getIsActive()==1) {
				    
				      
				     for(Customer cus_obj:cus_main_obj.customer_obj_list) {
				    	   if(acc_obj.getUserID().equalsIgnoreCase(cus_obj.getCustomerId())) {
				    		   flag=1;
				    		  // System.out.println(acc_obj.getUserID());
								
				    		   customerDashBoard(cus_obj);
				    		   break;
				    	   }
				    	 
				     }
				     
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Customer Sign In Successfully...");
					break;
				}
			}
			if(flag==0) {
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Sign in Failed ...");
				continue_var=continueMethod();
			}
			break;
		case "RESTAURANT":
			for(Account acc_obj:acc_main_obj.getAccount_obj_list()) {
				if(user_emailid.equalsIgnoreCase(acc_obj.getUser_emailid())&&
			    		user_password.equalsIgnoreCase(acc_obj.getUserPassword())&&
			    		user_type.equalsIgnoreCase(acc_obj.getUserType()) && acc_obj.getIsActive()==1) {
					    
					      
					     for(Restaurant res_obj:res_main_obj.restaurant_obj_list) {
					    	   if(acc_obj.getUserID().equalsIgnoreCase(res_obj.getRestaurantID())) {
					    		   flag=1;
					    		  // System.out.println(acc_obj.getUserID());
					    		   System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Sign In Successfully...");
					    		   restaurantDashBoard(res_obj);
					    	   }
					    	 
					     }
				
			
			break;
			}
			}
		if(flag==0)
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Sign in Failed ...");
			continue_var=continueMethod();
		}
		
		}
		}while(continue_var);
			
	}
	
	public static void restaurantDashBoard(Restaurant obj2) {
		do {
			continue_var=false;
		
			System.out.println();
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+".... "+obj2.getRestaurantName()+" Restaurant DashBoard ...."+"\n");
		
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Add Restaurant Details");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Update Restaurant Profile");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.View Booking");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.Sign Out"+"\n");
	
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice :");
		
		String restaurantDashBoardChoice=read.next().trim();
		while(!isCheckChoice(restaurantDashBoardChoice))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
			restaurantDashBoardChoice=read.next().trim();
		}
		
		switch(Integer.parseInt(restaurantDashBoardChoice)) {
		case 1:
			addRestaurantDetails(obj2);
			continue_var=true;
			break;
		case 2:
			updateRestaurantDetails(obj2);
			continue_var=true;
			break;
		case 3:
			obj2.viewBookingList(obj2);
			obj2.viewPaymentList(obj2);
			continue_var=true;
			break;
		case 4:
			 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Exited...");
				break;
		default:
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
			continue_var=continueMethod();
			break;
		}
		}while(continue_var);
		 
	}
	
	public static void adminDashBoard(Admin admin_obj) {
		do {
			continue_var=false;
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+".... A D M I N   D A S H B O A R D ...."+"\n");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Add Restaurant");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Update Restaurant");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Delete Restaurant");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.View Restaurant Details");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"5.View Customer Details");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"6.Change Password");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"7.Sign Out"+"\n");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice :");
			
			String admin_dashboard_choice=read.next().trim();
			while(!isCheckChoice(admin_dashboard_choice))
			{
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
				admin_dashboard_choice=read.next().trim();
			}
			switch(Integer.parseInt(admin_dashboard_choice)) {
			case 1:
				addRestaurant("RESTAURANT");
				viewRestaurantRecord();
				continue_var=true;
				break;
			case 2:
				updateRestaurant();
				continue_var=true;
				break;
			case 3:
				deleteRestaurant("RESTAURANT");
				continue_var=true;
				break;
			case 4:
                  viewRestaurantRecord();
                  continue_var=true;
				break;
			case 5:
				viewCustomerUpdatedRecord();
				continue_var=true;
				break;
			case 6:
                  System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Admin Password : ");
                  String newadminpassword=read.next().trim();
                  while(!isCheckPassword(newadminpassword))
					{
						System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Password Pls Enter Again...");
						System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Password : ");
						newadminpassword=read.next().trim();
					}
                  admin_obj.setAdminPassword(newadminpassword);
                  System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Change Admin password updated successfully...");
                  continue_var=true;
				break;
			case 7:
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Exited...");
				break;
			default:
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
				continue_var=continueMethod();
				break;
			}
			}while(continue_var);
			
	}
	
	
	
	public static void deleteRestaurant(String restaurantType) {
		
		do {
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+".... D E L E T E   R E S T A U R A N T   A C C O U N T ...."+"\n");
			
			continue_var=false;
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant ID : ");
			String restaurantID=read.next().trim();
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Note: Only Restaurant Name Dont Mention Restaurant");
			
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Name : ");
			read.nextLine();
			String restaurantName=read.nextLine().trim();		
			int flag=0;
			for(Restaurant obj:res_main_obj.restaurant_obj_list)
			{
				if(restaurantName.equalsIgnoreCase(obj.getRestaurantName()) && restaurantID.equalsIgnoreCase(obj.getRestaurantID())&& obj.getRestaurant_isActive()==1)
						{
					    flag=1;
					    do {
					    continue_var=false;
					    System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Confirm to Delete "+obj.getRestaurantID()+" Account ? 1.Yes 2.No");
					    System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
					    String check=read.next().trim();
					    while(!isCheckChoice(check))
						{
							System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
							System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
							check=read.next().trim();
						}
					    if(Integer.parseInt(check)==1) {
					    obj.account_obj2.setIsActive(0);
					    obj.setRestaurant_isActive(0);
					    cnpv.deleteRestaurantAccount(obj);
					    System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Account Deleted ID:"+obj.getRestaurantID()+"\n");
					    }else {
					    	System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
					    	continue_var=continueMethod();
					    }
					    }while(continue_var);
					    break;
				}
				
			}
			
			if(flag==0) {
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"No Record Found...");
				continue_var=continueMethod();
			}
			
		}while(continue_var);
		
	}
	
	public static void updateRestaurantDetails(Restaurant obj) {
		System.out.println();
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"O L D   R E C O R D ...");
		viewSingleAdminUpdatedRecord(obj);
		
		System.out.println("!!!-----------------------------------------------------------------------!!!");
		System.out.println("!!!                   B A S I C   S E A T  A R R A N G E M E N T             !!!");
		System.out.println("!!!-----------------------------------------------------------------------!!!");
		
		obj.tables.tableSeats.getBasicTableSeatArrangement();
		System.out.println("!!!------------------------* * * * *--------------------------------!!!");
		
		System.out.println("!!!-----------------------------------------------------------------------!!!");
		System.out.println("!!!             P R E M I U M  S E A T  A R R A N G E M E N T             !!!");
		System.out.println("!!!-----------------------------------------------------------------------!!!");
		
		obj.tables.tableSeats.getPremiumTableSeatArrangement();
		System.out.println("!!!-----------------------------------------------------------------------!!!");
		System.out.println("!!!                            A M O U N T                                !!!");
		System.out.println("!!!-----------------------------------------------------------------------!!!");
		
		System.out.println("Basic Seat Amount : "+obj.tables.getBasictableseatamount());
		System.out.println("Premium Seat Amount : "+obj.tables.getPremiumtableseatamount());
		System.out.println("!!!-----------------------------------------------------------------------!!!");
		
		
		
		
		do {
			continue_var=false;
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+".... U P D A T E   R E S T A U R A N T   D E T A I L S ...."+"\n");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Update Profile");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Update Table Arrangement & Amount");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Update Food Items");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.Go to Main"+"\n");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
			String choice=read.next().trim();
			System.out.println();
			while(!isCheckChoice(choice))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
				choice=read.next().trim();
			}
			switch(Integer.parseInt(choice)) {
			case 1:
					updateRestaurantPersonalProfile(obj);
					continue_var=true;
				break;
			case 2:
					updateTableArrangement(obj);	
					continue_var=true;

				break;
			case 3:
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Enter Your Food Menu:"+"\n");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 1 : ");
				read.nextLine();
				String item_1=read.nextLine();
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 2 : ");
				String item_2=read.nextLine();
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 3 : ");
				String item_3=read.nextLine();
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 4 : ");
				String item_4=read.nextLine();
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 5 : ");
				String item_5=read.nextLine();
				String res_menu=item_1.concat(","+item_2).concat(","+item_3).concat(","+item_4).concat(","+item_5);
				obj.fooditems.setFoodName(res_menu);
				cnpv.updateFoodMent(obj.getRestaurantID(), res_menu);
				
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Food Items Updated Successfully");
				
				continue_var=true;
				break;
			case 4:
				
				break;
			default:
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
				continue_var=continueMethod();
				break;
			}
			}while(continue_var);
		    /*System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"U P D A T E D   R E C O R D");
			viewSingleAdminUpdatedRecord(obj);
			
			
			System.out.println("!!!-----------------------------------------------------------------------!!!");
			System.out.println("!!!                   B A S I C   S E A T  A R R A N G E M E N T             !!!");
			System.out.println("!!!-----------------------------------------------------------------------!!!");
			
			obj.tables.tableSeats.getBasicTableSeatArrangement();
			System.out.println("!!!------------------------* * * * *--------------------------------!!!");
			
			System.out.println("!!!-----------------------------------------------------------------------!!!");
			System.out.println("!!!             P R E M I U M  S E A T  A R R A N G E M E N T             !!!");
			System.out.println("!!!-----------------------------------------------------------------------!!!");
			
			obj.tables.tableSeats.getPremiumTableSeatArrangement();
			System.out.println("!!!-----------------------------------------------------------------------!!!");
			System.out.println("!!!                            A M O U N T                                !!!");
			System.out.println("!!!-----------------------------------------------------------------------!!!");
			
			System.out.println("Basic Seat Amount : "+obj.tables.getBasictableseatamount());
			System.out.println("Premium Seat Amount : "+obj.tables.getPremiumtableseatamount());
			System.out.println("!!!-----------------------------------------------------------------------!!!");
			*/
			 System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Details Updated Successfully...");
			
			}
		 
		
	
	public static void updateTableArrangement(Restaurant obj) {
		do {
			continue_var=false;
		    System.out.println();
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Update Basic Tables");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Update Premium Tables");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Update Both Tables");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.Back"+"\n");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
			String choice=read.next().trim();
			while(!isCheckChoice(choice))
			{
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
				choice=read.next().trim();
			}
			switch(Integer.parseInt(choice)) {
			case 1:
				cnpv.deletePremiumTableSeatRecord(obj); 
				 cnpv.deleteBasicTableSeatRecord(obj);  
				 obj.tables.tableSeats.basicseatobj.clear();
				 obj.tables.tableSeats.premiumseatobj.clear();
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Basic Table Count : ");
				String basic_count=read.next().trim();
				while(!isCheckChoice(basic_count))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Table Count !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Basic Table Count : ");
					basic_count=read.next().trim();
				}
				
				int basic_table_count=Integer.parseInt(basic_count);
				
				obj.tables.tableSeats.setBasictablecount(basic_table_count);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Basic Table Seat Count : ");
				
				String basic_seat_count=read.next().trim();
				while(!isCheckChoice(basic_seat_count))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Table Seat Count !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Basic Table Seat Count : ");
					basic_seat_count=read.next().trim();
				}
				
				int basic_table_seat_count=Integer.parseInt(basic_seat_count);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Basic Seat Amount : ");
				
				String amt_ps=read.next().trim();
				
				while(!isCheckAmount(amt_ps))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid New Basic Seat Amount !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Amount : ");
					amt_ps=read.next().trim();
				}
				int amount1=Integer.parseInt(amt_ps);
				
				obj.tables.setBasictableseatamount(amount1);
				obj.tables.setBasictableseatamountCnpv(amount1,cnpv,obj);
				obj.tables.tableSeats.setBasictableseatcount(basic_table_seat_count);
				obj.tables.tableSeats.setBasicTableSeatID("B",obj,cnpv);
				obj.tables.setTableType("BASICS");
				cnpv.updatePremiumTableSeatInRes(0,0,obj);
				cnpv.updatePremiumTableAmount(0,obj);
				obj.tables.setPremiumtableseatamount(0);
				obj.tables.tableSeats.setPremiumtablecount(0);
				obj.tables.tableSeats.setPremiumtableseatcount(0);
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Basic Tables Successfully Updated..."+"\n");
				
				
				break;
			case 2:
				cnpv.deletePremiumTableSeatRecord(obj); 
				 cnpv.deleteBasicTableSeatRecord(obj);  
				 obj.tables.tableSeats.basicseatobj.clear();
				 obj.tables.tableSeats.premiumseatobj.clear();
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Premium Table Count : ");
				String premium_count=read.next().trim();
				while(!isCheckChoice(premium_count))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid New Premium Table Count !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter New Premium Table Count : ");
					premium_count=read.next().trim();
				}
				
				int premium_table_count=Integer.parseInt(premium_count);
				
				
				
				obj.tables.tableSeats.setPremiumtablecount(premium_table_count);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Premium Table Seat Count : ");
				
				String premium_seat_count=read.next().trim();
				while(!isCheckChoice(premium_seat_count))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid New Premium Table Count !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter New Premium Table Count : ");
					premium_seat_count=read.next().trim();
				}
				
				int premium_table_seat_count=Integer.parseInt(premium_seat_count);
				obj.tables.tableSeats.setPremiumtableseatcount(premium_table_seat_count);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Premium Seat Amount : ");
				String amt1=read.next().trim();
				while(!isCheckAmount(amt1))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid New Premium Seat Amount !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Amount : ");
					amt1=read.next().trim();
				}
				int amount2=Integer.parseInt(amt1);
		
				obj.tables.setPremiumtableseatamountCnpv(amount2,cnpv,obj);
				obj.tables.setPremiumtableseatamount(amount2);
				
				obj.tables.tableSeats.setPremiumTableSeatID("P",obj,cnpv);
				obj.tables.setTableType("PREMIUM");
				cnpv.updateBasicTableSeatInRes(0,0,obj);
				cnpv.updateBasicTableAmount(0,obj);
				obj.tables.setBasictableseatamount(0);
				obj.tables.tableSeats.setBasictablecount(0);
				obj.tables.tableSeats.setBasictableseatcount(0);

				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Premium Tables Successfully Updated..."+"\n");
				
				break;
			case 3:
				cnpv.deletePremiumTableSeatRecord(obj); 
				 cnpv.deleteBasicTableSeatRecord(obj);  
				 obj.tables.tableSeats.basicseatobj.clear();
				 obj.tables.tableSeats.premiumseatobj.clear();
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Basic Table Count : ");
				
				String basic_count1=read.next().trim();
				while(!isCheckChoice(basic_count1))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Table Count !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Basic Table Count : ");
					basic_count1=read.next().trim();
				}
				
				int basic_table_count1=Integer.parseInt(basic_count1);
					
				obj.tables.tableSeats.setBasictablecount(basic_table_count1);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Basic Table Seat Count : ");
				
				String basic_seat_count1=read.next().trim();
				while(!isCheckChoice(basic_seat_count1))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Table Seat Count !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Basic Table Seat Count : ");
					basic_seat_count1=read.next().trim();
				}
				int basic_table_seat_count1=Integer.parseInt(basic_seat_count1);	
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Basic Seat Amount : ");
				
				String amt2=read.next().trim();
				while(!isCheckAmount(amt2))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid New Basic Seat Amount !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Amount : ");
					amt2=read.next().trim();
				}
				int amount3=Integer.parseInt(amt2);
				obj.tables.setBasictableseatamount(amount3);
				obj.tables.setBasictableseatamountCnpv(amount3,cnpv,obj);
				obj.tables.tableSeats.setBasictableseatcount(basic_table_seat_count1);
				
				obj.tables.tableSeats.setBasicTableSeatID("B",obj,cnpv);
				obj.tables.setTableType("BOTH");
				
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Premium Table Count : ");
				
				String premium_count1=read.next().trim();
				while(!isCheckChoice(premium_count1))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid New Premium Table Count !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter New Premium Table Count : ");
					premium_count1=read.next().trim();
				}
				
				int premium_table_count1=Integer.parseInt(premium_count1);
				
				
				
				obj.tables.tableSeats.setPremiumtablecount(premium_table_count1);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Premium Table Seat Count : ");
				String premium_seat_count1=read.next().trim();
				while(!isCheckChoice(premium_seat_count1))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid New Premium Table Count !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter New Premium Table Count : ");
					premium_seat_count1=read.next().trim();
				}
				
				int premium_table_seat_count1=Integer.parseInt(premium_seat_count1);
				obj.tables.tableSeats.setPremiumtableseatcount(premium_table_seat_count1);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Premium Seat Amount : ");
				String amt4=read.next().trim();
				while(!isCheckAmount(amt4))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid New Premium Seat Amount !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Amount : ");
					amt4=read.next().trim();
				}
				int amount4=Integer.parseInt(amt4);			
				obj.tables.setPremiumtableseatamount(amount4);
				obj.tables.setPremiumtableseatamountCnpv(amount4,cnpv,obj);
				obj.tables.tableSeats.setPremiumTableSeatID("P",obj,cnpv);
				obj.tables.setTableType("BOTH");
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Basic and Premium Tables Successfully Updated..."+"\n");
				
				break;
			case 4:
				break;
			default:
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
		    	
				continue_var=continueMethod();
				break;
			}
			
		}while(continue_var);
		/*obj.tables.tableSeats.getBasicTableSeatArrangement();
		obj.tables.tableSeats.getPremiumTableSeatArrangement();*/
	}	
	
	
	public static void updateRestaurantPersonalProfile(Restaurant obj) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
			String sql2="UPDATE RESTAURANT SET FOODITEMS=? WHERE USERID=?";
		
		
		
		do {
			continue_var=false;
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"....U P D A T E    P E R S O N A L    D E T A I L S "+"\n");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Manager Name");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Contact No ");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Reset Password");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.Back"+"\n");
		
		
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
		String choice=read.next().trim();
		while(!isCheckChoice(choice))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
			choice=read.next().trim();
		}
		switch(Integer.parseInt(choice)) {
		case 1:
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Owner Name :");
			String owner_name=read.next().trim();
			obj.setName(owner_name);
			String sql1="UPDATE RESTAURANT SET MANAGERNAME=? WHERE USERID=?";
			PreparedStatement pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1,owner_name);
			pstmt1.setString(2,obj.getRestaurantID());
			pstmt1.executeUpdate();
			
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Owner Name Updated Successfully...");
			continue_var=true;
			break;
		
		case 2:
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Contact No :");
			String restaurant_contact_no=read.next().trim();
			while(!isCheckPhoneNo(restaurant_contact_no))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Contact No Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter New Contact No : ");
				restaurant_contact_no=read.next().trim();
			}			
			obj.setContact_no(restaurant_contact_no);
			
			
			String sql3="UPDATE RESTAURANT SET MANAGERCONTACTNO=? WHERE USERID=?";
			PreparedStatement pstmt2=con.prepareStatement(sql3);
			pstmt2.setString(1,restaurant_contact_no);
			pstmt2.setString(2,obj.getRestaurantID());
			pstmt2.executeUpdate();
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Contact Number Successfully Updated...");
			continue_var=true;
			break;
		case 3:
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Old Password : ");
			String oldpass=read.next().trim();
			while(!isCheckPassword(oldpass))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Password Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter Old Password : ");
				oldpass=read.next().trim();
			}
			if(oldpass.equalsIgnoreCase(obj.account_obj2.getUserPassword())) {
				
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"New Password : ");
				String newpass=read.next().trim();
				while(!isCheckPassword(newpass))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Password Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter New Password : ");
					newpass=read.next().trim();
				}
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Confirm Password : ");
				String conpass=read.next().trim();
				while(!isCheckPassword(conpass))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Confirm Password Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter Confirm Password : ");
					conpass=read.next().trim();
				}
				if(newpass.equals(conpass)) {
					obj.account_obj2.setUserPassword(conpass);
					
					String sql4="UPDATE ACCOUNT SET USERPASSWORD=? WHERE USERID=?";
					PreparedStatement pstmt4=con.prepareStatement(sql4);
					pstmt4.setString(1,conpass);
					pstmt4.setString(2,obj.getRestaurantID());
					pstmt4.executeUpdate();
					
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Password Updated Successfully...");
					continue_var=true;
				}
				else {
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Password Mismatch...");
				}
				
			}else {
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Password...");
				continue_var=continueMethod();
			}
			
			
			break;
		case 4:
			   
			
			con.close();
		
			break;
		default :
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
			continue_var=continueMethod();
			break;
		}
		}while(continue_var);
		
		}catch(ClassNotFoundException e) {
       	 
        }
        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
    public static void updateRestaurant() {
    	
    	boolean continue_var1;
    	do {
    		continue_var1=false;
    		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+".....U P D A T E   R E S T A U R A N T   D E T A I L S ...."+"\n");
    		
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant ID : ");
			String res_id=read.next().trim();
			
			
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Name : ");
			read.nextLine();
			String res_name=read.nextLine().trim();
			
			
			int flag=0,flag2=0;
			for(Restaurant obj3:res_main_obj.restaurant_obj_list) {
				//System.out.println(obj3.account_obj2.getUserID()+"="+obj3.account_obj2.getUserName());
				if(res_name.equalsIgnoreCase(obj3.getRestaurantName())&&
						res_id.equalsIgnoreCase(obj3.getRestaurantID())) {
					System.out.println();
					System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"     O L D   R E S T A U R A N T   P R O F I L E");
					flag=1;
					viewSingleAdminUpdatedRecord(obj3);
					
					System.out.println();
					System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"U P D A T E   R E S T A U R A N T   P R O F I L E");
					
					do {
						continue_var=false;
						System.out.println();
						System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Update Restaurant Name");
						System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Update Restaurant Address");
						System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Update Restaurant Location");
						System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.Back"+"\n");
						System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
						String choice=read.next().trim();
						while(!isCheckChoice(choice))
						{
							System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
							System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
							choice=read.next().trim();
						}
						switch(Integer.parseInt(choice)) {
						case 1:
							System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Note: Only Restaurant Name Dont Mention Restaurant");
							
							System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Restaurant Name : ");
							
							read.nextLine();
							String new_res_name=read.nextLine();
							obj3.account_obj2.setUserName(new_res_name);
							obj3.setRestaurantName(new_res_name);
							System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Name Updated Successfully...");
							continue_var=true;
							break;
						case 2:
							
							System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Note: Door No,Street,District,Pincode Separated By , ");
							
							System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Restaurant Address : ");
							read.nextLine();
							String new_res_address=read.nextLine();
							
							obj3.setRestaurantAddress(new_res_address);
							System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Address Updated Successfully...");
							continue_var=true;
							break;
						case 3:
							System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Restaurant Location : ");
							String new_res_location=read.next().trim();
							obj3.setRestaurantLocation(new_res_location);
							System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Location Updated Successfully...");
							continue_var=true;
							break;
						
						case 4:
							
							break;
						default:
							System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
							continue_var=continueMethod();
							break;
						}
					}while(continue_var);
					//viewSingleAdminUpdatedRecord(obj3);
					System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Details Successfully Updated ...");
					
					
				}
			}
			if(flag==0) {
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Record Not Found ...");
				continue_var1=continueMethod();
			}
    	}while(continue_var1);
		
	}
    
   
    
    public static void viewCustomerUpdatedRecord() {
    	
    	System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s%20s%23s%20s%20s%18s%18s%20s%20s\n","ID","Name","Email Id","ContactNo","Gender","Age","Address","order_count","IsActive");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(Customer obj1:cus_main_obj.customer_obj_list) {
			//if(obj1.getIsActive()==1) {
			
			String active_status;
			if(obj1.getIsActive()==1) {
				    active_status="ACTIVE";
					}
			else {
				active_status="INACTIVE";
			}
				System.out.println();
				System.out.printf("%5s%20s%23s%20s%20s%18s%18s%20s%20s\n",obj1.getCustomerId()
						,obj1.getName(),obj1.getEmail_id(),obj1.getContact_no(),obj1.getGender(),obj1.getAge(),obj1.getAddress(),obj1.getCus_order_count(),active_status);
			//	}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
    }
    
 public static void viewSingleCustomerUpdatedRecord(Customer obj1) {
    	
    	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%10s%23s%23s%23s%23s%23s%23s\n","Name","Email ID","ContactNo","Gender","Age","Address","Order_count");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		
			System.out.printf("%5s%23s%23s%23s%23s%23s%23s\n",
					obj1.getName(),obj1.getEmail_id(),obj1.getContact_no(),obj1.getGender(),obj1.getAge(),obj1.getAddress(),obj1.getCus_order_count());
			
		
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
			
    }
    
    
    public static void viewSingleAdminUpdatedRecord(Restaurant obj2) {
    	
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------"
				+ "-----------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s%18s%20s%23s%20s%20s%21s%21s%21s%23s%23s%23s%23s%20s\n","ID","Name","Manager Name","Manager Email Id","Address","Location","Distance","Contact No","Tables","Seats","BasicSeatAmount","PremiumSeatAmount","FoodItems","IsActive");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------"
				+ "-----------------------------------------------------------------------------------------------------------------------------");
		
			System.out.printf("%5s%18s%20s%23s%20s%20s%21s%21s%21s%23s%23s%23s%23s%20s\n",obj2.getRestaurantID(),obj2.getRestaurantName(),obj2.getName(),obj2.getEmail_id(),obj2.getRestaurantAddress(),
					obj2.getRestaurantLocation(),obj2.getRestaurant_distance(),obj2.getContact_no(),"Bascis-"+obj2.tables.tableSeats.getBasictablecount(),
					"Basics-"+obj2.tables.tableSeats.getBasictableseatcount(),obj2.tables.getBasictableseatamount(),obj2.tables.getPremiumtableseatamount(),obj2.fooditems.getFoodName());
		
				System.out.printf("%170s%23s\n","Premium-"+obj2.tables.tableSeats.getPremiumtablecount()
						,"Premium-"+obj2.tables.tableSeats.getPremiumtableseatcount());
			
		
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------------------------------------------------------------------------");
				
    }
     
    
    
    
	public static void viewRestaurantRecord() {
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------"
				+ "-----------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s%18s%20s%23s%20s%20s%21s%21s%21s%23s%23s%23s%23s%20s\n","ID","Name","Manager Name","Manager Email Id","Address","Location","Distance","Contact No","Tables","Seats","BasicSeatAmount","PremiumSeatAmount","FoodItems","IsActive");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------"
				+ "-----------------------------------------------------------------------------------------------------------------------------");
		for(Restaurant obj2:res_main_obj.restaurant_obj_list) {
			//System.out.println(obj2.getRestaurantID());
			String active_status;
			if(obj2.getRestaurant_isActive()==1) {
				    active_status="ACTIVE";
					}
			else {
				active_status="INACTIVE";
			}
			System.out.printf("%5s%18s%20s%23s%20s%20s%21s%21s%21s%23s%23s%23s%23s%20s\n",obj2.getRestaurantID(),obj2.getRestaurantName(),obj2.getName(),obj2.getEmail_id(),obj2.getRestaurantAddress(),
					obj2.getRestaurantLocation(),obj2.getRestaurant_distance(),obj2.getContact_no(),"Bascis-"+obj2.tables.tableSeats.getBasictablecount(),
					"Basics-"+obj2.tables.tableSeats.getBasictableseatcount(),obj2.tables.getBasictableseatamount(),obj2.tables.getPremiumtableseatamount(),obj2.fooditems.getFoodName(),active_status);
		
				System.out.printf("%170s%23s\n","Premium-"+obj2.tables.tableSeats.getPremiumtablecount()
						,"Premium-"+obj2.tables.tableSeats.getPremiumtableseatcount());
			//
				
		//}
			
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------"
				+ "-----------------------------------------------------------------------------------------------------------------------------");
		
	}
	public static void addRestaurantDetails(Restaurant res_obj) {
		
		do {
			continue_var=false;
			
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"*** A D D   R E S T A U R A N T   D E T A I L S ***"+"\n");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Table Arrangement & Amount");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Food Items");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Back to Main"+"\n");
		
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
		String choice=read.next().trim();
		while(!isCheckChoice(choice))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
			choice=read.next().trim();
		}
		switch(Integer.parseInt(choice)) {
		case 1:
			do {
				System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"*** D E T A I L S ***"+"\n");
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Basic Dinning"+"\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"2.Premium Dinning"+"\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"3.Both Dinning"+"\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"4.Back"+"\n");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice :");
				String restaurantDinningChoice=read.next().trim();
				while(!isCheckChoice(restaurantDinningChoice))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
					restaurantDinningChoice=read.next().trim();
				}
				
			switch(Integer.parseInt(restaurantDinningChoice)) {
			case 1:
				res_obj.tables.tableSeats.setBasictablecount(0);
				res_obj.tables.tableSeats.setBasictableseatcount(0);
				res_obj.tables.tableSeats.basicseatobj.clear();
				res_obj.tables.tableSeats.premiumseatobj.clear();
				 cnpv.deleteBasicTableSeatRecord(res_obj); 
				 cnpv.deletePremiumTableSeatRecord(res_obj); 
				restaurantDinningSeats("BASICS",res_obj);
				
				
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Basic Seat Amount : ");
				
				
				String amt_ps=read.next().trim();
				
				while(!isCheckAmount(amt_ps))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Seat Amount !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Amount : ");
					amt_ps=read.next().trim();
				}
				int amount1=Integer.parseInt(amt_ps);
				
				
				 
				res_obj.tables.setBasictableseatamountCnpv(amount1,cnpv,res_obj);
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("!!!               B A S I C  S E A T  A R R A N G E M E N T               !!!");
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				res_obj.tables.tableSeats.getBasicTableSeatArrangement();
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("!!!                            A M O U N T                                !!!");
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				
				System.out.println("Basic Seat Amount : "+res_obj.tables.getBasictableseatamount());
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Basic Seat Updated Successfully....");
				break;
			case 2:
				res_obj.tables.tableSeats.setPremiumtablecount(0);
				res_obj.tables.tableSeats.setPremiumtableseatcount(0);
				res_obj.tables.tableSeats.basicseatobj.clear();
				res_obj.tables.tableSeats.premiumseatobj.clear();
				 cnpv.deleteBasicTableSeatRecord(res_obj); 
				 cnpv.deletePremiumTableSeatRecord(res_obj); 
				restaurantDinningSeats("PREMIUM",res_obj);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Premium Seat Amount : ");
				
				String amt_ps1=read.next().trim();
				
				while(!isCheckAmount(amt_ps1))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Premium Seat Amount !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Amount : ");
					amt_ps1=read.next().trim();
				}
				int amount2=Integer.parseInt(amt_ps1);
				
				
				
				
				res_obj.tables.setPremiumtableseatamountCnpv(amount2,cnpv,res_obj);
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("!!!             P R E M I U M  S E A T  A R R A N G E M E N T             !!!");
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				
			  res_obj.tables.tableSeats.getPremiumTableSeatArrangement();
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("!!!                            A M O U N T                                !!!");
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				
				System.out.println("Premium Seat Amount : "+res_obj.tables.getPremiumtableseatamount());
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Premium Seat Updated Successfully....");
				
				break;
			case 3:
				 cnpv.deleteBasicTableSeatRecord(res_obj); 
				 cnpv.deletePremiumTableSeatRecord(res_obj);
				 res_obj.tables.tableSeats.basicseatobj.clear();
				 res_obj.tables.tableSeats.premiumseatobj.clear();
				res_obj.tables.tableSeats.setBasictablecount(0);
				res_obj.tables.tableSeats.setBasictableseatcount(0);
				res_obj.tables.tableSeats.setPremiumtablecount(0);
				res_obj.tables.tableSeats.setPremiumtableseatcount(0);
				restaurantDinningSeats("BOTH",res_obj);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Basic Seat Amount : ");
				
				String amt_ps2=read.next().trim();
				
				while(!isCheckAmount(amt_ps2))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Seat Amount !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Amount : ");
					amt_ps2=read.next().trim();
				}
				int amount3=Integer.parseInt(amt_ps2);
				
				
				res_obj.tables.setBasictableseatamountCnpv(amount3,cnpv,res_obj);
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Premium Seat Amount : ");
				
				String amt_ps3=read.next().trim();
				
				while(!isCheckAmount(amt_ps3))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Premium Seat Amount !!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Amount : ");
					amt_ps3=read.next().trim();
				}
				int amount4=Integer.parseInt(amt_ps3);
				res_obj.tables.setPremiumtableseatamountCnpv(amount4,cnpv,res_obj);
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("!!!                   B A S I C   S E A T  A R R A N G E M E N T             !!!");
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				
				res_obj.tables.tableSeats.getBasicTableSeatArrangement();
				System.out.println("!!!------------------------* * * * *--------------------------------!!!");
				
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("!!!             P R E M I U M  S E A T  A R R A N G E M E N T             !!!");
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				
				res_obj.tables.tableSeats.getPremiumTableSeatArrangement();
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("!!!                            A M O U N T                                !!!");
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				
				System.out.println("Basic Seat Amount : "+res_obj.tables.getBasictableseatamount());
				System.out.println("Premium Seat Amount : "+res_obj.tables.getPremiumtableseatamount());
				System.out.println("!!!-----------------------------------------------------------------------!!!");
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Basic And Premium Seat Updated Successfully....");
				
				break;
			case 4:
				
				break;
			default:
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
				continue_var=continueMethod();
				break;
			}
			
			}while(continue_var);
			continue_var=true;
			break;
		case 2:
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Note : Enter Food Items Without Space Use "+",");
			
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Your Food Menu:"+"\n");
			
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 1 : ");
			read.nextLine();
			String item_1=read.nextLine().trim();
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 2 : ");
	
			String item_2=read.nextLine().trim();
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 3 : ");
		
			String item_3=read.nextLine().trim();
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 4 : ");
		
			String item_4=read.nextLine().trim();
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Item 5 : ");
	
			String item_5=read.nextLine().trim();
			String res_menu= item_1.concat(","+item_2).concat(","+item_3).concat(","+item_4).concat(","+item_5);
			FoodItems foodobj=new FoodItems();
			foodobj.setFoodName(res_menu);
			res_obj.setFooditems(foodobj);
			cnpv.updateFoodMent(res_obj.getRestaurantID(), res_menu);
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Food Items Updated Successfully");
			
			continue_var=true;
			break;
		case 3:
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Exited...");
			break;
		default:
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
			continue_var=continueMethod();
			break;
		}

		}while(continue_var);
		
		
	}
	
	public static void restaurantDinningSeats(String dinning_type,Restaurant restaurant_obj) {
		switch(dinning_type) {
		case "BASICS":
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"*** B A S I C   S E A T ***"+"\n");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Table Count : ");
			
			String basic_count=read.next().trim();
			while(!isCheckChoice(basic_count))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Table Count !!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Basic Table Count : ");
				basic_count=read.next().trim();
			}
			
			int table_count=Integer.parseInt(basic_count);
		
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Each Table Seat Count : ");
			
			String basic_seat_count=read.next().trim();
			while(!isCheckChoice(basic_seat_count))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Table Seat Count !!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Basic Table Seat Count : ");
				basic_seat_count=read.next().trim();
			}
			
			int table_seat_count=Integer.parseInt(basic_seat_count);
			
			
		
			
			restaurant_obj.tables.tableSeats.setBasictablecount(table_count);
			restaurant_obj.tables.tableSeats.setBasictableseatcount(table_seat_count);
			restaurant_obj.tables.tableSeats.setBasicTableSeatID("B",restaurant_obj,cnpv);
			restaurant_obj.tables.setTableType(dinning_type);
			cnpv.updatePremiumTableSeatInRes(0,0,restaurant_obj);
			cnpv.updatePremiumTableAmount(0,restaurant_obj);
			restaurant_obj.tables.tableSeats.premiumseatobj.clear();
			restaurant_obj.tables.setPremiumtableseatamount(0);
			restaurant_obj.tables.tableSeats.setPremiumtablecount(0);
			restaurant_obj.tables.tableSeats.setPremiumtableseatcount(0);
			break;
		case "PREMIUM":
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"*** P R E M I U M   S E A T ***"+"\n");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Table Count : ");
			
			String premium_count=read.next().trim();
			while(!isCheckChoice(premium_count))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Premium Table Count !!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Premium Table Count : ");
				premium_count=read.next().trim();
			}
			
			int table_count1=Integer.parseInt(premium_count);
			
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Each Table Seat Count : ");
			
			String premium_seat_count=read.next().trim();
			while(!isCheckChoice(premium_seat_count))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid New Premium Table Count !!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter New Premium Table Count : ");
				premium_seat_count=read.next().trim();
			}
			
			int table_seat_count1=Integer.parseInt(premium_seat_count);
		
			
		
			restaurant_obj.tables.tableSeats.setPremiumtablecount(table_count1);
			restaurant_obj.tables.tableSeats.setPremiumtableseatcount(table_seat_count1);
			restaurant_obj.tables.tableSeats.setPremiumTableSeatID("P",restaurant_obj,cnpv);
			restaurant_obj.tables.setTableType(dinning_type);
			cnpv.updateBasicTableSeatInRes(0,0,restaurant_obj);
			cnpv.updateBasicTableAmount(0,restaurant_obj);
			restaurant_obj.tables.tableSeats.basicseatobj.clear();
			restaurant_obj.tables.setBasictableseatamount(0);
			restaurant_obj.tables.tableSeats.setBasictablecount(0);
			restaurant_obj.tables.tableSeats.setBasictableseatcount(0);
		
			break;
		case "BOTH":
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"*** B A S I C   S E A T ***"+"\n");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Table Count : ");
			
			String basic_count1=read.next().trim();
			while(!isCheckChoice(basic_count1))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Table Count !!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Basic Table Count : ");
				basic_count1=read.next().trim();
			}
			
			int table_count2=Integer.parseInt(basic_count1);
		
			
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Each Table Seat Count : ");
			
			
			
			String basic_seat_count1=read.next().trim();
			while(!isCheckChoice(basic_seat_count1))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Basic Table Seat Count !!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Basic Table Seat Count : ");
				basic_seat_count1=read.next().trim();
			}
			
			int table_seat_count2=Integer.parseInt(basic_seat_count1);
		
			restaurant_obj.tables.tableSeats.setBasictablecount(table_count2);
			restaurant_obj.tables.tableSeats.setBasictableseatcount(table_seat_count2);
			restaurant_obj.tables.tableSeats.setBasicTableSeatID("B",restaurant_obj,cnpv);
			restaurant_obj.tables.setTableType(dinning_type);
			
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"*** P R E M I U M   S E A T ***"+"\n");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Table Count : ");
			
			
			String premium_count1=read.next().trim();
			while(!isCheckChoice(premium_count1))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Premium Table Count !!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Premium Table Count : ");
				premium_count1=read.next().trim();
			}
			
			int table_count3=Integer.parseInt(premium_count1);
			
			
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Each Table Seat Count : ");
			
			
			String premium_seat_count1=read.next().trim();
			while(!isCheckChoice(premium_seat_count1))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Premium Table Count !!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Premium Table Count : ");
				premium_seat_count1=read.next().trim();
			}
			
			int table_seat_count3=Integer.parseInt(premium_seat_count1);
		
		
			restaurant_obj.tables.tableSeats.setPremiumtablecount(table_count3);
			restaurant_obj.tables.tableSeats.setPremiumtableseatcount(table_seat_count3);
			restaurant_obj.tables.tableSeats.setPremiumTableSeatID("P",restaurant_obj,cnpv);
			restaurant_obj.tables.setTableType(dinning_type);
			
			break;
		}
		
	}
	public static void addRestaurant(String usertype) {
		
		
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+".... A D D   R E S T A U R A N T   D E T A I L S ...."+"\n");
		
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Note: Only Restaurant Name Dont Mention Restaurant");
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Name : ");
	
		read.nextLine();
		String restaurant_name=read.nextLine().trim();
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Note: Door No,Street,District,Pincode Separated By , ");
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Address : ");
		
		String restaurant_address=read.nextLine().trim();
				
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Note: For Map Only mention Area");
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Location : ");
		String restaurant_location=read.next().trim();	
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Restaurant Distance From "+restaurant_location+" Main Bus Stand In km : ");
		
		String dist=read.next().trim();
		while(!isCheckDistance(dist))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Distance Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Restaurant Distance : ");
			dist=read.next().trim();
		}
		float distance=Float.parseFloat(dist);
		
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"***Manager Details***");
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Manager Name : ");
		read.nextLine();
		String resownername=read.nextLine();
		while(!isCheckName(resownername))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Manager Name Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Manager Name : ");
			resownername=read.next();
		}
		
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Manager Email ID : ");
		String resowneremailid=read.next().trim();
		while(!isCheckEmail(resowneremailid))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Email ID Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Manager Email ID : ");
			resowneremailid=read.next();
		}
		int flag4=1;
		for(Restaurant obj1:res_main_obj.restaurant_obj_list) {
			
			  if(obj1.getEmail_id().equalsIgnoreCase(resowneremailid)) {
				  flag4=0;
			  }
		
		}
		
		if(flag4==1) {
		
		int flag;
		String restaurant_password;
		String restaurant_confirm_password;
		do {
		flag=0;
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Password : ");
		restaurant_password=read.next().trim();
		while(!isCheckPassword(restaurant_password))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Password Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter Password : ");
			restaurant_password=read.next().trim();
		}
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Confirm Password : ");
		restaurant_confirm_password=read.next().trim();
		while(!isCheckPassword(restaurant_confirm_password))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Confirm Password Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Confirm Password : ");
			restaurant_confirm_password=read.next().trim();
		}
		if(restaurant_confirm_password.equals(restaurant_password)) {
		flag=0;
		}
		else {
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Password Error !!! ");
			flag=1;
		}
		}while(flag==1);
		
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Contact No: ");
		String restaurant_contact_no=read.next().trim();
		
		while(!isCheckPhoneNo(restaurant_contact_no))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Contact No Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Contact No : ");
			restaurant_contact_no=read.next().trim();
		}
			TableSeats tableseatobj=new TableSeats();
			tableseatobj.setBasictablecount(0);
			tableseatobj.setBasictableseatcount(0);
			tableseatobj.setPremiumtablecount(0);
			tableseatobj.setPremiumtableseatcount(0);
			Tables tableobj=new Tables();
			tableobj.setBasictableseatamount(0);
			tableobj.setPremiumtableseatamount(0);
			tableobj.setTableSeats(tableseatobj);
			FoodItems foodobj=new FoodItems();
			foodobj.setFoodName("***");
			res_main_obj=new Restaurant();
			res_main_obj.setTables(tableobj);
			res_main_obj.setFooditems(foodobj);
			
					try {
						res_main_obj.accountRestaurantSignUp(cnpv,1,usertype,restaurant_name,resownername,resowneremailid,restaurant_address,restaurant_confirm_password, restaurant_location, restaurant_contact_no,distance);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			res_main_obj.restaurant_obj_list.add(res_main_obj);
		}else
		{
			System.out.println("Account Already exist...");
		}
			
	}
	
	public static void signUp(String usertype) {
		do {
			continue_var=false;
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"....S I G N U P   P A G E ...."+"\n");
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Your Name : ");
		read.nextLine();
		String user_name=read.nextLine();
		while(!isCheckName(user_name))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid User Name Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter Your Name : ");
			user_name=read.next().trim();
		}
		
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Your Email ID :");
		String user_emailid=read.next().trim();
		while(!isCheckEmail(user_emailid))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Email ID Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter Your Email ID : ");
			user_emailid=read.next().trim();
		}
		
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Password : ");
		String user_password=read.next().trim();
		while(!isCheckPassword(user_password))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Password Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter Password : ");
			user_password=read.next().trim();
		}
		
		int flag=1;
		for(Customer obj1:cus_main_obj.customer_obj_list) {
			
			  if(obj1.getName().equalsIgnoreCase(user_name)&&obj1.getEmail_id().equalsIgnoreCase(user_emailid)) {
				  flag=0;
			  }
		
		}
		
		if(usertype=="CUSTOMER" && flag==1) {
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Your Contact No :");
			String user_phoneno=read.next().trim();
			while(!isCheckPhoneNo(user_phoneno))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Contact No Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Contact No : ");
				user_phoneno=read.next().trim();
			}
			
			
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Gender :");
			String user_Gender=read.next().trim();
			
			while(isCheckGender(user_Gender))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Gender Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Gender : ");
			     user_Gender=read.next().trim();
			}
			
			
			
			
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Your Age :");
			String userage=read.next().trim();
			while(!isCheckage(userage))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Age Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter Age : ");
				userage=read.next().trim();
			}			
			int user_age=Integer.parseInt(userage);
			
			
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Your Address : ");
			read.nextLine();
			String user_address=read.nextLine().trim();
		Customer customer_obj=new Customer();
		customer_obj.setCustomerId();
	    customer_obj.accountSignUp(cnpv,1,user_name, user_password, user_emailid, user_phoneno, user_Gender, user_age,user_address, usertype);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Welcome "+user_name+" You Are Sussessfully SignUp...");
		cus_main_obj.customer_obj_list.add(customer_obj);
		viewCustomerUpdatedRecord();
		}
		else {
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Account Already Exist...");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"SignUp Again...");
			continue_var=true;
			
		}
		}while(continue_var);
	} 
	
	
	public static void  customerDashBoard(Customer cus_obj) {
		do {
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+".... C U S T O M E R   D A S B O A R D ...."+"\n");
		 Notification notify_obj=new Notification();
		// notify_obj.cusOrderTickets(cus_obj.getCustomerId());
		 boolean continue_var2;
		
			continue_var=false;
			
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Search Restaurant");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.View Booking");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.History");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.Update Profile");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"5.Cancel Booking");
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"6.Sign Out"+"\n");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
			String choice=read.next().trim();
			while(!isCheckChoice(choice))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
				choice=read.next().trim();
			}
			switch(Integer.parseInt(choice)) {
			case 1:
				searchRestaurant(cus_obj);
				continue_var=true;
				break;
			case 2:
				notify_obj.cusOrderTickets(cus_obj.getCustomerId());
				continue_var=true;
				break;
			case 3:
				notify_obj.all_CusOrderTickets(cus_obj.getCustomerId());
				continue_var=true;
				break;
			case 4:
				update_customer_profile(cus_obj);
				continue_var=true;
				break;
			case 5:
				if(cus_obj.getCus_order_count()!=0) {
				notify_obj.cusOrderTickets(cus_obj.getCustomerId());
				
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Do You Want To Cancel any Booking Order ??? 1.Yes 2.No");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
				String choice1=read.next().trim();
				while(!isCheckChoice(choice1))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
					choice1=read.next().trim();
				}
				
				switch(Integer.parseInt(choice1)) {
				case 1:
						System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Order ID : ");
						String cancel_or_id=read.next().trim();
						boolean continue_var3;
						do {
						continue_var3=false;
						System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Confirm to Cancel ??? 1.Yes 2.No ");
						System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
						String choice2=read.next().trim();
						while(!isCheckChoice(choice2))
						{
							System.out.println("Invalid Input!!! Pls Enter Again...");
							System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
							choice2=read.next().trim();
						}
						if(Integer.parseInt(choice2)==1) {
							Booking booking_obj=new Booking();
							//cus_obj.setCus_order_count(cus_obj.getCus_order_count()-);
							booking_obj.cancelBooking(cus_obj, cancel_or_id);
							continue_var=true;
						}
						else {
							System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
							continue_var3=true;
							}
						}while(continue_var3);
					break;
				case 2:
					continue_var=true;
					break;
				default:
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
					continue_var=continueMethod();
					break;
				}
				}else {
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"No Booking Order....");
					continue_var=true;
				}
				break;
			case 6:
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Exited...");
				break;
			default:
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Enry...");
				continue_var=continueMethod();
				break;
			}
			
		}while(continue_var);
		
		
	}
	
	public static void update_customer_profile(Customer cus_obj) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
				String sql2="UPDATE RESTAURANT SET FOODITEMS=? WHERE USERID=?";
			
			
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"*** O L D   P R O F I L E ***"+"\n");
		viewSingleCustomerUpdatedRecord(cus_obj);
		
		do {
			continue_var=false;
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"*** E D I T   P R O F I L E ***"+"\n");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Name");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Contact No ");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Address");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.Reset Password");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"5.Back");
		System.out.print("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
		String choice=read.next().trim();
		while(!isCheckChoice(choice))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
			choice=read.next().trim();
		}
		switch(Integer.parseInt(choice)) {
		case 1:
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Name :");
			read.nextLine();
			String name1=read.nextLine();
			cus_obj.setName(name1);
			cus_obj.account_obj3.setUserName(name1);
			
			String sql1="UPDATE RESCUSTOMER SET CUSNAME=? WHERE USERID=?";
			PreparedStatement pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1,name1);
			pstmt1.setString(2,cus_obj.getCustomerId());
			pstmt1.executeUpdate();
			
			
			String sql3="UPDATE ACCOUNT SET USERNAME=? WHERE USERID=?";
			PreparedStatement pstmt2=con.prepareStatement(sql3);
			pstmt2.setString(1,name1);
			pstmt2.setString(2,cus_obj.getCustomerId());
			pstmt2.executeUpdate();
			
			
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Name Updated Successfully...");
			continue_var=true;
			break;
		
		case 2:
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Contact No :");
			String cus_contact_no=read.next().trim();
			while(!isCheckPhoneNo(cus_contact_no))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Contact No Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter New Contact No : ");
				cus_contact_no=read.next().trim();
			}			
			cus_obj.setContact_no(cus_contact_no);
			
			String sql4="UPDATE RESCUSTOMER SET CUSCONTACTNO=? WHERE USERID=?";
			PreparedStatement pstmt4=con.prepareStatement(sql4);
			pstmt4.setString(1,cus_contact_no);
			pstmt4.setString(2,cus_obj.getCustomerId());
			pstmt4.executeUpdate();
			
			
			
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Contact Number Successfully Updated...");
			continue_var=true;
			break;
		case 3:
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter New Address :");
			String cus_Address=read.next().trim();
			cus_obj.setAddress(cus_Address);
			String sql5="UPDATE RESCUSTOMER SET CUSADDRESS=? WHERE USERID=?";
			PreparedStatement pstmt5=con.prepareStatement(sql5);
			pstmt5.setString(1,cus_Address);
			pstmt5.setString(2,cus_obj.getCustomerId());
			pstmt5.executeUpdate();
			
			
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Address Successfully Updated...");
			continue_var=true;
			break;
		case 4:
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Enter Old Password : ");
			String oldpass=read.next().trim();
			while(!isCheckPassword(oldpass))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Old Password Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter Old Password : ");
				oldpass=read.next().trim();
			}
			if(oldpass.equalsIgnoreCase(cus_obj.account_obj3.getUserPassword())) {
				
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"New Password : ");
				String newpass=read.next().trim();
				while(!isCheckPassword(newpass))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter New Password : ");
					newpass=read.next().trim();
				}
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Confirm Password : ");
				String conpass=read.next().trim();
				while(!isCheckPassword(conpass))
				{
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
					System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re-Enter Confirm Password : ");
					conpass=read.next().trim();
				}
				if(newpass.equals(conpass)) {
					cus_obj.account_obj3.setUserPassword(conpass);
					
					
					String sql7="UPDATE ACCOUNT SET USERPASSWORD=? WHERE USERID=?";
					PreparedStatement pstmt7=con.prepareStatement(sql7);
					pstmt7.setString(1,conpass);
					pstmt7.setString(2,cus_obj.getCustomerId());
					pstmt7.executeUpdate();
					
					
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Password Updated Successfully...");
					continue_var=true;
				}
				else {
					System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Password Mismatch...");
				}
				
			}else {
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Password...");
			}
			
			
			break;
		case 5:
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Profile Successfully Updated...");
			con.close();
			break;
		default :
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
			continue_var=continueMethod();
			break;
		}
		}while(continue_var);
		
		
		}catch(ClassNotFoundException e) {
	       	 
        }
        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public static void searchRestaurant(Customer obj) {
		
		do {
			continue_var=false;
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+".... S E A R C H    R E S T A U R A N T ...."+"\n");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Search By Name");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Search By Location");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"3.Search By Distance");
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"4.Go To DashBoard"+"\n");
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
		search searchobj;
		String choice=read.next().trim();
		while(!isCheckChoice(choice))
		{
			System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
			System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Choice : ");
			choice=read.next().trim();
		}
		switch(Integer.parseInt(choice)) {
		case 1:
			searchobj=new SearchByName();
			System.out.print("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Enter Restaurant Name : ");
			searchobj.searchRestaurant(read.next().trim(),obj);
			
			break;
		case 2:
			searchobj=new SearchByLocation();
			System.out.print("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Enter Location : ");
			searchobj.searchRestaurant(read.next().trim(),obj);
			
			break;
		case 3:
			searchobj=new SearchByDistance();
			System.out.print("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Enter Distance : ");
			String dis=read.next().trim();
			
			while(!isCheckDistance(dis))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Distance Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Re Enter Distance : ");
				dis=read.next().trim();
			}
			
			searchobj.searchRestaurant(dis,obj);
			
			break;
		case 4:
			
			break;
		default:
			System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Wrong Entry...");
			continue_var=continueMethod();
			break;
		}
		}while(continue_var);
		
	}
	
	public static boolean isCheckGender(String gender) {
		
		if(gender.equalsIgnoreCase("male")|| gender.equalsIgnoreCase("female")||gender.equalsIgnoreCase("transgender")) {
			GENDER gn=GENDER.valueOf(gender.toUpperCase());
		 if( gn.equals(GENDER.MALE) || gn.equals(GENDER.FEMALE)||gn.equals(GENDER.TRANSGENDER)) {
			 return false;
		 }
		 else {
			 return true;
		 }
		}else {
			 return true;
		 }
		 
	   }
	
	public static boolean isCheckPhoneNo( String phoneno ) {
		 Pattern p = Pattern.compile("^\\d{10}$");
	        if (phoneno == null) {
	            return false;
	        }
	        Matcher m = p.matcher(phoneno);
	        return m.matches();
	   }
	
	public static boolean isCheckChoice(String choice) {
		 Pattern p = Pattern.compile("^\\d{1,4}$");
	        if (choice == null) {
	            return false;
	        }
	        Matcher m = p.matcher(choice);
	        return m.matches();
		
	}
	public static boolean isCheckAmount(String choice) {
		 Pattern p = Pattern.compile("^\\d{1,10}$");
	        if (choice == null) {
	            return false;
	        }
	        Matcher m = p.matcher(choice);
	        return m.matches();
		
	}
	public static boolean isCheckDistance(String choice) {
		 Pattern p = Pattern.compile("^\\d{1,3}$");
	        if (choice == null) {
	            return false;
	        }
	        Matcher m = p.matcher(choice);
	        return m.matches();
		
	}
	
	public static boolean isCheckage(String choice) {
		 Pattern p = Pattern.compile("^\\d{1,3}$");
	        if (choice == null) {
	            return false;
	        }
	        Matcher m = p.matcher(choice);
	        return m.matches();
		
	}
	
	public static boolean isCheckCardNo(String choice) {
		 Pattern p = Pattern.compile("^\\d{7,20}$");
	        if (choice == null) {
	            return false;
	        }
	        Matcher m = p.matcher(choice);
	        return m.matches();
		
	}
	public static boolean isCheckPin(String choice) {
		 Pattern p = Pattern.compile("^\\d{4,6}$");
	        if (choice == null) {
	            return false;
	        }
	        Matcher m = p.matcher(choice);
	        return m.matches();
		
	}
	
	public static boolean isCheckEmail( String email ) {
		 String regex ="^[a-zA-Z0-9_+&*-]+(?:\\."+
                 "[a-zA-Z0-9_+&*-]+)*@" +
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                 "A-Z]{2,7}$";
		  
	        Pattern p = Pattern.compile(regex);
	        if (email == null) {
	            return false;
	        }
	        Matcher m = p.matcher(email);
	        return m.matches();
	   }
	public static boolean isCheckName( String name ) {
		 String regex =( "[a-zA-Z ]*" );
		  
	        Pattern p = Pattern.compile(regex);
	        if (name == null) {
	            return false;
	        }
	        Matcher m = p.matcher(name);
	        return m.matches();
	   }
	public static boolean isCheckAddress( String add ) {
		 String regex =( "/^\\S*$/" );
		  
	        Pattern p = Pattern.compile(regex);
	        if (add == null) {
	            return false;
	        }
	        Matcher m = p.matcher(add);
	        return m.matches();
	   }
	public static boolean isCheckPassword( String password ) {
		 String regex ="^(?=.*[0-9])"
                 + "(?=.*[a-z])(?=.*[A-Z])"
                 + "(?=.*[@#$%^&+=])"
                 + "(?=\\S+$).{5,20}$";
		  
	        Pattern p = Pattern.compile(regex);
	        if (password == null) {
	            return false;
	        }
	        Matcher m = p.matcher(password);
	        return m.matches();
	   }
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		cnpv.connectionPart();
		
		//Booking.bookingobjlist.stream().forEach(x->System.out.println(x.getOrder_id()+" "+x.getOrder_status()+" "+x.getUser_choice_seats()+" key "+x.getUser_choice_seat_list_basic()+" "+x.getUser_choice_seat_list_premium()));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("*******************************************Welcome Page******************************************************");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		choice();
		read.close();
		System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"************Thank You********************");
	}


}
