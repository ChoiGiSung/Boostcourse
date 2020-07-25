package guestbookSample.config;
//디비 관련 클래스

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement //트랜젝션을 사용할꺼야
//트렌젝션은 오토메서드가 있는데 true로 하면 모두 성공해야지 반영할꺼야! 라는뜻
public class DBConfig implements TransactionManagementConfigurer{
	
	//db정보
	//db정보 뭐 아이디나 그런거
	private String driverClassName="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/book?serverTimezone=UTC&characterEncoding=euckr&useSSL=false";

	private String username="root";
	private String password="1234";
	
	

	//datasource는 dao에서 NamedParameterJdbcTemplate와 SimpleJdbcInsert 사용시 필요함
	//저 둘은 jsp의 preparstatment같은거라 생각하면됨 
	//빈등록
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	
	
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}


}
