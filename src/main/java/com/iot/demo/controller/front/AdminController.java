package com.iot.demo.controller.front;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iot.demo.bean.ConsigneeManagement;
import com.iot.demo.bean.OrderDetail;
import com.iot.demo.bean.OrderManagement;
import com.iot.demo.bean.ProductInfo;
import com.iot.demo.bean.UserInfoBack;
import com.iot.demo.service.ConsigneeManagementService;
import com.iot.demo.service.OrderManagementService;


/**
 * 登陆之后的关键操作（结算、提交订单）
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private ConsigneeManagementService cmService;
	
	@Autowired
	private OrderManagementService omService;
	
	@RequestMapping("ordercheck")
	public String orderCheck(String[] keys,Integer[] number,HttpSession session,Model model){
		Map<String , ProductInfo> cart = (Map<String, ProductInfo>)session.getAttribute("cart");
		double sum = 0;//总价
		List<OrderDetail> list = new ArrayList<>();
		for(int i = 0 ; i < number.length ; i++){
			OrderDetail od = new OrderDetail();//订单项
			ProductInfo productInfo = cart.get(keys[i]);
			od.setProductId(productInfo.getProductId());
			od.setProductName(productInfo.getProductName());
			od.setOrderPrice(productInfo.getProductPrice());
			od.setProductUrl(productInfo.getProductUrl());
			od.setOrdeNumber(number[i]);
			od.setEveryTotal(number[i] * Double.parseDouble(productInfo.getProductPrice()));
			list.add(od);
			sum += number[i] * Double.parseDouble(productInfo.getProductPrice());//总价
		}
		int num = 0;//数量
		for(int i : number){
			num += i;
		}
		model.addAttribute("list", list);
		model.addAttribute("sum", sum);
		model.addAttribute("num", num);
		
		ConsigneeManagement cm = new ConsigneeManagement();
		UserInfoBack userInfoBack = (UserInfoBack)session.getAttribute("loginuser");
		cm.setUserId(userInfoBack.getUserId());
		
		List<ConsigneeManagement> cmList = cmService.getCmList(cm);
		model.addAttribute("cmlist", cmList);
		
		return "front/order_check";
	}
	
	
	@RequestMapping("orderconfirm")
	public String orderConfirm(OrderManagement om,String[] goodsInfos,HttpSession session,Model model){
		UserInfoBack userInfo = (UserInfoBack) session.getAttribute("loginuser");
		om.setUserId(userInfo.getUserId());
		om.setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		//构建订单详情
		List<OrderDetail> list = new ArrayList<>();
		for(String str : goodsInfos){
			String[] goodsInfo = str.split(",");
			OrderDetail od = new OrderDetail();
			od.setProductId(Integer.parseInt(goodsInfo[0]));
			od.setOrdeNumber(Integer.parseInt(goodsInfo[1]));
			od.setOrderPrice(goodsInfo[2]);
			list.add(od);
		}
		
		try {
			omService.add(om, list);
			model.addAttribute("info", "yes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("info", "no");
		}
		
		return "front/orderok";
		
	}
}
