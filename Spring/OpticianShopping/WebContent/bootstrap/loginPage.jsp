<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<%-- 타이틀 생성 --%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-6">로그인</h1>
		</div>
	</div>
	
	<div class="container" align="center">
		<div class="col-md-4 col-md-offset-4">
			<h3 clss="form-signin-heading">Please Sign In</h3>
			<%
				String error = request.getParameter("error");
				if(error != null){
					out.println("<div class='alert alert-danger'>");
					out.println("아이디와 비밀번호를 확인하세요!");
					out.println("</div>");
				}
			%>
			<form class="form-signin" action="processLoginMember.jsp" method="post">
				<div class="form-group">
					<label for="id" class="sr-only">
						User Name
					</label>
					<input type="text" class="form-control" placeholder="아이디를 입력하세요" name="id" id="id" required autofocus>
				</div>
				<div class="form-group">
					<label for="password" class="sr-only">
						Password
					</label>
					<input type="password" class="form-control" name="password" id="password" required>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">
					로그인
				</button>
			</form>
		</div>
	</div>
</body>
</html>