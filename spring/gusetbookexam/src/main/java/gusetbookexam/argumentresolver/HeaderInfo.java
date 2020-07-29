package gusetbookexam.argumentresolver;

import java.util.HashMap;
import java.util.Map;
//http 요청 헤더 정보를 보려고


//헤더의 정보를 담자
public class HeaderInfo {
	//맵을 직접사용 못해서 필드로 생성
	private Map<String, String>map;
	
	public HeaderInfo() {
		map=new HashMap<String, String>();
	}
	
	public void put(String name,String value) {
		map.put(name,value);
	}
	
	public String get(String name) {
		return map.get(name);
	}
}
