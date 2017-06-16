/**
 * 
 */
function pie_keshi(data_legend,data_series) {
	var pie_keshi_option = {
			title : {
				text : '全国医院科室统计',
				left : 'center',
				textStyle : {
					fontSize:25,
					color : '#001934',
					fontWeight :'normal'
				}
			},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
/*			orient :'vertical',*/
			/*left : 'left',*/
			bottom:0,
			align :'left',
			itemGap :5,
			show:true,
			formatter:function (name) {
				return name;
			},
			tooltip: {
		        show: true
		    },
			data : data_legend
		},
		series : [ {
			name : '科室占比',
			type : 'pie',
			radius : '75%',
			center : [ '50%', '53%' ],
			data : data_series,
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};
	return pie_keshi_option;
}

function pie_course(data_legend,data_series){
	var pie_course_option = {
			title : {
				text : '患者教育课程统计',
				left : 'center',
				textStyle : {
					fontSize:25,
					color : '#001934',
					fontWeight :'normal'
				}
			},
			tooltip : {
				trigger : 'item',
				formatter : "{b}<br/> {c} ({d}%)",
			},
			legend : {
				formatter:function (name) {
					
					var ss = name +"                                                                       ";
					return ss.substr(0,10);
				},
				orient :'horizontal',
				/*left : 'left',*/
				bottom:5,
				padding :2,
				itemGap :5,
				show:true,
				data : data_legend,
				tooltip: {
			        show: true
			    },
			    borderColor : '#87C6F1'
			},
			series : [ {
				name : '课程占比',
				type : 'pie',
				radius : '75%',
				center : [ '50%', '48%' ],
				data : data_series,
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};
		return pie_course_option;
	}
