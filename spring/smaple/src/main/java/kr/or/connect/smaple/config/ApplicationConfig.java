package kr.or.connect.smaple.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class})
@ComponentScan(basePackages = {"kr.or.connect.smaple.dao"})
public class ApplicationConfig {
		//config 설정 파일 class
}
