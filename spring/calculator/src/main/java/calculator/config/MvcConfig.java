package calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages =  {"calculator.controller"})
public class MvcConfig implements WebMvcConfigurer{

	//defaultServlet에 대한 설정을 합니다
	//DispatcherServlet이 처리하지 못하는 url은 defaultServlet이 처리하게 됩니다.
	//해당 설정이 없으면 자동 생성된 Swaager페이지를 볼 수 없습니다.
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/*
	 * swagger 사용시에는 docket Bean을 품고 있는 설정 클래스 1개가 기본으로 필요하다.
	 * Spring boot에서는 이 기본적인 설정파일 1개로 swagger와 swagger ui를 함께 사용가능 하지만,
	 * spring mvc의 경우 swaager ui를 위한 별도의 설정이 필요하다.
	 * 이는 , swagge ui를 resourceHandler에 수동으로 등록해야 하는 작업인데,
	 * spring boot에서는 이를 자동으로 설정해주지만 spring mvc에서는 그렇지 않기 때문이다.
	 * */
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any()) // // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
				.paths(PathSelectors.ant("/api/**"))// PathSelectors.any() 를 할경우 모든 경로가 다 사용된다. RestController가 아닌 것 까지 사용된다.
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}
	
	//api info
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("강경미", "https://www.edwith.org", "carami@edwith.org");
		ApiInfo apiInfo =
				new ApiInfo("Swagger Sample", "APIs Sample", "Sample Doc 0.1v", "", contact, "This sentence will be display.", "/");
		return apiInfo;
	}
}
