package com.iot.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.demo.bean.OrderDetail;
import com.iot.demo.bean.OrderManagement;
import com.iot.demo.dao.OrderDetailDao;
import com.iot.demo.dao.OrderManagementDao;
import com.iot.demo.service.OrderManagementService;



@Service
public class OrderManagementServiceImpl implements OrderManagementService{
	@Autowired
	private OrderManagementDao omDao;
	@Autowired
	private OrderDetailDao odDao;
	@Override
	public void add(OrderManagement om, List<OrderDetail> list) throws Exception{
		omDao.addOrder(om);
		for(OrderDetail od : list){
			od.setOrderId(om.getOrderId());
			odDao.add(od);
		}
	}
}
