package com.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import com.booking.Booking;
import com.payment.Card;
import com.payment.Payment;
import com.payment.UPI;
import com.persondetails.Account;
import com.persondetails.Admin;
import com.persondetails.Customer;
import com.persondetails.Person;
import com.persondetails.Restaurant;
import com.restaurantdetails.FoodItems;
import com.restaurantdetails.TableSeats;
import com.restaurantdetails.Tables;

public class ConnectionProvider  {
	

	public static void connectionPart() throws ClassNotFoundException, SQLException {
		
	String driverClass="oracle.jdbc.driver.OracleDriver";
	Class.forName(driverClass);
	String url="jdbc:oracle:thin:@LocalHost:1521:xe";
	String name="Chouthri";
	String pass="welcome123";
	Connection con=DriverManager.getConnection(url,name,pass);
	if(con!=null) {
		//System.out.println("Connection Success");
		adminGetObjOperation(con);
		adminAccountGetObjOperation(con);
		restaurantAccountGetObjOperation(con);
		customerAccountGetObjOperation(con);
		bookingGetObjOperation(con);
		paymentGetObjOperation(con);
	}
	else {
		//System.out.println("Connection Fail");
		
	}
	}
	
public  static ArrayList<Restaurant> restaurantAccountGetObjOperationjsp() throws SQLException {
		
		//System.out.println("RES ACC Started...");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CHOUTHRI","welcome123");
		ArrayList<Restaurant> list=new ArrayList<Restaurant>();
		Statement stmt = con.createStatement();
		String selectquery="SELECT * FROM restaurant ORDER BY UserID";
		ResultSet rs =  stmt.executeQuery(selectquery);
		
		Restaurant res_obj = null;
		while(rs.next()){
		
			res_obj=new Restaurant();
			TableSeats tableseats=new TableSeats();
			Tables tables=new Tables();
			FoodItems fooditems=new FoodItems();
				res_obj.setRestaurantID2(rs.getString(2));
				res_obj.setRestaurantName(rs.getString(3));
				res_obj.setRestaurantAddress(rs.getString(4));
				res_obj.setRestaurantLocation(rs.getString(5));
				res_obj.setRestaurant_distance(rs.getFloat(6));
				res_obj.setName(rs.getString(7));
				res_obj.setEmail_id(rs.getString(8));
				res_obj.setContact_no(rs.getString(9));
				tableseats.setBasictablecount(rs.getInt(10));
				tableseats.setBasictableseatcount(rs.getInt(11));
				tableseats.setPremiumtablecount(rs.getInt(12));
				tableseats.setPremiumtableseatcount(rs.getInt(13));
				
				res_obj.setRestaurant_isActive(rs.getInt(14));
				
				String selectquery1="SELECT * FROM BasicTableSeatArrangement";
				Statement stmt1 = con.createStatement();
				ResultSet rs1 =  stmt1.executeQuery(selectquery1);
				while(rs1.next()){
					
					if(rs.getString(2).equalsIgnoreCase(rs1.getString(1))) {
						tableseats.basicseatobj.put(rs1.getInt(2), rs1.getString(3));
					}
				}
				String selectquery2="SELECT * FROM PremiumTableSeatArrangement";
				Statement stmt2 = con.createStatement();
				ResultSet rs2 =  stmt2.executeQuery(selectquery2);
				while(rs2.next()){
					if(rs.getString(2).equalsIgnoreCase(rs2.getString(1))) {
						tableseats.premiumseatobj.put(rs2.getInt(2), rs2.getString(3));
					}
				}
				tables.setTableSeats(tableseats);
				tables.setBasictableseatamount(rs.getInt(14));
				tables.setPremiumtableseatamount(rs.getInt(15));
				res_obj.setTables(tables);
				fooditems.setFoodName(rs.getString(16));
				res_obj.setRestaurant_isActive(rs.getInt(17));
				res_obj.setFooditems(fooditems);
				list.add(res_obj);
			} 
		
		
		stmt.close();
		rs.close();
		return list;
	}
	
	
public static ArrayList<Customer> customerAccountGetObjOperationjsp() throws SQLException {
	
	//System.out.println("Customer ACC Started...");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CHOUTHRI","welcome123");
	ArrayList<Customer> list2=new ArrayList<Customer>();
	Statement stmt = con.createStatement();
	String selectquery="SELECT * FROM RESCUSTOMER ORDER BY USERID";
	ResultSet rs =  stmt.executeQuery(selectquery);
	
	Customer cus_obj = null;
	while(rs.next()){
				cus_obj=new Customer();
			cus_obj.setCustomerId2(rs.getString(2));
			cus_obj.setName(rs.getString(3));
			cus_obj.setEmail_id(rs.getString(4));
			cus_obj.setContact_no(rs.getString(5));
			cus_obj.setGender(rs.getString(6));
			cus_obj.setAge(rs.getInt(7));
			cus_obj.setAddress(rs.getString(8));
			cus_obj.setCus_order_count(rs.getInt(9));
			cus_obj.setIsActive(rs.getInt(10));
			list2.add(cus_obj);	
			
		} 
	
	//System.out.println("CUS ID Count : "+cus_obj.n);
	
	stmt.close();
	rs.close();
	return (ArrayList<Customer>) list2;
}

	
	
	
	
