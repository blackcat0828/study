<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script>
	$(document).ready(function () {
	   $(function () {
	            $('.contact').keydown(function (event) {
	             var key = event.charCode || event.keyCode || 0;
	             $text = $(this); 
	             if (key !== 8 && key !== 9) {
	                 if ($text.val().length === 3) {
	                     $text.val($text.val() + '-');
	                 }
	                 if ($text.val().length === 8) {
	                     $text.val($text.val() + '-');
	                 }
	             }
	
	             return (key == 8 || key == 9 || key == 46 || (key >= 48 && key <= 57) || (key >= 96 && key <= 105));
				 // Key 8번 백스페이스, Key 9번 탭, Key 46번 Delete 부터 0 ~ 9까지, Key 96 ~ 105까지 넘버패트
				 // 한마디로 JQuery 0 ~~~ 9 숫자 백스페이스, 탭, Delete 키 넘버패드외에는 입력못함
	         })
	   });
	});
</script>



<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function Postcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
             

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

 

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                
                document.getElementById("addressName").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("addressName").focus();
            }
        }).open();
    }
</script>
<script type="text/javascript">
	function checkForm() {
	
		if (!document.newMember.id.value) {
			alert("아이디를 입력하세요.");
			return false;
		}

		if (!document.newMember.password.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}

		if (document.newMember.password.value != document.newMember.password_confirm.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
		
		if (!document.newMember.name.value) {
			alert("이름을 입력하세요.");
			return false;
		}
		

		

		
		if (!document.newMember.phone.value) {
			alert("휴대폰 번호를 선택하세요.");
			return false;
		}	
		
		if (!document.newMember.address.value) {
			alert("우편번호 찾기를 실행하세요");
			return false;
		}	
		
		if (!document.newMember.address2.value) {
			alert("상세주소내역을 입력하세요");
			return false;
		}
		
		
	}
</script>

<style type="text/css">
	body { 
		padding-bottom: 70px;
		padding-top: 70px;
	 }
</style>
<title>회원 가입</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">회원 가입</h1>
		</div>
	</div>
	
<!-- 
	class="form-group"
	입력폼의 컨트롤 종류는 하나 하나가 class="form-group"를 설정된 <div> 태그로 정리된다. 
	그러면 Bootstrap은 각각을 그룹으로 배치한다.
	예를 들어 <label>와 <input>가 그 중에 있으면, 레이블 아래에 입력 항목을 정렬된 형태로 배치된다. 
	이 입력 항목 그룹화하는 것이 class="form-group"라는 클래스이다. 
	
	class="form-control"
	
-->

	<div class="container">
		<form name="newMember"
			  action="addMember.member" 
			  method="post" onsubmit="return checkForm()">
			<div class="form-group  row">
				<label for="id" class="col-sm-2 ">아이디</label>
				<div class="col-sm-3">
					<input name="id" id="id" type="text" class="form-control" placeholder="아이디입력" >
				</div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2">비밀번호</label>
				<div class="col-sm-3">
					<input name="password" type="text" class="form-control" placeholder="비밀번호 입력" >
				</div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2">비밀번호확인</label>
				<div class="col-sm-3">
					<input name="password_confirm" type="text" class="form-control" placeholder="비밀번호 확인 입력" >
				</div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2">이름</label>
				<div class="col-sm-3">
					<input name="name" type="text" class="form-control" placeholder="이름 입력" >
				</div>
			</div>
	


			<div class="form-group  row">
				<label class="col-sm-2">전화번호</label>
				<div class="col-sm-3">
					<input class="contact" name="contact" type="text" class="form-control" placeholder="0000-0000-0000" >

				</div>
			</div>

			<div class="form-group row">
				<label class="col-sm-2">주소</label>					
				<div class="col-sm-5">
					<input id="addressName" name="addr" type="text" readonly="readonly"
					       class="form-control" />
					<input type="button" value="주소 찾기" onclick="Postcode()"/>    
				</div>				
			</div>
			

			<div class="form-group  row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary" value="등록" > 
					<input type="reset" class="btn btn-danger" value="취소" onclick="reset()" >
				</div>
			</div>
		</form>
	</div>
<%@ include file="footer.jsp" %>	
</body>
</html>