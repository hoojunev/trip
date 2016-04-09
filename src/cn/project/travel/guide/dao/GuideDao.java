package cn.project.travel.guide.dao;

import cn.project.core.dao.BaseDao;
import cn.project.travel.guide.entity.Guide;

public interface GuideDao extends BaseDao<Guide> {

	/**
	 * 查看线路时,通过导游姓名查看导游信息
	 * 
	 * @param guideName
	 * @return
	 */
	public Guide findGuideByName(String guideName);

}
