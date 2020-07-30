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
<h1>����</h1>
<br>
���� ��ü ��: ${count }<br>

<c:forEach items="${list }" var="dto">
${dto.id }<br>
${dto.name }<br>
${dto.content }<br>
${dto.regdate }<br>
</c:forEach>

<c:forEach items="${pageStartList }" var="pageIndex" varStatus="status">
	<a href="list?start=${pageIndex }">${status.index+1}</a>
</c:forEach>

<!-- for������ ���� ���������� -->
<form method="post" action="write">
	�̸�:<input type="text" name="name"><br>
	����:<textarea  name="content" rows="15" cols="10"></textarea><br>
	<input type="submit" value="Ȯ��">
</form>
</body>
</html>