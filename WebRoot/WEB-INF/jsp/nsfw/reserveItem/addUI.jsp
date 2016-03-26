<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>预约服务管理</title>

    <script>
    function getDealDeptr(){
		//1、获取部门
		var dept = $("#itemDept").val();
		if(dept != ""){
    		//2、根据部门到数据库中查询人员列表并返回json对象
    		$.ajax({
    			url:"${basePath}nsfw/reserveItem_getDealDeptr.action",
    			type:"post",
    			data:{"item.itemDept":dept},
    			dataType:"json",
    			success:function(data){
    				if(data != null && data != undefined){
    					if("success" == data.msg){
    					
    						var $dealDeptr = $("#dealDeptr");
    						$("#defaultOption").nextAll().remove();
    						
    						$.each(data.userList, function(index,user){
    							$dealDeptr.append("<option value='"+ user.name +"' id='"+user.id+"'>" + user.name+ "</option>");
    						});
    					} else {alert("获取部门人员列表失败！");}
    				} else {alert("获取部门人员列表失败！");}
    			},
    			error:function(){alert("获取部门人员列表失败！");}
    		});
    		
		} else {
			$("#defaultOption").nextAll().remove();
		}
	}
	
    //获取用户Id
    function getDealDeptrId(){
    	var userId = $("#dealDeptr :selected").attr("id");
    	$("#userId").val(userId); 
    }
    
    //提交表单
    function doSubmit(){
    	document.forms[0].action = "${basePath}nsfw/reserveItem_add.action";
    	if($("#userId").val()==""){
    		alert("请选择处理人员");
    		return false;
    	}else{
    		document.forms[0].submit();
    	}
    }
    </script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}nsfw/reserveItem_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>预约事项</strong>&nbsp;-&nbsp;新增事项</div></div>
    <div class="tableH2">新增事项</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">事项编号：</td>
            <td><s:textfield name="item.itemNo"/></td>
            <td class="tdBg" width="200px">事项名称：</td>
            <td><s:textfield name="item.itemName"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">处理部门：</td>
            <td colspan="3"><s:select name="item.itemDept" id="itemDept" list="#{'':'请选择','部门A':'部门A','部门B':'部门B'}" onchange="getDealDeptr()"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">处理人：</td>
            <td colspan="3">
            	<select id="dealDeptr" name="item.itemDealDeptr" onchange="getDealDeptrId()">
            		<option value="" id="defaultOption">请选择</option>
            	</select>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td colspan="3"><s:radio name="item.itemState" list="#{'1':'有效','0':'无效'}"/></td>
        </tr>
        
    </table>
    <s:hidden name="strItemTitle"/>
    <s:hidden name="strItemDept"/>
	<input type="hidden" name="item.userId"id="userId">
    <div class="tc mt20">
        <input type="button" class="btnB2" onclick="doSubmit()" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>