	public static void setNewPassword(String conpass ,String email,String usertype) throws ClassNotFoundException, SQLException {
		String driverClass="oracle.jdbc.driver.OracleDriver";
		Class.forName(driverClass);
		String url="jdbc:oracle:thin:@LocalHost:1521:xe";
		String name="Chouthri";
		String pass="welcome123";
		Connection con=DriverManager.getConnection(url,name,pass);
		
		String sql7="UPDATE ACCOUNT SET USERPASSWORD=? WHERE USEREMAILID=? AND USERTYPE=?";
		PreparedStatement pstmt7=con.prepareStatement(sql7);
		pstmt7.setString(1,conpass);
		pstmt7.setString(2,email);
		pstmt7.setString(3,usertype);
		
		int n=pstmt7.executeUpdate();
		if(n>0) {
			System.out.println("Successfully New pass");
		}
	}
	
	public static String forgetPasswordReturn(String emailid,String usertype) throws SQLException, ClassNotFoundException {
		String driverClass="oracle.jdbc.driver.OracleDriver";
		Class.forName(driverClass);
		String url="jdbc:oracle:thin:@LocalHost:1521:xe";
		String name="Chouthri";
		String pass="welcome123";
		Connection con=DriverManager.getConnection(url,name,pass);
		String str = null;
		
			PreparedStatement st=con.prepareStatement("SELECT USERPASSWORD FROM ACCOUNT WHERE USERTYPE=? AND USEREMAILID=?");
			st.setString(1,usertype);
			st.setString(2,emailid);
			//System.out.println(usertype+" "+emailid);
			ResultSet rs=st.executeQuery();
			//System.out.println("here-1");
			while(rs.next()) {
				//System.out.println("here-2");
				str=rs.getString(1);
				//System.out.println("DB-"+rs.getString(1));
			}
			
		return str;
	}
	
	
	public static void paymentGetObjOperation(Connection con) throws SQLException {
		
		
		Statement stmt = con.createStatement();
		String selectquery="SELECT * FROM CUSPAYMENT ORDER BY ORDERID";
		ResultSet rs =  stmt.executeQuery(selectquery);
		while(rs.next()){
			     Payment pay_obj=new Payment();
			     
			     pay_obj.setOrder_id(rs.getString(1));
			     pay_obj.setCustomer_id(rs.getString(2));
			     pay_obj.setPayment_type(rs.getString(3));
			     pay_obj.setAmount(rs.getInt(4));
			     Card card_obj=new Card();
			     UPI upi_obj=new UPI();
			     card_obj.setCard_number(rs.getString(5));
			     card_obj.setCard_holder_name(rs.getString(6));
			     upi_obj.setUpi_id(rs.getString(7));
			     pay_obj.setCard_obj_main(card_obj);
			     pay_obj.setUi_obj_main(upi_obj);   
			     pay_obj.setPayment_status(rs.getString(8));
			     pay_obj.setOrder_status_obj(rs.getInt(9));
			     pay_obj.setRes_id(rs.getString(10));
			     pay_obj.paymentobjlist.add(pay_obj);
				}
		
		//System.out.println("Payment Obj store finished..");
		con.close();
		stmt.close();
		rs.close();
	}
	
	
	public static void adminAccountGetObjOperation(Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String selectquery="SELECT * FROM account";
		ResultSet rs =  stmt.executeQuery(selectquery);
		
		int acc_count=0;
		while(rs.next()){
				acc_count+=1;
				Account acc_obj=new Account();
				acc_obj.setUserID(rs.getString(1));
				acc_obj.setUserType(rs.getString(2));
				acc_obj.setUser_emailid(rs.getString(3));
				acc_obj.setUserPassword(rs.getString(4));
				acc_obj.setUserName(rs.getString(5));
				acc_obj.setIsActive(rs.getInt(6));
				acc_obj.account_obj_list.add(acc_obj);
				//acc_obj.account_obj_list.stream().forEach(x->System.out.println(x.getUserName()));
				}
		Person.useridcount=acc_count+1;
		
		stmt.close();
		rs.close();
	}
	public static void restaurantAccountGetObjOperation(Connection con) throws SQLException {
		
		//System.out.println("RES ACC Started...");
		Statement stmt = con.createStatement();
		String selectquery="SELECT * FROM restaurant ORDER BY UserID";
		ResultSet rs =  stmt.executeQuery(selectquery);
		int res_count=0;
		Restaurant res_obj = null;
		while(rs.next()){
			res_count+=1;
			res_obj=new Restaurant();
			TableSeats tableseats=new TableSeats();
			Tables tables=new Tables();
			FoodItems fooditems=new FoodItems();
				res_obj.setRestaurantID2(rs.getString(2));
				res_obj.setRestaurantName(rs.getString(3));
				res_obj.setRestaurantAddress(rs.getString(4));
				res_obj.setRestaurantLocation(rs.getString(5));
				res_obj.setRestaurant_distance(rs.getFloat(6));
				res_obj.setName(rs.getString(7));
				res_obj.setEmail_id(rs.getString(8));
				res_obj.setContact_no(rs.getString(9));
				tableseats.setBasictablecount(rs.getInt(10));
				tableseats.setBasictableseatcount(rs.getInt(11));
				tableseats.setPremiumtablecount(rs.getInt(12));
				tableseats.setPremiumtableseatcount(rs.getInt(13));
				
				res_obj.setRestaurant_isActive(rs.getInt(14));
				
				String selectquery1="SELECT * FROM BasicTableSeatArrangement";
				Statement stmt1 = con.createStatement();
				ResultSet rs1 =  stmt1.executeQuery(selectquery1);
				while(rs1.next()){
					
					if(rs.getString(2).equalsIgnoreCase(rs1.getString(1))) {
						tableseats.basicseatobj.put(rs1.getInt(2), rs1.getString(3));
					}
				}
				String selectquery2="SELECT * FROM PremiumTableSeatArrangement";
				Statement stmt2 = con.createStatement();
				ResultSet rs2 =  stmt2.executeQuery(selectquery2);
				while(rs2.next()){
					if(rs.getString(2).equalsIgnoreCase(rs2.getString(1))) {
						tableseats.premiumseatobj.put(rs2.getInt(2), rs2.getString(3));
					}
				}
				tables.setTableSeats(tableseats);
				tables.setBasictableseatamount(rs.getInt(14));
				tables.setPremiumtableseatamount(rs.getInt(15));
				res_obj.setTables(tables);
				fooditems.setFoodName(rs.getString(16));
				res_obj.setRestaurant_isActive(rs.getInt(17));
				res_obj.setFooditems(fooditems);
				res_obj.restaurant_obj_list.add(res_obj);
			} 
		res_obj.m=res_count+1;
		//System.out.println(res_obj.m);
		
		stmt.close();
		rs.close();
	}
	
