<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="ko">
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<style type="text/css">
html, div, body, h3 {
	margin: 0;
	padding: 0;
}

h3 {
	display: inline-block;
	padding: 0.6em;
}
</style>
<script type="text/javascript">
  $(document).ready(function() {
    var name = ${result}.response.name;
    var email = ${result}.response.email;
    $("#email").html("환영합니다. "+email+"님");
   
    });
</script>

</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<a><img
					src="${pageContext.request.contextPath}/images/Bobbing-logo.png"
					style="height: 80px; margin-left: 10px;" /></a> <br> <br>
				<div
					style="background-color: #FF4D80; width: 100%; height: 50px; text-align: center; color: white;">
					<h3>네이버 로그인으로 밥빙 메인으로 갑니다~~</h3>
				</div>
				<br>
				<h2 style="text-align: center" id="name"></h2>
				<h4 style="text-align: center" id="email"></h4>

				<script>
    $(function () {
      $("body").hide();
      $("body").fadeIn(1000);  // 2초 뒤에 사라 지자 
     
      setTimeout(function(){$("body").fadeOut(3000);},1000);
      setTimeout(function(){location.href= "${pageContext.request.contextPath}/"},4000);
// 2초 뒤에 메인 화면 으로 가자  
    
    })
  </script>
			</div>
		</div>
	</div>
</body>
</html>