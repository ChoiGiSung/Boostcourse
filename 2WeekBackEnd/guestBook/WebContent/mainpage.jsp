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
<form method="post" action="./bookcontrol.jsp" name="form1">
	<input type="hidden" name="action" value="data">
	
	<div>
	
			<%
		
			ArrayList <Dto> ar=dao.getbook();
			for(Dto a:ar){
			%>
			<%=a.getId()%><br>
			<%=a.getName()%><br>
			<%=a.getContent()%><br>
			<%=a.getRegdate()%><br>
			<hr>
			<%
			}
			%>
	
	
	
	
		이름:<input type="text" name="name"><br>
		내용:<textarea name="content" rows="10" cols="15"></textarea><br>
		<input type="submit" value="확인" >
	</div>
</form>

</body>
</html>