package com.iot.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.iot.demo.bean.OrderManagement;



/**
 * 订单管理的数据接口
 * @author Administrator
 *
 */
@Mapper
public interface OrderManagementDao {
	/**
	 * 
	 * @param om
	 */
	public int addOrder(OrderManagement om);
}
