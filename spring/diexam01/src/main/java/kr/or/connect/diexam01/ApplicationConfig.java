package kr.or.connect.diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 설정 페이지다 xml파일 대신에 사용할 수 있다.
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c= new Car();
		//c.setEngine(e);
		return c;
		
	}
	
	@Bean
	public Engine engin() {
		return new Engine();
	}
}
