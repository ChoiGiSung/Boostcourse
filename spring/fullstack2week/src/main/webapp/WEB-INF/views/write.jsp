<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div>
<form action="writedata" method="post">

	<div 	align="center">
		<h5>어떤일 인가요?</h5>
		<input type="text" name="title"><br>
		<h5>누가 할 일인가?</h5>
		<input type="text" name="name"><br>
		<h5>우선순위를 선택하라?</h5>
		<input type="checkbox" name="sequence" value="1">1순위
		<input type="checkbox" name="sequence" value="2">2순위
		<input type="checkbox" name="sequence" value="3">3순위
	</div>
	
	<div>
	<input type="button" value="<이전">
	<input type="submit" value="제출">
	<input type="reset" value="내용지우기">
	</div>
</form>
</div>
</body>
</html>