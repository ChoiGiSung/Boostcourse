package gusetbookexam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gusetbookexam.dto.Dto;
import gusetbookexam.service.GuestbookService;

@RestController
@RequestMapping(path="/guestbooks") //이 url로 오면 여기로 와라
public class GuestbookApiController {
//rest컨트롤러 연습 이거는 json형태로 볼 수 있게 크롬 확장 프로그램에서 볼 수 있다
	//같으매핑으로 여러개 실행
	
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping //get으로 오면 이 메서드 실행
	public Map<String,Object> list(@RequestParam(name="start",required = false,defaultValue = "0")int start){
		List<Dto> list = guestbookService.getGuestbooks(start);
		
		int count =guestbookService.getCount();
		int pageCount =count/GuestbookService.LIMIT;
		if(count%GuestbookService.LIMIT >0) {
			pageCount++;
		}
		
		List<Integer> pageStartList=new ArrayList<Integer>();
		for(int i=0;i<pageCount;i++) {
			pageStartList.add(i*GuestbookService.LIMIT);
		}
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("list",list);
		map.put("count",count);
		map.put("pageStartList",pageStartList);
		
		return map;//map 객체를 반환하면 메시지컨버터로인해 json으로 바뀐다
	}
	
	@PostMapping
	public Dto write(@RequestBody Dto dto,
			HttpServletRequest request) {
		String clientIp= request.getRemoteAddr();
		//id가 입력한 guestbook이 반환
		Dto resultdto=guestbookService.addGuestbook(dto, clientIp);
		return resultdto;
	}
	
	@DeleteMapping("/{id}")
	public Map<String,String> delete(@PathVariable(name="id") Long id,
			HttpServletRequest request){
		String clientIp=request.getRemoteAddr();
		
		int deleteCount=guestbookService.deleteGuestbook(id,clientIp);
		return Collections.singletonMap("success",deleteCount>0?"true":"false");
	}
	
}
