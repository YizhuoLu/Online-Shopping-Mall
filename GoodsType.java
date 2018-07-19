package com.hzyc.backMall.po;

import java.util.List;

public class GoodsType {
	private String id;
	private String type;
	private List<Goods> goodsTypeList;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Goods> getGoodsTypeList() {
		return goodsTypeList;
	}
	public void setGoodsTypeList(List<Goods> goodsTypeList) {
		this.goodsTypeList = goodsTypeList;
	}
	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", type=" + type + ", goodsTypeList="
				+ goodsTypeList + "]";
	}
	
	
}
