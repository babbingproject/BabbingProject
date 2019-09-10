$(function(){
//	//유저 아이디 스크롤
//		$(function(){
//			// <ul id="banner">를 list 변수에 참조
//			var list = $("#banner");
//	        // 프레임의 사진 노출 개수
//	        var showNum =6;
//	        // 이전, 다음 버튼을 클릭할 때마다 증감되는 값
//	        var num = 0;
//	        // 총 <li>의 개수 5가 저장된다.
//	        var total = $(">li", list).size();
//	        // <li>의 너빗값 80이 저장된다.
//	        var liWidth = $("li:first", list).width();
//	        
//	        /* 
//	            <li> 태그 중 인덱스 값이 3보다 작은 <li> 태그만 복제한다.
//	            그러므로 0,1,2 인덱스에 해당하는 <li> 태그가 복제되어
//	            <ul id="banner">에 추가한다.
//	        */
//	        var copyObj = $(">li:lt("+showNum+")", list).clone();
//	        list.append(copyObj);
//	        
//	        // 다음 버튼을 클릭할 때마다 이벤트 핸들러를 실행한다.
//	        $("#right").on("click", function(){
//	            if(num == total){ // num값이 5일 경우 조건문을 실행
//	                num = 0; // num값 초기화
//	                list.css("margin-left",num); // 배너가 첫 부분으로 이동
//	            }
//	            num++;
//	            
//	            list.stop().animate({marginLeft:-liWidth*num+"px"},500);
//	            return false;
//	        });
//	        
//	        // 이전 버튼을 클릭할 때마다 이벤트 핸들러를 실행한다.
//	        $("#left").on("click", function(){
//	            if(num == 0){    // num값이 0일 경우 조건문을 수행
//	                num = total; // num값이 5가 된다.
//	                // 배너가 400px만큼 이동
//	                list.css("margin-left", -num*liWidth+"px");
//	            }
//	            
//	            num--;
//	            list.stop().animate({marginLeft:-liWidth*num+"px"},500);
//	            return false;
//	        });
//		})
	$('.emptyspace').on('click', function(){
		var followerMe = $('#followerMe').val();
		var followingYou = $(this).children().children("#followingYou").val();
		var closestATTR = $(this).find('.followbtn');
		
		$.ajax({
			url:"ajaxfollow",
			dataType: "JSON",
			type: "POST",
			data: {followerMe : followerMe, followingYou : followingYou},
			
			success:function(result){
				if(result == 1){
					var near = $(closestATTR).closest('.followbtn');
					$(near).removeClass('btn02');
					$(near).addClass('btn01');
					$(near).empty();
					$(near).text('팔로잉');
					
// 					var num = 1;
// 					var value = ($(near).parent().parent().parent().siblings().children().children().closest('#followingCount').val());
// 					alert(($(near).parent().parent().parent().siblings().children().children().closest('#followingCount')).val());
// 					alert(value);
// 					alert(value + num);
// 					$(near).parent().parent().parent().siblings().children().closest('#appenduse').html("<span value="+value+" id="+"followingCount"+">"+value+"</span>");
				} else if(result == 2) {
					var near = $(closestATTR).closest('.followbtn');
					$(near).removeClass('btn01');
					$(near).addClass('btn02');
					$(near).empty();
					$(near).text('팔로우');
// 					var number = 1;
// 					var value = Number($(near).parent().parent().parent().siblings().children().children().closest('#followingCount').val());
// 					alert(value);
// 					$(near).parent().parent().parent().siblings().children().closest('#appenduse').html("<span value="+value+" id="+"followingCount"+">"+value+"</span>");
				} else if(result == 0) {
					alert("자기자신을 팔로우 할 수 없습니다");
				} else if(result == -1) {
					alert("로그인을 해주세요");
				}
				
			}
		});
		
	});
	$('.emptyspace2').on('click', function(){
		var followerMe = $('#followerMe').val();
		var followingYou = $(this).children("#followingYou").val();
		var closestATTR = $(this).find('.followbtn');
		
		$.ajax({
			url:"ajaxput",
			dataType: "JSON",
			type: "POST",
			data: {followerMe : followerMe, followingYou : followingYou},
			
			success:function(result){
				if(result == 1){
					var near = $(closestATTR).closest('.followbtn');
					$(near).removeClass('btn02');
					$(near).addClass('btn01');
					$(near).empty();
					$(near).text('담기완료');
					
// 					var value = ($(near).parent().parent().parent().siblings().children().children().closest('#followingCount')).val();
// 					alert(value);
// 					alert(value + num);
// 					$(near).parent().parent().parent().siblings().children().closest('#appenduse').html("<span value="+value+" id="+"followingCount"+">"+value+"</span>");
				} else if(result == 2) {
					var near = $(closestATTR).closest('.followbtn');
					$(near).removeClass('btn01');
					$(near).addClass('btn02');
					$(near).empty();
					$(near).text('담아두기');
// 					var number = 1;
// 					var value = Number($(near).parent().parent().parent().siblings().children().children().closest('#followingCount').val());
// 					alert(value);
// 					$(near).parent().parent().parent().siblings().children().closest('#appenduse').html("<span value="+value+" id="+"followingCount"+">"+value+"</span>");
				} else if(result == 0) {
					alert("자기자신을 팔로우 할 수 없습니다");
				} else if(result == -1) {
					alert("로그인을 해주세요");
				}
				
			}
		});
		
	})
	
	$('.buttons').on('click', function(){
		$('.buttons.on').removeClass('on');
		$(this).closest('.buttons').addClass('on');
		var type = $(this).closest('.buttons').children().attr('id');
		var current = $(this);
		
		
		alert(type);
		$.ajax({
			url: "tabMenu",
			dataType: "JSON",
			type: "POST",
			data: {type : type},
			
			success:function(testing){
				var insideDiv = $(current).parent().parent().siblings().closest(".cont-area.info");
				$(insideDiv).children().children('#wee').remove();
				var htmlStr = "";
				for(var i in testing){
					htmlStr += "<li id='wee'>";
					htmlStr += "<div class='cont-txt'>";
					htmlStr += "<p class='photo'>";
					htmlStr += "<img src="+testing[i][4]+"></p>";
					htmlStr += "<a href='#' class='best01'>베스트</a>";
					htmlStr += "<ul class='info'>";
					htmlStr += "<li><span></span>"+testing[i][1]+" | "+testing[i][2]+"</li>";
					htmlStr += "<li><img src="+testing[i][5]+"><span>"+testing[i][6]+"</span></li>"
					htmlStr += "</ul></div></li>"
					
					$(insideDiv).children('.list-style03').html(htmlStr);
					
				}
				
			}
		})
	})
	
	$('.button').on('click', function(){
		var button = $(this);
		var followerMe = $('#followerMe').val();
		var reviewUserId = $(this).parent().siblings().children().children().children().closest('#reviewUserId').val();
		var reviewId = $(this).parent().siblings().children().closest('#get').val();
		console.log(followerMe);
		console.log(reviewUserId);
		console.log(reviewId);
		$.ajax({
			url: "scrapButton",
			dataType: "JSON",
			type: "GET",
			data: {followerMe : followerMe, reviewUserId : reviewUserId, reviewId : reviewId},
			success:function(result){
				if(result == -1){
					alert("로그인을 해주세요");
				} else if(result == 0){
					$(button).removeClass();
					$(button).addClass('best01');
				} else if(result == 1){
					$(button).removeClass();
					$(button).addClass('best02');
				}
				
				
			}
			
		})
		
		
	})
	
})