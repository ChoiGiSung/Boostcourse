<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> <!-- ������ ���ù� -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	int total = 0;
	for(int i=1; i<= 10; i++){
		total = total + i;
	}
%>
1���� 10������ ��<%=total %> <!-- �������� �ٲٸ� -> out.print(total) -->
			<!-- jsp�� �������� ��ȯ�� �ȴ� -> ���ϰ�θ� ã�ƺ��� ���� %=�� out.print�� ��ȯ�� �ȴ�
			 -->
	<!-- .metadate ���� �ؿ� jsp�� .java ���Ϸ� �ٲ� ������ 
	1.�������� �������� jsp�� ���� ��û ������ �����Ѵ�.
	2.�������� ��û�� jsp�� ���ʷ� ��û���� ��츸
	
		1.) jsp�� �ۼ��� �ڵ尡 �������� �ڵ�� ��ȯ�Ѵ�. (java ���ϻ���)
		2.)���� �ڵ带 ������ �ؼ� ���� ������ byrecode�� ��ȯ�Ѵ�. (class ���ϻ���)
		3.) ���� Ŭ������ �ε��ϰ� �ν��Ͻ��� �����Ѵ�.
	3.������ ����Ǿ� ��û�� ó���ϰ� ���� ������ �����Ѵ�.	-->

</body>
</html>