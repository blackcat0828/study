
console.log("reply.js 실행");

//즉시 실행 함수(함수의 이름 없음)
var replyService = (function(){

	//신규 댓글 입력 처리
	function add(reply,callback,error){
	
		$.ajax({
			//전송방식
			type:"post",
			url:"/replies/new",
			//자바스크립트 값이나 객체를 json문자열로 변환처리하는 메서드
			data:JSON.stringify(reply),
			contentType:"application/json;charset=utf-8",
			//result : 결과값을 가지는 변수
			//status : http 상태값
			//xhr : XMLHttpRequest의 약자
			success : function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr,status,err){
				if(error){
					error(err);
				}
			}
		
		})
			
	}
	
	//댓글 목록 처리 03.02
	function getList(param,callback,error){
	
		//게시물 번호
		var bno = param.bno;
		//현재 페이지 번호
		var page = param.page || 1;
		
		//서버로 부터 받은 JSON형태의 자료를 가져온다.
		//http://localhost:8080/replies/pages/게시물번호/페이지번호.json
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
		         function(data){
		         	if(callback){
		         		callback(data.replyCnt, data.list);
		         	}
		         }).fail(function(xhr,status,err){
		         		if(error){
		         			error();
		         		}
		         });
	}
	
	//특정 댓글 삭제처리
	//rno : 삭제하려는 댓글 번호
	//http://localhost:8080/삭제댓글번호
	function remove(rno,callback,error){
		
		$.ajax({
			type:"delete",
			url: "/replies/" + rno,
			success:function(deleteResult,status,xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error:function(xhr,status,err){
				if(error){
					error(err);
				}
			}
			
		});		
	}
	
	//댓글 수정 처리 03.02
	function update(reply,callback,error){
	
		$.ajax({
			
			type:"put",
			url: "/replies/" + reply.rno,
			data:JSON.stringify(reply),
			contentType:"application/json;charset=utf-8",
			success: function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error: function(xhr,status,err){
				if(error){
					error(err);
				}
			} 		
		
		});
		
	}
	
	
	//특정 댓글 상세보기 03.02
	//http://localhost:8080/replies/댓글번호.json
	function get(rno,callback,error){
	
		$.get("/replies/" + rno + ".json",function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr,status,err){
			if(error){
				error(err);
			}
		});
	}
	
	
	return {
			 add:add,
			 getList:getList,
			 remove:remove,
			 update:update,
			 get:get
	       };

})();







