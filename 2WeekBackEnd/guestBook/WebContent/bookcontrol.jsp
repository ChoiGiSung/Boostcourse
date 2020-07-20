<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="guestBook.Book.*,java.util.*"%>

<!DOCTYPE html>
    <jsp:useBean id="dao" class="guestBook.Book.Dao" scope="session"></jsp:useBean>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String req=request.getParameter("action");
	
	if(req.equals("data")){
		String name=request.getParameter("name");
		String conent=request.getParameter("content");
		String answer =	dao.addbook(name, conent);
	}else{
		pageContext.forward("mainpage.jsp");
	}
%>

</body>
</html>