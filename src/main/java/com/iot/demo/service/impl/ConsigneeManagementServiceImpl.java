package com.iot.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.demo.bean.ConsigneeManagement;
import com.iot.demo.dao.ConsigneeManagementMapper;
import com.iot.demo.service.ConsigneeManagementService;



@Service
public class ConsigneeManagementServiceImpl implements ConsigneeManagementService{
	
	@Autowired
	private ConsigneeManagementMapper cmMapper;
	
	@Override
	public List<ConsigneeManagement> getCmList(ConsigneeManagement cm) {
		return cmMapper.getCMList(cm);
	}

}
