package guestbookexample.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import guestbookexample.dto.LogDto;

@Repository
public class LogDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public LogDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		
		this.insertAction=new SimpleJdbcInsert(dataSource)
				.withTableName("log")
				.usingGeneratedKeyColumns("id");
	}
	
	public Long insert(LogDto log) {
		SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(log);
		return insertAction.executeAndReturnKey(parameterSource).longValue();
	}
}
