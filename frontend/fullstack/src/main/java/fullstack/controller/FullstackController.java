package fullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FullstackController {

	@GetMapping(path = "/main")
	public String main() {
		return "main";
	}
	
	@GetMapping(path = "selfview")
	public String selfview() {
		return "selfview";
	}
	
	@GetMapping(path = "/picture")
	public String picture() {
		return "picture";
	}
}
