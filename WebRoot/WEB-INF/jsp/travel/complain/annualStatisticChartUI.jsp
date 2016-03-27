<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	
	int curYear = Calendar.getInstance().get(Calendar.YEAR);
	request.setAttribute("curYear", curYear);
	
	List yearList = new ArrayList();
	for(int i = curYear; i > curYear -5; i--){
		yearList.add(i);
	}
	
	request.setAttribute("yearList", yearList);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <%@include file="/common/header.jsp"%>
    <title>年度投诉统计图</title>
    <script type="text/javascript" src="${basePath }js/fusioncharts/fusioncharts.js"></script>
	<script type="text/javascript" src="${basePath }js/fusioncharts/themes/fusioncharts.theme.fint.js"></script>
	<script type="text/javascript">
	  
	$(document).ready(doAnnualStatistic());
	  
	  // 根据年度或该年度下的每个月对应的投诉数并渲染统计图表
	  function doAnnualStatistic(){
		  //1、获取年份
		  var year = $("#year").val();
		  if(year == undefined || year == "") year = "${curYear}";
		  
		  //2、根据年度或该年度下的每个月对应的投诉数
		  $.ajax({
			  url:"${basePath}travel/complain_getAnnualStatisticData.action",
			  data:{"year":year},
			  dataType:"json",
			  type:"get",
			  success:function(data){
				//3、将投诉数渲染到统计图表中
				if(data != null && data != undefined){
					if("success" == data.msg){
						//------------------------------fusioncharts start
						//3、将投诉数渲染到统计图表中
						var revenueChart = new FusionCharts({
						        "type": "line",
						        "renderAt": "chartContainer",
						        "width": "600",
						        "height": "450",
						        "dataFormat": "json",
						        "dataSource":  {
						          "chart": {
						            "caption": year + "年度投诉数统计图",
						            "xAxisName": "月  份",
						            "yAxisName": "投  诉  数",
						            "theme": "fint"
						         },
						         "data": data.chartData
						      }
						
						  });
					revenueChart.render();
						
						//------------------------------fusioncharts end
					} else {alert("统计投诉数失败！");}
				} else {alert("统计投诉数失败！");}
			  },
			  error:function(){alert("统计投诉数失败！");}
		  });
			  
		  
	  }
	</script>
    
  </head>
  
  <body>
	 <div style="width: 100%;text-align: center;">
	  	<br>
	    <s:select id="year" list="#request.yearList" onchange="doAnnualStatistic()"></s:select>
	    <br>
	    <div id="chartContainer"></div>
    </div>
  </body>
</html>
