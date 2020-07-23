package gusetbookexam.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import gusetbookexam.dto.Log;


@Repository
public class LogDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	public LogDao(DataSource dataSource) {
		this.jdbc =new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("log").usingGeneratedKeyColumns("id");
		//using 부분은 아이디가 자동으로 입력되는 부분
	}
	
	public Long insert(Log log) {
		SqlParameterSource params=new BeanPropertySqlParameterSource(log);
		return insertAction.executeAndReturnKey(params).longValue();
		//인서트문을 내부적으로 생성해서 실행하고 자동으로 생성된 id를 리턴한다
	}
}
