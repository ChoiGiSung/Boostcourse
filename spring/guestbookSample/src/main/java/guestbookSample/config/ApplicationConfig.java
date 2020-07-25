package guestbookSample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//런타임시 실행되는 파일 web에서 설정해줘서 그래

@Configuration//설정 파일이야
@ComponentScan(basePackages = {"guestbookSample.dao","guestbookSample.service"})//여기서 한번 스캔해봐 빈이랑 뭐 있어
@Import({DBConfig.class})//디비 관련 설정도 있어
public class ApplicationConfig {

}
