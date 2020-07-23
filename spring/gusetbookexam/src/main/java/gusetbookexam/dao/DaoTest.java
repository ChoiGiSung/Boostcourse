package gusetbookexam.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gusetbookexam.applicationconfig.ApplicationConfig;
import gusetbookexam.dto.Dto;
import gusetbookexam.service.GuestbookService;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		
		
		//Dao dao=ac.getBean(Dao.class);
//		Dto dto=new Dto();
//		
//		dto.setName("강경미2");
//		dto.setContent("반갑2");
//		dto.setRegdate(new Date());
//		int id=dao.insert(dto);
//		System.out.println("id :"+id);

//		LogDao logDao= ac.getBean(LogDao.class);
//		Log log=new Log();
//		log.setIp("127.0.0.1");
//		log.setMethod("insert");
//		log.setRegdate(new Date());
//		logDao.insert(log);
//		//레이어드 아키텍쳐 중 레퍼지토리 레이어쪽 작성한거다 service작성 전임
		
		
		//서비스를 통한 값 넣기
		GuestbookService guestbookService=ac.getBean(GuestbookService.class);
		
		Dto dto=new  Dto();
		dto.setName("최기성");
		dto.setContent("ㅎㅇ");
		dto.setRegdate(new Date());
		
		Dto result=guestbookService.addGuestbook(dto, "127.0.0.1");
		System.out.println(result);
		
		
	}
}
