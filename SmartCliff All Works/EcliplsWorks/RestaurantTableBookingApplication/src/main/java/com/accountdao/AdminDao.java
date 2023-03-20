package com.accountdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDao {
	
	
public boolean update_Admin(String name,String email,String contact,String gen,String address) throws ClassNotFoundException, SQLException {
		
		final String driverclass="oracle.jdbc.driver.OracleDriver";
		
		final String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		String username="CHOUTHRI";
		
		String password="welcome123";
		
		Class.forName(driverclass);	

		Connection con=DriverManager.getConnection(url,username ,password);
		String sqla="UPDATE ACCOUNT SET USERNAME=? WHERE USEREMAILID=?";
		PreparedStatement rs1=con.prepareStatement(sqla);
		rs1.setString(1,name);
		
		rs1.setString(2,email);
		//System.out.println(name + " "+ email);
		int m=rs1.executeUpdate();
		//System.out.println(m+" m row modi");
		
		
		String sql = "UPDATE ADMIN SET ADMINNAME=?,ADMINCONTACTNO=?,ADMINGENDER=?,ADMINADDRESS=? WHERE ADMINEMAILID=?";
		
		PreparedStatement rs=con.prepareStatement(sql);
		rs.setString(1, name);
		rs.setString(2, contact);

		rs.setString(3, gen);

		rs.setString(4, address);

		rs.setString(5,email);

		int n=rs.executeUpdate();
		//System.out.println(n+" n row modi");
		if(n>0 && m>0) {
		//System.out.println("DB_admin_up");
		return true;
		}else {
		return false;}
		
}




public boolean update_AdminSetting(String email,String pass) throws ClassNotFoundException, SQLException {
	
	final String driverclass="oracle.jdbc.driver.OracleDriver";
	
	final String url ="jdbc:oracle:thin:@localhost:1521:xe";
	
	String username="CHOUTHRI";
	
	String password="welcome123";
	
	Class.forName(driverclass);	

	Connection con=DriverManager.getConnection(url,username ,password);
	String sqla="UPDATE ACCOUNT SET USERPASSWORD=? WHERE USEREMAILID=?";
	PreparedStatement rs1=con.prepareStatement(sqla);
	rs1.setString(1,pass);
	
	rs1.setString(2,email);
	//System.out.println(name + " "+ email);
	int m=rs1.executeUpdate();
	//System.out.println(m+" m row modi");

if(m>0) {
	return true;}else {
		return false;
	}
}







}
