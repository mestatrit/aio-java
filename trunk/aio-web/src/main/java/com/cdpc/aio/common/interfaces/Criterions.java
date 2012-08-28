package com.cdpc.aio.common.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

/**
 * 
 * 一、用法一
 * Criterions criterions = new Criterions()
 *                         .eq("propertyName", "value")
 *                         .allEq(new HashMap<String, String>())
 *                         .between("propertyName", "lo", "hi")
 *                         .isEmpty("propertyName")
 *                         .ge("propertyName", "value");
 * 
 * 二、用法二
 * List<Criterion> criterions = new Criterions()
 *                              .eq("propertyName", "value")
 *                              .allEq(new HashMap<String, String>())
 *                              .between("propertyName", "lo", "hi")
 *                              .isEmpty("propertyName")
 *                              .ge("propertyName", "value").list();
 * 
 * @author evin.liu
 *
 */
public class Criterions {
	
	public Criterions() {
		
	}

	public List<Criterion> list() {
		return innerCriterions;
	}
	
	//-------------------------------------------------------
	
	public Criterions idEq(Object value) {
		add(Restrictions.idEq(value));
		return this;
	}
	
	public Criterions eq(String propertyName, Object value) {
		add(Restrictions.eq(propertyName, value));
		return this;
	}
	
	public Criterions ne(String propertyName, Object value) {
		add(Restrictions.ne(propertyName, value));
		return this;
	}
	
	public Criterions like(String propertyName, Object value) {
		add(Restrictions.like(propertyName, value));
		return this;
	}
	
	public Criterions like(String propertyName, String value, MatchMode matchMode) {
		add(Restrictions.like(propertyName, value, matchMode));
		return this;
	}
	
	public Criterions ilike(String propertyName, Object value) {
		add(Restrictions.ilike(propertyName, value));
		return this;
	}
	
	public Criterions ilike(String propertyName, String value, MatchMode matchMode) {
		add(Restrictions.ilike(propertyName, value, matchMode));
		return this;
	}
	
	public Criterions gt(String propertyName, Object value) {
		add(Restrictions.gt(propertyName, value));
		return this;
	}
	
	public Criterions lt(String propertyName, Object value) {
		add(Restrictions.lt(propertyName, value));
		return this;
	}
	
	public Criterions le(String propertyName, Object value) {
		add(Restrictions.le(propertyName, value));
		return this;
	}
	
	public Criterions ge(String propertyName, Object value) {
		add(Restrictions.ge(propertyName, value));
		return this;
	}
	
	public Criterions between(String propertyName, Object lo, Object hi) {
		add(Restrictions.between(propertyName, lo, hi));
		return this;
	}
	
	public Criterions in(String propertyName, Object[] values) {
		add(Restrictions.in(propertyName, values));
		return this;
	}
	
	public Criterions in(String propertyName, Collection values) {
		add(Restrictions.in(propertyName, values));
		return this;
	}
	
	public Criterions isNull(String propertyName) {
		add(Restrictions.isNull(propertyName));
		return this;
	}
	
	public Criterions eqProperty(String propertyName, String otherPropertyName) {
		add(Restrictions.eqProperty(propertyName, otherPropertyName));
		return this;
	}
	
	public Criterions neProperty(String propertyName, String otherPropertyName) {
		add(Restrictions.neProperty(propertyName, otherPropertyName));
		return this;
	}
	
	public Criterions ltProperty(String propertyName, String otherPropertyName) {
		add(Restrictions.ltProperty(propertyName, otherPropertyName));
		return this;
	}
	
	public Criterions leProperty(String propertyName, String otherPropertyName) {
		add(Restrictions.leProperty(propertyName, otherPropertyName));
		return this;
	}
	
	public Criterions gtProperty(String propertyName, String otherPropertyName) {
		add(Restrictions.gtProperty(propertyName, otherPropertyName));
		return this;
	}
	
	public Criterions geProperty(String propertyName, String otherPropertyName) {
		add(Restrictions.geProperty(propertyName, otherPropertyName));
		return this;
	}
	
	public Criterions isNotNull(String propertyName) {
		add(Restrictions.isNotNull(propertyName));
		return this;
	}
	
	public Criterions and(Criterion lhs, Criterion rhs) {
		add(Restrictions.and(lhs, rhs));
		return this;
	}
	
	public Criterions or(Criterion lhs, Criterion rhs) {
		add(Restrictions.or(lhs, rhs));
		return this;
	}
	
	public Criterions not(Criterion expression) {
		add(Restrictions.not(expression));
		return this;
	}
	
	public Criterions sqlRestriction(String sql, Object[] values, Type[] types) {
		add(Restrictions.sqlRestriction(sql, values, types));
		return this;
	}
	
	public Criterions sqlRestriction(String sql, Object value, Type type) {
		add(Restrictions.sqlRestriction(sql, value, type));
		return this;
	}
	
	public Criterions sqlRestriction(String sql) {
		add(Restrictions.sqlRestriction(sql));
		return this;
	}
	
	public Criterions allEq(Map propertyNameValues) {
		add(Restrictions.allEq(propertyNameValues));
		return this;
	}
	
	public Criterions isEmpty (String propertyName) {
		add(Restrictions.isEmpty(propertyName));
		return this;
	}
	
	public Criterions isNotEmpty(String propertyName) {
		add(Restrictions.isNotEmpty(propertyName));
		return this;
	}
	
	public Criterions sizeEq(String propertyName, int size) {
		add(Restrictions.sizeEq(propertyName, size));
		return this;
	}
	
	public Criterions sizeNe(String propertyName, int size) {
		add(Restrictions.sizeNe(propertyName, size));
		return this;
	}
	
	public Criterions sizeGt(String propertyName, int size) {
		add(Restrictions.sizeGt(propertyName, size));
		return this;
	}
	
	public Criterions sizeLt(String propertyName, int size) {
		add(Restrictions.sizeLt(propertyName, size));
		return this;
	}
	
	public Criterions sizeGe(String propertyName, int size) {
		add(Restrictions.sizeGe(propertyName, size));
		return this;
	}
	
	public Criterions sizeLe(String propertyName, int size) {
		add(Restrictions.sizeLe(propertyName, size));
		return this;
	}
	
	//-------------------------------------------------------
	
	private void add(Criterion criterion) {
		innerCriterions.add(criterion);
	}
	
	private List<Criterion> innerCriterions = new ArrayList<Criterion>();
	
}
