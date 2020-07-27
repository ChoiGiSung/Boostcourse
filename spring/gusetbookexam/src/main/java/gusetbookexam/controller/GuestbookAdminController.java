package gusetbookexam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GuestbookAdminController {
	@GetMapping(path="/loginform")
	public String loginform() {
		
		return "loginform";
	}
	
	@PostMapping(path = "/login")
	public String login(@RequestParam(name="passwd",required = true)String passwd,
			HttpSession session,
			RedirectAttributes reAttributes) {
		
		if("1234".equals(passwd)) {
			session.setAttribute("isAdmin", "true");
		}else {
			//디스패쳐 서블릿의 플래쉬맵에 저장됨
			reAttributes.addFlashAttribute("errorMessage","암호가 틀렸스빈다");//redirect할때 딱 한번만 값을 유지할때 사용
			return "redirect:/loginform";
			//redirect는 요청을 2번하는것->에러메시지 값을 가지고 갈 수 있다 ,forword는 세션을 이용하거나 리퀘스트 이용
		}
		
		
		return "redirect:/list";
	}
	
	@GetMapping(path = "/logout")
	public String login(HttpSession session) {
		session.removeAttribute("isAdmin");
		return "redirect:/list";
	}
}
