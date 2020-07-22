package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserController {
	//사용자가 입력한 userform으로 가면 경로를 붙여서 그곳으로 이동
	@RequestMapping(path="/userform", method=RequestMethod.GET)
	public String userform() {
		return "userform";
	}
	
	@RequestMapping(path="/regist",method=RequestMethod.POST)
	public String regist(@ModelAttribute User user) {//dto에서 알아서 넣고 알아서 return할꺼다 
		System.out.println("사용자가 입력한 user 정보입니다 . 해당 정보를 이용하는 코드가 와야한다");
		System.out.print(user);
		return "regist";
	}
}
