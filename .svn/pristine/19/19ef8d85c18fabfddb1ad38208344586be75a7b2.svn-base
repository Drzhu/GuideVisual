<%@ page language="java" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="">
<head>
<meta charset="utf-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>中交数据中心</title>

<link rel="stylesheet" href="styles/main.css">

</head>
<body>

<header></header>

<article class="container">
	<section class="modify-password">
	<form action="change_pass" method="post" id="formid">
	<input id="username" value="${username}" hidden="true" name="username">
		<ul class="text-box">
			<li>
				<i><img src="images/re-p-icon.png" alt=""></i>
				<input id="password" type="password" placeholder="输入新密码" name="password">
			</li>
			<li>
				<i><img src="images/p-icon.png" alt=""></i>
				<input id="rePassword" type="password" placeholder="再次输入">
			</li>
		</ul>
		<div class="btn-box">
			<button id="enterBtn" class="enter-btn" type="button" >确定</button>
		</div>
		</form>
	</section>
	
</article>

<footer></footer>

<script src="scripts/zepto.min.js"></script>

<script src="scripts/main.js"></script>

<script>
	$(function(){

	$('#enterBtn').click(function(){
			var password = $('#password').val();
			var rePassword = $('#rePassword').val();
		
	if(isNull(password) || isNull(rePassword)){
		alert("密码不能为空！");
		return false;
	}else if(password!=rePassword){
		alert("两次密码输出不一致；请重新输入！");
		return false;
	}
		$("#enterBtn").attr("type","submit").submit();
	}); 
	});
</script>

</body>
</html>