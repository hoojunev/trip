package cn.project.core.dao;

import java.io.Serializable;
import java.util.List;

import cn.project.core.util.PageResult;
import cn.project.core.util.QueryHelper;

public interface BaseDao<T> {

	//新增
	public void save(T entity);
	//更新
	public void update(T entity);
	//删除
	public void delete(Serializable id);
	//根据ID查询
	public T findObjectById(Serializable id);
	//查询列表
	public List<T> findObjects();
	//条件查询列表
	public List<T> findObjects(String hql, List<Object> parameters);
	//条件查询列表-查询助手
	public List<T> findObjects(QueryHelper queryHelper);
	/**
	 * 分页条件查询列表-查询助手
	 * @param queryHelper 查询助手
	 * @param pageNo 页号
	 * @param pageSize 页大小
	 * @return 分页对象
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
}
