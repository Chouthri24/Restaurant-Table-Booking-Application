package com.accountdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantAccountDao {
	
	public ResultSet moreDetailRestaurant(String id) throws ClassNotFoundException, SQLException {
		
		final String driverclass="oracle.jdbc.driver.OracleDriver";
		
		final String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		String username="CHOUTHRI";
		
		String password="welcome123";
		
		Class.forName(driverclass);	

		Connection con=DriverManager.getConnection(url,username ,password);
		
		
		String sql = "SELECT * FROM Restaurant Where RESID=?";
		
		PreparedStatement rs=con.prepareStatement(sql);
		rs.setString(1, id);
		
		ResultSet ps=rs.executeQuery();
		
	return ps;
}
	
	/*public void add_Restaurant(String resname,String resAddress,String location,float distance,String manname,String manemail,String contact) throws ClassNotFoundException, SQLException {
	final String driverclass="oracle.jdbc.driver.OracleDriver";
		
		final String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		String username="CHOUTHRI";
		
		String password="welcome123";
		
		Class.forName(driverclass);	
		
		 try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","CHOUTHRI","welcome123");
				String sql ="INSERT INTO ACCOUNT(USERID,USERTYPE,USEREMAILID,USERPASSWORD,USERNAME,ISACTIVE) VALUES(?,?,?,?,?,?)";
				PreparedStatement pstmt1=con.prepareStatement(sql);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				pstmt1.setString(1,userid);
				pstmt1.setString(2,usertype);
				pstmt1.setString(3,manemail.toLowerCase());
				pstmt1.setString(4,restaurantpassword);
				pstmt1.setString(5,resname);
				pstmt1.setInt(6,isActive);
				int s1=pstmt1.executeUpdate();
				String sql1 ="INSERT INTO RESTAURANT(USERID,RESID,RESNAME,RESADDRESS,RESLOCATION,RESDISTANCE,MANAGERNAME,MANAGEREMAILID,MANAGERCONTACTNO,BASICTABLECOUNT,BASICTABLESEATCOUNT,PREMIUMTABLECOUNT,PREMIUMTABLESEATCOUNT,BASICTABLESEATAMOUNT,PREMIUMTABLESEATAMOUNT,FOODITEMS,ISACTIVE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt2=con.prepareStatement(sql1);
				pstmt2.setString(1, userid);
				pstmt2.setString(2, resuserid);
				pstmt2.setString(3, resname);
				pstmt2.setString(4,  resAddress);
				pstmt2.setString(5,location);
				pstmt2.setFloat(6, distance);
				
				pstmt2.setString(7, manname);
				pstmt2.setString(8, manemail.toLowerCase());
				pstmt2.setString(9, contact);
				pstmt2.setInt(10, 0);
				pstmt2.setInt(11, 0);
				pstmt2.setInt(12, 0);
				pstmt2.setInt(13,0);
				pstmt2.setInt(14,0);
				pstmt2.setInt(15,0);
				pstmt2.setString(16,"***");
				pstmt2.setInt(17,1);
				int s2=pstmt2.executeUpdate();
				
				if(s1==1) {
					System.out.println("ACCOUNT Successfully DB..");
				}
				if(s2==1) {
					System.out.println("RES Successfully DB..");
				}
				
					pstmt1.close();
				
				
				
		         }catch(ClassNotFoundException e) {
		        	 
		         }
		         catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
	}*/
	
	
public boolean update_Restaurant(String userid,String resid,String resname,String resadd,String resdis,String resloc,String name,String contact) throws ClassNotFoundException, SQLException {
		
		final String driverclass="oracle.jdbc.driver.OracleDriver";
		
		final String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		String username="CHOUTHRI";
		
		String password="welcome123";
		
		Class.forName(driverclass);	

		Connection con=DriverManager.getConnection(url,username ,password);
		String sqla="UPDATE ACCOUNT SET USERNAME=? WHERE USERID=?";
		PreparedStatement rs1=con.prepareStatement(sqla);
		rs1.setString(1,resname);
		
		rs1.setString(2, userid);
		int m=rs1.executeUpdate();
		
		
		String sql = "UPDATE RESTAURANT SET RESNAME=?,RESADDRESS=?,RESDISTANCE=?,RESLOCATION=?,MANAGERNAME=?,MANAGERCONTACTNO=? WHERE RESID=?";
		
		PreparedStatement rs=con.prepareStatement(sql);
		rs.setString(1, resname);
		rs.setString(2, resadd);

		rs.setString(3, resdis);

		rs.setString(4, resloc);

		rs.setString(5,name);

		rs.setString(6,contact);

		rs.setString(7, resid);

		int n=rs.executeUpdate();
		if(n>0) {
		System.out.println(n+"row updated...");
		return true;
		}else {
		return false;}
		
}


public boolean update_Restaurant_profile(String email,String manname,String mancontact,String pass) throws ClassNotFoundException, SQLException {
	
	final String driverclass="oracle.jdbc.driver.OracleDriver";
	
	final String url ="jdbc:oracle:thin:@localhost:1521:xe";
	
	String username="CHOUTHRI";
	
	String password="welcome123";
	
	Class.forName(driverclass);	

	Connection con=DriverManager.getConnection(url,username ,password);
	String sqla="UPDATE ACCOUNT SET USERPASSWORD=? WHERE USEREMAILID=?";
	PreparedStatement rs1=con.prepareStatement(sqla);
	rs1.setString(1,pass);
	
	rs1.setString(2, email);
	int m=rs1.executeUpdate();
	String sql = "UPDATE RESTAURANT SET MANAGERNAME=?,MANAGERCONTACTNO=? WHERE MANAGEREMAILID=?";
	
	PreparedStatement rs=con.prepareStatement(sql);
	rs.setString(1, manname);
	rs.setString(2, mancontact);
	rs.setString(3, email);
	int n=rs.executeUpdate();
	
	if(m>0 && n>0) {
		System.out.println("DB-Updated");
		return true;
	}
	else {
		return false;
	}
	
	
}
public boolean delete_Restaurant(String userid) throws ClassNotFoundException, SQLException {
	
	//System.out.println("DB-"+userid);
	final String driverclass="oracle.jdbc.driver.OracleDriver";
	
	final String url ="jdbc:oracle:thin:@localhost:1521:xe";
	
	String username="CHOUTHRI";
	
	String password="welcome123";
	
	Class.forName(driverclass);	

	Connection con=DriverManager.getConnection(url,username ,password);
	String sqla="UPDATE ACCOUNT SET ISACTIVE=? WHERE USERID=?";
	PreparedStatement rs1=con.prepareStatement(sqla);
	rs1.setInt(1,0);
	rs1.setString(2, userid);
	int m=rs1.executeUpdate();
	
	String sql = "UPDATE RESTAURANT SET ISACTIVE=? WHERE USERID=?";
	PreparedStatement rs=con.prepareStatement(sql);
	rs.setInt(1,0);
	rs.setString(2, userid);
	int n=rs.executeUpdate();
	
	if(n>0 && m>0) {
	return true;
	}else {
		return false;
	}
	
	
}


public boolean activate_Restaurant(String userid) throws ClassNotFoundException, SQLException {
	
	System.out.println("Activat DB-"+userid);
	final String driverclass="oracle.jdbc.driver.OracleDriver";
	
	final String url ="jdbc:oracle:thin:@localhost:1521:xe";
	
	String username="CHOUTHRI";
	
	String password="welcome123";
	
	Class.forName(driverclass);	

	Connection con=DriverManager.getConnection(url,username ,password);
	String sqla="UPDATE ACCOUNT SET ISACTIVE=? WHERE USERID=?";
	PreparedStatement rs1=con.prepareStatement(sqla);
	rs1.setInt(1,1);
	rs1.setString(2, userid);
	int m=rs1.executeUpdate();
	
	String sql = "UPDATE RESTAURANT SET ISACTIVE=? WHERE USERID=?";
	PreparedStatement rs=con.prepareStatement(sql);
	rs.setInt(1,1);
	rs.setString(2, userid);
	int n=rs.executeUpdate();
	
	if(n>0 && m>0) {
	return true;
	}else {
		return false;
	}
	
	
}

	

}
