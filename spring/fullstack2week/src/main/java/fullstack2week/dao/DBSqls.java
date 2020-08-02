package fullstack2week.dao;

public class DBSqls {

	public static final String SELECT_ALL="select id,title,name,sequence,type,regdate from todo order by regdate DESC";
	//전부 가져오는거 말고 타입 별로 가져오는거
	//타입에는 todo, doing, done을 넣어서
	
	//타입별로 값 가져오기
	public static final String SELECT_TODO="select id,title,name,sequence,type,regdate from todo where type='todo' order by regdate DESC";
	public static final String SELECT_DOING="select id,title,name,sequence,type,regdate from todo where type='doing' order by regdate DESC";
	public static final String SELECT_DONE="select id,title,name,sequence,type,regdate from todo where type='done' order by regdate DESC";
	
	//타입 수정
	public static final String UPDATE_DO_DOING="update todo set type='doing' where id= :id";
	public static final String UPDATE_DOING_DONE="update todo set type='done' where id= :id";
	
	//값 입력은 DOING에만
	//알아서 해준데
	
}
