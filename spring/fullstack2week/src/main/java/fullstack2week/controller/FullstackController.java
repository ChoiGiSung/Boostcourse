package fullstack2week.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fullstack2week.dto.TodoDto;
import fullstack2week.service.FullStackService;

@Controller
public class FullstackController {

	@Autowired
	FullStackService service;
	
	
	@GetMapping(path ="/list")
	public String list(@ModelAttribute TodoDto dto,
			ModelMap map) {
		
		List<TodoDto> list=service.getlist();
		
		//이제 list3개를 만들어서 다 넣어
		List<TodoDto> Todolist=new ArrayList<TodoDto>();
		List<TodoDto> Doinglist=new ArrayList<TodoDto>();
		List<TodoDto> Donelist=new ArrayList<TodoDto>();
		if(list !=null) {
			
			
			for(TodoDto ex:list) {
				if(ex.getType() !=null) {
					if(ex.getType().equals("todo")) {
						Todolist.add(ex);
					}else if(ex.getType().equals("doing")) {
						Doinglist.add(ex);
					}else if(ex.getType().equals("done")) {
						Donelist.add(ex);
					}
				}
	
			}
		}
		

		
		
		
		map.addAttribute("Todolist",Todolist);
		map.addAttribute("Doinglist",Doinglist);
		map.addAttribute("Donelist",Donelist);
		
		System.out.println("컨트롤러의 list"+list);
		return "list";
	}
	
	@GetMapping(path="/write")
	public String write() {
		return "write";
	}
	
	@PostMapping(path="/writedata")
	public String write(@ModelAttribute TodoDto dto) {
		System.out.print("여기는 컨트롤러"+dto.getName());System.out.print("여기는 컨트롤러"+dto.getTitle());System.out.print("여기는 컨트롤러"+dto.getType());
		
		try {
			TodoDto d=service.addFullStack(dto);
			
			return "redirect:list";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping(path = "/updatepage")
	public String upadte(@RequestParam(name="id",required = true) int id) {
		service.updateFullstack(id);
		return "redirect:list";
	}
	
	@GetMapping(path="/updatedoing")
	public String updatedoing(@RequestParam(name="doing",required =true) int id) {
		service.updatedoingFullstack(id);
		return "redirect:list";
	}
}
