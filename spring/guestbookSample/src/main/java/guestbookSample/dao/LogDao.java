package guestbookSample.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import guestbookSample.dto.LogDto;

@Repository
public class LogDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public LogDao(DataSource dataSource) {
		this.jdbc=new  NamedParameterJdbcTemplate(dataSource);
		this.insertAction=new SimpleJdbcInsert(dataSource)
				.withTableName("log")
				.usingGeneratedKeyColumns("id");
	}
	
	public Long insert(LogDto logDto) {
		SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(logDto);
		return insertAction.executeAndReturnKey(parameterSource).longValue();
		//인서트 문을 내부적으로 생성해서 실행하고 생성된 id를 리턴한다 
	}
}
