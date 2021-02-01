<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 입력</title>
<style>
	table {
		width:400px;
	}
	
	h1 {
		text-align:center;
	}
</style>
</head>
<body>
	<%
		//입력받은 값 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
	%>
	
	<%-- 
		<jsp:useBean> 자바빈즈를 사용하겠다는 선언
		id : 자바빈즈 식별자 (변수)
		class : 자바클래스의 위치 지정 
	--%>
	<jsp:useBean id="join" class="join.JoinBean"/>
	
	<%--
		<jsp:setProperty> : 자바클래스의 멤버변수에 값을 대입
		property : 멤버변수 이름을 설정
		property="*"는 자바 클래스의 모든 멤버변수 이름과
		form에서 입력받은 모든 매개변수의 이름이 같은 경우
		property="*" 이렇게 선언하면 입력창에서 입력받는 모든자료가
		자바 클래스의 모든 멤버변수에 자동적으로 대입처리 된다.
		
		name : <jsp:useBean> 에서 선언한 id 이름을 선언
	  --%>
	<jsp:setProperty property="*" name="join"/>
	
	<table>
		<tr>
			<td><b>아이디:</b></td>
			<td>
			<%--
				<jsp:getProperty> ?
				 자바클래스의 멤버변수 값을 가져온다.
				 property : 자바 클래스의 멤버변수명
				 name : <jsp:useBean> 에서 선언한 id 이름을 선언
			  --%>
				<jsp:getProperty property="id" name="join"/>
			</td>
		</tr>	
		<tr>
			<td><b>비밀번호:</b></td>
			<td>
				<jsp:getProperty property="pass" name="join"/>
			</td>
		</tr>
		<tr>	
			<td><b>이름:</b></td>
			<td>
				<jsp:getProperty property="name" name="join"/>
			</td>
		</tr>
		<tr>	
			<td><b>성별:</b></td>
			
			<%
		
				if (join.getSex() == 1){//남자
			%>		
					<td>남자</td>	
			<%
				}else{
			%>
					<td>여자</td>		
			<%		
				}
			%>
			<%-- <td>
				<jsp:getProperty property="sex" name="join"/>
			</td> --%>
			
		</tr>
		<tr>	
			<td><b>나이:</b></td>
			<td>
				<jsp:getProperty property="age" name="join"/>
			</td>
		</tr>
		<tr>	
				<td><b>이메일주소:</b></td>
				<td>
					<jsp:getProperty property="email" name="join"/>
				</td>	
		</tr>
	</table>
	
</body>
</html>