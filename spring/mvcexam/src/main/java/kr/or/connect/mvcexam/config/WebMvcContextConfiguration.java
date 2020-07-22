package kr.or.connect.mvcexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration //난 설정파일
@EnableWebMvc //기본적인 설정은 여기 해주셈
@ComponentScan(basePackages = {"kr.or.connect.mvcexam.controller"}) // 이 패키지 안에 컨트롤러 붙어있는거 알아서 스캔해
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	//디스페쳐 서블릿이 실행될때 읽는 설정 파일

	//요청중에 /asset밑에 뭐뭐뭐 여기서 찾아라
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
        
	}

	//매핑 정보가 없으면 디폴드 서블릿 핸들러를 사용하게 선언
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	//특정 url에 대한 컨트롤러를 작성하지 않고 매핑할 수 있게 해주는거
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.println("addViewControllers가 호출됩니다");
		// /라고 들어오면 main으로 가라
		registry.addViewController("/").setViewName("main");
		
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver=new  InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		//addViewControllers 에서 main앞에 prefix를 붙이고 뒤에 suffix를 붙야줘
		
		return resolver;
	}
	
	
	
	
	
}
