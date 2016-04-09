package cn.project.travel.travelline.service;

import java.util.List;

import cn.project.core.service.BaseService;
import cn.project.travel.guide.entity.Guide;
import cn.project.travel.travelline.entity.Travelline;

public interface TravellineService extends BaseService<Travelline> {

	public List<Guide> getGuides();
}
