package gusetbookexam.applicationconfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration //정보야
@EnableTransactionManagement		//트렌젝션 사용
public class DBConfig implements TransactionManagementConfigurer {
		//db정보 뭐 아이디나 그런거
	private String driverClassName="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/book?serverTimezone=UTC&characterEncoding=euckr&useSSL=false";
	
	private String username="root";
	private String password="1234";
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}

	
	//트렌젝션을 처리할 플렛폼을 반환
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
	
	//플레폼 트렌젝션 리턴
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
