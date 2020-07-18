<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
hello
<% //! 프로그래밍 코드 기술에 사용
	System.out.print("jspService()");
	//system.out은 콘솔로 out.print는(respone에서 받아옴) 응답결과의 아웃
	
%>


<%! //선언식 메서드나 필드 선언 라이프 사이클에서 따로 선언할떄 사용하면 좋겠다 처음에만 실행or마지막에만 실행
	//전역변수 선언 밋 메소드 선언
	public void jspInit(){
	System.out.print("jspInit()");//서블릿 생명주기 처럼 같다 처음에 service와 init 실행되고
				//새로고침은 service만 후에 내용을 수정하면 destoty후 처음 다시 생성한다.
}
// jsp는 서블릿으로 변환대서 !
public void jspDestroy(){
	System.out.print("jspDestroy()!");
}
%>

<%
	for(int i=0;i<5;i++){	
%>
	<H<%=i %>>아름다운 한글 </H>

<%
}%>


<%
	StringBuffer url= request.getRequestURL();

	out.print("url:"+ url.toString());
	out.print("<br>");
%>
</body>
</html>