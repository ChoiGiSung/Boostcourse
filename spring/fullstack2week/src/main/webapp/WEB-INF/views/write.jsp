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
		<h5>��� �ΰ���?</h5>
		<input type="text" name="title"><br>
		<h5>���� �� ���ΰ�?</h5>
		<input type="text" name="name"><br>
		<h5>�켱������ �����϶�?</h5>
		<input type="checkbox" name="sequence" value="1">1����
		<input type="checkbox" name="sequence" value="2">2����
		<input type="checkbox" name="sequence" value="3">3����
	</div>
	
	<div>
	<input type="button" value="<����">
	<input type="submit" value="����">
	<input type="reset" value="���������">
	</div>
</form>
</div>
</body>
</html>