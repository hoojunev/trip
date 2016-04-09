package cn.project.travel.user.action;

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

public class UserAction extends BaseAction {

	private Travelline travelline;

	private String firstStartTime;

	private String secondStartTime;

	// private String guideId;

	private String guideName;

	private Guide guide;

	@Resource
	private GuideService guideService;

	@Resource
	private TravellineService travellineService;

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

	public String guideUI() {

		guide = guideService.findGuideByName(guideName);
		// guide = guideService.findObjectById(guideId);
		return "guideUI";
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

	public String getSecondStartTime() {
		return secondStartTime;
	}

	public void setSecondStartTime(String secondStartTime) {
		this.secondStartTime = secondStartTime;
	}

	// public String getGuideId() {
	// return guideId;
	// }
	//
	// public void setGuideId(String guideId) {
	// this.guideId = guideId;
	// }

	public Guide getGuide() {
		return guide;
	}

	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

}
