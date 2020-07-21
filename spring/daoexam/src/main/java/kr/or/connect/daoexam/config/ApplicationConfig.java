package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class}) //설정 파일을 여러게로 만들기 -> db관련은 빼기 여기서 dvconfing로 연결된다
@ComponentScan(basePackages ={"kr.or.connect.daoexam.dao"})	//나 컴포넌트 스캔으로 읽어 낼꺼여 자동으로 저장소를 bean에 등록해 줄 꺼다
public class ApplicationConfig {
	//config 설정 파일 class
	
	

}
