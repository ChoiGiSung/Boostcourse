<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- jstl 사용위해 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <!-- 컨트롤러에서 list라는 url이 오면 modelmap객체에 list,count,pagestartlist 3개를 넣어준다 -->
 
 <c:forEach items="${list}" var="Dto">
 	${Dto.id }<br>
 </c:forEach>
 
 <c:forEach items="${pageStartList }" var="dd">
 	${dd }<br>
 </c:forEach>
 
 <!-- pagelink 부분 -->
 	<c:forEach items="${pageStartList }" var="pageIndex" varStatus="status">
 		<a href="list?start=${pageIndex }">${status.index+1}</a>
 		
 		<!-- for문으로 값을 빼오ㅏ야해 -->
<form method="post" action="write">
	이름:<input type="text" name="name"><br>
	내용:<textarea  name="content" rows="15" cols="10"></textarea><br>
	<input type="submit" value="확인">
</form>
 	</c:forEach>
</body>
</html>