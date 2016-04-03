package cn.project.travel.travelline.action;

import java.net.URLDecoder;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import cn.project.core.action.BaseAction;
import cn.project.core.exception.ActionException;
import cn.project.core.util.QueryHelper;
import cn.project.travel.travelline.entity.Travelline;
import cn.project.travel.travelline.service.TravellineService;

public class TravellineAction extends BaseAction {

	private Travelline travelline;

	@Resource
	private TravellineService travellineService;

	private String firstStartTime;

	private String secondStarTime;

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
				if (StringUtils.isNotBlank(secondStarTime)) {
					queryHelper.addCondition("t.startTime <= ?",
						DateUtils.parseDate(secondStarTime + ":00", "yyyy-MM-dd HH:mm:ss"));
				}
			}
			// 根据创建时间降序排序
			queryHelper.addOrderByProperty("t.startTime", QueryHelper.ORDER_BY_ASC);

			pageResult = travellineService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "listUI";
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

	public String getSecondStarTime() {
		return secondStarTime;
	}

	public void setSecondStarTime(String secondStarTime) {
		this.secondStarTime = secondStarTime;
	}

}
