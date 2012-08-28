package com.cdpc.aio.common.interfaces;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.cdpc.aio.common.exception.PersistenceException;

/**
 * 
 * Hibernate 工具类
 * 1、提供QBC查询功能
 * 2、提供HQL查询功能
 * 3、提供QBE查询功能
 * 
 * @author evin.liu
 * 
 */
public abstract class BaseDAO<T> extends HibernateDaoSupport {

	private Class<T> persistentClass = null; // 持久化类
	private String persistentClassName = null; // 持久化类全名
	private static Logger log = null;

	public BaseDAO() {
		persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		persistentClassName = persistentClass.getName();
		log = LoggerFactory.getLogger(persistentClass);
	}
	
	//-------------------------------QBC start-----------------------------------------------------------
	/**
	 * 分页查询类
	 * @param pageQuery
	 * @return
	 */
	public PageQuery<T> pageQuery(final PageQuery<T> pageQuery) {
		if(pageQuery == null) {
			return null;
		} else {
			List<T> resultList = (List<T>) getHibernateTemplate().executeFind(
					new HibernateCallback() {

						public Object doInHibernate(Session session) throws HibernateException, SQLException {
							Criteria criteria = session.createCriteria(persistentClass);
							criteria.setFirstResult(pageQuery.getFirstResult());
							criteria.setMaxResults(pageQuery.getMaxResults());
							
							List<Criterion> criterions = pageQuery.getCriterions();
							List<Order> orders = pageQuery.getOrders();
							
							// 计算总记录数量
							int totalSize = countByCriteria(criterions);
							pageQuery.setTotalSize(totalSize);
							
							// 添加查询条件
							for (int i = 0; i < criterions.size(); i++) {
								criteria.add(criterions.get(i));
							}
							
							// 添加排序字段
							for(int i = 0; i < orders.size(); i++) {
								Order order = orders.get(i);
								criteria.addOrder(order);
							}
							return criteria.list();
						}
						
					}
			);
			pageQuery.setPagedata(resultList);
			return pageQuery;
		}
	}

