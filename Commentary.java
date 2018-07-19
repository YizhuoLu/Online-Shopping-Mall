package com.hzyc.backMall.po;

import java.util.List;

public class Commentary {
	private String id;
	private String goodsId;
	private String userId;
	private String comment;
	private List<Goods> goodsList;
	
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Commentary [id=" + id + ", goodsId=" + goodsId + ", userId="
				+ userId + ", comment=" + comment + ", goodsList=" + goodsList
				+ "]";
	}
	
	
}
