<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>导游管理</title>
<script type="text/javascript"
	src="${basePath }js/datepicker/WdatePicker.js"></script>
</head>
<body class="rightBody">
	<form id="form" name="form"
		action="${basePath }travel/guide_add.action" method="post"
		enctype="multipart/form-data">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>导游添加管理</strong>
						</div>
					</div>
					<div class="tableH2">新增信息</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="tdBg" width="100px">导游名称：</td>
							<td colspan="3"><s:textfield name="guide.name"
									cssStyle="width:90%;" /></td>
									<td class="tdBg" width="100px"></td>
									<td colspan="3"></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">导游性别：</td>
							<td colspan="3"><s:textfield name="guide.sex"
									cssStyle="width:90%;" /></td>
							<td class="tdBg" width="200px">导游年龄：</td>
							<td colspan="3"><s:textfield name="guide.age"
									cssStyle="width:90%;" /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">导游身高：</td>
							<td colspan="3"><s:textfield name="guide.height"
									cssStyle="width:90%;" /></td>
									<td class="tdBg" width="100px"></td>
									<td colspan="3"></td>
						</tr>
						
					</table>
					<!-- 暂存查询条件 -->
					<s:hidden name="strName" />
					<s:hidden name="strSex" />
					<div class="tc mt20">
						<input type="submit" class="btnB2" value="保存" />
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
							onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>