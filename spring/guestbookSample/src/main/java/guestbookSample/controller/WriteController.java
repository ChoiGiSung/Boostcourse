package guestbookSample.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import guestbookSample.dto.Dto;
import guestbookSample.service.GuestbookService;

@Configuration //설정 파일이야
public class WriteController {

	
	//서비스 사용할꺼야
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path="/list")//리스트라고 들어오면
						//리퀘스트에 start라는걸 받아 required는 false-> 꼭 있어야하는건 아니야
	public String list(@RequestParam(name="start",required = false,defaultValue = "0") int start
			,ModelMap modelMap) {//다 하고 나서 값은 model에 넣을 꺼야 request랑 연결된 통로임
		
		//서비스의 겟북을 쓰자->서비스는 dao의 selectAll을 씀
		List<Dto> list=guestbookService.getGuestbooks(start);
		
		//전체 페이지 수 구하기
		int count=guestbookService.getCount();
		int pageCount=count/GuestbookService.LIMIT;
		if(count%GuestbookService.LIMIT >0) {
			pageCount++;
		}
		
		//페이지 수 만큼 start의 값을 리스트로 저장
		//예를 들면 페이지수가 3이면 
		//0 5 10 이렇게 저장된다
		//list?start=0 5 10 을 링크가 걸린다
		List<Integer> pageStartList=new ArrayList<Integer>();
		for(int i=0;i<pageCount;i++) {
			pageStartList.add(i*GuestbookService.LIMIT);
		}
		
		//jsp에서 사용하기 위해 모델에 값 넣기 및 리스트로 이동
		modelMap.addAttribute("list",list);
		modelMap.addAttribute("count",count);
		modelMap.addAttribute("pageStartList",pageStartList);
		//->리스트로 들어오면 modelmap을 넘겨주는데 그게 requset에서 빼서 볼 수 있다
		
		
		return "list";
	}
	
	@PostMapping(path="/write")
	public String write(@ModelAttribute Dto dto, HttpServletRequest request) {
		String clientIp=request.getRemoteAddr();
		guestbookService.addGuestBook(dto,clientIp);
		
		return "redirect:list";
	}
	
}
