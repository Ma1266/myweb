package cn.mwm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.mwm.exception.BusinessException;
import cn.mwm.pageModel.Page;


/**
 * 
 * @author Administrator
 *
 */
public interface IbaseDao<T> {

	public Serializable save(T o) throws BusinessException;

	public void delete(T o);

	public void update(T o);

	public void saveOrUpdate(T o);

	public T get(Class<T> c, Serializable id);

	public T get(Class<T> c);

	public T get(String hql);

	public T get(String hql, Map<String, Object> params);

	public List<T> find(String hql);

	public List<T> find(String hql, Map<String, Object> params);

	public List<T> find(String hql, int page, int rows);

	public List<T> find(String hql, Map<String, Object> params, int page, int rows);
	/**
	 * 
	* @Title: find 
	* @Description: TODO(分页查询数据列表) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param @param hql
	* @param @param params
	* @param @param pageUtil
	* @param @return    设定文件 
	* @return List<T>    返回类型 
	* @throws 
	* @date 2014-9-18 下午12:50:18 
	* @version V1.0
	 */
	public List<T> find(StringBuffer hql, Map<String, Object> params, Page page);

	public Long count(String hql);

	public Long count(String hql, Map<String, Object> params);

	public int executeHql(String hql);

	public List findBySQL(String sql);

}
