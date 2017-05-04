<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<script type="text/javascript" src="./js/echarts.js"></script>
		<script type="text/javascript">
			 // 基于准备好的dom，初始化echarts实例
			function init() {
				var myChart = echarts.init(document.getElementById('main'));

				// 指定图表的配置项和数据
				var option = {
					title: {
						text: '图书馆预约记录详情'
					},
					toolbox: {show:true , feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            dataView: {readOnly: false},
            magicType: {type: ['line', 'bar']},
            restore: {},
            saveAsImage: {}
        }},
					tooltip: {type: 'showTip'},
					legend: {
						data:['预约数量']
					},
					xAxis: {
						data: ["1月","2月","3月","4月","6月","7月"]
					},
					yAxis: {},
					series: [{
						name: '预约数量',
						type: 'bar',
						data: [35, 30, 16, 10, 40, 5]
					}]
				};

				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
			}
		</script>
</head>
<body onload="init();">
	<div id="main" style="width: 80%;height:700px;"></div>
</body>
</html>