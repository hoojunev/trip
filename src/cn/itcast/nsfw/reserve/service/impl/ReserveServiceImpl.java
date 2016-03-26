package cn.itcast.nsfw.reserve.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.itcast.core.service.impl.BaseServiceImpl;
import cn.itcast.nsfw.reserve.dao.ReserveDao;
import cn.itcast.nsfw.reserve.entity.Reserve;
import cn.itcast.nsfw.reserve.service.ReserveService;

@Service("reserveService")
public class ReserveServiceImpl extends BaseServiceImpl<Reserve> implements ReserveService {
	private ReserveDao reserveDao;
	
	@Resource
	public void setReserveDao(ReserveDao reserveDao){
		super.setBaseDao(reserveDao);
		this.reserveDao = reserveDao;
	}

}