	/**
	 * 根据条件统计记录数量
	 * @param criterion list集合
	 * @return
	 */
	public int countByCriteria(final List<Criterion> criterions) {
		Integer rowSum = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistentClass);
				if (criterions != null) {
					for (Criterion c : criterions) {
						criteria.add(c);
					}
				}
				int count = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				return count;
			}
		});
		return rowSum;
	}
	
	/**
	 * 根据条件统计记录数量
	 * @param criterions
	 * @return
	 */
	public int countByCriteria(final Criterions criterions) {
		Assert.notNull(criterions, "countByCriteria criterions cannot be null.");
		Integer rowSum = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistentClass);
				
				if (criterions != null) {
					for (Criterion c : criterions.list()) {
						criteria.add(c);
					}
				}
				int count = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
				return count;
			}
		});
		return rowSum;
	}
	
	/**
	 * 根据条件查询记录集
	 * @param criterions
	 * @return
	 */
	public List<T> searchByCriteria(final List<Criterion> criterions) {
		List<T> resultList = (List<T>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistentClass);
				if (criterions != null) {
					for (Criterion c : criterions) {
						criteria.add(c);
					}
				}
				return criteria.list();
			}
		});
		return resultList;
	}
	
	/**
	 * 根据条件查询记录集
	 * @param criterions
	 * @return
	 */
	public List<T> searchByCriteria(final Criterions criterions) {
		Assert.notNull(criterions, "searchByCriteria criterions cannot be null.");
		List<T> resultList = (List<T>)this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistentClass);
				if(criterions != null) {
					for(Criterion c : criterions.list()) {
						criteria.add(c);
					}
				}
				return criteria.list();
			}
		});
		return resultList;
	}
	
	/**
	 * 根据条件查询有序记录集
	 * @param criterions
	 * @param orders
	 * @return
	 */
	public List<T> searchByCriteria(final Criterions criterions, final Orders orders) {
		Assert.notNull(criterions, "searchByCriteria criterions cannot be null.");
		List<T> resultList = (List<T>)this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistentClass);
				if(criterions != null) {
					for(Criterion c : criterions.list()) {
						criteria.add(c);
					}
				}
				if(orders != null) {
					for(Order order : orders.list()) {
						criteria.addOrder(order);
					}
				}
				return criteria.list();
			}
		});
		return resultList;
	}
	
	/**
	 * 根据条件查询记录集
	 * @param criterions 可变长数组
	 * @return
	 */
	public List<T> searchByCriteria(final Criterion... criterions) {
		List<T> resultList = (List<T>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistentClass);
				if (criterions != null) {
					for (Criterion c : criterions) {
						criteria.add(c);
					}
				}
				return criteria.list();
			}
		});
		return resultList;
	}
	
	//-------------------------------QBC end-----------------------------------------------------------
	
	//-------------------------------HQL start-----------------------------------------------------------
	/**
	 * 根据hql语句查询特定记录对象
	 * @param hql
	 * @return
	 */
	public T searchByHQL(String hql) {
		List<T> resultList = this.getHibernateTemplate().find(hql);
		if(resultList == null || resultList.size() == 0) {
			return null;
		} else {
			return resultList.get(0);
		}
	}
	
	/**
	 * 根据hql语句查询特定记录对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public T searchByHQL(String hql, Object... params) {
		List<T> resultList = this.getHibernateTemplate().find(hql, params);
		if(resultList == null || resultList.size() == 0) {
			return null;
		} else {
			return resultList.get(0);
		}
	}
	
	/**
	 * 根据hql语句查询记录集合
	 * @param hql
	 * @return
	 */
	public List<T> searchListByHQL(String hqlString) {
		return (List<T>) this.getHibernateTemplate().find(hqlString);
	}
	
	/**
	 * 根据hql语句查询记录集合
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> searchListByHQL(String hqlString, Object... params) {
		return (List<T>) this.getHibernateTemplate().find(hqlString, params);
	}
	
	/**
	 * 根据hql语句分页查询记录集合
	 * @param hql
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<T> searchListByHQL(final String hqlString, final Object[] params, final int firstResult, final int maxResults) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hqlString);
				for (int i = 0; i < params.length; ++i) {
					query = query.setParameter(i, params[i]);
				}
				query.setFirstResult(firstResult);
				query.setMaxResults(maxResults);
				return (List<T>) query.list();
			}
		});
	}
	
	//------------------------------HQL end------------------------------------------------------------

	//------------------------------QBE start------------------------------------------------------------
	public List<T> findByExample(T entity) {
		Assert.notNull(entity, "findByExample, entity must not be null");
		return (List<T>)this.getHibernateTemplate().findByExample(entity);
	}
	
	public List<T> findByExample(T entity, int firstResult, int maxResults) {
		Assert.notNull(entity, "findByExample, entity must not be null");
		return (List<T>)this.getHibernateTemplate().findByExample(entity, firstResult, maxResults);
	}
	//------------------------------QBE end------------------------------------------------------------
	
	//------------------------------others  start------------------------------------------------------
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	
	/**
	 * 保存或
	 * @param entity
	 */
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	/**
	 * 批量更新删除
	 * @param entities
	 */
	public void saveOrUpdateAll(List<T> entities) {
		this.getHibernateTemplate().saveOrUpdateAll(entities);
	}
	
	/**
	 * 批量删除
	 * @param entities
	 */
	public void deleteAll(List<T> entities) {
		this.getHibernateTemplate().deleteAll(entities);
	}
	
	/**
	 * 批量更新
	 * @param hqlString
	 * @return
	 */
	public int bulkUpdate(String hqlString) {
		return this.getHibernateTemplate().bulkUpdate(hqlString);
	}
	
	/**
	 * 批量更新
	 * @param hqlString
	 * @param value
	 * @return
	 */
	public int bulkUpdate(String hqlString, Object value) {
		return this.getHibernateTemplate().bulkUpdate(hqlString, value);
	}
	
	/**
	 * 批量更新
	 * @param hqlString
	 * @param values
	 * @return
	 */
	public int bulkUpdate(String hqlString, Object... values) {
		return this.getHibernateTemplate().bulkUpdate(hqlString, values);
	}
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<T> searchAll() {
		List<T> resultList = (List<T>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(persistentClass);
				return criteria.list();
			}
		});
		return resultList;
	}
	
	//------------------------------others end------------------------------------------------------------
	
	//-------------------------------增删改 start-----------------------------------------------------------
		/**
		 * 新增实体记录
		 * 
		 * @param entity
		 * @throws PersistenceException
		 */
		public void insert(T entity) throws PersistenceException {
			try {
				this.getHibernateTemplate().save(entity);
			} catch (Exception e) {
				log.error("保存" + persistentClassName + "[" + entity.toString() + "]" + "记录出错,", e);
				throw new PersistenceException(e);
			}
		}

		/**
		 * 删除实体记录
		 * 
		 * @param entity
		 * @throws PersistenceException
		 */
		public void delete(T entity) throws PersistenceException {
			try {
				this.getHibernateTemplate().delete(entity);
			} catch (Exception e) {
				log.error("删除" + persistentClassName + "[" + entity.toString() + "]" + "记录出错,", e);
				throw new PersistenceException(e);
			}
		}

		/**
		 * 更新实体记录
		 * 
		 * @param entity
		 * @throws PersistenceException
		 */
		public void update(T entity) throws PersistenceException {
			try {
				this.getHibernateTemplate().update(entity);
			} catch (Exception e) {
				log.error("更新" + persistentClassName + "[" + entity.toString() + "]" + "记录出错,", e);
				throw new PersistenceException(e);
			}
		}
		//-------------------------------增删改 end-----------------------------------------------------------

		/**
		 * 获取序列下个值
		 * @param sequenceName sequence名称
		 * @return
		 */
		public Long findNextSequenceVal(final String sequenceName) {
			List resultList = (List)this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public List doInHibernate(Session session) throws HibernateException, SQLException {
					String sql = "SELECT (NEXT VALUE FOR  " + sequenceName +") AS I FROM SYSIBM.SYSDUMMY1";
					return session.createSQLQuery(sql).list();
				}
			});
			
			long nextSeq = 0;
			if(resultList != null){
				Object obj = resultList.get(0);
				nextSeq=Long.valueOf(obj.toString());
			}
			return nextSeq;
		}
}
