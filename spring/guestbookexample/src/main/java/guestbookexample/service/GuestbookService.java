package guestbookexample.service;

import java.util.List;

import guestbookexample.dto.UserDto;

//서비스는 여러곳에 사영되기 위해 작성함
public interface GuestbookService {
	//방명록을 저장하기 페이지대로 읽어오기 , 아이디에 해당하는 방명록 삭제등
	
	public static final Integer LIMIT=5;
	public List<UserDto> getGuestbooks(Integer start);//함수
	public int deleteGuestbook(Long id,String ip);
	public UserDto addGuestbook(UserDto dto,String ip);
	public int getCount();
	
}
