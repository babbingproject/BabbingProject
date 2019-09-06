$(function(){
	//유저 아이디 스크롤
		$(function(){
			// <ul id="banner">를 list 변수에 참조
			var list = $(".list-style04-user");
	        // 프레임의 사진 노출 개수
	        var showNum = 1;
	        // 이전, 다음 버튼을 클릭할 때마다 증감되는 값
	        var num = 1;
	        // 총 <li>의 개수 5가 저장된다.
	        var total = $(">li", list).size();
	        // <li>의 너빗값 80이 저장된다.
	        var liWidth = $("li:first", list).width();
	        
	        /* 
	            <li> 태그 중 인덱스 값이 3보다 작은 <li> 태그만 복제한다.
	            그러므로 0,1,2 인덱스에 해당하는 <li> 태그가 복제되어
	            <ul id="banner">에 추가한다.
	        */
	        var copyObj = $(">li:lt("+showNum+")", list).clone();
	        list.append(copyObj);
	        
	        // 다음 버튼을 클릭할 때마다 이벤트 핸들러를 실행한다.
	        $(".arr-btn-right on").on("click", function(){
	            if(num == total){ // num값이 5일 경우 조건문을 실행
	                num = 0; // num값 초기화
	                list.css("margin-left",num); // 배너가 첫 부분으로 이동
	            }
	            num++;
	            
	            list.stop().animate({marginLeft:-liWidth*num+"px"},500);
	            return false;
	        });
	        
	        // 이전 버튼을 클릭할 때마다 이벤트 핸들러를 실행한다.
	        $(".arr-btn-left").on("click", function(){
	            if(num == 0){    // num값이 0일 경우 조건문을 수행
	                num = total; // num값이 5가 된다.
	                // 배너가 400px만큼 이동
	                list.css("margin-left", -num*liWidth+"px");
	            }
	            
	            num--;
	            list.stop().animate({marginLeft:-liWidth*num+"px"},500);
	            return false;
	        });
		})
})