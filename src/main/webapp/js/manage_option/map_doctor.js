/**
 * 
 */
function map_doctor_option(doc_prov_list) {
	var option = {
		title : {
			text : '全国医生分布',
			left : 'center',
			textStyle : {
				fontSize:25,
				color : '#001934',
				fontWeight :'normal'
			}
		},
		tooltip : {
			trigger : 'item'
		},
		legend : {
			show : false,
			orient : 'vertical',
			x : 'left',
			textStyle : {
				fontSize : 9,
			},
			data : [ '医生人数' ]
		},
		visualMap : {
			min : 0,
			max : 500,
			x : 'left',
			y : 'top',
			itemWidth : 10,
			calculable : false,
			/* color : [ '#FFA200','#87CEFA'], */
			text : [ '高', '低' ], // 文本，默认为数值文本
			calculable : true
		},
		series : [ {
			tooltip : {
				trigger : 'item',
			},
			name : '医生人数',
			type : 'map',
			mapType : 'china',
			layoutCenter : [ '50%', '50%' ],
			// 如果宽高比大于 1 则宽度为 100，如果小于 1 则高度为 100，保证了不超过 100x100 的区域
			layoutSize : 500,
			selectedMode : 'single',
			label : {
				normal : {
					show : true,
					textStyle : {
						fontSize : 10,
					}
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : 10,
					}
				}
			},
			showLegendSymbol : false,
			data : doc_prov_list
		}, ],
	};
	return option;
}