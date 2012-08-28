package com.cdpc.aio.common.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Order;

/**
 * 
 * 一、用法一
 * Orders orders = new Orders().asc("propertyName")
 *                             .desc("propertyName");
 * 
 * 二、用法二
 * List<Order> orders = new Orders().asc("propertyName")
 *                                  .desc("propertyName")
 *                                  .list();
 * 
 * @author evin.liu
 *
 */
public class Orders {

	public Orders() {
		
	}

	public List<Order> list() {
		return innerOrders;
	}

	// -------------------------------------------------------

	public Orders asc(String propertyName) {
		add(Order.asc(propertyName));
		return this;
	}

	public Orders desc(String propertyName) {
		add(Order.desc(propertyName));
		return this;
	}

	// -------------------------------------------------------

	private void add(Order order) {
		innerOrders.add(order);
	}

	private List<Order> innerOrders = new ArrayList<Order>();
}