<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> <!-- 페이지 지시문 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	int total = 0;
	for(int i=1; i<= 10; i++){
		total = total + i;
	}
%>
1부터 10까지의 합<%=total %> <!-- 서블릿으로 바꾸면 -> out.print(total) -->
			<!-- jsp는 서블릿으로 변환이 된다 -> 파일경로를 찾아보면 위의 %=는 out.print로 변환이 된다
			 -->
	<!-- .metadate 폴더 밑에 jsp가 .java 파일로 바뀌어서 생성됨 
	1.브라우저가 웹서버에 jsp에 대한 요청 정보를 전달한다.
	2.브라우저가 요청한 jsp가 최초로 요청했을 경우만
	
		1.) jsp로 작성된 코드가 서블릿으로 코드로 변환한다. (java 파일생성)
		2.)서블릿 코드를 컴파일 해서 실행 가능한 byrecode로 변환한다. (class 파일생성)
		3.) 서블릿 클래스를 로딩하고 인스턴스를 생성한다.
	3.서블릿이 실행되어 요청을 처리하고 응답 정보를 생성한다.	-->

</body>
</html>