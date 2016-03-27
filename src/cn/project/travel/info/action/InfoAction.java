package cn.project.travel.info.action;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.project.core.action.BaseAction;
import cn.project.core.exception.ActionException;
import cn.project.core.util.PageResult;
import cn.project.core.util.QueryHelper;
import cn.project.travel.info.entity.Info;
import cn.project.travel.info.service.InfoService;

import com.opensymphony.xwork2.ActionContext;

public class InfoAction extends BaseAction {

	@Resource
	private InfoService infoService;

	private Info info;

	private String[] privilegeIds;
	
	private String strTitle;
	
	// 列表页面
	public String listUI() throws ActionException {
		// 加载分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		QueryHelper queryHelper = new QueryHelper(Info.class, "i");
		try {
			if(info != null){
				if(StringUtils.isNotBlank(info.getTitle())){
					info.setTitle(URLDecoder.decode(info.getTitle(), "utf-8"));
					queryHelper.addCondition("i.title like ?", "%"+ info.getTitle() + "%");
				}
				if(StringUtils.isNotBlank(info.getState())){
					queryHelper.addCondition("i.state = ?", info.getState());
				}
			}
			// 根据创建时间降序排序
			queryHelper.addOrderByProperty("i.createTime", QueryHelper.ORDER_BY_DESC);
			
			pageResult = infoService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			return "error";
		}
		return "listUI";
	}

	// 跳转到新增页面
	public String addUI() {
		// 加载分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		if(info != null){
			strTitle = info.getTitle();
		}
		info = new Info();
		info.setCreateTime(new Timestamp(new Date().getTime()));
		return "addUI";
	}

	// 保存新增
	public String add() {
		try {
			if (info != null) {
				infoService.save(info);
			}
			info = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	//
	// 跳转到编辑页面
	public String editUI() {
		// 加载分类集合
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);

		if (info != null && StringUtils.isNotBlank(info.getInfoId())) {
			//避免查询条件被覆盖
			strTitle = info.getTitle();
			info = infoService.findObjectById(info.getInfoId());
		}
		return "editUI";
	}

	// 保存编辑
	public String edit() {
		try {
			if (info != null) {
				infoService.update(info);
			}
			info = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}

	//
	// 根据ID删除
	public String delete() {
		if(info != null){
			strTitle = info.getTitle();
		}
		if (info != null && StringUtils.isNotBlank(info.getInfoId())) {
			infoService.delete(info.getInfoId());
		}
		return "list";
	}

	//
	// 批量删除
	public String deleteSelected() {
		if(info != null){
			strTitle = info.getTitle();
		}
		if (selectedRow != null) {
			for (String id : selectedRow) {
				infoService.delete(id);
			}
		}
		return "list";
	}
	
	//异步信息发布
	public void publicInfo(){
		try {
			//1、更新信息的状态
			if(info != null){
				Info tmp = infoService.findObjectById(info.getInfoId());
				tmp.setState(info.getState());
				infoService.update(tmp);
				
				//2、输出结果
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write("更新状态成功".getBytes("utf-8"));
				outputStream.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getStrTitle() {
		return strTitle;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

}
