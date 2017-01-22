<%
	Cookie[] cookies = 
		request.getCookies();
	if(cookies != null){
		for(int i = 0;i < cookies.length;i ++){
			Cookie c = cookies[i];
			String name = c.getName();
			String value = c.getValue();
			out.println(name + " " + value + "<br/>");
		}
	}
%>