<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>旅游线路管理</title>
<script type="text/javascript"
	src="${basePath }js/datepicker/WdatePicker.js"></script>
</head>
<body class="rightBody">
	<form id="form" name="form"
		action="${basePath }travel/travelline_add.action" method="post"
		enctype="multipart/form-data">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>旅游线路发布管理</strong>&nbsp;-&nbsp;新增信息
						</div>
					</div>
					<div class="tableH2">新增信息</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="tdBg" width="200px">线路名称：</td>
							<td colspan="3"><s:textfield name="travelline.attraction"
									cssStyle="width:90%;" /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">开始时间：</td>
							<td><s:textfield name="travelline.startTime"
									cssClass="s_text" cssStyle="width:160px;" readonly="true"
									onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})" /></td>
							<td class="tdBg" width="200px">结束时间：</td>
							<td><s:textfield name="travelline.endTime"
									cssClass="s_text" cssStyle="width:160px;" readonly="true"
									onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'})" /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">导游名称：</td>
							<td><select name="travelline.tourist">
									<option value=""></option>
									<s:iterator value="guides">
										<option value="<s:property value='id'/>">
											<s:property value='name' />
										</option>
									</s:iterator>
							</select></td>
							<td class="tdBg" width="200px"></td>
							<td></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">花费：</td>
							<td colspan="3"><s:textfield name="travelline.cost"
									cssStyle="width:90%;" /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">创建人：</td>
							<td><s:property value="#session.SYS_USER.name" /> <s:hidden
									name="info.creator" value="%{#session.SYS_USER.name}"></s:hidden>
							</td>
							<td class="tdBg" width="200px">创建时间：</td>
							<td><s:date name="info.createTime" format="yyyy-MM-dd HH:mm" />
								<s:hidden name="info.createTime"></s:hidden></td>
						</tr>
					</table>
					<!-- 暂存查询条件 -->
					<s:hidden name="strTravelline" />
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