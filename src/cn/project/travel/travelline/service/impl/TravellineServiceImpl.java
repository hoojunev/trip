package cn.project.travel.travelline.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.project.core.service.impl.BaseServiceImpl;
import cn.project.travel.travelline.dao.TravellineDao;
import cn.project.travel.travelline.entity.Travelline;
import cn.project.travel.travelline.service.TravellineService;

@Service("travellineService")
public class TravellineServiceImpl extends BaseServiceImpl<Travelline> implements TravellineService {

	private TravellineDao travellineDao;

	@Resource
	public void setTravellineDao(TravellineDao travellineDao) {
		super.setBaseDao(travellineDao);
		this.travellineDao = travellineDao;
	}
}
