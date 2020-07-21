package kr.or.connect.daoexam.dao;

public class RoleDaoSqls {
	//dao sql관련 class
	//쿼리문 작성
	
	public static final String SELECT_ALL="select role_id, description from role order by role_id";
	public static final String UPDATE="update role set description = :description where role_id = :roleId";
}
