package kr.or.connect.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //나는 설정이야
@EnableTransactionManagement
public class DBConfig {
	//db관련 설정 class
	private String driverClassName="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/book?serverTimezone=UTC&characterEncoding=euckr";
	
	private String username="root";
	private String password="1234";
	
	
	//스프링jdbc를 이용할때는 데이타소스를 통해서 db접속 부분을 얻어낸다
	//데이타소스 객체 빈에 등록하기
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource =new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
}
