<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>我要预约</title>
    <script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
   	    var isFull = false;
   		var verifyReserveTime = function(){
			$.ajax({
   				url:"${basePath}sys/home_reserveFullorNot.action",
   				data:"reserveTime="+$("#reserveTime")[0].value,
   				type:"get",
   				async:true,
   				success:function(msg){
    				if("full" == msg){
    					alert("本日预约已满，请调整预约日期！");
        				isFull = true;
    				}else{
    					isFull = false;
    				}
   				}
   			});
   		}
    		
		function judgeFull(){
   			verifyReserveTime();
   		}
   		
    	//新的预约信息的表单校验
    	$(function(){
    		$("#form").on("submit", function(){
				var item = document.getElementById("reserveItem").value;
    			if(item==null || item==""){
    				alert("请选择预约事项！");
    				return false;
    			}
    			var time = document.getElementById("reserveTime").value;
    			if(time==null || time==""){
    				alert("请选择预约时间！");
    				return false;
    			}else{
    				verifyReserveTime();
    				if(isFull){
    					return false;
    				}
    			}
    			
    			var place = document.getElementById("reservePlace").value;
    			if(place==null || place==""){
    				alert("请填写预约地点！");
    				return false;
    			}
    			
				$.ajax({
    				url:"${basePath}sys/home_reserveAdd.action",
    				data:$("#form").serialize(),
    				type:"post",
    				async:false,
    				success:function(msg){
	    				if("success" == msg){
	        				alert("预约信息提交成功！");
	        	    		window.opener.parent.location.reload(true);
	        	    		window.close();
	    				} else {alert("预约信息提交失败！");}
    				},
    				error: function(){alert("预约信息提交失败！");}
    			});
    		});
    	});
    	
    </script>
</head>
<body>
<form id="form" name="form" action="" method="post" enctype="multipart/form-data">
    <div class="vp_d_1">
        <div style="width=1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <div class="vp_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>工作主页</strong>&nbsp;-&nbsp;我要预约</div></div>
    <div class="tableH2">我要预约</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="250px">预约事项：</td>
            <td><s:select id="reserveItem" name="item.itemId" list="#itemMaps" headerKey="" headerValue="- -可选事项- -"></s:select></td>
        </tr>
        <tr>
            <td class="tdBg">预约时间：</td>
            <td><s:textfield id="reserveTime" name="reserveTime" readonly="true" onchange="judgeFull()"
            	onfocus="WdatePicker({skin:'whyGreen', disabledDays: [0,6], 
            	minDate: '%y-%M-#{%d+1}', maxDate: '%y-#{%M+1}-%d', dateFmt:'yyyy-MM-dd HH:mm'})"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg">预约地点：</td>
            <td><s:textfield id="reservePlace" name="reserve.reservePlace"/></td>
        </tr>
        <tr>
            <td class="tdBg">预约说明：</td>
            <td><s:textfield name="reserve.reserveDeclare"/></td>
        </tr>
        <tr>
            <td class="tdBg">预约人：</td>
            <td><s:property value="%{#session.SYS_USER.name}"/></td>
        </tr>
       
    </table>

    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="window.close()" class="btnB2" value="关闭" />
    </div>
    </div></div>
    <div style="width=1%;float:left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
</form>
</body>
</html>