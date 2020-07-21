package kr.or.connect.daoexam.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.daoexam.dto.Role;

//클래스 구분없이 바로 사용가능하게 import시키기
import static kr.or.connect.daoexam.dao.RoleDaoSqls.*;

@Repository //dao에는 저장소라는 개념이 붙는다
public class RoleDao {
	//Dao 관련 class
	
	private NamedParameterJdbcTemplate jdbc;//이름을 통해 바인딩 등
	private RowMapper <Role> rowMapper =BeanPropertyRowMapper.newInstance(Role.class);

	//inset문
	private SimpleJdbcInsert insertAction;
	
	public RoleDao(DataSource dataSource) {
		this.jdbc=new NamedParameterJdbcTemplate(dataSource);
		
		this.insertAction=new SimpleJdbcInsert(dataSource).withTableName("role");
		
	}
	
	//select해서 가져오는 부분
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
		//( static import로 select all 가져오기,빈 맵, 위에 만든 맵{돌아온 값을 저장하는 맵})
		//sql에 바인딩할 값이 있을 경우에 이 바인딩할 값을 전달할 목적을 가진 객체이다,
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
	}
	public int update(Role role) {
		SqlParameterSource params=new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
}
