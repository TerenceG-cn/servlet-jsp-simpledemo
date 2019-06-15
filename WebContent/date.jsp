<%@page import="java.util.Date, java.text.SimpleDateFormat" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>date.jsp</title>
</head>
<body>
	<p>
		Today's date:
		<%=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())%>
	</p>
</body>
</html>