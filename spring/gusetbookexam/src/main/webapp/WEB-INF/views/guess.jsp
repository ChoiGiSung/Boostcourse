<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<c:if test="${sessionScope.count !=null }">
	<form method="get" action="guess">
	1���� 100���� ��
	<input type="text" name="number" placeholder="����">
	<input type="submit">
	</form>
</c:if>

<a href="guess">���� �ٽ��ϱ�</a>
${message }

</body>
</html>