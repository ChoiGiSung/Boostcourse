package gusetbookexam;

import java.util.Iterator;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import gusetbookexam.argumentresolver.HeaderInfo;

public class HeaderMapArgumentResolver implements HandlerMethodArgumentResolver {


	//supports가 true를 반환할때만 호출됨
	//resolver메서드가 리턴한 값은 컨트롤러 메소드의 인자로 전달
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HeaderInfo headerInfo=new HeaderInfo();
		
		Iterator<String> headerNames=webRequest.getHeaderNames();
		while (headerNames.hasNext()) {
			String headerName=headerNames.next();
			String headerValue=webRequest.getHeader(headerName);
			
			System.out.println(headerName+","+headerValue);
			
			headerInfo.put(headerName, headerValue);
		}
		
		return headerInfo;
	}
	
	//컨트롤러 메소드의 인자가 4개면 4번 호출됨
	//해당 인자에 원하는 파라메터가 있다면 true를 반환
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType()==HeaderInfo.class;
	}


}
