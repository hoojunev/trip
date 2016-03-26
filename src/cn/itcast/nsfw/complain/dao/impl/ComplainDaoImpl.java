package cn.itcast.nsfw.complain.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;

import cn.itcast.core.dao.impl.BaseDaoImpl;
import cn.itcast.nsfw.complain.dao.ComplainDao;
import cn.itcast.nsfw.complain.entity.Complain;

public class ComplainDaoImpl extends BaseDaoImpl<Complain> implements ComplainDao {

	@Override
	public void updateStateByStateAndBeforeCompTime(String updateState, String whereState, Date compTime) {
		getCurrentSession().createQuery("UPDATE Complain SET state=? WHERE state=? AND compTime<?")
		.setParameter(0, updateState)
		.setParameter(1, whereState)
		.setParameter(2, compTime)
		.executeUpdate();
	}

	@Override
	public List<Object[]> getAnnualStatisticDataByYear(int year) {
		StringBuilder sb = new StringBuilder("select t1.imonth,t2.c2");
		sb.append(" from tmonth t1 left join ")
		.append(" (")
		.append("select month(comp_time) c1,count(*) c2 from complain where year(comp_time)=? group by month(comp_time)")
		.append(") t2")
		.append(" on t1.imonth=t2.c1")
		.append(" order by t1.imonth");
		
		SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sb.toString());
		sqlQuery.setParameter(0, year);
		return sqlQuery.list();
	}

}
