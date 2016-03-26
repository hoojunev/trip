package cn.itcast.nsfw.complain.dao;

import java.util.Date;
import java.util.List;

import cn.itcast.core.dao.BaseDao;
import cn.itcast.nsfw.complain.entity.Complain;

public interface ComplainDao extends BaseDao<Complain> {

	/**
	 * 更新在compTime之前并状态为whereState对应的投诉的状态为 updateState
	 * @param updateState 即将更新为的状态
	 * @param whereState 条件语句中的状态
	 * @param compTime 对比时间
	 */
	public void updateStateByStateAndBeforeCompTime(String updateState, String whereState, Date compTime);

	/**
	 * 获取该年份每月对应的投诉数列表
	 * @param year 年份
	 * @return 12个月的投诉数列表
	 */
	public List<Object[]> getAnnualStatisticDataByYear(int year);

}
