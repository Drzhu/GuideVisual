<%@ page language="java" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<%@ include file="../common/lpt1_common.jsp" %>
		<title>manage-chart</title>
	</head>
	<body>
		<div id="sidebar" class="col-sm-3 col-lg-2 sidebar">
			<ul class="nav-list">
	            <li ><a href="hospital"><i class="fa fa-dashboard"></i> 医院信息</a></li>
				<li><a href="course"><i class="fa fa-th"></i> 课程信息</a></li>
				<li><a href="patient"><i class="fa fa-info-circle"></i> 患者信息</a></li>
				<li class="active"><a href="date"><i class="fa fa-calendar"></i> 日期信息</a></li>
	        	<li><a href="query_detailinfo"><i class="fa fa-user-md"></i> 医生查询 </a></li>
	        </ul>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
			<div class="row">
				<ol class="breadcrumb">
				  <li><i class="fa fa-home"></i> 日期信息</li>
				</ol>
			</div>
			<div class="row margin-top">
				<div class="col-sm-12">
					<div class="panel panel-info">
						<div class="panel-heading">日期统计</div>
						<div class="panel-body">
							<div id="date_line" style="width: 100%; height: 450px;"></div>
							<h3 class="color-info">统计表格</h3>
							<div class="table-responsive">
											<!--全国表格start-->
											<table class="table table-bordered table-hover table-striped">
												<tr>
													<th>日期</th>
													<th>录制课程数</th>
													<th>医生注册数</th>
												</tr>
												<c:forEach var="item" items="${Line_date}" varStatus="status">
												<tr>
												<td>${item.date}</td>
												<td>${item.course_num}</td>
												<td>${item.doctor_reg_num}</td>
												</tr>
												</c:forEach>
											</table>	
										</div>
						</div>
					</div>
				</div>
			</div>	
		</div>
		<script src="../js/manage_option/line.js"></script>
		<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
     var Date_info_chart = echarts.init(document.getElementById('date_line'));
     date_legend_list=[];
		date_data1_list=[];
		date_data2_list=[];
		<c:forEach var="item" items="${Line_date}" varStatus="status">
		date_legend_list.push('${item.date}');
		
		date_data1_list.push(parseInt('${item.course_num}'));
		date_data2_list.push(parseInt('${item.doctor_reg_num}'));
		</c:forEach>
		var date_line_option = date_line(date_legend_list,date_data1_list,date_data2_list); 
        // 指定图表的配置项和数据
		
        // 使用刚指定的配置项和数据显示图表。
        Date_info_chart.setOption(date_line_option);
        window.onresize = Date_info_chart.resize;
    </script>
	</body>
</html>
