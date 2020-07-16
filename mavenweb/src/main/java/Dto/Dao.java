package Dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dao {
		//db 관련
	public Dao() {
		
	}
	
	String jdbcUrl="jdbc:mysql://localhost:3306/bostsample?serverTimezone=UTC&characterEncoding=euckr";
	String dbId="root";
	String dbPw="1234";
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	String sql2="";
	
	SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time=format1.format(new Date());
	
	public String addName(String name,String call,String company){
		try {
			connet();
			sql="select name from businesscard where name=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,name);
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				if(rs.getString("name").equals(name)) {
					System.out.print("이미 있는 이름");	
				}
			}else {
				sql2="insert into businesscard values(?,?,?,?)";
				pstmt=conn.prepareStatement(sql2);
				pstmt.setString(1,name);
				pstmt.setString(2,call);
				pstmt.setString(3,company);
				pstmt.setString(4,time);
				
				pstmt.executeUpdate();
				
				return "참";
			}
			
					} catch (Exception e) {
						e.printStackTrace();
						
					}finally {disconnet();}
		
		return "거짓";
	}
	
	
	public String getname(String name) {
		
		try {
			connet();
			
			sql="select * from businesscard where name like ?";
			pstmt=conn.prepareStatement(sql);			
			pstmt.setString(1,"%"+name+"%");

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("call"));
					System.out.println(rs.getString("company"));
					System.out.println(rs.getString("date"));
					
			}
			
		} catch (Exception e) {e.printStackTrace();}finally {
			disconnet();
		}
		
		return "";
	}
	
	
	public void disconnet() {
		if(pstmt !=null) {try {pstmt.close();} catch (SQLException e) {}}
		if(rs !=null) {try {rs.close();} catch (SQLException e) {}}
		if(conn !=null) {try {conn.close();} catch (SQLException e) {}}
	}
	
	public void connet() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(jdbcUrl,dbId,dbPw);
		} catch (Exception e) {}
	}
}
