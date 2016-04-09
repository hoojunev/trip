package cn.project.travel.guide.service;

import cn.project.core.service.BaseService;
import cn.project.travel.guide.entity.Guide;

public interface GuideService extends BaseService<Guide> {

	/**
	 * 查看线路时,通过导游姓名查看导游信息
	 * 
	 * @param guideName
	 * @return
	 */
	public Guide findGuideByName(String guideName);
}
