package kr.or.connect.smaple.dto;

import java.util.Date;

public class BookDto {
	private int id;
	private String name;
	private String content;
	private String regdate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() { //출력을 위한거
		return "BookDto [id=" + id + ", name=" + name + ", content=" + content + ", regdate=" + regdate + "]";
	}
	
	
}
