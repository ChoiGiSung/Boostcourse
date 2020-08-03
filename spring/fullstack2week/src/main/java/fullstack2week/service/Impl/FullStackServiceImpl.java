package fullstack2week.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import fullstack2week.dao.TodoDao;
import fullstack2week.dto.TodoDto;
import fullstack2week.service.FullStackService;

@Service
public class FullStackServiceImpl implements FullStackService{
	
	@Autowired
	TodoDao dao;
	
	@Override
	@Transactional
	public List<TodoDto> getlist() {

			List<TodoDto> list=dao.selectAll();
			if(list ==null) {
			}
			return list;
	}

	@Override
	@Transactional(readOnly = false)
	public int updateFullstack(int id) {
		dao.updateTodo(id);
		return 0;
	}
	
	
	@Override
	@Transactional(readOnly = false)
	public int updatedoingFullstack(int id) {
		dao.updateToding(id);
		return 0;
	}

	@Override
	@Transactional(readOnly = false)
	public TodoDto addFullStack(TodoDto dto) {
		System.out.print("여기는 서비스"+dto.getName());System.out.print("여기는 서비스"+dto.getTitle());System.out.print("여기는 서비스"+dto.getType());
		
		try {
			dto.setRegdate(new Date());
			dto.setType("todo");
			int id=dao.insert(dto);
			dto.setId(id);
			return dto;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	
	
	
	
}
