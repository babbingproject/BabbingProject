
$(function(){
	
	var list = document.getElementsByClassName('temp');
//	alert(list);
	for ( var i = 0; i < list.length; i ++){
		list[i].setAttribute('id', "box" + i);
	}
	
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
		var followingYou = $(this).children("#followingYou").val();
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
		var followingYou = $(this).children().closest("#followingYou").val();
		var closestATTR = $(this).find('.followbtn');
		
;		$.ajax({
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
	//업종 버튼
	$('.buttons').on('click', function(){
		$('.buttons.on').removeClass('on');
		$(this).closest('.buttons').addClass('on');
		var type = $(this).closest('.buttons').children().attr('id');
		var current = $(this);
		var followerMe = $(this).parent().parent().siblings('#followerMe').val();
		
		alert(followerMe);
		$.ajax({
			url: "tabMenu",
			dataType: "JSON",
			type: "GET",
			data: {type : type, followerMe : followerMe},
			
			success:function(testing){
				
//				alert('success');
				//div tag selector up to .cont area.info class
				var insideDiv = $(current).parent().parent().siblings().closest(".cont-area.info");
				
//			
//				if(!testing[1].scrapvo.isEmpty){
//					alert('wee');
//				}
//				$(box).children().children().siblings().find('#reviewPlace').html(testing[i].img[i][4]);

				for(i in testing){

					//selecting each div li div, needs to select each single individual 
					var box = $(insideDiv).children().find('#box'+i);
					
					//리뷰의 이미지
					$(box).children().children('.photos').children().find("#img1").attr("src", testing[i].img[i][4]);
					//리뷰의 북마크 버튼 여부
					if(testing[i].scrapvo!=''){
						
						$(box).children().children().find('#scrapButton').addClass('best01');
						$(box).children().children().find('#scrapButton').removeClass('best02');
					}
					if(testing[i].scrapvo==''){
					
						$(box).children().children().find('#scrapButton').addClass('best02');
						$(box).children().children().find('#scrapButton').removeClass('best01');
					}
					
					//리뷰의 장소
					$(box).children().children('.info').children().find('#reviewPlace').html(testing[i].img[i][1]);
					//리뷰의 타이틀
					$(box).children().children('.info').children().eq(2).find('#reviewTitle').html(testing[i].img[i][2]);
					//리뷰의 프로파일 이미지
					$(box).children().children('.info').children().eq(3).children().find('#img2').attr('src', testing[i].img[i][5]);
					//리뷰의 프로파일 네임
					$(box).children().children('.info').children().eq(3).children().find('#userNickname').html(testing[i].img[i][6]);
					//스크랩을위한 리뷰번호 번경
					$(box).children().children('.info').find('#get').val(testing[i].img[i][0]);
					//스크랩을위한 리뷰작성자 아이디 변경
					$(box).children().children('.info').children().eq(3).children().children('#reviewUserId').val(testing[i].img[i][7]);
//					$(first).children().children().children().find("img[id=box"+i+"]").attr('src', testing[i].img[i][4]);
//					htmlStr += "<div class='cont-txt' id='wee'>";
//					htmlStr += "<p class='photo'>";
//					htmlStr += "<img src=";
//					htmlStr += testing[i].img[i][4];
//					htmlStr += " /></p></div>";
//					htmlStr += "<span> ";
//					if(testing[i].scrapvo.isEmpty){
//						htmlStr += "<span id='scrapButton' class='button best02'></span>";
//					} else {
//						htmlStr += "<span id='scrapButton' class='button best01'></span>";
//					}
//					htmlStr += "</span>";
//					htmlStr += testing[i].uservo.nickname;
					
					
					
					
//					htmlStr += testing[i].reviewImagevo.img;
//					htmlStr += testing[i].reviewImagevo.img;
//					for(a in testing[i]reviewImgList){
//						htmlStr += reviewImgList[i].img;
//					}
//					htmlStr += "<img src="+testing[i].reviewRegistrationvo.reviewImgList.img+"></img>";
//					htmlStr += "</span>";
				}
				
//				for(var i in testing){
//					htmlStr += testing.reviewRegistrationvo.reviewPlace;
//					htmlStr += "></span></p></div>"
//					htmlStr += "<span th:each="+check +":"+ [[${everything.reviewRegistrationvo.reviewImgList}]]+">";
//					htmlStr += "<img th:src='${check.img'}></span></p>";
				
//					htmlStr += "<p class='photo'>";
//					htmlStr += "<img src="+testing[i][4]+"></p>";
//					htmlStr += "<a href='#' class='best01'>베스트</a>";
//					htmlStr += "<ul class='info'>";
//					htmlStr += "<li><span></span>"+testing[i][1]+" | "+testing[i][2]+"</li>";
//					htmlStr += "<li><img src="+testing[i][5]+"><span>"+testing[i][6]+"</span></li>"
//					htmlStr += "</ul></div></li>"
				
				
//					$(insideDiv).children('.list-style03').html(htmlStr);
					
//				}
			}
		})
	})
	//스크랩 버튼 이름 죄송
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