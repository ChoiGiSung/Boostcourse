<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>방명록</h1>
<br>
방명록 전체 수: ${count }<br>

<c:forEach items="${list }" var="dto">
${dto.id }<br>
${dto.name }<br>
${dto.content }<br>
${dto.regdate }<br>
</c:forEach>

<c:forEach items="${pageStartList }" var="pageIndex" varStatus="status">
	<a href="list?start=${pageIndex }">${status.index+1}</a>
</c:forEach>

<!-- for문으로 값을 빼오ㅏ야해 -->
<form method="post" action="write">
	이름:<input type="text" name="name"><br>
	내용:<textarea  name="content" rows="15" cols="10"></textarea><br>
	<input type="submit" value="확인">
</form>
</body>
</html>