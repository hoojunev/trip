<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>旅游线路管理</title>
    <script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
  	//全选、全反选
	function doSelectAll(){
		$("input[name=selectedRow]").prop("checked", $("#selAll").is(":checked"));		
	}
  	//新增
  	function doAdd(){
  		document.forms[0].action = "${basePath}travel/travelline_addUI.action";
  		document.forms[0].submit();
  	}
  	//编辑
  	function doEdit(id){
  		document.forms[0].action = "${basePath}travel/travelline_editUI.action?travelline.id=" + id;
  		document.forms[0].submit();
  		
  	}
  	//删除
  	function doDelete(id){
  		document.forms[0].action = "${basePath}travel/travelline_delete.action?travelline.id=" + id;
  		document.forms[0].submit();
  	}
  	//批量删除
  	function doDeleteAll(){
  		document.forms[0].action = "${basePath}travel/role_deleteSelected.action";
  		document.forms[0].submit();
  	}
  	//搜索
  	function doSearch(){
  		document.forms[0].action = list_url;
  		document.forms[0].submit();
  	}
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>旅游线路管理</strong></div> </div>
                <div class="search_art">
                    <li>
                        线路名称：<s:textfield name="travelline.attraction" cssClass="s_text" id="infoTitle"  cssStyle="width:160px;"/>
                    </li>
                    <li>
                       	开始时间：<s:textfield id="startTime" name="firstStartTime" cssClass="s_text"  cssStyle="width:160px;" 
                       	readonly="true" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})"/>
                             	 至 
                             <s:textfield id="endTime" name="secondStartTime" cssClass="s_text"  cssStyle="width:160px;"
                              readonly="true" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd()"/>&nbsp;
                        <input type="button" value="更新" class="s_button" onclick="doEdit()"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="120" align="center">线路名称</td>
                            <td width="120" align="center">开始时间</td>
                            <td width="140" align="center">结束时间</td>
                            <td width="80" align="center">花费</td>
                            <td width="120" align="center">导游</td>
                        </tr>
                        <s:iterator value="pageResult.items" status="st">
                            <tr <s:if test="#st.odd"> bgcolor="#f8f8f8" </s:if> >
                                <td align="center"><input type="checkbox" name="selectedRow" value="<s:property value='id'/>"/></td>
                                <td align="center"><s:property value="attraction"/></td>
                                <td align="center"><s:date name="startTime" format="yyyy-MM-dd HH:mm"/></td>
                                <td align="center"><s:date name="endTime" format="yyyy-MM-dd HH:mm"/></td>
                                <td align="center"><s:property value="costs"/></td>
                                <td align="center"><s:property value="tourist"/></td>
                            </tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
        <jsp:include page="/common/pageNavigator.jsp"></jsp:include>
        </div>
    </div>
</form>

</body>
</html>