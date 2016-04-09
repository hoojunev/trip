<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>导游信息</title>
  
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}travel/guide_edit.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>导游信息查看</strong></div></div>
    <div class="tableH2">导游详细信息</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">导游姓名：</td>
            <td><s:property value="guide.name"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">导游性别：</td>
            <td colspan="3"><s:property value="guide.sex"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">导游年龄：</td>
            <td colspan="3"><s:property value="guide.age"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">导游身高：</td>
            <td colspan="3"><s:property value="guide.height"/></td>
        </tr>
       
    </table>
    <div class="tc mt20">
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>