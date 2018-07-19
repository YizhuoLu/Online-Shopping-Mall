package com.hzyc.backMall.po;

public class Advertisement {
	private String id;
	private String imgTitle;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImgTitle() {
		return imgTitle;
	}
	public void setImgTitle(String imgTitle) {
		this.imgTitle = imgTitle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", imgTitle=" + imgTitle
				+ ", status=" + status + "]";
	}
	
	
}
