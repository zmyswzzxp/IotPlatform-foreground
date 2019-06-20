package com.iot.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.iot.demo.bean.ConsigneeManagement;



/**
 * 收货人信息的数据接口
 * @author Administrator
 *
 */

@Mapper
public interface ConsigneeManagementMapper {
	/**
	 * 查询收货人信息
	 * @param cm
	 * @return
	 */
	public List<ConsigneeManagement> getCMList(ConsigneeManagement cm);
}
