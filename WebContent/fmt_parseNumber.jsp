<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fmt:parseNumber示例</title>
</head>
<body>
    <div style="margin: auto; width: 80%">
        <h3>数字解析:</h3>
        <c:set var="balance" value="2255003.250" />

        <fmt:parseNumber var="i" type="number" value="${balance}" />
        <p>
            Parsed Number (1) :
            <c:out value="${i}" />
        </p>
        <fmt:parseNumber var="i" integerOnly="true" type="number"
            value="${balance}" />
        <p>
            Parsed Number (2) :
            <c:out value="${i}" />
        </p>
    </div>

</body>
</html>