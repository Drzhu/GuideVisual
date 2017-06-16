/**
 * 
 */
function date_line(date_legend_list,date_data1_list,date_data2_list) {
	var option = {
		tooltip : {
			trigger : 'axis'
		},
		grid: {
			left :'7%',
			right :'7%',
			containLabel: false
		},
		legend : {
			data : [ '课程数目', '医生注册数量' ],
			left :'center',
			top: 'top',
			textStyle :{
				fontWeight :'bolder'
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			boundaryGap : true,
			axisLabel :{
				textStyle :{
					fontSize :9,
					fontWeight :'bolder'
				},
				formatter:function (value, index) {
					return value.split("-")[0].substr(2, 4)+"年"+value.split("-")[1]+"月";
				},
				margin :3
			},
			axisTick: {
				show: false
			},
			data : date_legend_list
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				formatter : '{value} ',
				textStyle :{
					fontSize :8,
					fontWeight :'bolder'
				},
				margin :1
			},
			axisTick: {
				show: false
			},
		} ],
		series : [ {
			name : '课程数目',
			type : 'line',
			symbol :'circle',
			symbolSize :5,
			lineStyle :{
				normal :{
					width :3,
				}
			},
			itemStyle : {
				normal : {
					color : '#70B5EC'
				}
			},
			data : date_data1_list,
		}, {
			name : '医生注册数量',
			type : 'line',
			symbolSize :5,
			lineStyle :{
				normal :{
					width :3,
				}
			},
			itemStyle : {
				normal : {
					color : '#D84C29'
				}
			},
			data : date_data2_list,
		} ]
	};
	return option;
}

function new_date_line(date_legend_list,date_data1_list,date_data2_list){
var	option = {
		backgroundColor:"#fff",
		"tooltip": {
			"trigger": "axis",
		},
		grid: {
			top:'40',
			bottom:'40',
			left :'7%',
			right :'7%',
			containLabel: false
		},
		"legend": {
			data : [ '课程数目', '医生注册数量' ],
			left :'center',
			top: 'top',
			textStyle :{
				fontWeight :'bolder'
			}
		},
		"calculable": true,
		"xAxis": [{
			type : 'category',
			boundaryGap : true,
			axisLabel :{
				textStyle :{
					fontSize :9,
					fontWeight :'bolder'
				},
				formatter:function (value, index) {
					return value.split("-")[0].substr(2, 4)+"年"+value.split("-")[1]+"月";
				},
				margin :3
			},
			axisTick: {
				show: false
			},
			data : date_legend_list
		}, 
		],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				formatter : '{value} ',
				textStyle :{
					fontSize :8,
					fontWeight :'bolder'
				},
				margin :1
			},
			axisTick: {
				show: false
			},
		} ],
		"dataZoom": [{
			"show": true,
			"height": 20,
			"xAxisIndex": [0],
			bottom: 0,
			"start": 10,
			"end": 80,
			handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
			handleSize: '120%',
			handleStyle: {
				color: "#00B0FC",
			},
			textStyle: {
				color: "#000",
					fontSize :8,
					fontWeight :'bolder'
			},
			borderColor: "#BBAAE0",
			labelFormatter: function (value) {
			    return date_legend_list[value].split("-")[0].substr(2, 4)+"年"+date_legend_list[value].split("-")[1]+"月";
			}
		}, {
			"type": "inside",
			"show": true,
			"height": 15,
		}],
		/*"series": [{
				"name": "课程数目",
				"type": "line",
				"stack": "总量",
				symbolSize: 5,
				symbol: 'circle',
				lineStyle :{
					normal :{
						width :3,
					}
				},
				"itemStyle": {
					"normal": {
						"color": "#70B5EC",
						"barBorderRadius": 0,
						"label": {
							textStyle :{
								fontSize :8,
								fontWeight :'bolder'
							},
							"show": true,
							"position": "top",
							formatter: function(p) {
								return p.value > 0 ? (p.value) : '';
							}
						}
					}
				},
				"data": date_data1_list
			},{
				"name": "医生注册数量",
				"type": "line",
				"stack": "总量",
				symbolSize: 5,
				symbol: 'circle',
				lineStyle :{
					normal :{
						width :3,
					}
				},
				"itemStyle": {
					"normal": {
						"color": "#D84C29",
						"barBorderRadius": 0,
						"label": {
							textStyle :{
								fontSize :8,
								fontWeight :'bolder'
							},
							"show": true,
							"position": "top",
							formatter: function(p) {
								return p.value > 0 ? (p.value) : '';
							}
						}
					}
				},
				"data":date_data2_list
			},
		]*/
		series:[ {
			name : '课程数目',
			type : 'line',
			symbol :'circle',
			symbolSize :5,
			lineStyle :{
				normal :{
					width :3,
				}
			},
			itemStyle : {
				normal : {
					color : '#70B5EC',
					label: {
						textStyle :{
							fontSize :8,
							fontWeight :'bolder'
						},
						show: true,
						position: "top",
						formatter: function(p) {
							return p.value > 0 ? (p.value) : '';
						}
					}
				}
			},
			data : date_data1_list,
		}, {
			name : '医生注册数量',
			type : 'line',
			symbolSize :5,
			lineStyle :{
				normal :{
					width :3,
				}
			},
			itemStyle : {
				normal : {
					color : '#D84C29',
					label: {
						textStyle :{
							fontSize :8,
							fontWeight :'bolder'
						},
						show: true,
						position: "top",
						formatter: function(p) {
							return p.value > 0 ? (p.value) : '';
						}
					}
				}
			},
			data : date_data2_list,
		} ]
	};
return option;
}
