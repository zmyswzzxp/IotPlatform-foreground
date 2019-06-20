package com.iot.demo.service;

import java.util.List;

import com.iot.demo.bean.OrderDetail;
import com.iot.demo.bean.OrderManagement;



/**
 * 订单管理的业务接口
 * @author Administrator
 *
 */
public interface OrderManagementService {
	public void add(OrderManagement om,List<OrderDetail> list) throws Exception;
}