	public static void bookingGetObjOperation(Connection con) throws SQLException {
		
		//System.out.println("Booking obj store Started...");
		Statement stmt = con.createStatement();
		String selectquery="SELECT * FROM BOOKING";
		ResultSet rs =  stmt.executeQuery(selectquery);
		int orderid_count=0;
		Booking book_obj = null;
		while(rs.next()){
			orderid_count+=1;
			book_obj=new Booking();
			book_obj.setOrder_id2(rs.getString(1));
			book_obj.setCustomerId(rs.getString(2));
			LocalDate lcDate = rs.getDate(3).toLocalDate();
			book_obj.setNextdate(lcDate);
			book_obj.setCustomerEmailid(rs.getString(4));
			book_obj.setCustomerphoneno(rs.getString(5));
			book_obj.setRes_id(rs.getString(6));
			book_obj.setRes_name(rs.getString(7));
			book_obj.setRes_address(rs.getString(8));
			book_obj.setBillamount(rs.getInt(9));
			book_obj.setPaymentstatus(rs.getString(10));
			book_obj.setOrder_status(rs.getInt(11));
			book_obj.setCustomername(rs.getString(12));
			    
				String selectquery1="SELECT * FROM CUSBOOKEDSEAT";
				Statement stmt1 = con.createStatement();
				ResultSet rs1 =  stmt1.executeQuery(selectquery1);
				while(rs1.next()){
					//System.out.println(rs.getString(1) + "CUSBOOKEDSEAT added...");
					if(rs.getString(1).equalsIgnoreCase(rs1.getString(1)))
					{						
						book_obj.user_choice_seats.add(rs1.getString(3));
					}
				}
				stmt1.close();
				
				String selectquery2="SELECT * FROM CUSBOOKEDBASICSEATKEY";
				Statement stmt2 = con.createStatement();
				ResultSet rs2 =  stmt2.executeQuery(selectquery2);
				
				while(rs2.next()){
					//System.out.println(rs2.getString(1) + "CUSBOOKEDBasicSEAT added...");
					
					if(rs.getString(1).equalsIgnoreCase(rs2.getString(1))) {
						
						book_obj.user_choice_seat_keylist_basic.add(rs2.getInt(3));
					
					}
				}
				stmt2.close();
				String selectquery3="SELECT * FROM CUSBOOKEDPREMIUMSEATKEY";
				Statement stmt3 = con.createStatement();
				ResultSet rs3 =  stmt3.executeQuery(selectquery3);
			
				while(rs3.next()){
					//System.out.println(rs3.getString(1) + "CUSBOOKEDPremiumSEAT added...");
					if(rs.getString(1).equalsIgnoreCase(rs3.getString(1))) {
						
						book_obj.user_choice_seat_keylist_premium.add(rs3.getInt(3));
					
					}
				}
				stmt3.close();
				book_obj.bookingobjlist.add(book_obj);
			} 
		book_obj.n=orderid_count+1;
		//System.out.println(book_obj.n);
		
		stmt.close();
		rs.close();
	}
	
	
	
public static ArrayList<Booking> bookingGetObjOperationjsp() throws SQLException {
		
		//System.out.println("Booking obj store Started...");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CHOUTHRI","welcome123");
	
		Statement stmt = con.createStatement();
		ArrayList<Booking> list=new ArrayList<Booking>();
		String selectquery="SELECT * FROM BOOKING";
		ResultSet rs =  stmt.executeQuery(selectquery);
		int orderid_count=0;
		Booking book_obj = null;
		
		while(rs.next()){
			orderid_count+=1;
			book_obj=new Booking();
			book_obj.setOrder_id2(rs.getString(1));
			book_obj.setCustomerId(rs.getString(2));
			LocalDate lcDate = rs.getDate(3).toLocalDate();
			book_obj.setNextdate(lcDate);
			book_obj.setCustomerEmailid(rs.getString(4));
			book_obj.setCustomerphoneno(rs.getString(5));
			book_obj.setRes_id(rs.getString(6));
			book_obj.setRes_name(rs.getString(7));
			book_obj.setRes_address(rs.getString(8));
			book_obj.setBillamount(rs.getInt(9));
			book_obj.setPaymentstatus(rs.getString(10));
			book_obj.setOrder_status(rs.getInt(11));
			book_obj.setCustomername(rs.getString(12));
			    
				String selectquery1="SELECT * FROM CUSBOOKEDSEAT";
				Statement stmt1 = con.createStatement();
				ResultSet rs1 =  stmt1.executeQuery(selectquery1);
				while(rs1.next()){
					//System.out.println(rs.getString(1) + "CUSBOOKEDSEAT added...");
					if(rs.getString(1).equalsIgnoreCase(rs1.getString(1)))
					{						
						book_obj.user_choice_seats.add(rs1.getString(3));
					}
				}
				stmt1.close();
				
				String selectquery2="SELECT * FROM CUSBOOKEDBASICSEATKEY";
				Statement stmt2 = con.createStatement();
				ResultSet rs2 =  stmt2.executeQuery(selectquery2);
				
				while(rs2.next()){
					//System.out.println(rs2.getString(1) + "CUSBOOKEDBasicSEAT added...");
					
					if(rs.getString(1).equalsIgnoreCase(rs2.getString(1))) {
						
						book_obj.user_choice_seat_keylist_basic.add(rs2.getInt(3));
					
					}
				}
				stmt2.close();
				String selectquery3="SELECT * FROM CUSBOOKEDPREMIUMSEATKEY";
				Statement stmt3 = con.createStatement();
				ResultSet rs3 =  stmt3.executeQuery(selectquery3);
			
				while(rs3.next()){
					//System.out.println(rs3.getString(1) + "CUSBOOKEDPremiumSEAT added...");
					if(rs.getString(1).equalsIgnoreCase(rs3.getString(1))) {
						
						book_obj.user_choice_seat_keylist_premium.add(rs3.getInt(3));
					
					}
				}
				stmt3.close();
				list.add(book_obj);
			} 
		book_obj.n=orderid_count+1;
		//System.out.println(book_obj.n);
		
		stmt.close();
		rs.close();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public static void customerAccountGetObjOperation(Connection con) throws SQLException {
		
		//System.out.println("Customer ACC Started...");
		Statement stmt = con.createStatement();
		String selectquery="SELECT * FROM RESCUSTOMER ORDER BY USERID";
		ResultSet rs =  stmt.executeQuery(selectquery);
		int cus_count=0;
		Customer cus_obj = null;
		while(rs.next()){
			cus_count+=1;
			cus_obj=new Customer();
				cus_obj.setCustomerId2(rs.getString(2));
				cus_obj.setName(rs.getString(3));
				cus_obj.setEmail_id(rs.getString(4));
				cus_obj.setContact_no(rs.getString(5));
				cus_obj.setGender(rs.getString(6));
				cus_obj.setAge(rs.getInt(7));
				cus_obj.setAddress(rs.getString(8));
				cus_obj.setCus_order_count(rs.getInt(9));
				cus_obj.setIsActive(rs.getInt(10));
				cus_obj.customer_obj_list.add(cus_obj);	
				
			} 
		cus_obj.n=cus_count+1;
		//System.out.println("CUS ID Count : "+cus_obj.n);
		
		stmt.close();
		rs.close();
	}
	
	
public static void adminGetObjOperation(Connection con) throws SQLException {
	
	//System.out.println("Customer ACC Started...");
	Statement stmt = con.createStatement();
	String selectquery="SELECT * FROM ADMIN";
	ResultSet rs =  stmt.executeQuery(selectquery);
	
	Admin cus_obj = null;
	while(rs.next()){
	
		cus_obj=new Admin();
			
			cus_obj.setAdmin_user_id(rs.getString(2));
			cus_obj.setName(rs.getString(3));
			
			cus_obj.setEmail_id(rs.getString(4));
		
			cus_obj.setContact_no(rs.getString(5));
			cus_obj.setGender(rs.getString(6));
			cus_obj.setAge(rs.getInt(7));
			cus_obj.setAddress(rs.getString(8));
			cus_obj.setIsActive(rs.getInt(9));	
			//System.out.println("CUS ID Count : "+rs.getString(2));
			Admin.admin_obj_list.add(cus_obj);
		} 

	
	
	stmt.close();
	rs.close();
}


	public void accountRestaurantSignUp(String resuserid,String userid,int isActive,String usertype,String restaurantname,String resownername,String resowneremailid,
			String restaurantaddress,String restaurantpassword
			,String restaurantlocation,String restaurant_contactno,float restaurantdistance)  {
		
	         try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
			String sql ="INSERT INTO ACCOUNT(USERID,USERTYPE,USEREMAILID,USERPASSWORD,USERNAME,ISACTIVE) VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt1=con.prepareStatement(sql);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			pstmt1.setString(1,userid);
			pstmt1.setString(2,usertype);
			pstmt1.setString(3,resowneremailid.toLowerCase());
			pstmt1.setString(4,restaurantpassword);
			pstmt1.setString(5,restaurantname);
			pstmt1.setInt(6,isActive);
			int s1=pstmt1.executeUpdate();
			String sql1 ="INSERT INTO RESTAURANT(USERID,RESID,RESNAME,RESADDRESS,RESLOCATION,RESDISTANCE,MANAGERNAME,MANAGEREMAILID,MANAGERCONTACTNO,BASICTABLECOUNT,BASICTABLESEATCOUNT,PREMIUMTABLECOUNT,PREMIUMTABLESEATCOUNT,BASICTABLESEATAMOUNT,PREMIUMTABLESEATAMOUNT,FOODITEMS,ISACTIVE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt2=con.prepareStatement(sql1);
			pstmt2.setString(1, userid);
			pstmt2.setString(2, resuserid);
			pstmt2.setString(3, restaurantname);
			pstmt2.setString(4,  restaurantaddress);
			pstmt2.setString(5,restaurantlocation);
			pstmt2.setFloat(6, restaurantdistance);
			
			pstmt2.setString(7, resownername);
			pstmt2.setString(8, resowneremailid.toLowerCase());
			pstmt2.setString(9, restaurant_contactno);
			pstmt2.setInt(10, 0);
			pstmt2.setInt(11, 0);
			pstmt2.setInt(12, 0);
			pstmt2.setInt(13,0);
			pstmt2.setInt(14,0);
			pstmt2.setInt(15,0);
			pstmt2.setString(16,"*,*,*,*,*");
			pstmt2.setInt(17,1);
			int s2=pstmt2.executeUpdate();
			
			if(s1==1) {
				//System.out.println("ACCOUNT Successfully DB..");
			}
			if(s2==1) {
				//System.out.println("RES Successfully DB..");
			}
			
				pstmt1.close();
			
			
			
	         }catch(ClassNotFoundException e) {
	        	 
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}
	
	public void updateBasicTableAmount(int amt,Restaurant res_obj) {
		
		
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
				String sql2="UPDATE RESTAURANT SET BASICTABLESEATAMOUNT=? WHERE RESID=?";
				PreparedStatement pstmt2=con.prepareStatement(sql2);
				pstmt2.setInt(1,amt);
				pstmt2.setString(2,res_obj.getRestaurantID());
				int s2=pstmt2.executeUpdate();
				if(s2==1) {
					//System.out.println("Basic Seat Amount Updated DB...........");
				}
				
				pstmt2.close();
				
				con.close();
				
	         }catch(ClassNotFoundException e) {
	        	 
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	
public void deleteRestaurantAccount(Restaurant res_obj) {
		
		
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
				String sql2="UPDATE RESTAURANT SET ISACTIVE=? WHERE RESID=?";
				PreparedStatement pstmt2=con.prepareStatement(sql2);
				pstmt2.setInt(1,0);
				pstmt2.setString(2,res_obj.getRestaurantID());
				int s2=pstmt2.executeUpdate();
				if(s2==1) {
					//System.out.println("DELETED RESTAURANT Amount Updated DB...........");
				}
				
				String sql3="UPDATE ACCOUNT SET ISACTIVE=? WHERE USEREMAILID=?";
				PreparedStatement pstmt3=con.prepareStatement(sql3);
				pstmt3.setInt(1,0);
				pstmt3.setString(2,res_obj.getEmail_id());
				int s3=pstmt3.executeUpdate();
				if(s3==1) {
					//System.out.println("DELETED Amount Updated DB...........");
				}

				pstmt3.close();
				pstmt2.close();
			
				con.close();
			
	         }catch(ClassNotFoundException e) {
	        	 
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	
	
public void updatePremiumTableAmount(int amt,Restaurant res_obj) {
		
		
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
				String sql2="UPDATE RESTAURANT SET PREMIUMTABLESEATAMOUNT=? WHERE RESID=?";
				PreparedStatement pstmt2=con.prepareStatement(sql2);
				pstmt2.setInt(1,amt);
				pstmt2.setString(2,res_obj.getRestaurantID());
				int s2=pstmt2.executeUpdate();
				if(s2==1) {
					//System.out.println("Premium Seat Amount Updated DB...........");
				}

				pstmt2.close();
			
				con.close();
			
	         }catch(ClassNotFoundException e) {
	        	 
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	public void updateBasicTableSeatInRes(int basictablecount,int basictableseatcount,Restaurant res_obj) {
		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
			String sql2="UPDATE RESTAURANT SET BASICTABLECOUNT=?,BASICTABLESEATCOUNT=? WHERE RESID=?";
			PreparedStatement pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1,basictablecount);
			pstmt2.setInt(2,basictableseatcount);
			pstmt2.setString(3,res_obj.getRestaurantID());
			int s2=pstmt2.executeUpdate();
			if(s2==1) {
				//System.out.println("Basic Seat Updated DB...........");
			}

			pstmt2.close();
		
			con.close();
		
         }catch(ClassNotFoundException e) {
        	 
         }
         catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void updatePremiumTableSeatInRes(int premiumtablecount,int premiumtableseatcount,Restaurant res_obj) {
		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
			String sql2="UPDATE RESTAURANT SET PREMIUMTABLECOUNT=?,PREMIUMTABLESEATCOUNT=? WHERE RESID=?";
			PreparedStatement pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1,premiumtablecount);
			pstmt2.setInt(2,premiumtableseatcount);
			pstmt2.setString(3,res_obj.getRestaurantID());
			int s2=pstmt2.executeUpdate();
			if(s2==1) {
				//System.out.println("Premium Seat Updated DB...........");
			}

			pstmt2.close();
		
			con.close();
		
         }catch(ClassNotFoundException e) {
        	 
         }
         catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void deleteBasicTableSeatRecord(Restaurant res_obj) {
		try {
			
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
		  String sql1="DELETE FROM BASICTABLESEATARRANGEMENT WHERE RESID=?";
		  PreparedStatement pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1,res_obj.getRestaurantID());
			pstmt1.executeUpdate();
		
				//System.out.println("Clear Basic table Seat Old Record From DB");
			
			}catch(ClassNotFoundException e) {
	        	 
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void deletePremiumTableSeatRecord(Restaurant res_obj) {
		try {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
		   String sql1="DELETE FROM PREMIUMTABLESEATARRANGEMENT WHERE RESID=?";
		  PreparedStatement pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1,res_obj.getRestaurantID());
		pstmt1.executeUpdate();
			
				//System.out.println("Clear premium table Seat Old Record From DB");
			
			}catch(ClassNotFoundException e) {
	        	 
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void basicTableSeatInsertArrangement(Restaurant res_obj,int key,String seatid,Connection con) {
		   try {
			  
				String sql2="INSERT INTO BASICTABLESEATARRANGEMENT(RESID,BASICSEATKEY,BASICSEATID) VALUES(?,?,?)";
				PreparedStatement pstmt2=con.prepareStatement(sql2);
				pstmt2.setString(1,res_obj.getRestaurantID());
				pstmt2.setInt(2,key);
				pstmt2.setString(3,seatid);
				int s2=pstmt2.executeUpdate();
				if(s2==1) {
					//System.out.println("Basic Seat Arranged  DB...........");
				}

				pstmt2.close();
			
				
			
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	//makeResCustomer(cusobj,cusobj.getCus_order_count());
	
	
	
	public void makeResCustomer(String cusid,int order_count) {
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
				String sql5="UPDATE ResCustomer SET CusOrderCount=? WHERE RESID=?";
				PreparedStatement pstmt5=con.prepareStatement(sql5);
				pstmt5.setInt(1,order_count);
				pstmt5.setString(2,cusid);
				int s5=pstmt5.executeUpdate();
				if(s5==1) {
					//System.out.println("Basic Seat Amount Updated DB...........");
				}
				
				pstmt5.close();
				
				con.close();
				
	         }catch(ClassNotFoundException e) {
	        	 
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	
	
	
	
	public void premiumTableSeatInsertArrangement(Restaurant res_obj,int key,String seatid,Connection con) {
		   try {
			  
			   String sql3="INSERT INTO PREMIUMTABLESEATARRANGEMENT(RESID,PREMIUMSEATKEY,PREMIUMSEATID) VALUES(?,?,?)";
			 
			   PreparedStatement pstmt3=con.prepareStatement(sql3);
				pstmt3.setString(1,res_obj.getRestaurantID());
				pstmt3.setInt(2,key);
				pstmt3.setString(3,seatid);
				int s3=pstmt3.executeUpdate();
				if(s3==1) {
					//System.out.println("Premium Seat Arranged...........");
				}

				pstmt3.close();
			
			
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	public void accountCustomerSignUp(String cus_userid,int cusordercount,String userid,int isActive,String person_name,String person_password,String person_emailid
			,String person_contactno,String person_gender,int person_age,String person_address,String usertype) {
		
		
		  try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
				String sql ="INSERT INTO ACCOUNT(USERID,USERTYPE,USEREMAILID,USERPASSWORD,USERNAME,ISACTIVE) VALUES(?,?,?,?,?,?)";
				PreparedStatement pstmt1=con.prepareStatement(sql);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				pstmt1.setString(1,userid);
				pstmt1.setString(2,usertype);
				pstmt1.setString(3,person_emailid.toLowerCase());
				pstmt1.setString(4,person_password);
				pstmt1.setString(5,person_name);
				pstmt1.setInt(6,isActive);
				int s1=pstmt1.executeUpdate();
				String sql1 ="INSERT INTO RESCUSTOMER(USERID,CUSID,CUSNAME,CUSEMAILID,CUSCONTACTNO,CUSGENDER,CUSAGE,CUSADDRESS,CUSORDERCOUNT,ISACTIVE) VALUES(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt2=con.prepareStatement(sql1);
				pstmt2.setString(1, userid);
				pstmt2.setString(2, cus_userid);
				pstmt2.setString(3, person_name);
				pstmt2.setString(4,  person_emailid.toLowerCase());
				pstmt2.setString(5,person_contactno);
				pstmt2.setString(6, person_gender);
				pstmt2.setInt(7, person_age);
				pstmt2.setString(8, person_address);
				pstmt2.setInt(9,cusordercount);
				pstmt2.setInt(10,isActive);
				int s2=pstmt2.executeUpdate();
				
				if(s1==1) {
					//System.out.println("ACCOUNT Successfully DB..");
				}
				if(s2==1) {
					//System.out.println("Customer Successfully DB..");
				}
				
					pstmt1.close();
				
				con.close();
				
		         }catch(ClassNotFoundException e) {
		        	 
		         }
		         catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
	
	}
	public void orderTicketBooking(int cus_order_count,int order_status,HashSet<String> user_choice_seats,ArrayList<Integer> user_choice_seat_key_basic,ArrayList<Integer> user_choice_seat_key_premium,String orderid,String customerId,String customername,String cusEmailid,String resid,String customerphoneno,
			int billamount,String paymentstatus,String resname,String resaddress,Date nextdate) {
		{
			
			 try {
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
					String sql ="INSERT INTO BOOKING(ORDERID,CUSID,NEXTDATE,CUSEMAILID,CUSCONTACTNO,RESID,RESNAME,RESADDRESS,BILLAMOUNT,PAYMENTSTATUS,ORDERSTATUS,CUSNAME) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pstmt1=con.prepareStatement(sql);
					Class.forName("oracle.jdbc.driver.OracleDriver");
					pstmt1.setString(1,orderid);
					pstmt1.setString(2,customerId);
					pstmt1.setDate(3,nextdate);
					pstmt1.setString(4,cusEmailid);
					pstmt1.setString(5,customerphoneno);
					pstmt1.setString(6,resid);
					pstmt1.setString(7,resname);
					pstmt1.setString(8,resaddress);
					pstmt1.setInt(9,billamount);
					pstmt1.setString(10,paymentstatus);
					
					pstmt1.setInt(11,order_status);
					pstmt1.setString(12,customername);
					int s1=pstmt1.executeUpdate();
					
					
					
					String sqlcus="Update RESCUSTOMER SET CUSORDERCOUNT=? WHERE CUSID=?";
					PreparedStatement ps=con.prepareStatement(sqlcus);
					ps.setInt(1,cus_order_count);
					ps.setString(2,customerId);
					ps.executeUpdate();
					
					
					for(String seat:user_choice_seats) {
			        
					String sql1 ="INSERT INTO CUSBOOKEDSEAT(ORDERID,CUSID,SEATIDSET) VALUES(?,?,?)";
					PreparedStatement pstmt2=con.prepareStatement(sql1);
					pstmt2.setString(1, orderid);
					pstmt2.setString(2, customerId);
					pstmt2.setString(3, seat);
					int s2=pstmt2.executeUpdate();
					if(s2==1) {
						//System.out.println("CusBookedSeats Successfully DB..");
					}
					}
					
					
					for(int seatkeybasic: user_choice_seat_key_basic) {
				        
						String sql1 ="INSERT INTO CUSBOOKEDBASICSEATKEY(ORDERID,CUSID,SEATIDKEYSET) VALUES(?,?,?)";
						PreparedStatement pstmt2=con.prepareStatement(sql1);
						pstmt2.setString(1, orderid);
						pstmt2.setString(2, customerId);
						pstmt2.setInt(3, seatkeybasic);
						int s2=pstmt2.executeUpdate();
						if(s2==1) {
							//System.out.println("basic seat key Successfully DB..");
						}
					}
					
					for(int seatkeypremium: user_choice_seat_key_premium) {
				        
						String sql1 ="INSERT INTO CUSBOOKEDPREMIUMSEATKEY(ORDERID,CUSID,SEATIDKEYSET) VALUES(?,?,?)";
						PreparedStatement pstmt2=con.prepareStatement(sql1);
						pstmt2.setString(1, orderid);
						pstmt2.setString(2, customerId);
						pstmt2.setInt(3, seatkeypremium);
						int s2=pstmt2.executeUpdate();
						if(s2==1) {
							//System.out.println("premium seat key Successfully DB..");
						}
					}
					
					if(s1==1) {
						//System.out.println("ACCOUNT Successfully DB..");
					}
					
					
						pstmt1.close();
					
					con.close();
					
			         }catch(ClassNotFoundException e) {
			        	 
			         }
			         catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
		}
	}
	
	public void putNullToBasicSeat(String resid,int key,Connection con) throws SQLException {
		
		String sql1 ="UPDATE BASICTABLESEATARRANGEMENT SET BASICSEATID='_**_' WHERE RESID=? AND BASICSEATKEY=?";
		PreparedStatement pstmt2;
		try {
			pstmt2 = con.prepareStatement(sql1);
			pstmt2.setString(1, resid);
			pstmt2.setInt(2, key);
			int s2=pstmt2.executeUpdate();
			if(s2==1) {
				//System.out.println("Basic seat key Successfully in BASICTABLEsearArrangement ..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void updateFoodMent(String resid,String food_item) {
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CHOUTHRI","welcome123");
				String sql2="UPDATE RESTAURANT SET FOODITEMS=? WHERE RESID=?";
				PreparedStatement pstmt2=con.prepareStatement(sql2);
				pstmt2.setString(1,food_item);
				pstmt2.setString(2,resid);
				int s2=pstmt2.executeUpdate();
				if(s2==1) {
				//	System.out.println("Food item Updated...........");
				}

				pstmt2.close();
			
				con.close();
			
	         }catch(ClassNotFoundException e) {
	        	 
	         }
	         catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
	
	
	public void updateCancelOperation(String orderid,String cus_id,int count,Connection con) {
		try {
		String sqlcus="Update RESCUSTOMER SET CUSORDERCOUNT=? WHERE CUSID=?";
		PreparedStatement ps=con.prepareStatement(sqlcus);
		//System.out.println("New in db update:"+count);
		ps.setInt(1,count);
		ps.setString(2,cus_id);
		ps.executeUpdate();
		
		String sql1="Update BOOKING SET ORDERSTATUS=?,PAYMENTSTATUS=? WHERE ORDERID=?";
		PreparedStatement ps1=con.prepareStatement(sql1);
		ps1.setInt(1,0);
		ps1.setString(2,"REFUND INITIATED");
		ps1.setString(3,orderid);
		ps1.executeUpdate();
		
		String sql2="Update CUSPAYMENT SET PAYMENTSTATUS=?,ORDERSTATUS=? WHERE ORDERID=? AND CUSID=?";
		PreparedStatement ps2=con.prepareStatement(sql2);
		ps2.setString(1,"REFUND INITIATED");
		ps2.setInt(2,0);
		ps2.setString(3,orderid);
		ps2.setString(4,cus_id);
		ps2.executeUpdate();
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void putValueToBasicSeat(String cusid,String res_id,String orderid,int key,String value,Connection con) {
		
		String sql1 ="UPDATE BASICTABLESEATARRANGEMENT SET BASICSEATID=? WHERE RESID=? AND BASICSEATKEY=?";
		PreparedStatement pstmt2;
		try {
			pstmt2 = con.prepareStatement(sql1);
			pstmt2.setString(1, value);
			pstmt2.setString(2, res_id);
			pstmt2.setInt(3, key);
			int s2=pstmt2.executeUpdate();
			if(s2==1) {
				//System.out.println("Basic seat key Value Fixed ..");
			}
			
			
			String sql3 ="DELETE from CusBookedSeat WHERE SEATIDSET=? AND ORDERID=? AND CUSID=?";
			PreparedStatement pstmt3;
			
				pstmt3 = con.prepareStatement(sql3);
				pstmt3.setString(1, value);
				pstmt3.setString(2, orderid);
				pstmt3.setString(3, cusid);
				int s3=pstmt3.executeUpdate();
				if(s3==1) {
					//System.out.println("Basic seat DELETED IN CUSBOOKEDSEAT ..");
				}				
				
				String sql4 ="DELETE from CUSBOOKEDBASICSEATKEY WHERE SEATIDKEYSET=? AND ORDERID=? AND CUSID=?";
				PreparedStatement pstmt4;
				
					pstmt4 = con.prepareStatement(sql4);
					pstmt4.setInt(1,key);
					pstmt4.setString(2, orderid);
					pstmt4.setString(3, cusid);
					int s4=pstmt4.executeUpdate();
					if(s4==1) {
					//	System.out.println("Basic seat DELETED IN CUSBOOKED BASIC SEAT KEY SEAT ..");
					}				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
public void putValueToPremiumSeat(String cusid,String res_id,String orderid,int key,String value,Connection con) {
		
		String sql1 ="UPDATE PREMIUMTABLESEATARRANGEMENT SET PREMIUMSEATID=? WHERE RESID=? AND PREMIUMSEATKEY=?";
		PreparedStatement pstmt2;
		try {
			pstmt2 = con.prepareStatement(sql1);
			pstmt2.setString(1, value);
			pstmt2.setString(2, res_id);
			pstmt2.setInt(3, key);
			int s2=pstmt2.executeUpdate();
			if(s2==1) {
				//System.out.println("PREMIUM seat key Value Fixed ..");
			}
			
			
			String sql3 ="DELETE from CusBookedSeat WHERE SEATIDSET=? AND ORDERID=? AND CUSID=?";
			PreparedStatement pstmt3;
			
				pstmt3 = con.prepareStatement(sql3);
				pstmt3.setString(1, value);
				pstmt3.setString(2, orderid);
				pstmt3.setString(3, cusid);
				int s3=pstmt3.executeUpdate();
				if(s3==1) {
					//System.out.println("PREMIUM seat DELETED IN CUSBOOKEDSEAT ..");
				}				
				
				String sql4 ="DELETE from CUSBOOKEDPREMIUMSEATKEY WHERE SEATIDKEYSET=? AND ORDERID=? AND CUSID=?";
				PreparedStatement pstmt4;
				
					pstmt4 = con.prepareStatement(sql4);
					pstmt4.setInt(1,key);
					pstmt4.setString(2, orderid);
					pstmt4.setString(3, cusid);
					int s4=pstmt4.executeUpdate();
					if(s4==1) {
						//System.out.println("PREMIUM seat DELETED IN CUSBOOKED PREMIUM SEAT KEY SEAT ..");
					}				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
public void putNullToPremiumSeat(String resid,int key,Connection con) throws SQLException {
		
		String sql1 ="UPDATE PREMIUMTABLESEATARRANGEMENT SET PREMIUMSEATID='-**-' WHERE RESID=? AND PREMIUMSEATKEY=?";
		PreparedStatement pstmt2;
		try {
			pstmt2 = con.prepareStatement(sql1);
			pstmt2.setString(1, resid);
			pstmt2.setInt(2, key);
			int s2=pstmt2.executeUpdate();
			if(s2==1) {
				//System.out.println("PREMIUM seat key Successfully in PREMIUMTABLEsearArrangement ..");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


public void paymentOperation(String card_no,String card_holder_name,String upi,String cusid,int or_st,String orderid,String res_id2,String payment_type,
		int amount,String payment_status) {
	
	
	  try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
			String sql ="INSERT INTO CUSPAYMENT(ORDERID,CUSID,PAYMENTTYPE,BILLAMOUNT,CARDNO,CARDHOLDERNAME,UPI,PAYMENTSTATUS,ORDERSTATUS,RESID) VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt1=con.prepareStatement(sql);
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
			pstmt1.setString(1,orderid);
			pstmt1.setString(2,cusid);
			pstmt1.setString(3,payment_type);
			pstmt1.setInt(4,amount);
			pstmt1.setString(5,card_no);
			pstmt1.setString(6,card_holder_name);
			pstmt1.setString(7, upi);
			pstmt1.setString(8,payment_status);
			pstmt1.setInt(9,or_st);
			pstmt1.setString(10,res_id2);
			int s1=pstmt1.executeUpdate();
			if(s1==1) {
				//System.out.println("Payment inserted to DB...");
			}
	  }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	
}
