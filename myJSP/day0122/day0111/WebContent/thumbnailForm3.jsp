<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thumbnail Form 예제</title>
<script>
	function fileSizeCheck(){
		var maxSize = 1 * 1024 * 1024;//1MB
		if(document.getElementById("filename").value!=""){
		    
			var fileSize = document.getElementById("filename").files[0].size;
			    
		    if(fileSize > maxSize){
		       alert("첨부파일 사이즈는 1MB 이내로 등록 가능합니다. ");
		       return;
		    }else{
		    	document.frm.submit();
		    }
	    } 
	}	  
</script>
</head>
<body>
	<form name = "frm" action="thumbnail.jsp" method="post"
	      enctype="multipart/form-data">
		이미지 파일:<input type="file" name="filename" id="filename">
		<input type="button" onclick="fileSizeCheck();" value="전송"/>       
	</form>
</body>
</html>


