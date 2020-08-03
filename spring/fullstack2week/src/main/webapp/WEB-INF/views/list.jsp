<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>

	div{
		border: 1px solid gray; 
			
	}
	.list{
		position: relative;
		height:900px ;
	}
	
	.list > div{
		border: 1px solid red; 
		width: 200px;
		display: inline;
		margin-left: 150px;
		
	}
	h2{
		display: inline;
		background-color: green;
		 width: 200px;
		 display: inline;
	}
	.todo{
		position: absolute;
		top: 20px;
	}
	.doing{
		position: absolute;
		left: 280px;
		top: 20px;
		}
	.done{
		position: absolute;
		right: 60px;
		top: 20px;
	}
</style>

</head>
<body>
	<div class="full">
		<div align="right">
			<input type="button" value="�� �� �����" onclick="location.href = 'write'">
		</div>
		<div class="list">
			<div  class="todo">
				<h2>todo</h2>
				<c:forEach items="${Todolist }" var="dto">
					${dto.id }<br>
					${dto.title }<br>
					${dto.name }<br>
					${dto.sequence }<br>
					${dto.regdate }<br>
					<input type="button" onclick="location.href='updatepage?id=${dto.id}'" value="������"> 
				</c:forEach>
				<!-- ����Ʈ -->
			</div>
			
			
			<div class="doing">
				<h2 >doing</h2>
					<c:forEach items="${Doinglist }" var="dto">
					${dto.id }<br>
					${dto.title }<br>
					${dto.name }<br>
					${dto.sequence }<br>
					${dto.regdate }<br>
					<input type="button" onclick="location.href='updatedoing?doing=${dto.id}'" value="����">
				</c:forEach>
				<!-- ����Ʈ -->
			</div>
			
			
			<div class="done">
				<h2>done</h2>
					<c:forEach items="${Donelist }" var="dto">
					${dto.id }<br>
					${dto.title }<br>
					${dto.name }<br>
					${dto.sequence }<br>
					${dto.regdate }<br>
				</c:forEach>
				<!-- ����Ʈ -->
			</div>
				
		</div>
	</div>
</body>
</html>