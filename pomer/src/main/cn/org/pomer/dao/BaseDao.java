package cn.org.pomer.dao;

import java.util.List;

import cn.org.pomer.PageList;
import cn.org.pomer.entity.BaseEntity;

public interface BaseDao<E extends BaseEntity> {
	void delete(Long id);

	PageList<E> findAll(int start, int limit);

	List<E> findAll();

	List<E> findByExample(E instance);

	E findById(Long id);

	List<E> findByProperty(String propertyName, Object value);

	E insert(E entity);

	E update(E entity);
}
