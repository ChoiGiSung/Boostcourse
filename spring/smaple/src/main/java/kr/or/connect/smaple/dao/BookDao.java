package kr.or.connect.smaple.dao;

import static kr.or.connect.smaple.dao.BookDaoSqls.*;

import java.util.Collections;
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

import kr.or.connect.smaple.dto.BookDto;

@Repository
public class BookDao {
	//Dao 관련 class
	
	private NamedParameterJdbcTemplate jdbc; //이름을 통해 바인딩 등
	private RowMapper<BookDto> rowMapper= BeanPropertyRowMapper.newInstance(BookDto.class);
	
	//insert문
	private SimpleJdbcInsert insertAction;
	
	public BookDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		
		//insert문
		this.insertAction=new SimpleJdbcInsert(dataSource).withTableName("guestbook");
	}
	
	//select해서 가져오는 부분
	public List<BookDto> selectAll(){
		return jdbc.query(SELECT_ALL,Collections.emptyMap(),rowMapper);
	}
	
	//insert문
	public int insert(BookDto bookdto) {
		SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(bookdto);
		return insertAction.execute(parameterSource);
	}
	
	//update문
	public int update(BookDto bookDto) {
		SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(bookDto);
		return jdbc.update(UPDATE,parameterSource);
	}
	
	//select 하나만 가져오기
	public BookDto selectById(Integer id) {
		try {

			Map<String,?> params=Collections.singletonMap("id",id);
			return jdbc.queryForObject(SELECT_BY_BOOK_ID, params,rowMapper);	
		}catch (Exception e) {
			return null;
		}
		}
	
	
	//delete하기
	public int deleteById(Integer id) {
		Map<String,?> params=Collections.singletonMap("id",id);
		return jdbc.update(DELETE_BY_BOOK_ID, params); 
	}
}
