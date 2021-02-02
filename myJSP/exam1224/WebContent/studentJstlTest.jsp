<%@ page language ="java" contentType="text/html; charset=UTF-8"
				import="java.util.*,jstl.Student"
				pageEncoding="UTF-8"
				isELIgnored="false" %>


<%
	
	ArrayList<Student> studentList = new ArrayList<>();
	Student s1 = new Student("1000","이순신","lee@naver.com");
	Student s2 = new Student("2000","홍길동","hong@daum.net");
	Student s3 = new Student("3000","강감찬","kang@google.com");

	studentList.add(s1);
	studentList.add(s2);
	studentList.add(s3);
	
	session.setAttribute("studentList", studentList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
    width: 600px;
    border: 1px solid black;
    border-collapse: collapse;
    text-align: center;
}

td, th {
	width: 600px;
    border: 1px solid black;
    border-collapse: collapse;
    text-align: center;
}
</style>
</head>
<body>
	학생정보
	<table>
		<tr>
			<th>학생번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<tr>
			<td>${sessionScope.studentList[0].getStudNo()}</td>
			<td>${sessionScope.studentList[0].getName()}</td>
			<td>${sessionScope.studentList[0].getEmail()}</td>
		</tr>
		<tr>
			<td>${sessionScope.studentList[1].getStudNo()}</td>
			<td>${sessionScope.studentList[1].getName()}</td>
			<td>${sessionScope.studentList[1].getEmail()}</td>
		</tr>
		<tr>
			<td>${sessionScope.studentList[2].getStudNo()}</td>
			<td>${sessionScope.studentList[2].getName()}</td>
			<td>${sessionScope.studentList[2].getEmail()}</td>
		</tr>
	</table>
	테스트 : ${studentList[0].getStudNo()}
</body>
</html>