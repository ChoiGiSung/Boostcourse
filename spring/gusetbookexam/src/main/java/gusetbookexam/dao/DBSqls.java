package gusetbookexam.dao;

public class DBSqls {
	//dao sql관련 class
	//쿼리문 작성
	
	public static final String SELECT_ALL="select id,name,content,regdate from guestbook order by id DESC limit :start, :limit";
	public static final String UPDATE="update guestbook set name= :name where id= :id";
	public static final String DELETE_BY_BOOK_ID="delete from guestbook where id= :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";

}
