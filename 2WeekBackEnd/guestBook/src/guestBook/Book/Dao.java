package guestBook.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Dao {
		String jdbcUrl="jdbc:mysql://localhost:3306/book?serverTimezone=UTC&characterEncoding=euckr";//mysql 계정 //타임존 설정도 해줘야함
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String dbid="root";
		String dbpw="1234";
		String sql="";
		
		SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date1=date.format(new Date());
		
		public String addbook(String name,String conent) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(jdbcUrl,dbid,dbpw);
				
				sql="insert into guestbook values(?,?,?,?)";
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, 0);
				pstmt.setString(2,name);
				pstmt.setString(3,conent);
				pstmt.setString(4,date1);
				pstmt.executeUpdate();
			
				return "성공";
			} catch (Exception e) {e.printStackTrace();}finally {
				try {
					pstmt.close();
					conn.close();
					rs.close();
				} catch (Exception e) {}
			}
			return "실패";
		}
		public ArrayList<Dto> getbook() {
			ArrayList<Dto> ar=new ArrayList<Dto>();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(jdbcUrl,dbid,dbpw);
				
				sql="select * from guestbook";
				
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					Dto dto=new Dto();
					
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					dto.setContent(rs.getString("content"));
					dto.setRegdate(rs.getDate("regdate"));
					ar.add(dto);
				}
			} catch (Exception e) {e.printStackTrace();
			}finally {
				try {
					pstmt.close();
					conn.close();
					rs.close();
				} catch (Exception e) {e.printStackTrace();}
				
			}
			return ar;
		}
		
}

