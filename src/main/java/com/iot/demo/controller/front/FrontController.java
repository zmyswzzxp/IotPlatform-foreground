package com.iot.demo.controller.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.iot.demo.bean.ProductInfo;
import com.iot.demo.bean.UserInfoBack;
import com.iot.demo.service.ProductsInfoService;
import com.iot.demo.service.UserInfoBackService;
import com.iot.demo.utils.Key;



@Controller
@RequestMapping("/")
public class FrontController {

	@Autowired
	private ProductsInfoService productInfoService;
	
	@Autowired
	private UserInfoBackService userinfobackservice;
	
	
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
	
	@RequestMapping("cart/{productId}")
	public String addToCart(@PathVariable Integer productId,Model model,HttpSession session){
		Map<String , ProductInfo> cart = (Map<String, ProductInfo>)session.getAttribute("cart");
		if(cart == null){
			cart = new HashMap<String, ProductInfo>();
			session.setAttribute("cart", cart);
		}
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId(productId);
		productInfo = productInfoService.getProductInfo(productInfo);
		cart.put(productId+productInfo.getProductName(), productInfo);
		return "front/shoppingcart";
	}
	
	@RequestMapping("cart/delete")
	public String cartDelete(String[] keys,HttpSession session){
		Map<String , ProductInfo> cart = (Map<String, ProductInfo>)session.getAttribute("cart");
		for(String key : keys){
			System.out.println("key = " + key);
			cart.remove(key);
		}
		return "front/shoppingcart";
	}
	
	@RequestMapping("cart/show")
	public String cartShow(){
		return "front/shoppingcart";
	}
	
	/**
	 * 用户登陆页面
	 * @return
	 */
	@RequestMapping("login")
	public String login(){
		return "front/login";
	}
	
	@RequestMapping("dologin")
	public String doLogin(UserInfoBack userInfo,HttpSession session){
		UserInfoBack loginuser = userinfobackservice.doLogin(userInfo);
		if(loginuser != null){
			session.setAttribute("loginuser", loginuser);
			return "front/index";
		}else{
			return "front/login";
		}
	}
}
