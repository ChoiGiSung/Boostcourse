package gusetbookexam.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {
	
	//log예제
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	
	//인터셉터는 다 작성하고나서 등록해야함 web config에
	
	//컨트롤러의 메소드가 실행되고 나서 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("{} 가 종료 되었스빈다.{} 를 view로 사용합니다",handler.toString(),modelAndView.getViewName());
		//System.out.println(handler.toString()+"가 종료되었습니다."+modelAndView.getViewName()+"을 view로 사용합니다");
	}

	
	//컨트롤러 메소드가 실행되기 전에 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.debug("{} 를 호출했다",handler.toString());
		
		//System.out.println(handler.toString()+"를 호출 했스빈다.");
		return true;
	}
	
	//


	
	
}
