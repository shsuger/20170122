<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<html>
	<head>
		<style>
			.tips{
				color:red;
				font-style:italic;
			}
		</style>
	</head>
	<body style="font-size:30px;">
		<form action="login.do" method="post">
			<fieldset>
				<legend>登录</legend>
				用户名:<input name="username"/>
				<%
					String msg =
					(String)request.getAttribute("login_failed");
				 %>
				<span class="tips"><%=(msg == null ? "" : msg)%></span>
				<br/>
				密码:<input type="password" name="pwd"/><br/>
				<input type="submit" value="确定"/>
			</fieldset>
		</form>
	</body>
</html>
