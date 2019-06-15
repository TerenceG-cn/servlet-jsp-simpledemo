<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl demo</title>
</head>
<body>
	<c:out value="${'<tag> , &'}" />
	<br />
	<c:out value="${'this is print by <c:out>' }" />
	<br />

	<c:set var="salary" scope="session" value="${5600*2}" />
	薪水值：
	<c:out value="${salary}" />

	<c:remove var="salary" />
	删除之后的值:
	<c:out value="${salary}" />

	<c:catch var="catchException">
		<%
			int x = 25 / 0;
		%>
	</c:catch>
	<c:if test="${catchException!=null}">
		<p>
			The exception is : ${catchException} <br /> There is an exception:
			${catchException.message}
		</p>
	</c:if>

	<div style="margin: auto; width: 80%">
		<c:set var="salary" scope="session" value="${4500}" />
		<p>
			Your salary is :
			<c:out value="${salary}" />
		</p>
		<c:choose>
			<c:when test="${salary<=0}">
			Salary is very low to survive.
			</c:when>
			<c:when test="${salary>5000}">
			Salary is very good.
			</c:when>

			<c:otherwise>
			No comment sir...
			</c:otherwise>
		</c:choose>
	</div>

	<div style="margin: auto; width: 80%">
		<c:import var="data" url="https://www.baidu.com" />
		<c:out value="${data}" />
	</div>

	<div style="margin: auto; width: 80%">
		<c:forEach var="i" begin="1" end="10">
    	当前值:<c:out value="${i}" />
			<br />
		</c:forEach>
	</div>

	<div style="margin: auto; width: 80%">
		<c:forTokens items="Java,Party,Jsp,Servlet" delims="," var="name">
			<c:out value="${name}" />
			<br />
		</c:forTokens>
	</div>

	<div style="margin: auto; width: 80%">
		<a href="<c:url value = "/main.jsp"/>">Main.jsp Page</a>
	</div>

	<div>
		<c:url var="myURL" value="my_servlet/main.jsp">
			<c:param name="name" value="NAME_VALUE" />
			<c:param name="url" value="URL_VALUE" />
		</c:url>
		<a href="/<c:out value="${myURL}"/>">为指定URL发送两个参数</a>
	</div>

	<p>
		<c:redirect url="https://www.yiibai.com" />
	</p>

</body>
</html>