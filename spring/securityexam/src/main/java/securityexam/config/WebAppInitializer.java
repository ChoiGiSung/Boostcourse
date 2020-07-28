package securityexam.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	//스프링에서 web은 web.xml을 가장 먼저 읽는다
	//web.xml을 대신해서 사용가능 
	
	
	//spring config파일을 설정한다
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {ApplicationConfig.class,SecurityConfig.class}; //리턴값으로 설정파일을 주면 이걸 읽어서 설정한다
	}
	//spring config파일을 설정한다
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {MvcConfig.class};
	}
	
	
	/*
	 *getServletMappings은 디스패쳐 서블릿이 매핑되기 위한 하나의 혹은 여러개의 패스를 지정한다
	 *위의 코드에서는 애플리케이션 기본 서블릿인 / 에만 매핑이 되어 있다  그리고 이것은  애플리케이션으로 들어오는 모든 요청을 처리한다
	 *원래 서블릿에서는 /을 처리하는 디스패쳐서블릿이 설정되어있었다*/

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	
	/*필터를 설정한다 /디스패쳐 서블릿앞에서 동작하는 필터*/
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter=new  CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
	

}
