package com.booking;

import java.util.Scanner;

import com.main.Main;
import com.persondetails.Customer;
import com.persondetails.Restaurant;

public class ShowRestaurant{
	
	public static boolean  go_to_Book;
		
	 public static boolean showRestaurantDetails(Restaurant obj) {
		 Scanner read=new Scanner(System.in);
		System.out.println("\n"+"-----------------------------------------------------*** "+obj.getRestaurantName()+" Restaurant "+"***-------------------------------------");
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Distance : "+obj.getRestaurant_distance() +" km");
		System.out.println("\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"FOOd MenU : "+obj.fooditems.getFoodName());
		
		 System.out.println();
		 System.out.println("......................................***........................................***................................."+"\n");
		 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"1.Book Seats");
		 System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"2.Back");
		 boolean continue_var;
		 String choice;
		 do {
			 continue_var=false;
		 System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
		 
		 
		 choice=read.nextLine();
			while(!Main.isCheckChoice(choice))
			{
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				System.out.print("\t"+"\t"+"\t"+"\t"+"\t"+"Choice : ");
				choice=read.nextLine();
			}
			if(Integer.parseInt(choice)>3) {
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"Invalid Input!!! Pls Enter Again...");
				continue_var=true;
			}
			
		 }while(continue_var);
		 
		 switch(Integer.parseInt(choice)) {
		 case 1:
			
			 if(obj.tables.tableSeats.getBasictableseatcount()!=0 && obj.tables.tableSeats.getPremiumtableseatcount()!=0 ) {
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
				System.out.println("!!!-----------------------------------------------------------------------!!!");	}
			 else if(obj.tables.tableSeats.getBasictableseatcount()!=0 && obj.tables.tableSeats.getPremiumtableseatcount()==0) {
				 
				 System.out.println("!!!-----------------------------------------------------------------------!!!");
					System.out.println("!!!                   B A S I C   S E A T  A R R A N G E M E N T             !!!");
					System.out.println("!!!-----------------------------------------------------------------------!!!");
					
					obj.tables.tableSeats.getBasicTableSeatArrangement();
					System.out.println("!!!------------------------* * * * *--------------------------------!!!");
					System.out.println("!!!                            A M O U N T                                !!!");
					System.out.println("!!!-----------------------------------------------------------------------!!!");
					
					System.out.println("Basic Seat Amount : "+obj.tables.getBasictableseatamount());
					System.out.println("!!!-----------------------------------------------------------------------!!!");	}
				 
				 
				 
			 else {
					System.out.println("!!!-----------------------------------------------------------------------!!!");
					System.out.println("!!!             P R E M I U M  S E A T  A R R A N G E M E N T             !!!");
					System.out.println("!!!-----------------------------------------------------------------------!!!");
					
					obj.tables.tableSeats.getPremiumTableSeatArrangement();
					System.out.println("!!!-----------------------------------------------------------------------!!!");
					System.out.println("!!!                            A M O U N T                                !!!");
					System.out.println("!!!-----------------------------------------------------------------------!!!");
					
					System.out.println("Premium Seat Amount : "+obj.tables.getPremiumtableseatamount());
					System.out.println("!!!-----------------------------------------------------------------------!!!");	}
			
			 
				
				go_to_Book=true;
			 break;
		 case 2:
			 go_to_Book=false;
			 break;
		 	}
		return  go_to_Book;
		 
	}
}
