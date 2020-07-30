package guestbookexample.dao;


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

import static guestbookexample.dao.DBSqls.*;

import guestbookexample.dto.UserDto;

@Repository
public class UserDao {

	//여기서 정리하고 list에서 뽑고 wirte에서 넣고
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<UserDto> rowMapper= BeanPropertyRowMapper.newInstance(UserDto.class);
	
	private SimpleJdbcInsert insertAction;
	
	public UserDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		
		this.insertAction=new SimpleJdbcInsert(dataSource)
				.withTableName("guestbook")
				.usingGeneratedKeyColumns("id");
	}
	
	//select해서 가져오는 부분
	public List<UserDto> selectAll(Integer start,Integer limit){
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("start",start);
		map.put("limit",limit);
		return jdbc.query(SELECT_ALL, map,rowMapper);
	}
	
	//insert문
	public int insert(UserDto dto) {
		SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(dto);
		return insertAction.executeAndReturnKey(parameterSource).intValue();
		//알아서 숫자를 늘려주는 부분
	}
	
	//딜리트
	public int deleteById(Long id) {
		Map<String,?> params=Collections.singletonMap("id",id);
		return jdbc.update(DELETE_BY_BOOK_ID,params);
	}
	
	//셀렉트 카운트
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(),Integer.class);
	}
}
