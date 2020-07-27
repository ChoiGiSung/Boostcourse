<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 로그인</h1>
	<br><br>
	${errorMessage }
	<br>
	<form method="post" action="login">
		암호	<input type="password" name="passwd"><br>
		<input type="submit">
	</form>

</body>
</html>