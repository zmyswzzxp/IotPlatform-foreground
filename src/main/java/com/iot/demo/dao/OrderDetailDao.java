package com.iot.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.iot.demo.bean.OrderDetail;


/**
 * 订单明细的数据接口
 * @author Administrator
 *
 */
@Mapper
public interface OrderDetailDao {
	/**
	 * 添加订单明细
	 * @param od
	 * @return
	 */
	public void add(OrderDetail od);
}
