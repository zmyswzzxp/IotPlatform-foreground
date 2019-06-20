package com.iot.demo.bean;

public class OrderDetail {
    private Integer orderDetailId;

    private Integer orderId;

    private Integer productId;

    private Integer ordeNumber;

    private String orderPrice;
    
    
    public String productName;

	private String productUrl;
	
	private Double everyTotal;

	public Double getEveryTotal() {
		return everyTotal;
	}

	public void setEveryTotal(Double everyTotal) {
		this.everyTotal = everyTotal;
	}

	
	public String getGoodsUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrdeNumber() {
        return ordeNumber;
    }

    public void setOrdeNumber(Integer ordeNumber) {
        this.ordeNumber = ordeNumber;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice == null ? null : orderPrice.trim();
    }
}