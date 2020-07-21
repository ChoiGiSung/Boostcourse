package kr.or.connect.daoexam.dto;

public class Role {
	//dto 관련 class
	private int roleId;
	private String description;
	
	//내가 db가 없어서 그렇네 role이라는 dv가
	
	
	public int getRoldID() {
		return roleId;
	}
	public void setRoldID(int roldID) {
		this.roleId = roldID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() { //실제 객체가 가진 값들을 문자열로 한번에 편하게 보게하려고 오버라이드
		return "Role [roldID=" + roleId + ", description=" + description + "]";
	}
}
