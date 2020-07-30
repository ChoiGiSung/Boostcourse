package guestbookexample.dao;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import guestbookexample.config.ApplicationConfig;
import guestbookexample.dto.UserDto;
import guestbookexample.service.GuestbookService;

public class UserDaoTest {
	public static void main(String[] args) {

		
		ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
			UserDao dao=ac.getBean(UserDao.class);
//		
//		UserDto dto=new UserDto();
//		dto.setName("샘플");	
//		dto.setContent("반갑2");
//		dto.setRegdate(new Date());
//		int id=dao.insert(dto);
//		System.out.println("id :"+id);
//		
//		
		
		GuestbookService guestbookService=ac.getBean(GuestbookService.class);
		
		UserDto dto=new UserDto();
		dto.setName("기성");
		dto.setContent("ㅎㅇ");
		dto.setRegdate(new Date());
		
		UserDto reslut=guestbookService.addGuestbook(dto,"127");
		System.out.println(reslut);
	}
	
	
}
