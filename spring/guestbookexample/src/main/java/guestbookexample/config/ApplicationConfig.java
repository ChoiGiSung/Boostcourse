package guestbookexample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"guestbookexample.dao","guestbookexample.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
