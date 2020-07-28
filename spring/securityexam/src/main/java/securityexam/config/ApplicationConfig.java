package securityexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//레이어드 아키테쳐에서 controller가 사용하는 bean에 대해 설정을 한다
//dao, service를 컴포넌트 스캔하며 찾도록 한다.
//어노테이션으로 트랜젝션을 관리하기 위해 @EnableTransactionManagement을 설정한다.

@Configuration
@ComponentScan(basePackages = {"securityexam.dao","securityexam.servicec"})
//스캔해서 봤는데 거기에 @레퍼지토리 ,@서비스 이런게 있으면 자동으로 빈으로 설정해줌
public class ApplicationConfig {

}
