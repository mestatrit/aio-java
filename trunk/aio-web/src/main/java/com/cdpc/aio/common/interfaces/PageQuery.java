package com.cdpc.aio.common.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;


/**
 * 
 * 封装分页查询
 * 
 * 用法:
 * 一、创建查询条件
 * 1、多个OR的条件集合
 * 	  List<Criterion> criterions = ...;
 * 	  Criterion criterion = null;
 * 	  Disjunction dj = Restrictions.disjunction();
 * 	  for (int i = 0; i < criterions.size(); j++) {
 *    	criterion = dj.add(criterions.get(i));
 *    }
 * 2、等于
 *    Criterion criterion = Restrictions.eq(propertyName, value);
 *    Criterion criterion = Restrictions.eqProperty(propertyName, otherPropertyName);
 * 3、不等于
 *    Criterion criterion = Restrictions.ne(propertyName, value);
 *    Criterion criterion = Restrictions.neProperty(propertyName, otherPropertyName);
 * 4、大于
 *    Criterion criterion = Restrictions.gt(propertyName, value);
 *    Criterion criterion = Restrictions.gtProperty(propertyName, otherPropertyName);
 * 5、小于
 *    Criterion criterion = Restrictions.lt(propertyName, value);
 *    Criterion criterion = Restrictions.ltProperty(propertyName, otherPropertyName);
 * 6、大于等于
 *    Criterion criterion = Restrictions.ge(propertyName, value);
 *    Criterion criterion = Restrictions.geProperty(propertyName, otherPropertyName);
 * 7、小于等于
 *    Criterion criterion = Restrictions.le(propertyName, value);
 *    Criterion criterion = Restrictions.leProperty(propertyName, otherPropertyName);
 * 8、属于
 *    Criterion criterion = Restrictions.in(propertyName, Object[] values);
 *    Criterion criterion = Restrictions.in(propertyName, Collection values);
 * 9、在...之间
 *    Criterion criterion = Restrictions.between(propertyName, low, high);
 * 10、为空
 *    Criterion criterion = Restrictions.isNull(propertyName);
 * 11、不为空
 *    Criterion criterion = Restrictions.isNotNull(propertyName);
 * 12、LIKE模糊查询
 *    Criterion criterion = Restrictions.like(propertyName, value);
 * 13、多个AND条件   
 *    List<Criterion> criterions = ...;
 *    Criterion criterion = null;
 *    Conjunction cj = Restrictions.conjunction();
 *    for (int i = 0; i < criterions.size(); j++) {
 *        criterion = cj.add(criterions.get(i));
 *    }
 * 
 * 二、添加查询条件
 * PageQuery<T> pageQuery = new PageQuery<T>();
 * pageQuery.addCriteria(criterion);
 * 
 * 三、添加排序字段
 * 1、升序
 *    Order order = Order.asc(propertyName);
 * 2、降序
 *    Order order = Order.desc(propertyName);
 *    
 * PageQuery<T> pageQuery = new PageQuery<T>();
 * pageQuery.addOrder(order);
 * 
 * 四、查询
 * TDAO tDAO = new TDAO();
 * pageQuery = tDAO.pageQuery(pageQuery);
 * 
 * @author evin.liu
 * 
 */
public class PageQuery<T> {

	public PageQuery() {

	}

	// 首页
	public void firstPage() {
		this.currentPage = 1;
	}

	// 末页
	public void lastPage() {
		this.currentPage = (this.totalPage == 0 ? 1 : this.totalPage);
	}

	// 上一页
	public void priviousPage() {
		if (this.currentPage <= 1) {
			this.currentPage = 1;
		} else {
			this.currentPage = this.currentPage - 1;
		}
	}

	// 下一页
	public void nextPage() {
		if (this.currentPage >= this.totalPage) {
			this.currentPage = (this.totalPage == 0 ? 1 : this.totalPage);
		} else {
			this.currentPage = this.currentPage + 1;
		}
	}

	// 抓取指定页、指定数量的记录
	public PageQuery<T> fetch(int currentPage, int pageSize) {
		setCurrentPage(currentPage);
		setPageSize(pageSize);
		return this;
	}

	// 抓取指定页的记录
	public PageQuery<T> fetch(int currentPage) {
		setCurrentPage(currentPage);
		return this;
	}
	
	// 获取本次查询首条记录序号
	public int getFirstResult() {
		return (currentPage - 1) * pageSize;
	}
	
	// 获取本次查询记录条数
	public int getMaxResults() {
		return pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	// 设置总记录数,同时计算总页数
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
		countTotalPage();
	}

	public List<T> getPagedata() {
		return pagedata;
	}

	public void setPagedata(List<T> pagedata) {
		this.pagedata = pagedata;
	}

	// 计算总页数
	private void countTotalPage() {
		totalPage = (totalSize + pageSize - 1) / pageSize;
	}

	private int currentPage = Constants.DEFAULT_PAGE_NO;
	private int totalPage = 0;
	private int pageSize = Constants.DEFAULT_PAGE_SIZE;
	private int totalSize = 0;

	private List<T> pagedata = null;

	// ---------------------------------------------------------------------------
	public boolean isHasNextPage() {
		if (currentPage >= totalPage) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isHasPreviousPage() {
		if (currentPage > 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isHasFirstPage() {
		if (currentPage != 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isHasLastPage() {
		if (currentPage < totalPage) {
			return true;
		} else {
			return false;
		}
	}
	// ---------------------------------------------------------------------------
	
	public List<Criterion> getCriterions() {
		if(criterions != null) {
			for(Criterion criterion : criterions.list()) {
				criterionList.add(criterion);
			}
		}
		return criterionList;
	}
	
	public List<Order> getOrders() {
		if(orders != null) {
			for(Order order : orders.list()) {
				orderList.add(order);
			}
		}
		return orderList;
	}
	
	// 添加查询条件
	public PageQuery<T> addCriterion(Criterion criterion) {
		criterionList.add(criterion);
		return this;
	}
	
	// 添加排序字段
	public PageQuery<T> addOrder(Order order) {
		orderList.add(order);
		return this;
	}

	private List<Criterion> criterionList = new ArrayList<Criterion>();
	private List<Order> orderList = new ArrayList<Order>();

	public List<Criterion> getCriterionList() {
		return criterionList;
	}

	public void setCriterionList(List<Criterion> criterionList) {
		this.criterionList = criterionList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	// ---------------------------------------------------------------------------
	public void setCriterions(Criterions criterions) {
		this.criterions = criterions;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	private Criterions criterions = null;
	private Orders orders = null;
	
}
