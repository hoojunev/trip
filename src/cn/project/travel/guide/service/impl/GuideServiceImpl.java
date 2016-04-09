package cn.project.travel.guide.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.project.core.service.impl.BaseServiceImpl;
import cn.project.travel.guide.dao.GuideDao;
import cn.project.travel.guide.entity.Guide;
import cn.project.travel.guide.service.GuideService;

@Service("guideService")
public class GuideServiceImpl extends BaseServiceImpl<Guide> implements GuideService {

	private GuideDao guideDao;

	@Resource
	public void setGuideDao(GuideDao guideDao) {
		super.setBaseDao(guideDao);
		this.guideDao = guideDao;
	}

	@Override
	public Guide findGuideByName(String guideName) {
		return guideDao.findGuideByName(guideName);
	}

}
