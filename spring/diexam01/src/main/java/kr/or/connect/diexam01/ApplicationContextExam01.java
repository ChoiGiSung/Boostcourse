package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		//src밑에 applicationContext 설정파일을 사용할 객체 만들기
		
		ApplicationContext ac= new  ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화 완료");
		
		UserBean userBean = (UserBean)ac.getBean("userBean"); //설정파일에 userbean이라는 객체가 생성되어 있어서 그거 꺼내오는거  다른거 쓰러면 id를 다르게 다시 만들어야함
		userBean.setName("kang");
		
		System.out.println(userBean.getName());
	
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
	
		if(userBean == userBean2) {
			System.out.println("같은 인스턴스 싱글톤 패턴을 이용하기 때문에");
			System.out.println(userBean2.getName());
			
			//이렇게 객체를 대신 생성 , 싱글톤으로 대신 관리해주는게  컨테이너고 이걸 ioc라고 한다 (제어의 역전)
		}
	}

}
