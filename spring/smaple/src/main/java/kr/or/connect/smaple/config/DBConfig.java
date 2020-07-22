package kr.or.connect.smaple.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	//db관련 설정
	private String driverClassName="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/book?serverTimezone=UTC&characterEncoding=euckr";
	
	private String username="root";
	private String password="1234";
	
	//t스프링 jdbc를 이용할때는 데이타 소스를 통해서 db접속 부분을 얻어낸다
	//데이타 소스 객체 빈에 등록하기
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource= new  BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
}
