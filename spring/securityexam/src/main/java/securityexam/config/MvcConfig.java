package securityexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc //스프링 mvc설정에는 반드시 있어야함
@ComponentScan(basePackages = {"securityexam.controller"})
public class MvcConfig implements WebMvcConfigurer{
	private final int MAX_SIZE=10*1024*1024;


	
	
	//default servlet 핸들러를 설정한다
	//원래 서블릿은 / (모든 요청)을 처리하는 default servlet을 제공한다. 스플리에서 설정힌 path는 스프링이
	//처리하고, 스프링이 처리하지 못한 경로에 대한 처리는 디폴트 서블릿에게 전닿하여 처리하게 된다
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}


	//spring mvc에서 jsp view가 위치하는 경로를 설정한다
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/",".jsp");
	}


	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/","/main");
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
	
	
}
