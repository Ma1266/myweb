package cn.mwm.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mwm.dao.IbaseDao;
import cn.mwm.exception.BusinessException;
import cn.mwm.pageModel.Page;
@Repository("baseDao")
public class BaseDaoImpl<T> implements IbaseDao<T> {

	private SessionFactory SessionFactory;
	
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}
	public Session getSession(){
		return this.SessionFactory.getCurrentSession();	
	}

	@Override
	public Serializable save(T o) throws BusinessException {
		return getSession().save(o);
	}

	@Override
	public void delete(T o) {
		getSession().delete(o);
	}

	@Override
	public void update(T o) {
		getSession().update(o);
	}

	@Override
	public void saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(Class<T> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(Class<T> c) {
		return null;
	}

	@Override
	public T get(String hql) {
		Query q = this.getSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(String hql, Map<String, Object> params) {
		Query q=getSession().createQuery(hql);
		if(null != params && !params.isEmpty()){
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		List<T> l=q.list();
		if (null != l && l.size()>0) {
			return l.get(0);
		}
		}
		return null;
	}

	@Override
	public List<T> find(String hql) {
		List<T> list=getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = this.getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q = this.getSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Map<String, Object> params, int page,
			int rows) {
		Query q = this.getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(StringBuffer hql, Map<String, Object> params,
			Page page) {
		if(page.getSort()!=null && page.getOrder()!=null){
			hql.append(" order by "+page.getSort()+" "+page.getOrder());
		}
		Query q = this.getSession().createQuery(hql.toString());
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page.getPage() - 1) * page.getRows()).setMaxResults(page.getRows()).list();
	}
	@Override
	public Long count(String hql) {
		return (Long) getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public int executeHql(String hql) {
		return getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public List findBySQL(String sql) {
		return getSession().createSQLQuery(sql).list();
	}

}
