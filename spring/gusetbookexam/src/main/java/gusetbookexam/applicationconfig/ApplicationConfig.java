package gusetbookexam.applicationconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration//설정파일
@ComponentScan(basePackages = {"gusetbookexam.dao","gusetbookexam.service"})
@Import({DBConfig.class})
public class ApplicationConfig {
	//다오나 서비스 서비스에 구현된 컴포넌트를 읽어옴 이것들이 내부적으로 실행될때 디비를 컴피그 해야해서 임포트함
}
