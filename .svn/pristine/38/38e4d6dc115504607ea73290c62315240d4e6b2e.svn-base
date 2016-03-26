package cn.itcast.nsfw.complain.service;

import java.util.List;
import java.util.Map;

import cn.itcast.core.service.BaseService;
import cn.itcast.nsfw.complain.entity.Complain;

public interface ComplainService extends BaseService<Complain> {
	
	/**
	 * 自动受理本月之前的投诉信息，将待受理的投诉信息的状态修改为已失效
	 */
	public void autoDeal();

	/**
	 * 获取该年份每月对应的投诉数列表
	 * @param year 年份
	 * @return 12个月的投诉数列表
	 */
	public List<Map<String, Object>> getAnnualStatisticDataByYear(int year);

}
