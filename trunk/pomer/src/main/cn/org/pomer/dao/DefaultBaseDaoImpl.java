package cn.org.pomer.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.org.pomer.PageList;
import cn.org.pomer.entity.BaseEntity;

public abstract class DefaultBaseDaoImpl<E extends BaseEntity> extends
		HibernateDaoSupport implements BaseDao<E> {

	public void delete(Long id) {
		Object entity = findById(id);
		getHibernateTemplate().delete(entity);
	}

	public PageList<E> findAll(int start, int limit) {
		StringBuffer hql = new StringBuffer();
		hql.append(" FROM ").append(getEntityClass().getName());
		String defalutOrderFileds = getDefalutOrderFileds();
		if (StringUtils.isNotEmpty(defalutOrderFileds)) {
			hql.append(" order by " + defalutOrderFileds);
		}

		String queryString = hql.toString();
		Query query = getSession().createQuery(queryString);
		//return getHibernateTemplate().find(queryString);F
		return null;
	}

	public List<E> findAll() {
		StringBuffer hql = new StringBuffer();
		hql.append(" FROM ").append(getEntityClass().getName());
		String defalutOrderFileds = getDefalutOrderFileds();
		if (StringUtils.isNotEmpty(defalutOrderFileds)) {
			hql.append(" order by " + defalutOrderFileds);
		}

		String queryString = hql.toString();
		return getHibernateTemplate().find(queryString);
	}

	protected abstract Class getEntityClass();

	protected String getDefalutOrderFileds(){
		return null;
	}

	public List<E> findByExample(E instance) {
		List results = getHibernateTemplate().findByExample(instance);
		return results;
	}

	public E findById(Long id) {
		E entity = (E) getHibernateTemplate().get(getEntityClass(), id);
		return entity;
	}

	public List<E> findByProperty(String propertyName, Object value) {
		if (value != null) {
			String queryString = "from " + getEntityClass().getName()
					+ " as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} else {
			String queryString = "from " + getEntityClass().getName()
					+ " as model where model." + propertyName + " is null";
			return getHibernateTemplate().find(queryString);
		}
	}

	public E insert(E entity) {
		getHibernateTemplate().save(entity);
		return entity;
	}

	public E update(E entity) {
		getHibernateTemplate().merge(entity);
		return entity;
	}

}
