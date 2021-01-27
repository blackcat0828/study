<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="fintech.MemberVO" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach Status 예제</title>
</head>
<body>
	<%
		MemberVO m1 = new MemberVO("이순신","lee@naver.com",15);
		MemberVO m2 = new MemberVO("홍길동","hong@daum.net",38);
		MemberVO m3 = new MemberVO("강감찬","kang@google.com",57);
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		//3명의 멤버를 가지는 list를 memberList 속성으로 지정
		request.setAttribute("memberList",list);
	%>
	
	<h3>회원정보</h3>
	<table border="1" style="border-collapse:collapse;width:650px">
		<tr>
			<th width="50px">번호</th>
			<th width="100px">이름</th>
			<th width="200px">이메일</th>
			<th width="100px">나이</th>
			
			<%--
			    varStatus 상태값
				${varStatus변수명.count} => 번호 넘버링을 1부터 출력
				${varStatus변수명.index} => 번호 넘버링을 0부터 출력
				${varStatus변수명.current} => 현재 for문에 해당하는 번호
				${varStatus변수명.first} => 현재 행이 첫번째 행인지 여부
				${varStatus변수명.last} => 현재 행이 마지막 행인지 여부
				${varStatus변수명.begin} => for문의 시작번호
				${varStatus변수명.end} => for문의 마지막번호
				${varStatus변수명.step} => for문의 증가치
			 --%>
			
			
			<c:forEach var="member" 
			           items="${memberList}" varStatus="num">
				<tr>
					<td align="center">${num.count}</td>
					<td align="center">${member.name}</td>
					<td align="center">${member.email}</td>
					<td align="center">${member.age}</td>
				</tr>
			</c:forEach>
			
		</tr>	
	</table>
	
</body>
</html>



