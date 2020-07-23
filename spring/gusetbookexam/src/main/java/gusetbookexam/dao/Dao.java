package gusetbookexam.dao;

import static gusetbookexam.dao.DBSqls.*;

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

import gusetbookexam.dto.Dto;

@Repository
public class Dao {
	//여기서 정리하고 list에서 뽑고 write에서 넣고
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Dto> rowMapper = BeanPropertyRowMapper.newInstance(Dto.class);


	//insert문
	private SimpleJdbcInsert insertAction;
	
	public Dao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		
		this.insertAction=new SimpleJdbcInsert(dataSource)
				.withTableName("guestbook")
				.usingGeneratedKeyColumns("id");
		
	}
	
	//select해서 가져오는 부분
	public List<Dto> selectAll(Integer start,Integer limit){
		Map<String,Integer> params =new HashMap<>();
		params.put("start",start);
		params.put("limit",limit);
		return jdbc.query(SELECT_ALL,params,rowMapper);
	}
	
	//insert
	public int insert(Dto dto) {
		SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(dto);
		return insertAction.executeAndReturnKey(parameterSource).intValue();
		//알아서 숫자를 늘려주는 부분
	}
	
	//delete
	public int deleteById(Long id) {
		Map<String,?> params=Collections.singletonMap("id",id);
		return jdbc.update(DELETE_BY_BOOK_ID,params);
	}
	
	//selectCount
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT,Collections.emptyMap(),Integer.class);
	}
	
	
}
