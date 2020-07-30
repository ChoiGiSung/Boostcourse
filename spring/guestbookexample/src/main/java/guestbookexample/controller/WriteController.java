package guestbookexample.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import guestbookexample.dto.UserDto;
import guestbookexample.service.GuestbookService;

	

@Controller
public class WriteController {

	@Autowired
	GuestbookService guestbookService;
	
	@GetMapping(path = "/list")
	public String list(@RequestParam(name="start",required = false,defaultValue = "0")int start,
		ModelMap map) {
		
		//start로 시작하는 방명록 구하기
		List<UserDto> list=guestbookService.getGuestbooks(start);
		
		//전체 페이지수 구하기
		int count=guestbookService.getCount();
		int pageCount=count/GuestbookService.LIMIT;
		if(count%GuestbookService.LIMIT >0) {
			pageCount++;
		}
		
		List<Integer> pageStartList=new ArrayList<Integer>();
		for(int i=0;i<pageCount;i++) {
			pageStartList.add(i*guestbookService.LIMIT);
		}
		
		map.addAttribute("list",list);
		map.addAttribute("count",count);
		map.addAttribute("pageStartList",pageStartList);
		map.addAttribute("list",list);
		
		return "list";
	}
	
	@PostMapping(path="/write")
	public String write(@ModelAttribute UserDto dto,
			HttpServletRequest request) {
		String clientIp=request.getRemoteAddr();
		guestbookService.addGuestbook(dto,clientIp);
		return "redirect:list";
	}
	
	@GetMapping(path = "/delete")
	public String delete(@RequestParam(name = "id",required = true)Long id,
			HttpServletRequest request,
			RedirectAttributes reAttributes) {
		String clientIp=request.getRemoteAddr();
		guestbookService.deleteGuestbook(id,clientIp);
		return "redirect:list";
	}
	
}
