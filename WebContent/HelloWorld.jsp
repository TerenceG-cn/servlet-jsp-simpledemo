<%@page import="java.util.Date, java.text.SimpleDateFormat" pageEncoding="UTF-8"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>
	Hello World!
	<br />
	<%
		out.println("Your IP address is " + request.getRemoteAddr());
	%>
	<br />
	<jsp:scriptlet>out.println("Your IP address is " + request.getRemoteAddr());</jsp:scriptlet>

	<p>
		Today's date:
		<%=
		//(new java.util.Date()).toLocaleString()//过时方法
		new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())
		//注意导包：
		//import java.text.SimpleDateFormat;
		//import java.util.Date;
		%>
		 
	</p>
</body>
</html>


