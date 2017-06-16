<%@ page language="java" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpSession"%> 
<%
HttpSession s = request.getSession();
s.setAttribute("login_level", "login");
String name="";  
String psw="";  
String checked="";  
Cookie[] cookies=request.getCookies();  
if(cookies!=null&&cookies.length>0){   
    //遍历Cookie  
    for(int i=0;i<cookies.length;i++){  
        Cookie cookie=cookies[i];  
        //此处类似与Map有name和value两个字段,name相等才赋值,并处理编码问题   
        if("name".equals(cookie.getName())){  
            name=java.net.URLDecoder.decode(cookie.getValue(),"utf-8");  
            //将"记住我"设置为勾选   
            checked="checked";  
        }  
        if("psw".equals(cookie.getName())){  
            psw=cookie.getValue();  
        }  
    }  
}  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link rel="stylesheet" type="text/css" href="font-awesome-4.6.3/css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/manage_css/css.css" />
<link rel="stylesheet" type="text/css" href="css/manage_css/supersized.css" />
<link rel="stylesheet" type="text/css" href="css/animate.min.css" />
<link rel="shortcut icon" href="img/guide.ico" />
<title>用户登录</title>
</head>
<body class="enter-body">
	<ul class="show-box animated ">
		<li>
			<button type="button" id="block1" class="block1">ASCVD<br/>患者远程教育</button>
		</li>
		<li>
			<button type="button" id="block2" class="block2">基层医生<br/>心血管慢病管理</button>
		</li>
		<li>
			<button type="button" id="block3" class="block3" disabled="disabled">中国百万<br/>血管健康计划</button>
		</li>
	</ul>
	
	<div id="login1" class="login-box animated ">
		<div class="login-logo">ASCVD患者远程教育</div>
		<div class="login-box-body">
			<p>用户登录</p>
			<div class="form-group">
				<i class="fa fa-user onlyicon"></i> 
				<input id="username" type="text" name="username" placeholder="用户名" class="form-control" />
				<div class="red username-tips" id = "username-tips1"></div>
			</div>
			<div class="form-group">
				<i class="fa fa-lock onlyicon"></i> 
				<input id="password" type="password" name="password" placeholder="密码"	class="form-control" />
				<div class="red password-tips" id ="password-tips1"></div>
			</div>
			<div class="checkbox">
				<label> <input id="remberInput" type="checkbox"
					name="remberInput" />记住我
				</label>
			</div>
			<button id="lpt1" type="submit" class="btn btn-block btn-primary btn-login">登录</button>
			<div class="login-help">
				<button id="backBtn1" type="button" class="btn btn-xs btn-success pull-right back-btn">返回</button>
			</div>
		</div>
	</div>
	
	<div id="login2" class="login-box animated ">
		<div class="login-logo">基层医生心血管慢病管理</div>
		<div class="login-box-body">
			<p>用户登录</p>
			<div class="form-group">
				<i class="fa fa-user onlyicon"></i> 
				<input id="username2" type="text" name="username" placeholder="用户名" class="form-control" />
				<div class="red username-tips" id ="username-tips2"></div>
			</div>
			<div class="form-group">
				<i class="fa fa-lock onlyicon"></i> 
				<input id="password2" type="password" name="password" placeholder="密码"	class="form-control" />
				<div class="red password-tips" id="password-tips2"></div>
			</div>
			<div class="checkbox">
				<label> <input id="remberInput" type="checkbox"
					name="remberInput" />记住我
				</label>
			</div>
			<button id="community" type="submit" class="btn btn-block btn-primary btn-login">登录</button>
			<div class="login-help">
				<button id="backBtn2" type="button" class="btn btn-xs btn-success pull-right back-btn">返回</button>
			</div>
		</div>
	</div>

	<script src="js/loginbg/jquery-2.2.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrapValidator.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script>
		$(function() {
			$("#block1").on("click",function(){
				$.ajax({
					type : "GET",
					url : "val_level",
					data : {
						level:"lpt1"
					},
					success : function(res) {
						console.log(res);
						if(res == "success"){
							window.location.href = "lpt1/hospital";	
						}else{
							return false;
						}
						
					}
				});
				$(this).parents(".show-box").addClass("fadeOutLeftBig");
				$("#login1").removeClass("fadeOutRightBig").addClass("fadeInRightBig").show();
			});
			$("#backBtn1").on("click",function(){
				$(".show-box").removeClass("fadeOutLeftBig").addClass("fadeInLeftBig");
				$("#login1").removeClass("fadeInRightBig").addClass("fadeOutRightBig");
			});
			
			$("#block2").on("click",function(){
				$.ajax({
					type : "GET",
					url : "val_level",
					data : {
						level:"lpt2"
					},
					success : function(res) {
						console.log(res);
						if(res == "success"){
							window.location.href = "community/hospital";	
						}else{
							return false;
						}
						
					}
				});
				$(this).parents(".show-box").addClass("fadeOutLeftBig");
				$("#login2").removeClass("fadeOutRightBig").addClass("fadeInRightBig").show();
			});
			$("#backBtn2").on("click",function(){
				$(".show-box").removeClass("fadeOutLeftBig").addClass("fadeInLeftBig");
				$("#login2").removeClass("fadeInRightBig").addClass("fadeOutRightBig");
			});
			
			$('#lpt1').on('click',function() {
					var reqData = {
						mobile : $('#username').val(),
						password : $('#password').val(),
					};
					if (reqData.mobile == "") {
						$("#username-tips1").text("请输入用户名");
						return false;
					}
					if (reqData.password == "") {
						$("#password-tips1").text("请输入密码");
						return false;
					}
					var mobile =reqData.mobile;
					var password = reqData.password;
					$.ajax({
								type : "POST",
								url : "Validate_b",
								data : {
									username : mobile,
									password : password,
									level:"lpt1"
								},
								success : function(res) {
									var obj = eval('(' + res + ')');
									for ( var i in obj) {
										if (i == "success") {
											window.location.href = "lpt1/hospital";
										}
										if (i == "error_0") {
											$("#username-tips1").text(obj[i]);
										}
										if (i == "error_1") {
											//alert(obj[i]);
											$("#password-tips1").text(obj[i]);
										}
									}
								},
								contentType : "application/x-www-form-urlencoded;charset=UTF-8"
							});
				});
			$('#community').on('click',function() {
				var reqData = {
					mobile : $('#username2').val(),
					password : $('#password2').val(),
				};
				console.log(reqData);
				if (reqData.mobile == "") {
					$("#username-tips2").text("请输入用户名");
					return false;
				}
				if (reqData.password == "") {
					$("#password-tips2").text("请输入密码");
					return false;
				}
				var mobile =reqData.mobile;
				var password = reqData.password;
				$.ajax({
							type : "POST",
							url : "Validate_b",
							data : {
								username : mobile,
								password : password,
								level:"lpt2"
							},
							success : function(res) {
								var obj = eval('(' + res + ')');
								for ( var i in obj) {
									if (i == "success") {
										window.location.href = "community/hospital";
									}
									if (i == "error_0") {
										$("#username-tips2").text(obj[i]);
									}
									if (i == "error_1") {
										//alert(obj[i]);
										$("#password-tips2").text(obj[i]);
									}
								}
							},
							contentType : "application/x-www-form-urlencoded;charset=UTF-8"
						});
			});
			//初始化页面时验证是否记住了密码 
			if ($.cookie("remberInput") == "true") {
				alert('cookie');
				$("#remberInput").attr("checked", true);
				$("#username").val($.cookie("userName"));
				$("#password").val($.cookie("passWord"));
			}
			//保存用户信息 
			function saveUserInfo() {
				alert($("#remberInput").attr("checked"));
				if ($("#remberInput").attr("checked") == true) {
					var userName = $("#username").val();
					var passWord = $("#password").val();
					$.cookie("remberInput", "true", {
						expires : 7
					}); // 存储一个带7天期限的 cookie 
					$.cookie("userName", userName, {
						expires : 7
					}); // 存储一个带7天期限的 cookie 
					$.cookie("passWord", passWord, {
						expires : 7
					}); // 存储一个带7天期限的 cookie 
				} else {
					$.cookie("remberInput", "false", {
						expires : -1
					});
					$.cookie("userName", '', {
						expires : -1
					});
					$.cookie("passWord", '', {
						expires : -1
					});
				}
			}

		});
	</script>
</body>
</html>


