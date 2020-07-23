package gusetbookexam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gusetbookexam.dto.Dto;
import gusetbookexam.service.GuestbookService;


//설정 파일로 가서 거기서 함수를 만나서 경로타고 jsp로 간다
@Controller
public class WriteController {
//	@RequestMapping(path="/write", method=RequestMethod.POST)
//	public String write(@ModelAttribute Dao dao) {
//		System.out.println("t사용자가 입력한거");
//		System.out.println(dao);
//		
//		return "write";
//	}
	
	//서비스 사용
	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path="/list")
	public String list(@RequestParam(name="start",required = false,defaultValue = "0")int start,
			ModelMap model) {
		System.out.print("controller의 list");
		//start로 시작하는 방명록 목록 구하기
		List<Dto> list=guestbookService.getGuestbooks(start);
		
		//전체 페이지수 구하기
		int count =guestbookService.getCount();
		int pageCount=count/GuestbookService.LIMIT;
		if(count%GuestbookService.LIMIT >0) {
			pageCount++;
		}
		
		//페이지 수만큼 start의 값을 리스트로 저장
		//예를 들면 페이지수가 3이면
		//0,5,10 이렇게 저장된다
		//list?start=0. list?start=5,list?start=10 을 링크가 걸린다.
		List<Integer> pageStartList=new ArrayList<>();
		for(int i=0;i<pageCount;i++) {
			pageStartList.add(i*GuestbookService.LIMIT);
		}
		
		//jsp에서 사용하기위해 모델에 값 넣기및 리스트로 이동
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		model.addAttribute("pageStartList",pageStartList);
		
		return "list";
	
	}
	
	@PostMapping(path="/write")
	public String write(@ModelAttribute Dto dto,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp:"+clientIp);
		guestbookService.addGuestbook(dto,clientIp);
		return "redirect:list";
	}
	
	
	}
