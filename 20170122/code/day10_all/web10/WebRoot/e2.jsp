<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@page import="java.util.*" %>
<html>
	<head></head>
	<body style="font-size:30px;">
		算术运算<br/>
		${1+1}<br/>
		${"111" + "222"}<br/>
		关系运算<br/>
		${1 < 2}
		<%
			request.setAttribute("str1","abc");
		 %>
		${str1 == "abc" }<br/>
		逻辑运算<br/>
		${1 < 2 && 2 > 0 }<br/>
		empty运算<br/>
		<%
			request.setAttribute("str2","");
		 %>
		${empty str2 }
		<%
			List l1 = new ArrayList();
			//l1.add("a");
			request.setAttribute("l1",l1);
		 %>
		${empty l1}<br/>
		${empty null}<br/>
		${empty aaa}
		
	</body>
</html> 