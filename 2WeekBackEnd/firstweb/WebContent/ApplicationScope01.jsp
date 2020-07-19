<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
try{
	int value=(int)application.getAttribute("value");
	value++;
	value++;
	application.setAttribute("value",value);

%>
	<h1><%=value %></h1>
<%
}catch(Exception e){
	%>
	<h1>설정된 값이 없다</h1>
	<%
	}
	%>

</body>
</html>