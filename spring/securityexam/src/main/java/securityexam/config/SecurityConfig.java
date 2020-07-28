package securityexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//로그인 로그아웃 인가 등을 스프링 시큐리티를 사용하기 위한 클래스

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//인증,인가가 필요없는 페이지를 불를때 
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**");
	}
	
	
	//인증,인가에 대한 설정을 하겠다
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http	//포스트방식으로 설정하는 보안설정 csrf ->보안은 높지만 개발초기에는 잘안씀
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/","/main").permitAll()//이경로는 누구나 접근가능
				.anyRequest().authenticated();//그 이외는 인증.인가를 받아야해
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();//입력한 암호와 설정된 암호가 맞는지
	}
	
	

	
}
