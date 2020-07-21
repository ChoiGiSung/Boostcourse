package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {

	public static void main(String[] args) {
		//어노테이션을 이용한 설정 파일 읽어 오기 
		//xml을 사용하거나 자바언어를 사용하거나 둘 중 하나 선택
		ApplicationContext ac= new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Car car=(Car)ac.getBean(Car.class);
		car.run();

	}

}
