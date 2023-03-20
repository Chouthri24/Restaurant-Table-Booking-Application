package com.accountdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.registration.customeraccount.Customer;

public class CustomerAccountDao {
	
	 /*public int signUpCustomerAccount(Customer cus) throws SQLException, ClassNotFoundException {
		 
		 final String driverclass="oracle.jdbc.driver.OracleDriver";
			
			final String url ="jdbc:oracle:thin:@localhost:1521:xe";
			
			String username="CHOUTHRI";
			
			String password="welcome123";
			
			Class.forName(driverclass);	

			Connection con=DriverManager.getConnection(url,username ,password);
			
			PreparedStatement ps=con.prepareStatement("Insert into usercheck values(?,?)");
			ps.setString(1,cus.getEmailId());
			ps.setString(2,cus.getPassword());
			int check=ps.executeUpdate();
			if(check!=0) {
					return 1;
			}
			return 0;
	 }*/
	public boolean signInAccountCheck(String Type,String emailid,String pass) throws ClassNotFoundException, SQLException {
	
			final String driverclass="oracle.jdbc.driver.OracleDriver";
			
			final String url ="jdbc:oracle:thin:@localhost:1521:xe";
			
			String username="CHOUTHRI";
			
			String password="welcome123";
			
			Class.forName(driverclass);	

			Connection con=DriverManager.getConnection(url,username ,password);
			
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM Account";
			
			ResultSet rs =  stmt.executeQuery(sql);
			
			while(rs.next()){
				
				if(Type.equalsIgnoreCase(rs.getString(2)) && emailid.equalsIgnoreCase(rs.getString(3)) && pass.equalsIgnoreCase(rs.getString(4))) {
					
					return true;
					}
				} 
			
			con.close();
			stmt.close();
			rs.close();
			
		return false;
	}
	
	
	
	public boolean update_Customer_profile(String userid,String cusid,String name,String email,String contact,String gender,String age,String address ,String pass) throws ClassNotFoundException, SQLException {
		
		//System.out.println(userid+" "+cusid+" "+name+" "+email+" "+contact+" "+gender+" "+age+" "+address);
		final String driverclass="oracle.jdbc.driver.OracleDriver";
		
		final String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		String username="CHOUTHRI";
		
		String password="welcome123";
		
		Class.forName(driverclass);	

		Connection con=DriverManager.getConnection(url,username ,password);
		
		
		String sqla="UPDATE ACCOUNT SET USERNAME=?,USERPASSWORD=? WHERE USERID=?";
		PreparedStatement rs1=con.prepareStatement(sqla);
		rs1.setString(1,name);
		rs1.setString(2, pass);
		rs1.setString(3, userid);
		int m=rs1.executeUpdate();
		
		
		String sql = "UPDATE RESCUSTOMER SET CUSNAME=?,CUSCONTACTNO=?,CUSGENDER=?,CUSAGE=?,CUSADDRESS=? WHERE CUSID=?";
		
		PreparedStatement rs=con.prepareStatement(sql);
		rs.setString(1, name);
		rs.setString(2, contact);

		rs.setString(3, gender);

		rs.setString(4, age);

		rs.setString(5,address);

		rs.setString(6, cusid);

		int n=rs.executeUpdate();
		if(n>0 && m>0) {
		System.out.println(n+"row updated...");
		return true;
		}else {
		return false;
		}
		
		
		
	}
	
	
	
	
}

