package kr.or.connect.daoexam.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;

public class DataSourceTest {

	public static void main(String[] args) {
		//db커넥션이 잘되는지 앓아보는 class
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//공장 만들기(어디서 정보 읽을 꺼야)
		DataSource ds= ac.getBean(DataSource.class); //클래스를 요청-> 데이터 소스를 구현하고 있는 객체 리턴
		Connection conn=null;
		
		try {
			conn=ds.getConnection();//컨넥션이 되는지 확인
			if( conn!=null) {
				System.out.print("w접속정송");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
	}

}
