package com.hzyc.backMall.po;

import java.util.List;

public class Person {
	private String id;
	private String username;
	private String password;
	private String email;
	private String identity;
	private List<Cart> cartList;
	private List<Orders> ordersList;
	private List<Commentary> commentList;
	
	
	public List<Commentary> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Commentary> commentList) {
		this.commentList = commentList;
	}
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	public List<Cart> getCartList() {
		return cartList;
	}
	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	@Override
	public String toString() {
		return "Person [username=" + username + ",cartList="+cartList+"]";
	}
	
	
}
