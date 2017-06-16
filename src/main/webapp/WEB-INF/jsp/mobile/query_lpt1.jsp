<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="shortcut icon" href="img/guide.ico" />
<title>ASCVD信息查询</title>
</head>
<body style="background: #fff;">
	<nav class="navbar navbar-inverse custom-navbar"
		style="margin: 0 -10px;">
		<div class="container">
			<div class="navbar-header">
				<a href="" class="navbar-brand">ASCVD信息查询 </a>
			</div>
		</div>
	</nav>
	<div class="container no-padding">
		<div class="row">
			<div class="col-md-12">
				<table id="doc_info" class="table table-bordered table-hover table-striped" style="width:100%;">
				</table>
			</div>
		</div>
	</div>

	<script src="js/jquery-3.1.0.min.js"></script>
	<script src="js/jquery.dataTables.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script>
	$(function(){
		$('#doc_info').DataTable({
			'lengthChange':false,
			'bdestroy' : true,
			'bRetrieve' : true,
			'aoColumns' : [ {
				title : "城市",
				width:"22%"
			}, {
				title : "姓名",
				width:"21%"
			}, {
				title : "医院",
				width:"36%"
			}, {
				title : "科室",
				width:"22%"
			}, ],
			"serverSide" : true,
			"ajax" : "lpt_datatable_query",
			'language' : {
				'emptyTable' : '没有数据',
				'loadingRecords' : '加载中...',
				'processing' : '查询中...',
				'search' : '<i class="fa fa-search" style="position:absolute; margin:30px 10px; color:#4f9cde;"></i>',
				'lengthMenu' : '每页 _MENU_ 条',
				'zeroRecords' : '没有数据',
				'paginate' : {
					'first' : '首页',
					'last' : '末页',
					'next' : '下页',
					'previous' : '上页'
				},
				'info' : "第 _PAGE_ 页 / 总 _PAGES_ 页，共 _TOTAL_ 条数据",
				'infoEmpty' : '没有数据',
				'infoFiltered' : '(过滤总数 _MAX_ 条)'
			}
		});
		
		$("#doc_info_filter input[type=search]").addClass("form-control").attr("placeholder","按城市、医院、姓名、科室搜索").css("padding-left","30px").val("");
	});	
	</script>
</body>
</html>


