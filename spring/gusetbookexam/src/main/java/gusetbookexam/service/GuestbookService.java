package gusetbookexam.service;

import java.util.List;

import gusetbookexam.dto.Dto;

public interface GuestbookService {
	//방명록으 저장하기 페이지대로 읽어오기 ,아이디에 해당하는 방명록삭제 등
	
	public static final Integer LIMIT=5;
	public List<Dto> getGuestbooks(Integer start);
	public int deleteGuestbook (Long id,String ip);
	public Dto addGuestbook(Dto dto,String ip); //ip는 logdao를 통해 table 저장 
	public int getCount();
}
