package fullstack2weeksample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"fullstack2weeksample.service","fullstack2weeksample.dao"})
@Import({DBinfo.class})
public class ApplicationConfig {

}
