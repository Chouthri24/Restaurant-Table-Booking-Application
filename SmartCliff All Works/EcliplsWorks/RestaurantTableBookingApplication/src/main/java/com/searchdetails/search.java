package com.searchdetails;

import java.util.Scanner;

import com.persondetails.Customer;

public interface search {
	
	abstract void searchRestaurant(String element,Customer cusobj);
	Scanner read=new Scanner(System.in);
	
}
