package gusetbookexam.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gusetbookexam.dao.Dao;
import gusetbookexam.dao.LogDao;
import gusetbookexam.dto.Dto;
import gusetbookexam.dto.Log;
import gusetbookexam.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService{
	//서비스 인터페이스에서 구현
	
	//dao 사용할꺼니까 bean 자동 등록
	 @Autowired 
	 Dao dao;
	 //알아서 생성해서 주입해준다
	 
	 @Autowired
	 LogDao logDao;
	 
	 
	@Override
	@Transactional //읽기만 함 readonly  
	public List<Dto> getGuestbooks(Integer start) {
		//게스트 북 목록 가져오기 시작부터 몇개
		List<Dto> list =dao.selectAll(start,GuestbookService.LIMIT);
		return list;
	}
	
	@Override
	@Transactional(readOnly = false) //읽기만 하지 않음 해야지만 db에 잘입력됨
	//--> 이 메소드 전체가 성공해야지만 성공 하나라도 오루나면 전부 취소
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount =dao.deleteById(id);
		Log log=new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		
		logDao.insert(log);
		
		return deleteCount;
	}
	@Override
	@Transactional(readOnly = false) //읽기만 하지 않음
	//--> 이 메소드 전체가 성공해야지만 성공 하나라도 오루나면 전부 취소
	public Dto addGuestbook(Dto dto, String ip) {
		dto.setRegdate(new Date());
		int id =dao.insert(dto);
		dto.setId(id);
		
		Log log=new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		
		return dto;
	}
	@Override
	public int getCount() {
		return dao.selectCount();
	}
	
	 
}
