$(function(){
	// 사용자의 자료 입력여부를 검사하는 함수
	$('#confirm').click(function(){
    	if( $.trim($("#userId").val()) == '' ){
            alert("아이디를 입력해 주세요.");
            $("#userId").focus();
            return;
        }
    	
    	if($.trim($('#userPass').val())==''){
    		alert("비번입력해주세요.");
    		$('#userPass').focus();
    		return;
    	}
    	
    	if($.trim($('#userPass').val()) != $.trim($('#userPass2').val())){
    		alert("비밀번호가 일치하지 않습니다..");
    		$('#userPass2').focus();
    		return;
    	}
    	
    	
    	if($.trim($('#userName').val())==''){
    		alert("이름입력해주세요.");
    		$('#userName').foucs();
    		return;
    	}
       
        // 자료를 전송합니다.
        document.userinput.submit();
	});
	
	//아이디 중복체크
	$('#userId').keyup(function(){
        // 비동기통신 ajax
		
		$.ajax({
			type:'post', /* get을 하나 post를 하나 url에 보이진 않음, 용량이 많으면 post */
			async : true, // default : true
			url : 'idCheck.do',	// 이미 url 자체가 user까지 내려온 상태임
			contentType : 'application/x-www-form-urlencoded;charset=UTF-8', /*넘어가는 데이터를 인코딩하기 위함*/
			data : "userId=" + $('#userId').val(),
			success : function(resultData) {
				$('#idCheckResult').html(resultData);
			}
		});
       
	})
})
	
	
	
	
	
	
	
	
	