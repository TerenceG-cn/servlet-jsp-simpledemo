<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<html>
   <head>
      <title>JSTL fmt:bundle标签</title>
   </head>

   <body>
      <fmt:bundle basename = "com.tce.myjsp.Example_Cn" prefix = "count.">
         <fmt:message key = "one"/><br/>
         <fmt:message key = "two"/><br/>
         <fmt:message key = "three"/><br/>
      </fmt:bundle>
      <br/>
      <fmt:bundle basename = "com.tce.myjsp.Example_Cn">
         <fmt:message key = "count.one"/><br/>
         <fmt:message key = "count.two"/><br/>
         <fmt:message key = "count.three"/><br/>
      </fmt:bundle>
   </body>
</html>

