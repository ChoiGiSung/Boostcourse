package fullstack2week.service;

import java.util.List;

import fullstack2week.dto.TodoDto;

public interface FullStackService {

	public List<TodoDto> getlist();
	public int updateFullstack(TodoDto dto);
	public TodoDto addFullStack(TodoDto dto);
}
