<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Http Header Request Example</title>
</head>
<body>
<h2>HTTP Header Request Example</h2>
<table  border="1" style="text-align:center;width=100px">
<tr bgcolor="#949494">
<th>Header Name</th><th>Header Value(s)</th>
</tr>
<%	Enumeration headernames = request.getHeaderNames();
	while(headernames.hasMoreElements()){
		String paramName = (String)headernames.nextElement();
		out.print("<tr><td>"+paramName+"</td>");
		String paramValue = request.getHeader(paramName);
		out.println("<td> "+paramValue+"</td></tr>\n");	
	}
%>
</table>
</body>
</html>