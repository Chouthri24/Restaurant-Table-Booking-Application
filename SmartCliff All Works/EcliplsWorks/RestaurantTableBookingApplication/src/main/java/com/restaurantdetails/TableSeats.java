package com.restaurantdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.booking.Booking;
import com.main.ConnectionProvider;
import com.persondetails.Restaurant;

public class TableSeats {
	private int basictablecount;
	private int basictableseatcount;
	private int premiumtablecount;
	private int premiumtableseatcount;
	
	public  HashMap<Integer,String> basicseatobj=new HashMap<Integer,String>();
	public  HashMap<Integer,String> premiumseatobj=new HashMap<Integer,String>();
	
	 Booking objbooking=new Booking();
	
	public int getBasictablecount() {
		return basictablecount;
	}
	public void setBasictablecount(int basictablecount) {
		this.basictablecount = basictablecount;
	}
	public int getBasictableseatcount() {
		return basictableseatcount;
	}
	public void setBasictableseatcount(int basictableseatcount) {
		this.basictableseatcount = basictableseatcount;
	}
	public int getPremiumtablecount() {
		return premiumtablecount;
	}
	public void setPremiumtablecount(int premiumtablecount) {
		this.premiumtablecount = premiumtablecount;
	}
	public int getPremiumtableseatcount() {
		return premiumtableseatcount;
	}
	public void setPremiumtableseatcount(int premiumtableseatcount) {
		this.premiumtableseatcount = premiumtableseatcount;
	}
	
	public HashMap<Integer, String> getBasicseatobj() {
		return basicseatobj;
	}
	public HashMap<Integer, String> getPremiumseatobj() {
		return premiumseatobj;
	}
	public void setBasicseatobj(HashMap<Integer, String> basicseatobj) {
		this.basicseatobj = basicseatobj;
	}
	public void setPremiumseatobj(HashMap<Integer, String> premiumseatobj) {
		this.premiumseatobj = premiumseatobj;
	}
	public void getBasicTableSeatArrangement() {
		
		int c=basictableseatcount;
		int r=basictablecount*3;
		System.out.println("10AM to 12PM"+"\n");
		for(Map.Entry hashobj: basicseatobj.entrySet())
		{			
			       
					System.out.print(hashobj.getValue()+"   ");
					c--;
					if(c==0 && r!=0) {
						r--;
						if(r==basictablecount*2)
						{
							System.out.println("\n"+"\n");
							System.out.println("1 PM to 3 PM");
						}
						if(r==basictablecount) {
							System.out.println("\n"+"\n");
							System.out.println("7 PM to 10 PM");
						}
						
						System.out.println();
						c=basictableseatcount;
					}
					
		}
		System.out.println();
	}
	
	public void setBasicTableSeatID(String DinningObj,Restaurant res_obj,ConnectionProvider cnpv) {
		 
		cnpv.updateBasicTableSeatInRes(basictablecount,basictableseatcount,res_obj);
			
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
				
		for(int i=1;i<=basictablecount*basictableseatcount*3;i++) {
				if(i<10) {
					
					cnpv.basicTableSeatInsertArrangement(res_obj, i,DinningObj+"00"+i,con);
					basicseatobj.put(i, DinningObj+"00"+i);
				}
				else if(i>9 &&i<100) {
					cnpv.basicTableSeatInsertArrangement(res_obj, i,DinningObj+"0"+i,con);
					basicseatobj.put(i, DinningObj+"0"+i);
				}
				else {
					cnpv.basicTableSeatInsertArrangement(res_obj, i,DinningObj+i,con);
					basicseatobj.put(i, DinningObj+i);
			      }
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
			public void getPremiumTableSeatArrangement() {
				
				int c=premiumtableseatcount;
				int r=premiumtablecount*3;
				System.out.println("10AM to 12PM"+"\n");
				for(Map.Entry hashobj:premiumseatobj.entrySet())
				{			
					System.out.print(hashobj.getValue()+"   ");
					c--;
					if(c==0 && r!=0) {
						r--;
						if(r==premiumtablecount*2)
						{
							System.out.println("\n"+"\n");
							System.out.println("1 PM to 3 PM");
						}
						if(r==premiumtablecount) {
							System.out.println("\n"+"\n");
							System.out.println("7 PM to 10 PM");
						}
						
						System.out.println();
						c=premiumtableseatcount;
					}
					if(r==0)
					{
						break;
					}
							
				}
				System.out.println();
			}
			
			public void setPremiumTableSeatID(String DinningObj,Restaurant res_obj,ConnectionProvider cnpv) {
				 
				 cnpv.updatePremiumTableSeatInRes(premiumtablecount,premiumtableseatcount,res_obj);
				 try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
							for(int i=1;i<=premiumtablecount*premiumtableseatcount*3;i++) {
								if(i<10) {
									cnpv.premiumTableSeatInsertArrangement(res_obj, i,DinningObj+"00"+i,con);
									premiumseatobj.put(i, DinningObj+"00"+i);
								}
								else if(i>9 &&i<100) {
									cnpv.premiumTableSeatInsertArrangement(res_obj, i,DinningObj+"0"+i,con);
									premiumseatobj.put(i, DinningObj+"0"+i);
								}
								else {
									cnpv.premiumTableSeatInsertArrangement(res_obj, i,DinningObj+i,con);
									premiumseatobj.put(i, DinningObj+i);
							 }
							
					 
					 }
						}catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
		//int p=1;
		/*for(int i=0;i<tableCount;i++) {
			for(int j=0;j<tableSeatCount;j++) {
				if(p<10) {
					arrSeat[i][j]=DinningObj+"00"+p;
				}
				else if(p>9 &&p<100) {
					arrSeat[i][j]=DinningObj+"0"+p;
				}
				else {
				arrSeat[i][j]=DinningObj+p;
				}
				p++;
			}*/
					
					
					
					
					
		}
		

	
