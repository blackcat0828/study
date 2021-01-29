<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${contextPath}/city" method="get">
  <input type="checkbox" id="city1" name="city" value="서울">
  <label for="city1"> 서울</label><br>
  <input type="checkbox" id="city2" name="city" value="대전">
  <label for="city2"> 대전</label><br>
  <input type="checkbox" id="city3" name="city" value="대구">
  <label for="city3"> 대구</label><br>
  <input type="checkbox" id="city4" name="city" value="부산">
  <label for="city4"> 부산</label><br>
  <input type="checkbox" id="city5" name="city" value="광주">
  <label for="city5"> 광주</label><br>
  <input type="submit" value="선택">
</form>
</body>
</html>