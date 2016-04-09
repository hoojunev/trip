package cn.project.travel.guide.dao.impl;

import org.hibernate.Query;

import cn.project.core.dao.impl.BaseDaoImpl;
import cn.project.travel.guide.dao.GuideDao;
import cn.project.travel.guide.entity.Guide;

public class GuideDaoImpl extends BaseDaoImpl<Guide> implements GuideDao {

	@Override
	public Guide findGuideByName(String guideName) {

		String hql = "FROM Guide WHERE name =?";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter(0, guideName);
		return (Guide) query.uniqueResult();

	}

}
