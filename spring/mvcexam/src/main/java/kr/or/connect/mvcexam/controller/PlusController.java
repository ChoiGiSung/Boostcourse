package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //컨트롤러는 붙여야하
public class PlusController {
	
	//겟으로 들어오면 -> 너가 직접 url을 치면 -> 친게 뒤에 plusform이면 return으로 plusForm을 주고 
	//설정 파일에서 getInternalResourceViewResolver 가 앞뒤에 붙여서 위치를 찾아 줄 꺼야
	@GetMapping(path="/plusform")
	public String plusform() {
		return "plusForm"; //요청이 들어오면 이 이름이 있는 곳으로가 아까처럼 앞에 뭐 붙이고 뒤에 .jsp붙야서가
		
	}
	
	@PostMapping(path="/plus")// url이 plus이면 이걸 실행해
	public String plus(@RequestParam(name = "value1", required = true) int value1,
			@RequestParam(name="value2", required = true)int value2, ModelMap modelMap) {
		int result=value1+value2;
		
		modelMap.addAttribute("value1",value1);
		modelMap.addAttribute("value2",value2);
		modelMap.addAttribute("result",result);
		return "plusResult"; //getInternalResourceViewResolver로간다
	}
	
}
