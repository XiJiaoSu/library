<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript" src="./js/echarts.js"></script>
		<script type="text/javascript">
			 // 基于准备好的dom，初始化echarts实例
			function init() {
					var obj={
							type:"post",
							url:"${basePath}order/onums",
							data:JSON.stringify({"num":7}),
							contentType:"application/json"
							};
					$.ajax(obj).done(function(res){
						result(res.result);
					});

			}
			 
			function result(data) {
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
						data: ["1","2","3","4","5","6","7"]
					},
					yAxis: {},
					series: [{
						name: '预约数量',
						type: 'bar',
						data: data
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