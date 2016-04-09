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
  		document.forms[0].action = "${basePath}travel/guide_addUI.action";
  		document.forms[0].submit();
  	}
  	//编辑
  	function doEdit(id){
  		var selectedRow = $("[name=selectedRow]:checked");
  		if(selectedRow.length != 1){
  			alert("请选择一名导游更新");
  			return ;
  		}
  		document.forms[0].action = "${basePath}travel/guide_editUI.action?guide.id=" + id;
  		document.forms[0].submit();
  		
  	}
  	//删除
  	function doDelete(id){
  		document.forms[0].action = "${basePath}travel/guide_delete.action?guide.id=" + id;
  		document.forms[0].submit();
  	}
  	//批量删除
  	function doDeleteAll(){
  		var selectedRow = $("[name=selectedRow]:checked");
  		if(selectedRow.length == 0){
  			alert("请至少选择一名导游删除");
  			return ;
  		}
  		document.forms[0].action = "${basePath}travel/guide_deleteSelected.action";
  		document.forms[0].submit();
  	}
  	var list_url = "${basePath}travel/guide_listUI.action";
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
                <div class="c_crumbs"><div><b></b><strong>导游管理</strong></div> </div>
                <div class="search_art">
                    <li>
                        导游名称：<s:textfield name="guide.name" cssClass="s_text" id="guideName"  cssStyle="width:160px;"/>
                    </li>
                   <li>
                        导游性别：<s:textfield name="guide.sex" cssClass="s_text" id="guideSex"  cssStyle="width:160px;"/>
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
                            <td width="120" align="center">导游名称</td>
                            <td width="120" align="center">性别</td>
                            <td width="140" align="center">年龄</td>
                            <td width="80" align="center">身高</td>
                        </tr>
                        <s:iterator value="pageResult.items" status="st">
                            <tr <s:if test="#st.odd"> bgcolor="#f8f8f8" </s:if> >
                                <td align="center"><input type="checkbox" name="selectedRow" value="<s:property value='id'/>"/></td>
                                <td align="center"><s:property value="name"/></td>
                                <td align="center"><s:property value="sex"/></td>
                                <td align="center"><s:property value="age"/></td>
                                <td align="center"><s:property value="height"/></td>
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