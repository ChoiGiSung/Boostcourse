package guestbookSample.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guestbookSample.dao.Dao;
import guestbookSample.dao.LogDao;
import guestbookSample.dto.Dto;
import guestbookSample.dto.LogDto;

@Service//여긴 서비스야
public class GuestbookServicempl implements GuestbookService{
	//서비스 인터페이스 구현
	
	//bean 자종 등록해라
	@Autowired
	Dao dao;
	
	@Autowired
	LogDao logDao;
	
	
	@Override
	@Transactional //읽기만 할껴
	public List<Dto> getGuestbooks(Integer start) {
		//게스트 북 목록을 가져오기 시작 값도 줘야함
		List<Dto> list = dao.selectAll(start,GuestbookService.LIMIT);
		return list;//리스트 돌려주기
	}

	//값 삭제하기
	@Override
	@Transactional(readOnly = false) //읽기만 하지 않음 모두 완료해야지만 db에 잘입력됨
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount=dao.deleteById(id);
		
		//로그테이블에 값 넣기
		LogDto logDto=new LogDto();
		logDto.setIp(ip);
		logDto.setMethod("delete");
		logDto.setRegdate(new Date());
		logDao.insert(logDto);
		
		return deleteCount;
	}

	//값 널어주기
	@Override
	@Transactional(readOnly = false) //읽기만 하지마
	public Dto addGuestBook(Dto dto, String ip) {
		dto.setRegdate(new Date());
		int id=dao.insert(dto);
		dto.setId(id);
		
		//로그 찍기
		LogDto logDto=new LogDto();
		logDto.setIp(ip);
		logDto.setMethod("insert");
		logDto.setRegdate(new Date());
		logDao.insert(logDto);
		
		return dto;
	}

	//총 몇개야
	@Override
	public int getCount() {
		return dao.selectCount();
	}

	
}
