package guestbookexample.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guestbookexample.dao.LogDao;
import guestbookexample.dao.UserDao;
import guestbookexample.dto.LogDto;
import guestbookexample.dto.UserDto;
import guestbookexample.service.GuestbookService;

//여러군데서 재사용을 위해
@Service
public class GuestbookServiceImpl implements GuestbookService{

	//서비스 인터페이스 구현

	@Autowired
	UserDao dao;
	
	@Autowired
	LogDao logDao;

	
	@Override
	@Transactional //읽기만 함 
	public List<UserDto> getGuestbooks(Integer start) {
		List<UserDto> list=dao.selectAll(start,GuestbookService.LIMIT);
		return list;
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount =dao.deleteById(id);
		
		LogDto logDto=new LogDto();
		logDto.setIp(ip);
		logDto.setMethod("delete");
		logDto.setRegdate(new Date());
		logDao.insert(logDto);
		
		return deleteCount;
	}

	@Override
	public UserDto addGuestbook(UserDto dto, String ip) {
		dto.setRegdate(new Date());
		int id=dao.insert(dto);
		dto.setId(id);
		
		LogDto logDto=new LogDto();
		logDto.setIp(ip);
		logDto.setMethod("insert");
		logDto.setRegdate(new Date());
		logDao.insert(logDto);
		
		return dto;
	}

	@Override
	public int getCount() {
		return dao.selectCount();
	}
	
	//빈들을 알아서 넣기
	
	
}
