<%@page import="java.util.List"%>
<%@page import="gusetbookexam.dao.Dao"%>
<%@page import="org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter"%>
<%@page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="gusetbookexam.dto.Dto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- jstl 사용하기 위해 -->
 <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>방명록</h1>
	<br>방명록 전체 수 : ${count } 방문수:${cookieCount}
	<br>
	<br>
	
	<c:forEach items="${list }" var="Dto">
${Dto.id }<br>
${Dto.name }<br>
${Dto.content }<br>
${Dto.regdate}<br>

<!-- 세션스콥은-> 세션 안에 있는 값을 보겠다 -->
<c:if test="${sessionScope.isAdmin == 'true'}"><a href="delete?id=${Dto.id }">삭제</a></c:if><br><br>
</c:forEach><br>


<c:forEach items="${pageStartList }" var="dd">
	${dd}<br>
</c:forEach>


<!-- pagelink부분 -->
	<c:forEach items="${pageStartList} " var="pageIndex" varStatus="status">
		<a href="list?start=${pageIndex}">${status.index+1}</a>&nbsp;&nbsp;
	 </c:forEach>



<!-- for문으로 값을 빼오ㅏ야해 -->
<form method="post" action="write">
	이름:<input type="text" name="name"><br>
	내용:<textarea  name="content" rows="15" cols="10"></textarea><br>
	<input type="submit" value="확인">
</form>
</body>
</html>