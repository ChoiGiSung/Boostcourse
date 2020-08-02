package fullstack2week.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"fullstack2week.dao","fullstack2week.service"})
@Import({DBInfo.class})
public class ApplicationConfig {

}
