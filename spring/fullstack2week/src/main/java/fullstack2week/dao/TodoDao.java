package fullstack2week.dao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import fullstack2week.dto.TodoDto;
import static fullstack2week.dao.DBSqls.*;

@Repository
public class TodoDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper <TodoDto> rowMapper=BeanPropertyRowMapper.newInstance(TodoDto.class);
	
	
	public TodoDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
	
		insertAction=new SimpleJdbcInsert(dataSource)
				.withTableName("todo")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<TodoDto> selectAll(){
		//if로 타입 별로 셀렉트
		return jdbc.query(SELECT_ALL,rowMapper) ;
	}
	
	//값 넣기
	public int insert(TodoDto dto) {
		System.out.print("여기는 dao"+dto.getName());System.out.print("여기는 dao"+dto.getTitle());System.out.print("여기는 dao"+dto.getType());
		try {
			SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(dto);
			return insertAction.executeAndReturnKey(parameterSource).intValue();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//엡데이트
	public int updateTodo(TodoDto dto) {
		Map<String,?> map=Collections.singletonMap("id",dto.getId());
		if(dto.getType().equals("todo")) {
			return jdbc.update(UPDATE_DO_DOING,map);
		}else if(dto.getType().equals("doing")){
			return jdbc.update(UPDATE_DOING_DONE,map);
		}
		
		//바꾸고자하는거의 타입이 todo였으면 두잉으로 ,두잉이였으면 던으로
		
		return 0;
	}
	
	
}
