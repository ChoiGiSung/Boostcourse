package fullstack2week.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
public class DBInfo implements TransactionManagementConfigurer{
	private String driverClassName="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/todo?serverTimezone=UTC&characterEncoding=euckr&useSSL=false";
	
	private String username="root";
	private String password="1234";
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource= new  BasicDataSource();
		basicDataSource.setDriverClassName(driverClassName);
		basicDataSource.setUrl(url);
		
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
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
