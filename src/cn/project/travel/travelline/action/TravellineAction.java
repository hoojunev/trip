package cn.project.travel.travelline.action;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import cn.project.core.action.BaseAction;
import cn.project.core.exception.ActionException;
import cn.project.core.util.QueryHelper;
import cn.project.travel.guide.entity.Guide;
import cn.project.travel.guide.service.GuideService;
import cn.project.travel.travelline.entity.Travelline;
import cn.project.travel.travelline.service.TravellineService;

public class TravellineAction extends BaseAction {

	private Travelline travelline;

	@Resource
	private TravellineService travellineService;

	@Resource
	private GuideService guideService;

	private List<Guide> guides;

	private String firstStartTime;

	private String secondStartTime;

	private String strTravelline;

	// 列表页面
	public String listUI() throws ActionException {
		// 加载分类集合
		QueryHelper queryHelper = new QueryHelper(Travelline.class, "t");
		try {
			if (travelline != null) {
				if (StringUtils.isNotBlank(travelline.getAttraction())) {
					travelline.setAttraction(URLDecoder.decode(travelline.getAttraction(), "utf-8"));
					queryHelper.addCondition("t.attraction like ?", "%" + travelline.getAttraction() + "%");
				}
				if (StringUtils.isNotBlank(firstStartTime)) {
					queryHelper.addCondition("t.startTime >= ?",
						DateUtils.parseDate(firstStartTime + ":00", "yyyy-MM-dd HH:mm:ss"));
				}
				if (StringUtils.isNotBlank(secondStartTime)) {
					queryHelper.addCondition("t.startTime <= ?",
						DateUtils.parseDate(secondStartTime + ":00", "yyyy-MM-dd HH:mm:ss"));
				}
			}
			// 根据创建时间降序排序
			queryHelper.addOrderByProperty("t.startTime", QueryHelper.ORDER_BY_ASC);

			pageResult = travellineService.getPageResult(queryHelper, getPageNo(), getPageSize());
			for (Travelline travelline : (List<Travelline>) pageResult.getItems()) {
				Guide guide = guideService.findObjectById(travelline.getTourist());
				if (guide != null) {
					travelline.setTourist(guide.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listUI";
	}

	// 跳转到新增页面
	public String addUI() {
		if (travelline != null) {
			strTravelline = travelline.getAttraction();
		}
		guides = travellineService.getGuides();
		return "addUI";
	}

	// 保存新增
	public String add() {
		try {
			if (travelline != null) {
				travellineService.save(travelline);
			}
			travelline = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// guides = guideService.findObjects();
		return "list";
	}

	// 跳转到修改页面

	public String editUI() {
		if (travelline != null && StringUtils.isNotBlank(travelline.getId())) {

			if (StringUtils.isNotBlank(travelline.getAttraction())) {
				strTravelline = travelline.getAttraction();
			}
		}
		return "editUI";
	}

	// 保存修改
	public String edit() {
		travellineService.update(travelline);
		return "list";
	}

	// 批量删除线路
	public String deleteSelected() {

		if (StringUtils.isNotBlank(travelline.getAttraction())) {
			strTravelline = travelline.getAttraction();
		}
		if (selectedRow != null) {
			for (String element : selectedRow) {
				travellineService.delete(element);
			}
		}
		return "list";
	}

	public Travelline getTravelline() {
		return travelline;
	}

	public void setTravelline(Travelline travelline) {
		this.travelline = travelline;
	}

	public String getFirstStartTime() {
		return firstStartTime;
	}

	public void setFirstStartTime(String firstStartTime) {
		this.firstStartTime = firstStartTime;
	}

	public String getStrTravelline() {
		return strTravelline;
	}

	public String getSecondStartTime() {
		return secondStartTime;
	}

	public void setSecondStartTime(String secondStartTime) {
		this.secondStartTime = secondStartTime;
	}

	public void setStrTravelline(String strTravelline) {
		this.strTravelline = strTravelline;
	}

	public List<Guide> getGuides() {
		return guides;
	}

	public void setGuides(List<Guide> guides) {
		this.guides = guides;
	}

}
