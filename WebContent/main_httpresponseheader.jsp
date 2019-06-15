<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auto Refresh Header Example</title>
</head>
<body>
<h2>Auto Refresh Header Example</h2>
<%	//设置每隔5s自动刷新
	response.setIntHeader("Refresh",5);
	//获取当前时间
	Calendar calendar = new GregorianCalendar();
	String am_pm;
	int hour = calendar.get(Calendar.HOUR);
	int minute = calendar.get(Calendar.MINUTE);
	int second = calendar.get(Calendar.SECOND);
	if(calendar.get(Calendar.AM_PM)==0)
		am_pm="AM";
	else am_pm="PM";
	String currentTime=hour+":"+ minute +":"+ second +" "+ am_pm;
	out.println("Current Time is: "+currentTime+"\n");
%>
</body>
</html>