package kr.or.connect.smaple.main;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.smaple.config.ApplicationConfig;
import kr.or.connect.smaple.dao.BookDao;
import kr.or.connect.smaple.dto.BookDto;

public class Test {

	public static void main(String[] args) {
		//db커넥션이 잘되는지 알아보는 class
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		//	방벙!)
		//pom.xml에 버전, 스프링 등록하기 sql문 작성하기 config 설정하기 dao에 해당 메소드 작성하기(static import시키기)
		//메인에서 어플 컨텍스트로 ac읽어오고 ac에서 getbean으로 클래스 읽어오기 <- 읽어오려면 각종 어노테이션 해야함
		
		
		
		
		
		//select문 하나만 가져오기 
		BookDao bookDao=ac.getBean(BookDao.class);
		BookDto bookDto= bookDao.selectById(1);
		System.out.print(bookDto);
		
		
		
		
		
//		//delete문
//		BookDao bookDao=ac.getBean(BookDao.class);
//
//		int count =bookDao.deleteById(70);
//		System.out.print(count+"삭제");
			
		
//		//update문
//		BookDao bookDao = ac.getBean(BookDao.class);
//		
//		BookDto bookDto=new BookDto();
//		
//		bookDto.setId(70);bookDto.setName("업데이트완료");
//		
//		int count=bookDao.update(bookDto);
//		System.out.print(count+"업데이트 ");
//		
		
		
//		//insert 문
//		BookDao bookDao=ac.getBean(BookDao.class);
//		
//		BookDto bookDto=new BookDto();
//		bookDto.setId(0);bookDto.setName("마운틴");bookDto.setContent("내용");bookDto.setRegdate("2009-12-31 15:12:23");
//		int count=bookDao.insert(bookDto);
//		System.out.println(count+"올리기 성공");
		
		
		
		
		//select all 문
//		BookDao bookDao=ac.getBean(BookDao.class); 
//		
//		//selectAll
//		List<BookDto> list=bookDao.selectAll();
//		
//		for(BookDto book:list) {
//			System.out.println(book);
//		}
		
		
		
		
//		//확인 절차
//		
//		DataSource ds=ac.getBean(DataSource.class); //데이타 소스를 사용하는 빈을 쓰겠다
		
		
//		Connection conn=null;
//		
//		try {
//			conn=ds.getConnection();
//			if(conn != null) {
//				System.out.println("접속중");
//			}
//		} catch (Exception e) {}finally {
//			if(conn !=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		
		
		
	}

}
