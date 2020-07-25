package guestbookSample.dao;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import guestbookSample.dto.Dto;
import static guestbookSample.dao.DBSqls.*;

@Repository//디오임 을 알려주기 applicationconfig에서 읽음
public class Dao {
	private NamedParameterJdbcTemplate jdbc;//spring에서 제공하는 쿼리문을 사용위해
	private RowMapper<Dto> rowMapper=BeanPropertyRowMapper.newInstance(Dto.class);
	//반환되어 오는 sql문 받기
	
	//insert문을 쉽게 도와줌
	private SimpleJdbcInsert insertAction;

	public Dao(DataSource dataSource) {//datasource결합하기
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		
		this.insertAction=new SimpleJdbcInsert(dataSource)
				.withTableName("guestbook")
				.usingGeneratedKeyColumns("id");//id값이 알아서 하나씩 늘어나기 위해
	}
	
	//select해서 가져오는 부분
	public List<Dto> selectAll(int start,int limit){//시작과 끝을 받는데 이거는 나중에 페이지에 할당 하기 위해
		Map<String,Integer> params=new HashMap<String, Integer>();
		
		params.put("start",start);
		params.put("limit",limit);
		
		return jdbc.query(SELECT_ALL,Collections.emptyMap(),rowMapper);//(쿼리문을 넣기 ,여기에 널어줘,이 형태로)
	}
	
	//insert문
	public int insert(Dto dto) {
		SqlParameterSource parameterSource=new  BeanPropertySqlParameterSource(dto);
		return insertAction.executeAndReturnKey(parameterSource).intValue();
	}
	
	//delete문
	public int deleteById(Long id) {
		Map<String,?> parMap=Collections.singletonMap("id",id);
		return jdbc.update(DELETE_BY_BOOK_ID, parMap);
	}
	
	//selectCount
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
}
