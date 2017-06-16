<%@ page language="java" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<%@ include file="../common/lpt1_common.jsp" %>
		<title>课程信息</title>
	</head>
	<body>
		<div id="sidebar" class="col-sm-3 col-lg-2 sidebar">
			<ul class="nav-list">
	     	  <li ><a href="hospital"><i class="fa fa-dashboard"></i> 医院信息</a></li>
				<li class="active"><a href="course"><i class="fa fa-th"></i> 课程信息</a></li>
				<li><a href="patient"><i class="fa fa-info-circle"></i> 患者信息</a></li>
				<li><a href="date"><i class="fa fa-calendar"></i> 日期信息</a></li>
				<li><a href="query_detailinfo"><i class="fa fa-user-md"></i> 医生查询 </a></li>
	        </ul>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
			<div class="row">
				<ol class="breadcrumb">
				  <li><i class="fa fa-home"></i> 课程信息</li>
				</ol>
			</div>
			<div class="row margin-top">
				<div class="col-sm-12">
					<div class="panel panel-info">
						<div class="panel-heading">课程统计</div>
						<div class="panel-body">
							<div id="course_cal" style="width: 100%; height: 700px;"></div>
							<h3 class="color-info">统计表格</h3>
							<div class="table-responsive">
											<!--全国表格start-->
											<table class="table table-bordered table-hover table-striped">
												<tr>
													<th>课程名称</th>
													<th>录制课程数目</th>
												</tr>
												<c:forEach var="item" items="${Pie_course}" varStatus="status">
												<tr>
												<td>${item.kecheng_name}</td>
												<td>${item.kecheng_num}</td>
												</tr>
												</c:forEach>
											</table>	
										</div>
						</div>
					</div>
				</div>
			</div>	
		</div>
		
		<script src="../js/china.js"></script>
		<script src="../js/manage_option/pie_keshi.js"></script>
		<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
		var Pie_course_chart = echarts.init(document.getElementById('course_cal'));
		var course_legend_list = [];
    	var course_data_list = [];
		<c:forEach var="item" items="${Pie_course}" varStatus="status">
		var course_dict= {};
		course_legend_list.push('${item.kecheng_name}');
		course_dict["name"]='${item.kecheng_name}';
		course_dict["value"]=${item.kecheng_num};
		course_data_list.push(course_dict);
		</c:forEach>
		var pie_course_option = pie_course(course_legend_list,course_data_list);
        // 使用刚指定的配置项和数据显示图表。
         Pie_course_chart.setOption(pie_course_option);
        window.onresize = Pie_course_chart.resize;
    </script>
	</body>
</html>
