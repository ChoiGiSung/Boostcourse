package Dto;

import java.util.Scanner; 

public class mainpage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dao dao= new Dao();
		Scanner sc = new Scanner(System.in);
		
		
		
		while(true) {	
			System.out.println("------------------");
			System.out.println("1.명함 입력");
			System.out.println("명함 검색");
			System.out.println("종료");
			System.out.println("------------------");
			System.out.println("메뉴를 입력하세요");
			
			int say=sc.nextInt();
		
			
			switch(say) {
			case 1:
				System.out.println("이름 입력");
				String name=sc.next();
				System.out.println("전번 입력");
				String call=sc.next();
				System.out.println("회사 입력");
				String company=sc.next();
				
				String result=dao.addName(name,call,company);
				System.out.println(result);
				
				break;
			case 2:
				System.out.println("명함 검색");
				
				String search=sc.next();
				dao.getname(search);
				
				break;
			case 3:
				System.out.println("종료");
				
				return;
				
			}
			
		}
		
		
		
		

		
		
		
		
		
		
		
		
	}

}
