package gusetbookexam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
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
			ModelMap model
		//	,HttpServletRequest request//쿠키를 위해 HttpSErvletRequest ,HttpSErvletResponse 추가
			,@CookieValue(value = "count",defaultValue = "0",required = true) String value//spring 어노테이션을 사용하면 아주 간편해짐
			,HttpServletResponse response) {
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
		
		
		
		//쿠기 관련
		/*어노테이션 사용으로 인해 삭제
		 * String value=null;
		boolean find=false;
		Cookie[] cookies=request.getCookies();
		if(cookies !=null) {
			for(Cookie cookie:cookies) {
				if("count".equals(cookie.getName())) {
					find=true;
					value=cookie.getValue();
				}
			}
		}
		*/
		
		/*
		 * 어노테이션 사용으로 인해 삭제
		if(!find) {
			value="1";
		}else {//쿠키를 찾았다면,
		*/
			try {
				int i=Integer.parseInt(value);
				value=Integer.toString(++i);
			}catch (Exception e) {
				value="1";
			}
			/*
			 * 어노테이션 사용으로 인해 삭제
		}
		*/
		Cookie cookie=new  Cookie("count", value);
		cookie.setMaxAge(60*60*24*365);//1년동안 유지
		cookie.setPath("/");// /경로 이하에 모두 쿠키 적용
		response.addCookie(cookie);
		
		//쿠키관련 끝
		
		//jsp에서 사용하기위해 모델에 값 넣기및 리스트로 이동
		model.addAttribute("list",list);
		model.addAttribute("count",count);
		model.addAttribute("pageStartList",pageStartList);
		model.addAttribute("cookieCount",value);
		
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
