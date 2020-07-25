package guestbookSample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//디스페쳐 서블릿 web.xml에서 정의한 url에서 /이 들어오면 디퐆트로 여기 클래스를 읽음

@Configuration //설정 파일
@EnableWebMvc //web에 관한 기본 설정
@ComponentScan(basePackages = {"guestbookSample.controller"})//여기서 스캔한번해서 읽어봐
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter{//web에대해 좀더 설정할게 있어

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	     registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
	     registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
	     registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
	     registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}

	
	//기본 핸들러 사용할꺼야
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}


	//특정 url에 대한 컨트롤러를 작성하지 않고 매핑할 수 있게 해줌 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.print("addViewController가 호출");
		registry.addViewController("/").setViewName("index");
	}
	//여기서 setViewName은 resolver를 사용함
	
	@Bean
	public InternalResourceViewResolver getResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		//들어오는 값에 앞뒤에 붙이기
		
		return resolver;
	}
	
	
	
	

	
	

}
