package cn.itcast.core.util;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
	
	//from子句
	private String fromClause = "";
	//where子句
	private String whereClause = "";
	//order by子句
	private String orderByClause = "";
	
	//查询条件值集合
	private List<Object> parameters;
	
	//排序序列 升序
	public static final String ORDER_BY_ASC = "ASC";
	//排序序列 降序
	public static final String ORDER_BY_DESC = "DESC";
	
	/**
	 * 构造from子句
	 * @param clazz 查询实体
	 * @param alias 实体对应的别名
	 */
	public QueryHelper(Class clazz , String alias){
		fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}
	
	/**
	 * 构造where子句
	 * @param condition 查询条件；如：i.title like ?
	 * @param params 查询语句Hql中?对应的查询条件值；如： %信息标题%
	 */
	public void addCondition(String condition, Object... params){
		if(whereClause.length() > 0){
			//非第一个查询条件，关键字为and
			whereClause += " AND " + condition;
		} else {
			//第一个查询条件，关键字为where
			whereClause = " WHERE " + condition;
		}
		
		//处理查询条件值集合
		if(parameters == null) parameters = new ArrayList<Object>();
		
		if(params != null){
			for(Object param: params){
				parameters.add(param);
			}
		}
	}
	
	/**
	 * 构造order by子句
	 * @param property 排序属性；如：i.createTime
	 * @param order 排序序列，升序（ASC）或降序(DESC)
	 */
	public void addOrderByProperty(String property, String order){
		if(orderByClause.length() > 0){
			//非第一个排序属性，关键字为,
			orderByClause += "," + property + " " + order;
		} else {
			//第一个排序属性，关键字为order by
			orderByClause = " ORDER BY " + property + " " + order;
		}
	}
	
	//查询语句hql
	public String getListHql(){
		return fromClause + whereClause + orderByClause;
	}
	
	//查询总记录数语句hql
	public String getCountHql(){
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}
	
	//查询语句hql中对应的查询条件值集合
	public List<Object> getParameters(){
		return parameters;
	}
}
