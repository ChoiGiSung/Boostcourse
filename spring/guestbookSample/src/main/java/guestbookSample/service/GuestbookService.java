package guestbookSample.service;

import java.util.List;

import guestbookSample.dto.Dto;

public interface GuestbookService {
	//방명록을 저장하기 페이지대로 읽어오기 , 아이디에 해당하는 방명록 삭제등
	
	public static final Integer LIMIT=5;
	public List<Dto> getGuestbooks(Integer start);//북들 목록 읽기
	public int deleteGuestbook(Long id,String ip);//삭제
	public Dto addGuestBook(Dto dto,String ip);//해당 북을 일기
	public int getCount();//몇개인지 얻는 함수

}
