<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value='<%=request.getParameter("language") %>'/>
<fmt:bundle basename="bundle.myBundle">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="title"/></title>
</head>
<body>
	<div>
		<a href="?language=ko">한국어</a>
		<a href="?language=en">영어</a>
	</div>
	
	<form action="jstlfmtProcess.jsp" method="post">
		<p><fmt:message key="id"/>:
		       <input type="text" name="id">
		<p><fmt:message key="name"/>:
		       <input type="text" name="name">
		<p><fmt:message key="addr"/>:
		       <input type="text" name="addr">
		<p><fmt:message key="phone"/>:
		       <input type="text" name="phone">
		<p><fmt:message key="email"/>:
		       <input type="text" name="email">              
		<p><input type="submit"
		      value="<fmt:message key="button"/>">		       
	</form>
</body>
</html>
</fmt:bundle>