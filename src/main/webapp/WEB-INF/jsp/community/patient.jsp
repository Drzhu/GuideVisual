<%@ page language="java" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/lpt1_common.jsp" %>
<title>manage-chart</title>
</head>
<body>
	<div id="sidebar" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav-list">
			<li><a href="hospital"><i class="fa fa-dashboard"></i> 医院信息</a></li>
			<li><a href="course"><i class="fa fa-th"></i> 课程信息</a></li>
			<li class="active"><a href="patient"><i class="fa fa-info-circle"></i> 患者信息</a></li>
			<li><a href="date"><i class="fa fa-calendar"></i> 日期信息</a></li>
			<li><a href="query_detailinfo"><i class="fa fa-user-md"></i> 医生查询 </a></li>
		</ul>
	</div>
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><i class="fa fa-home"></i> 患者信息</li>
			</ol>
		</div>
		<div class="row margin-top">
			<div class="col-sm-12">
				<div class="panel panel-info">
					<div class="panel-heading">医生患者对比</div>
					<div class="panel-body">
						<div id="bar_doctor" style="width: 100%; height: 600px;"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-info">
					<div class="panel-heading">观看时间对比</div>
					<div class="panel-body">
						<button class="btn btn-sm btn-success pull-right" id="change_log"
							style="position: relative; z-index: 99">log转换</button>
						<div id="bar_viewer" style="width: 100%; height: 600px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../js/manage_option/bar.js"></script>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var Bar_doctor_chart = echarts.init(document
				.getElementById('bar_doctor'));
		var Bar_viewer_chart = echarts.init(document
				.getElementById('bar_viewer'));
		bar1_legend_list = [];
		bar1_data1_list = [];
		bar1_data2_list = [];
		<c:forEach var="item" items="${Bar_doctor}" varStatus="status">
		bar1_legend_list.push('${item.serialName}');
		bar1_data1_list.push(parseInt('${item.serialCount1}'));
		bar1_data2_list.push(parseInt('${item.serialCount2}'));
		</c:forEach>

		var bar_doctor_option = bar1(bar1_legend_list, bar1_data1_list,
				bar1_data2_list);

		bar2_legend_list = [];
		bar2_data1_list = [];
		bar2_data2_list = [];
		<c:forEach var="item" items="${Bar_viewer}" varStatus="status">
		bar2_legend_list.push('${item.serialName}');
		bar2_data1_list.push(parseInt('${item.serialCount1}'));
		bar2_data2_list.push(parseInt('${item.serialCount2}'));
		</c:forEach>
		var bar_viewer_option = bar2(bar2_legend_list, bar2_data1_list,
				bar2_data2_list);
		// 使用刚指定的配置项和数据显示图表。
		Bar_doctor_chart.setOption(bar_doctor_option);
		Bar_viewer_chart.setOption(bar_viewer_option);

		setTimeout(function() {
			window.onresize = function() {
				Bar_doctor_chart.resize();
				Bar_viewer_chart.resize();
			}
		}, 200);
		$("#change_log").on("click", function() {
			if (bar_viewer_option.xAxis.type == "log") {
				bar_viewer_option.xAxis.type = 'value';
				Bar_viewer_chart.setOption(bar_viewer_option);
			} else {
				bar_viewer_option.xAxis.type = 'log';
				Bar_viewer_chart.setOption(bar_viewer_option);
			}
		});
	</script>
</body>
</html>
