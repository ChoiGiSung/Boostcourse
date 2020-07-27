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
	1부터 100까지 써
	<input type="text" name="number" placeholder="숫자">
	<input type="submit">
	</form>
</c:if>

<a href="guess">게임 다시하기</a>
${message }

</body>
</html>