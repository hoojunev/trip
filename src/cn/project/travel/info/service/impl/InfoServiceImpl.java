package cn.project.travel.info.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.project.core.service.impl.BaseServiceImpl;
import cn.project.travel.info.dao.InfoDao;
import cn.project.travel.info.entity.Info;
import cn.project.travel.info.service.InfoService;

@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService {
	
	private InfoDao infoDao;
	
	@Resource
	public void setInfoDao(InfoDao infoDao){
		super.setBaseDao(infoDao);
		this.infoDao = infoDao;
	}
}
