<%@page import="java.util.List"%>
<%@page import="gusetbookexam.dao.Dao"%>
<%@page import="org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter"%>
<%@page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="gusetbookexam.dto.Dto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- jstl ����ϱ� ���� -->
 <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>����</h1>
	<br>���� ��ü �� : ${count } �湮��:${cookieCount}
	<br>
	<br>
	
	<c:forEach items="${list }" var="Dto">
${Dto.id }<br>
${Dto.name }<br>
${Dto.content }<br>
${Dto.regdate}<br>

<!-- ���ǽ�����-> ���� �ȿ� �ִ� ���� ���ڴ� -->
<c:if test="${sessionScope.isAdmin == 'true'}"><a href="delete?id=${Dto.id }">����</a></c:if><br><br>
</c:forEach><br>


<c:forEach items="${pageStartList }" var="dd">
	${dd}<br>
</c:forEach>


<!-- pagelink�κ� -->
	<c:forEach items="${pageStartList} " var="pageIndex" varStatus="status">
		<a href="list?start=${pageIndex}">${status.index+1}</a>&nbsp;&nbsp;
	 </c:forEach>



<!-- for������ ���� ���������� -->
<form method="post" action="write">
	�̸�:<input type="text" name="name"><br>
	����:<textarea  name="content" rows="15" cols="10"></textarea><br>
	<input type="submit" value="Ȯ��">
</form>
</body>
</html>