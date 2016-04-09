package cn.project.travel.guide.action;

import java.net.URLDecoder;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cn.project.core.action.BaseAction;
import cn.project.core.exception.ActionException;
import cn.project.core.util.QueryHelper;
import cn.project.travel.guide.entity.Guide;
import cn.project.travel.guide.service.GuideService;

public class GuideAction extends BaseAction {

	@Resource
	private GuideService guideService;

	private Guide guide;

	private String strName;

	private String strSex;

	// 列表页面
	public String listUI() throws ActionException {
		// 加载分类集合
		QueryHelper queryHelper = new QueryHelper(Guide.class, "g");
		try {
			if (guide != null) {
				if (StringUtils.isNotBlank(guide.getName())) {
					guide.setName(URLDecoder.decode(guide.getName(), "utf-8"));
					queryHelper.addCondition("t.attraction like ?", "%" + guide.getName() + "%");
				}
				if (StringUtils.isNotBlank(guide.getSex())) {
					queryHelper.addCondition("g.sex= ?", guide.getSex());
				}
			}

			pageResult = guideService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listUI";
	}

	// 跳转到新增页面
	public String addUI() {
		if (guide != null) {
			strName = guide.getName();
			setStrSex(guide.getSex());
		}
		return "addUI";
	}

	// 保存新增
	public String add() {
		try {
			if (guide != null) {
				guideService.save(guide);
			}
			guide = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// guides = guideService.findObjects();
		return "list";
	}

	// 跳转到修改页面

	public String editUI() {
		if (selectedRow != null && selectedRow.length == 1) {
			if (StringUtils.isNotBlank(guide.getName())) {
				strName = guide.getName();
			}
			guide = guideService.findObjectById(selectedRow[0]);
		}
		return "editUI";
	}

	// 保存修改
	public String edit() {
		guideService.update(guide);
		return "list";
	}

	// 批量删除导游
	public String deleteSelected() {

		if (StringUtils.isNotBlank(guide.getName())) {
			strName = guide.getName();
		}
		if (selectedRow != null) {
			for (String element : selectedRow) {
				guideService.delete(element);
			}
		}
		return "list";
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getStrSex() {
		return strSex;
	}

	public void setStrSex(String strSex) {
		this.strSex = strSex;
	}

}
