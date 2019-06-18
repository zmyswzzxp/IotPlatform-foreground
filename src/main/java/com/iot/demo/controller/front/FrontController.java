package com.iot.demo.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iot.demo.bean.ProductInfo;
import com.iot.demo.service.ProductsInfoService;

@Controller
@RequestMapping("/")
public class FrontController {

	@Autowired
	private ProductsInfoService productInfoService;
	
	@RequestMapping("index")
	public String index(Model model){
	List<ProductInfo> list=	productInfoService.getFrontProductInfoList(new ProductInfo());
		model.addAttribute("list",list);
		return "front/index";
	}
	
	@RequestMapping("productinfo/{productId}")
	public String getProductInfo(@PathVariable Integer productId,Model model)
	{
		ProductInfo  productInfo=new ProductInfo();
		productInfo.setProductId(productId);
		ProductInfo  pproductInfo=	productInfoService.getProductInfo(productInfo);
		model.addAttribute("g",pproductInfo);
	return "front/productinfo";
	}
}
