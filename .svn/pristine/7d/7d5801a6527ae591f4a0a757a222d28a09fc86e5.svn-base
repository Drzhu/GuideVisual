<%@ page language="java" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<link rel="stylesheet" type="text/css"
	href="font-awesome-4.6.3/css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/animate.min.css" />
<link rel="shortcut icon" href="img/guide.ico" />
<title>盖德医学数据中心</title>
<style type="text/css">
body {
	background: url(img/gobg.jpg) no-repeat 0 0;
	background-size:100%;
}

.show-box {
	width: 80%;
	padding: 0;
	margin: 35% auto 10% auto;
	list-style: none;
}

.show-box>li>button {
	border: none;
	font-size: 2.4rem;
	padding: 2.8rem;
	color: #FFF;
	width: 100%;
	margin-bottom: 2rem;
}

.show-box .block1{background-color:#A957AC;}	
.show-box .block2{background-color:#0565c3;}
.show-box .block3{background-color:#66C010;}
.show-box .block1:hover{background-color:#a050a2; border:2px solid rgba(255,255,255,.6);}
.show-box .block2:hover{background-color:#065cb1; border:2px solid rgba(255,255,255,.6);}
.show-box .block3:hover{background-color:#5cad0f; border:2px solid rgba(255,255,255,.6);}
</style>
</head>
<body>
	<ul class="show-box">
		<li>
			<button type="button" id="block1" class="block1">ASCVD</button>
		</li>
		<li>
			<button type="button" id="block2" class="block2">基层慢病管理</button>
		</li>
		<li>
			<button type="button" id="block3" class="block3" disabled="disabled">百万血管健康</button>
		</li>
	</ul>
	<script src="js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript">
		$("#block1").on("click",function(){
			  window.location.href="mobile_lpt1";
		});
		$("#block2").on("click",function(){
			  window.location.href="mobile_community";
		});
	</script>
</body>
</html>