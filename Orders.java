package com.hzyc.backMall.po;

import java.util.List;

public class Orders {
	private String id;
	private String userId;
	private String goodsId;
	private String number;
	private String money;
	private String createTime;
	private String address;
	private String phone;
	private String status;
	private List<Goods> goodsList;
	
	
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", goodsId="
				+ goodsId + ", number=" + number + ", money=" + money
				+ ", createTime=" + createTime + ", address=" + address
				+ ", phone=" + phone + ", status=" + status + ", goodsList="
				+ goodsList + "]";
	}
	
	

	
	
	
}
