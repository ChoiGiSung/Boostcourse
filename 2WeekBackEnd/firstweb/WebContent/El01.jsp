<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("p1","page scope value");
	request.setAttribute("r1","requset scope value");
	session.setAttribute("s1","session scope value");
	application.setAttribute("a1","application scope value");
%>

<% request.setAttribute("k", 10);
request.setAttribute("m", true);%>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
pageContext.getAttribute :<%= pageContext.getAttribute("p1") %>
El pageContext.getAttribute :${pageScope.p1} <br>
<!-- name이 겹치지 않으면 -->
${p1}<br>

request.getAttribute :<%= request.getAttribute("r1") %>
El request.getAttribute :${requestScope.r1} <br>

session.getAttribute :<%= session.getAttribute("s1") %>
El session.getAttribute :${sessionScope.s1} <br>

application.getAttribute :<%= application.getAttribute("a1") %>
El application.getAttribute :${applicationScope.a1} <br><Hr>

El k: ${k } <br>
k+5 : ${k+5} <br>
k*5 : ${k*5} <br>
k/5 : ${k div 5} <br>
<Hr>
k: ${k } <br>
m: ${m} <br>
<Hr>

k>5: ${k>5}<br>
k<=10: ${k<=10}<br>
m: ${m}<br>
!m: ${!m}<br>
</body>
</html>