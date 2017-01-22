<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<html>
	<head>
		<style>
			.row1{
				background-color:#fff8dc;
			}
			.row2{
				background-color:#f0f0f0;
			}
		</style>
	</head>
	<body style="font-size:30px;">
		 <table border="1" cellpadding="0" cellspacing="0"
		 width="60%">
		 	<tr><td>序号</td><td>index</td><td>姓名</td><td>年龄</td></tr>
		 	<c:forEach items="${users}" var="u" 
		 	varStatus="s">   
		 		<tr class="row${s.index % 2 + 1}">
		 			<td>${s.count}</td>
		 			<td>${s.index}</td>
		 			<td>${u.name}</td>
		 			<td>${u.age}</td>
		 		</tr>
		 	</c:forEach>
		 </table>
	</body>
</html> 